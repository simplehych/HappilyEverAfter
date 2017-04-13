package com.simple.commonlibrary.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simple.commonlibrary.manager.ActivityManager;
import com.simple.commonlibrary.utils.TUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by hych on 2017/4/12.
 */

public abstract class BaseFragment<T extends BasePresenter, E extends BaseModel> extends Fragment {

    protected View mRootView;
    public T mPresenter;
    public E mModel;
    public Context mContext;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getLayoutResId(), container, false);
        }
        unbinder = ButterKnife.bind(this, mRootView);
        //通过泛型传入的T获得Presenter
        mPresenter = TUtil.getT(this, 0);
        //通过泛型传入的E获得Model
        mModel = TUtil.getT(this, 1);
        if (mPresenter != null) {
            mPresenter.mContext = this.getActivity();
        }
        this.initView();
        return mRootView;
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
        intent.setClass(getActivity(), cls);
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
        intent.setClass(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null)
            mPresenter.onDestroy();
        unbinder.unbind();
    }

    /**
     * 获取布局文件ID
     *
     * @return
     */
    public abstract int getLayoutResId();

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
