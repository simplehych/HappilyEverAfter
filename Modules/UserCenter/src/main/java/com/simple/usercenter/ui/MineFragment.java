package com.simple.usercenter.ui;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.simple.commonlibrary.arouter.RouterManager;
import com.simple.commonlibrary.base.BaseFragment;
import com.simple.commonlibrary.base.BaseMainFragment;
import com.simple.usercenter.R;
import com.simple.usercenter.R2;
import com.simple.usercenter.ui.login.LoginFragment;

import butterknife.OnClick;

/**
 * Created by hych on 2017/4/17 11:06.
 */
@Route(path = RouterManager.USER_MINE)
public class MineFragment extends BaseMainFragment {

    public static MineFragment newInstance() {
        Bundle args = new Bundle();
        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.user_fragment_mine;
    }

    @Override
    public void initView() {

    }

    @OnClick(R2.id.avatar_iv)
    public void onViewClicked() {
        _mActivity.start(LoginFragment.newInstance());
    }

    @Override
    protected boolean showToolbar() {
        return false;
    }
}
