package com.simple.commonlibrary.base.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用于数量也比较少，相对静态的页，每生成一个fragment都保存在内存中
 * <p>
 * Created by hych on 2017/4/13.
 */

public class BaseFragmentAdapter extends FragmentPagerAdapter {

    List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private List<String> mTitles;

    public BaseFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.mFragmentList = fragmentList;
    }

    public BaseFragmentAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> mTitles) {
        super(fm);
        this.mTitles = mTitles;
        setFragments(fm, fragmentList, mTitles);
    }

    //刷新fragment
    public void setFragments(FragmentManager fm, List<Fragment> fragments, List<String> mTitles) {
        this.mTitles = mTitles;
        if (this.mFragmentList != null) {
            FragmentTransaction ft = fm.beginTransaction();
            for (Fragment f : this.mFragmentList) {
                ft.remove(f);
            }
            ft.commitAllowingStateLoss();
            ft = null;
            fm.executePendingTransactions();
        }
        this.mFragmentList = fragments;
        notifyDataSetChanged();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return !isNullOrEmpty(mTitles) ? mTitles.get(position) : "";
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public static boolean isNullOrEmpty(Collection c) {
        if (null == c || c.isEmpty()) {
            return true;
        }
        return false;
    }
}
