package com.simple.happilyeverafter.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simple.commonlibrary.base.BaseFragment;
import com.simple.commonlibrary.base.BaseMainFragment;
import com.simple.happilyeverafter.R;

/**
 * Created by hych on 2017/4/14 17:27.
 */

public class MainFragment1 extends BaseMainFragment {

    public static MainFragment1 newInstance() {
        Bundle args = new Bundle();
        MainFragment1 fragment = new MainFragment1();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater,container,savedInstanceState);
        return view;
    }

    @Override
    protected boolean showToolbar() {
        return true;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_main_1;
    }

    @Override
    public void initView() {
        setToolbar("首页",false,false,null);
    }

}
