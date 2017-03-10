package com.simple.sharelib.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;

/**
 * View基类，所有的Activity和Fragmentment继承
 * <p>
 * Created by Anthony on 2017/3/10.
 */
public abstract class BaseView<V, T extends BasePresenter<V>> extends BasePresenter implements IBaseView {

    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置页面布局
        setContentView(getLayoutResID());
        //在基类中绑定视图，避免所有的视图层重复该操作
        ButterKnife.bind(this);
        initView();
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
     * 初始化视图
     */
    protected abstract void initView();


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
