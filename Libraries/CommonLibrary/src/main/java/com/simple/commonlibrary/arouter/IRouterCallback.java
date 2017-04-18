package com.simple.commonlibrary.arouter;

/**
 * 自定义路由回调接口，成功、失败等
 *
 * Created by hych on 2017/4/17 14:52.
 */

public interface IRouterCallback {

    void onRouterSuccess();

    void onRouterFailed();

}
