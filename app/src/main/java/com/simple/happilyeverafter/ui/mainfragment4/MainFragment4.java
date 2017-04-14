package com.simple.happilyeverafter.ui.mainfragment4;

import android.os.Bundle;

import com.simple.commonlibrary.base.BaseFragment;
import com.simple.happilyeverafter.R;
import com.simple.happilyeverafter.ui.mainfragment2.MainFragment2;

/**
 * Created by hych on 2017/4/14 17:27.
 */

public class MainFragment4 extends BaseFragment {

    public static MainFragment4 newInstance() {
        Bundle args = new Bundle();
        MainFragment4 fragment = new MainFragment4();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_main_4;
    }

    @Override
    public void initView() {

    }
}
