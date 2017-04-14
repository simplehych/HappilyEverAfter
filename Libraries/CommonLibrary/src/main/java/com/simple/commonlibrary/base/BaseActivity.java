package com.simple.commonlibrary.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.simple.commonlibrary.manager.ActivityManager;
import com.simple.commonlibrary.utils.TUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by hych on 2017/4/12.
 */

public abstract class BaseActivity<T extends BasePresenter, E extends BaseModel> extends BaseSupportActivity {

    public T mPresenter;
    public E mModel;
    public Context mContext;
    private Unbinder unbinder;

    /**
     * 注意关注底层方法内实现的顺序
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeSetContentView();
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        mContext = this;
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        if (mPresenter != null) {
            mPresenter.mContext = this;
        }
        this.initPresenter();
        this.initView();
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, int requestCode) {
        startActivityForResult(cls, null, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 添加布局之前将当前的Activity放到栈中进行统一的管理
     */
    private void beforeSetContentView() {
        ActivityManager.getInstance().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.onDestroy();
        unbinder.unbind();
        ActivityManager.getInstance().finishActivity(this);
    }


    /**
     * 获取布局文件ID
     *
     * @return
     */
    public abstract int getLayoutId();

//    /**
//     * 使用Mvp模式下初始化Presenter，即 mPresenter.setVM(this, mModel);
//     * 若子类均实现略显繁杂
//     */
//    public abstract void initPresenter();

    /**
     * Mvp模式进行初始化
     */
    protected void initPresenter() {

        if (mPresenter != null && mModel != null) { //若继承泛型则为MVP模式
            mPresenter.setVM(this, mModel);
        }
    }

    /**
     * 初始化视图
     */
    public abstract void initView();

}
