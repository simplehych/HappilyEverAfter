package com.simple.happilyeverafter.ui.mainfragment2;

import android.os.Bundle;

import com.simple.commonlibrary.base.BaseFragment;
import com.simple.happilyeverafter.R;

/**
 * Created by hych on 2017/4/14 17:27.
 */

public class MainFragment2 extends BaseFragment {

    public static MainFragment2 newInstance() {
        Bundle args = new Bundle();
        MainFragment2 fragment = new MainFragment2();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_main_2;
    }

    @Override
    public void initView() {

    }
}
