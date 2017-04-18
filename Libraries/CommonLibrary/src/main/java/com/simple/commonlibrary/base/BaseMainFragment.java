package com.simple.commonlibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.simple.commonlibrary.base.mvp.BaseModel;
import com.simple.commonlibrary.base.mvp.BasePresenter;

/**
 * 处理主页面 Tab Fragment，没有Toolbar
 * Created by hych on 2017/4/18 09:07.
 */

public abstract class BaseMainFragment<T extends BasePresenter, E extends BaseModel> extends BaseFragment<T, E> {

    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setShowToolbar(showToolbar());
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public boolean onBackPressedSupport() {

        if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
            _mActivity.finish();
        } else {
            TOUCH_TIME = System.currentTimeMillis();
            Toast.makeText(_mActivity, "再按一次退出", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    protected abstract boolean showToolbar();
}
