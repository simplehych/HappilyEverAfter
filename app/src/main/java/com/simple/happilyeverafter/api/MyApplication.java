package com.simple.happilyeverafter.api;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.simple.commonlibrary.base.BaseApplication;

/**
 * Created by Anthony on 2017/3/16.
 */
public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        ARouter.init(this); // 尽可能早，推荐在Application中初始化
    }
}
