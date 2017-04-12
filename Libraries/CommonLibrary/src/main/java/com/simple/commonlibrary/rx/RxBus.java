package com.simple.commonlibrary.rx;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/**
 * 用RxJava实现的EventBus
 * <p>
 * Created by hych on 2017/4/12.
 */

public class RxBus {

    private static RxBus sInstance;

    //线程安全的HashMap
    private ConcurrentHashMap<Object, List<Subject>> subjectMapper = new ConcurrentHashMap<>();

    public static synchronized RxBus getsInstance() {
        if (sInstance == null) {
            sInstance = new RxBus();
        }
        return sInstance;
    }

    private RxBus() {
    }

    /**
     * 注册事件源
     *
     * @param tag
     * @param <T>
     * @return
     */
    public <T> Observable<T> register(Object tag) {
        List<Subject> subjectList = subjectMapper.get(tag);
        if (subjectList == null) {
            subjectList = new ArrayList<>();
            subjectMapper.put(tag, subjectList);
        }
        //与普通Subject不同，在订阅时并不立即触发订阅事件，
        //而是允许我们在任意时刻手动调用onNext(),onError(),onCompleted来触发事件。
        Subject<T, T> subject = PublishSubject.create();
        subjectList.add(subject);
        return subject;
    }

    /**
     * 取消监听
     *
     * @param tag
     * @param observable
     * @return
     */
    public RxBus unRegister(Object tag, Observable observable) {
        if (observable == null)
            return getsInstance();
        List<Subject> subjectList = subjectMapper.get(tag);
        if (subjectList != null) {
            subjectList.remove(observable);
            if (isEmpty(subjectList)) {
                subjectMapper.remove(tag);
            }
        }
        return getsInstance();
    }

    public void unRegister(Object tag) {
        List<Subject> subjectList = subjectMapper.get(tag);
        if (subjectList != null) {
            subjectMapper.remove(tag);
        }
    }

    /**
     * 触发事件，或者说被订阅者向订阅者发送事件
     *
     * @param tag
     * @param content
     */
    public void post(Object tag, Object content) {
        List<Subject> subjectList = subjectMapper.get(tag);
        if (!isEmpty(subjectList)) {
            for (Subject subject : subjectList) {
                subject.onNext(content);
            }
        }
    }

    public void post(Object tag) {
        post(tag.getClass().getName(), tag);
    }

    public static boolean isEmpty(Collection<Subject> collection) {
        return null == collection || collection.isEmpty();
    }
}
