package com.simple.commonlibrary.test.base;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Anthony on 2017/3/17.
 */
public abstract class BaseFragmentPagerAdapter extends FragmentPagerAdapter {

    public BaseFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }
}
