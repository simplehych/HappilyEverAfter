package com.simple.happilyeverafter.modules.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simple.happilyeverafter.R;
import com.simple.sharelib.base.BaseFragment;

/**
 * Created by Anthony on 2017/3/17.
 */
public class FragmentTwo extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        return view;
    }
}