package com.simple.commonlibrary.base;

import android.content.Context;
import android.content.res.Resources;
import android.support.multidex.MultiDex;

import org.litepal.LitePalApplication;

/**
 * Created by hych on 2017/4/12.
 */

public class BaseApplication extends LitePalApplication {

    private static BaseApplication baseApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
    }

    public static Context getAppContext() {
        return baseApplication;
    }

    public static Resources getAppResources() {
        return baseApplication.getResources();
    }

    /**
     * 分包
     *
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
