package com.simple.commonlibrary.test.base.testbase;

/**
 * Created by Anthony on 2017/3/10.
 */
public interface IBaseView {

    /**
     * 显示加载动画
     */
    void showLoading();

    /**
     * 隐藏加载动画
     */
    void hideLoading();

    /**
     * 加载成功
     */
    void success();

    /**
     * 加载失败
     */
    void failure();
}
