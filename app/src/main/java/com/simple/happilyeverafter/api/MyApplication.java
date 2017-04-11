package com.simple.happilyeverafter.api;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by Anthony on 2017/3/16.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }
}
