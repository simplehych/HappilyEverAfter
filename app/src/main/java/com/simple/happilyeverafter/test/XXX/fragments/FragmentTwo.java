package com.simple.happilyeverafter.test.XXX.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simple.happilyeverafter.R;
import com.simple.commonlibrary.test.base.BaseFragment;

/**
 * Created by Anthony on 2017/3/17.
 */
public class FragmentTwo extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_user_normal, container, false);
        return view;
    }
}
