package com.simple.sharelib.testbase;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 *
 * V基类
 * Created by Anthony on 2017/3/10.
 */
public abstract class BaseActivity<V,T extends BasePresenter<V>> extends BaseView implements IBaseView {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        //设置页面布局
//        setContentView(getLayoutResID());
//        //在基类中绑定视图，避免所有的视图层重复该操作
//        ButterKnife.bind(this);

        //创建Presenter
        mPresenter = createPresenter();
        //通过Presenter将视图绑定
        mPresenter.attachView((V) this);
    }

    /**
     * 视图销毁时，解除View和Model的引用
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    /**
     * 实现类创建相应的Presenter
     *
     * @return
     */
    protected abstract T createPresenter();

    /**
     * 获取实现类的视图布局文件ID
     *
     * @return
     */
    protected abstract int getLayoutResID();
}
