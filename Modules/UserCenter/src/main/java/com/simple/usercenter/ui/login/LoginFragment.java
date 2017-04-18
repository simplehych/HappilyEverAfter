package com.simple.usercenter.ui.login;

import android.os.Bundle;

import com.simple.commonlibrary.base.BaseSecondaryFragment;
import com.simple.commonlibrary.rx.RxManager;
import com.simple.usercenter.R;

/**
 * Created by hych on 2017/4/17 09:39.
 */

public class LoginFragment extends BaseSecondaryFragment {

    public static LoginFragment newInstance() {

        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.user_fragment_login;
    }

    @Override
    public void initView() {
    }

    @Override
    protected void setToolbar() {

    }
}
