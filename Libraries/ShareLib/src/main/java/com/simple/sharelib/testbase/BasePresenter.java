package com.simple.sharelib.testbase;

import android.support.v7.app.AppCompatActivity;

import java.lang.ref.WeakReference;

/**
 * P基类，MVP模式中，Model持有View的引用，
 * 当Model进行异步操作的时候，此时View恰好被销毁，则会造成内存泄漏，所以采用弱引用方式
 * <p>
 * Created by Anthony on 2017/3/10.
 */
public abstract class BasePresenter<T> extends AppCompatActivity {

    /**
     * 当内存不足可释放内存
     */
    private WeakReference<T> mViewRef;

    /**
     * 绑定View
     *
     * @param view
     */
    public void attachView(T view) {
        mViewRef = new WeakReference<T>(view);
    }

    /**
     * 解除绑定
     */
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    public T getView() {
        return mViewRef.get();
    }


}
