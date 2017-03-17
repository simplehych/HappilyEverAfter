package com.simple.happilyeverafter.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.simple.sharelib.base.BaseFragment;
import com.simple.sharelib.base.BaseFragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Anthony on 2017/3/17.
 */
public class NewsFragmentPagerAdapter extends BaseFragmentPagerAdapter {


    private ArrayList<BaseFragment> mChannelFragmentList;
    private ArrayList<String> mChannelNameList;

    public NewsFragmentPagerAdapter(FragmentManager fm, ArrayList<BaseFragment> fragments,ArrayList<String> channelNames) {
        super(fm);
        this.mChannelFragmentList = fragments;
        this.mChannelNameList = channelNames;
    }

    @Override
    public int getCount() {
        return mChannelFragmentList.size();
    }


    @Override
    public Fragment getItem(int position) {
        return mChannelFragmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mChannelNameList.get(position);
    }
}
