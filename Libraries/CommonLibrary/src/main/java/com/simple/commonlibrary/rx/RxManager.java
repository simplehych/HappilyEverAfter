package com.simple.commonlibrary.rx;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/**
 * 管理RxBus的事件和Rxjava相关代码的生命周期处理
 * <p>
 * Created by hych on 2017/4/12.
 */

public class RxManager {

    public static RxBus mRxBus = RxBus.getsInstance();
    //管理rxbus订阅
    private static Map<String, Observable<?>> mObservables = new HashMap<>();
    //管理Observables 和 Subscribers订阅
    private static CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    /**
     * RxBus注入监听
     *
     * @param eventName
     * @param action1
     */
    public static  <T> void on(String eventName, Action1<T> action1) {
        Observable<T> mObservable = mRxBus.register(eventName);
        mObservables.put(eventName, mObservable);
        //订阅管理
        mCompositeSubscription
                .add(mObservable.observeOn(AndroidSchedulers.mainThread())//指定Subscriber的回调发生在主线程
                        .subscribe(action1, new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                throwable.printStackTrace();
                            }
                        }));
    }

    /**
     * 单纯的Observables 和 Subscribers管理
     *
     * @param m
     */
    public void add(Subscription m) {
        /*订阅管理*/
        mCompositeSubscription.add(m);
    }

    /**
     * 单个presenter生命周期结束，取消订阅和所有rxbus观察
     */
    public void clear() {
        mCompositeSubscription.unsubscribe();// 取消所有订阅
        for (Map.Entry<String, Observable<?>> entry : mObservables.entrySet()) {
            mRxBus.unRegister(entry.getKey(), entry.getValue());//移除rxbus观察
        }
    }

    /**
     * 发送rxbus
     *
     * @param tag
     * @param content
     */
    public static void post(Object tag, Object content) {
        mRxBus.post(tag, content);
    }
}
