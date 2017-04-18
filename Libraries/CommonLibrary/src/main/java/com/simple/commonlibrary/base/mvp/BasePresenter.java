package com.simple.commonlibrary.base.mvp;

import android.content.Context;

import com.simple.commonlibrary.rx.RxManager;

/**
 * MVP模式-基础P
 * <p>
 * Created by hych on 2017/4/12.
 */

public abstract class BasePresenter<T, E> {
    public Context mContext;
    public T mView;
    public E mModel;
    public RxManager mRxManager = new RxManager();

    public void setVM(T v, E m) {
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }

    public void onStart() {
    }

    ;

    public void onDestroy() {
        mRxManager.clear();
    }
}
