package com.simple.commonlibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.simple.commonlibrary.R;
import com.simple.commonlibrary.base.mvp.BaseModel;
import com.simple.commonlibrary.base.mvp.BasePresenter;
import com.simple.commonlibrary.event.BottomBarEvent;
import com.simple.commonlibrary.rx.RxManager;

/**
 * 处理普通的二级页面,有Toolbar
 * <p>
 * Created by hych on 2017/4/18 09:12.
 */

public abstract class BaseSecondaryFragment<T extends BasePresenter, E extends BaseModel> extends BaseFragment<T, E> {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setShowToolbar(true);
        setToolbar();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
     * 处理回退事件
     *
     * @return
     */
    @Override
    public boolean onBackPressedSupport() {
        if (getChildFragmentManager().getBackStackEntryCount() > 1) {
            popChild();
        } else {
            pop();
        }
        return true;
    }

    /**
     * 二级页面显示的时候发送事件，隐藏BottomBar
     */
    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
//        RxManager.post(BottomBarEvent.class.getName(), new BottomBarEvent(false));
    }

    /**
     * 二级页面隐藏的时候发送事件，显示BottomBar
     */
    @Override
    public void onSupportInvisible() {
        super.onSupportInvisible();
        RxManager.post(BottomBarEvent.class.getName(), new BottomBarEvent(true));
    }

    /**
     * 二级页面设置设置Toolbar，调用方法
     * eg: initToolbarNav(mToolbar, "设置", true, true, "下一步");
     */
    protected abstract void setToolbar();

}
