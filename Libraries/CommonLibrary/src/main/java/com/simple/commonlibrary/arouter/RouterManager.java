package com.simple.commonlibrary.arouter;

import android.app.Activity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.simple.commonlibrary.R;

/**
 * 路由框架将各模块进行统一管理
 * <p>
 * Created by hych on 2017/4/17 14:17.
 */

public class RouterManager {

    /**
     * 用户中心模块路由分配地址配置
     */
    public static final String USERCENTER = "/usercenter";// 用户中心地址根路径
    public static final String USER_PROVIDER = USERCENTER + "/provider";//提供内容接口地址
    public static final String USER_MINE = USERCENTER + "/mine";//我的页面地址
    public static final String USER_TEST = USERCENTER + "/test";//测试

    /**
     * 用户中心模块向外暴露信息的接口
     */
    public static IUserProvider sIUserProvider;

    /**
     * 依赖某个模块后动态的初始化接口
     */
    public static void initUserProvider() {
        sIUserProvider = (IUserProvider) ARouter.getInstance().build(USER_PROVIDER).navigation();
    }

    public static Object start(String path) {
        return start(path, null);
    }

    public static Object start(String path, Bundle bundle) {
        return ARouter.getInstance()
                .build(path)
                .with(bundle)
                .withTransition(R.anim.common_enter, R.anim.comoon_out)
                .navigation();
    }

    public static void start(String path, Bundle bundle, int[] anim, Activity context, int requestCode, IRouterCallback routerCallback) {
        ARouter.getInstance()
                .build(path)
                .with(bundle)
                .withTransition(anim[0], anim[1])
                .navigation(context, requestCode, new MyRouterNavigationCallback(routerCallback));
    }


    static class MyRouterNavigationCallback implements NavigationCallback {

        private IRouterCallback routerCallback;

        public MyRouterNavigationCallback(IRouterCallback routerCallback) {
            this.routerCallback = routerCallback;
        }

        @Override
        public void onFound(Postcard postcard) {

        }

        @Override
        public void onLost(Postcard postcard) {
            if (routerCallback != null) {
                routerCallback.onRouterFailed();
            }
        }

        @Override
        public void onArrival(Postcard postcard) {
            if (routerCallback != null) {
                routerCallback.onRouterSuccess();
            }
        }

        @Override
        public void onInterrupt(Postcard postcard) {

        }
    }

}
