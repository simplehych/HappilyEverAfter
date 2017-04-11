package com.simple.sharelib.testbase;

/**
 * Created by Anthony on 2017/3/10.
 */
public interface IBaseModel {

    /**
     * 单一职责，加载数据
     */
    void loadData(GirlOnLoadListener listener);

    /**
     * 加载完成的监听
     */
    interface GirlOnLoadListener {
        void onComplete();
        void onFail();
    }
}
