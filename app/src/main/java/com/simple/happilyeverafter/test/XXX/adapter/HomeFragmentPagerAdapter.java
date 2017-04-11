package com.simple.happilyeverafter.test.XXX.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.simple.sharelib.base.BaseFragment;
import com.simple.sharelib.base.BaseFragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Anthony on 2017/3/17.
 */
public class HomeFragmentPagerAdapter extends BaseFragmentPagerAdapter {


    private ArrayList<BaseFragment> mFragmentList;

    public HomeFragmentPagerAdapter(FragmentManager fm, ArrayList<BaseFragment> fragments) {
        super(fm);
        this.mFragmentList = fragments;
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }


    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
