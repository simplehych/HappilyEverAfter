package com.simple.happilyeverafter.ui.mainfragment1;

import android.os.Bundle;

import com.simple.commonlibrary.base.BaseFragment;
import com.simple.happilyeverafter.R;

/**
 * Created by hych on 2017/4/14 17:27.
 */

public class MainFragment1 extends BaseFragment {

    public static MainFragment1 newInstance() {
        Bundle args = new Bundle();
        MainFragment1 fragment = new MainFragment1();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_main_1;
    }

    @Override
    public void initView() {

    }
}
