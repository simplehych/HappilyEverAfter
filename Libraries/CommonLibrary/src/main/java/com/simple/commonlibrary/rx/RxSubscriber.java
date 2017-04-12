package com.simple.commonlibrary.rx;

import android.content.Context;

import com.simple.commonlibrary.base.BaseApplication;
import com.simple.commonlibrary.utils.NetWorkUtils;
import com.simple.commonlibrary.utils.ToastUtils;

import rx.Subscriber;

/**
 * Subscriber简易封装
 * <p>
 * Created by hych on 2017/4/12.
 */

public abstract class RxSubscriber<T> extends Subscriber<T> {

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onNext(T t) {
        OnNext(t);
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Context context = BaseApplication.getAppContext();
        String errorMsg = "";
        if (!NetWorkUtils.isNetConnected(context)) {//联网错误
            errorMsg = "网络不可用,请检查你的网络";
        } else if (e instanceof Exception) {//服务器问题
            errorMsg = e.getMessage();

        } else {//其他
            errorMsg = "网络访问错误，请稍后再试";
        }
        ToastUtils.showShort(context, errorMsg);
    }

    protected abstract void OnNext(T t);

}
