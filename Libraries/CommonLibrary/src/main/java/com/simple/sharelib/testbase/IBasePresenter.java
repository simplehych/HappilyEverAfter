package com.simple.sharelib.testbase;

/**
 * Presenter基础接口
 * <p>
 * Created by Anthony on 2017/3/10.
 */
public interface IBasePresenter {

    /**
     * 获取数据
     *
     * @param isPullRefresh 是否为下拉刷新更新数据，下拉刷新的时候不应该显示加载界面和异常界面
     */
    void getData(boolean isPullRefresh);

    /**
     * 加载更多数据
     */
    void getMoreData();

}
