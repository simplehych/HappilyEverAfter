package com.simple.happilyeverafter.modules.fragments.newsfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.simple.happilyeverafter.R;
import com.simple.happilyeverafter.adapter.HomeFragmentPagerAdapter;
import com.simple.happilyeverafter.adapter.NewsFragmentPagerAdapter;
import com.simple.happilyeverafter.modules.fragments.FragmentOne;
import com.simple.happilyeverafter.modules.fragments.FragmentThree;
import com.simple.happilyeverafter.modules.fragments.FragmentTwo;
import com.simple.sharelib.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Anthony on 2017/3/17.
 */
public class NewsFragment extends BaseFragment {

    @BindView(R.id.news_tab_layout)
    TabLayout mNewsTabLayout;
    @BindView(R.id.news_view_pager)
    ViewPager mNewsViewPager;
    private NewsFragmentPagerAdapter mNewsFragmentPagerAdapter;
    @BindView(R.id.news_channel_add)
    ImageView mNewsChannelAdd;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, view);

        ArrayList<BaseFragment> fragments = new ArrayList<>();
        fragments.add(new FragmentOne());
        fragments.add(new FragmentTwo());
        fragments.add(new FragmentThree());
        fragments.add(new FragmentThree());
        fragments.add(new FragmentThree());

        ArrayList<String> names = new ArrayList<>();
        names.add("News 1");
        names.add("News 2");
        names.add("News 3");
        names.add("News 3");
        names.add("News 3");

        mNewsFragmentPagerAdapter = new NewsFragmentPagerAdapter(getChildFragmentManager(),fragments,names);
        mNewsViewPager.setAdapter(mNewsFragmentPagerAdapter);
        mNewsTabLayout.setupWithViewPager(mNewsViewPager);
        return view;
    }

    @OnClick(R.id.news_channel_add)
    public void onClick() {
        Log.e("Simple","已响应----news_channel_add");
    }
}
