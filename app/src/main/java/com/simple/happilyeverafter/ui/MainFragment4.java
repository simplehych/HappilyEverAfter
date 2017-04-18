package com.simple.happilyeverafter.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simple.commonlibrary.arouter.RouterManager;
import com.simple.commonlibrary.base.BaseMainFragment;
import com.simple.happilyeverafter.R;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by hych on 2017/4/14 17:27.
 */

public class MainFragment4 extends BaseMainFragment {

    private SupportFragment mMineFragment;

    public static MainFragment4 newInstance() {
        Bundle args = new Bundle();
        MainFragment4 fragment = new MainFragment4();
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
    public int getLayoutResId() {
        return R.layout.fragment_main_4;
    }

    @Override
    public void initView() {

    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);

        mMineFragment = (SupportFragment) RouterManager.start(RouterManager.USER_MINE);

        if (savedInstanceState == null) {
            loadFragment();
        } else {  // 这里可能会出现该Fragment没被初始化时,就被强杀导致的没有load子Fragment
            if (findChildFragment(mMineFragment.getClass()) == null) {
                loadFragment();
            }
        }
    }

    private void loadFragment() {
        loadRootFragment(R.id.container_main_4_fl, mMineFragment);
    }
}
