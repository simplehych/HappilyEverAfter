package com.simple.happilyeverafter.ui.mainfragment3;

import android.os.Bundle;

import com.simple.commonlibrary.base.BaseFragment;
import com.simple.happilyeverafter.R;
import com.simple.happilyeverafter.ui.mainfragment2.MainFragment2;

/**
 * Created by hych on 2017/4/14 17:27.
 */

public class MainFragment3 extends BaseFragment {

    public static MainFragment3 newInstance() {
        Bundle args = new Bundle();
        MainFragment3 fragment = new MainFragment3();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_main_3;
    }

    @Override
    public void initView() {

    }
}
