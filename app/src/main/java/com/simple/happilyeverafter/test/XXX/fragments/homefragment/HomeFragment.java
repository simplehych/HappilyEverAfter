package com.simple.happilyeverafter.test.XXX.fragments.homefragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.simple.happilyeverafter.R;
import com.simple.happilyeverafter.test.XXX.adapter.HomeFragmentPagerAdapter;
import com.simple.happilyeverafter.test.XXX.fragments.FragmentThree;
import com.simple.happilyeverafter.test.XXX.fragments.FragmentTwo;
import com.simple.happilyeverafter.test.XXX.fragments.newsfragment.NewsFragment;
import com.simple.commonlibrary.test.base.BaseFragment;
import com.simple.commonlibrary.test.base.BaseViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Anthony on 2017/3/17.
 */
public class HomeFragment extends BaseFragment implements BottomNavigationBar.OnTabSelectedListener, ViewPager.OnPageChangeListener {


    @BindView(R.id.home_view_pager)
    BaseViewPager mHomeViewPager;
    @BindView(R.id.home_bottom_nav_bar)
    BottomNavigationBar mHomeBottomNavBar;
    @BindView(R.id.home_fab)
    FloatingActionButton mHomeFab;

    private HomeFragmentPagerAdapter mHomeFragmentPagerAdapter;
    private BadgeItem mBadgeItem;


    private int mLastSelectedNavBottomPos = 0;
    private boolean mIsShowBadge = true;
    private Context mContext;
    private NewsFragment mNewsFragment;
    private FragmentTwo mFragmentTwo;
    private FragmentThree mFragmentThree;

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        if (savedInstanceState != null) {
            FragmentManager manager = getChildFragmentManager();
            mNewsFragment = (NewsFragment) manager.getFragment(savedInstanceState,"NewsFragment");
            mFragmentTwo = (FragmentTwo) manager.getFragment(savedInstanceState,"FragmentTwo");
            mFragmentThree = (FragmentThree) manager.getFragment(savedInstanceState,"FragmentThree");
        }else {
            mNewsFragment = new NewsFragment();
            mFragmentTwo = new FragmentTwo();
            mFragmentThree = new FragmentThree();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        ArrayList<BaseFragment> fragments = new ArrayList<>();
        fragments.add(mNewsFragment);
        fragments.add(mFragmentTwo);
        fragments.add(mFragmentThree);
        mHomeFragmentPagerAdapter = new HomeFragmentPagerAdapter(getChildFragmentManager(),fragments);
        mHomeViewPager.setIsCanSlide(false);
        mHomeViewPager.setOffscreenPageLimit(3);
        mHomeViewPager.setAdapter(mHomeFragmentPagerAdapter);
        mHomeViewPager.addOnPageChangeListener(this);
        mHomeViewPager.setCurrentItem(0);
        initNavigationBottomBar();
    }

    private void initNavigationBottomBar() {

        mHomeBottomNavBar.clearAll();
        /**
         * FloatingActionButton attach to NavigationBottomBar
         */
        mHomeBottomNavBar.setFab(mHomeFab);
        /**
         * NavigationBottomBar show number BadgeItem
         */
        mBadgeItem = new BadgeItem()
                .setBorderWidth(4)
                .setBackgroundColorResource(R.color.blue)
                .setText("" + mLastSelectedNavBottomPos)
                .setHideOnSelect(mIsShowBadge);
        /**
         * set Mode for BottomNavigationBar
         *      1.MODE_FIXED
         *      2.MODE_SHIFTING
         */
        mHomeBottomNavBar.setMode(BottomNavigationBar.MODE_FIXED);
        /**
         * set BackgroundStyle for BottomNavigationBar
         *      1.BACKGROUND_STYLE_STATIC
         *      2.BACKGROUND_STYLE_RIPPLE
         */
        mHomeBottomNavBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        /**
         * set Number for BottomNavigationBar
         */
        int navBottomCount = 3;
        switch (navBottomCount) {
            case 3:
                mHomeBottomNavBar
                        .addItem(new BottomNavigationItem(R.drawable.ic_location_on_white_24dp, "NewsFragment").setActiveColorResource(R.color.orange))
                        .addItem(new BottomNavigationItem(R.drawable.ic_find_replace_white_24dp, "Find").setActiveColorResource(R.color.teal))
                        .addItem(new BottomNavigationItem(R.drawable.ic_favorite_white_24dp, "Categories").setActiveColorResource(R.color.blue))
                        .setFirstSelectedPosition(mLastSelectedNavBottomPos > 2 ? 2 : mLastSelectedNavBottomPos)
                        .initialise();
                break;
            case 4:
                mHomeBottomNavBar
                        .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "Home").setActiveColorResource(R.color.orange).setBadgeItem(mBadgeItem))
                        .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "Books").setActiveColorResource(R.color.teal))
                        .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "Music").setActiveColorResource(R.color.blue))
                        .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "Movies & TV").setActiveColorResource(R.color.brown))
                        .setFirstSelectedPosition(mLastSelectedNavBottomPos > 3 ? 3 : mLastSelectedNavBottomPos)
                        .initialise();
                break;
            default:
                mHomeBottomNavBar
                        .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "Home").setActiveColorResource(R.color.orange))
                        .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "Books").setActiveColorResource(R.color.teal))
                        .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "Music").setActiveColorResource(R.color.blue))
                        .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "Movies & TV").setActiveColorResource(R.color.brown))
                        .addItem(new BottomNavigationItem(R.drawable.ic_videogame_asset_white_24dp, "Games").setActiveColorResource(R.color.grey))
                        .setFirstSelectedPosition(mLastSelectedNavBottomPos)
                        .initialise();
                break;
        }
        mHomeBottomNavBar.setTabSelectedListener(this);
    }


    @Override
    public void onTabSelected(int position) {
        mLastSelectedNavBottomPos = position;
        if (mBadgeItem != null) {
            mBadgeItem.setText(Integer.toString(position));
        }
        switch (position) {
            case 0:
                mHomeViewPager.setCurrentItem(0,false);
                break;
            case 1:
                mHomeViewPager.setCurrentItem(1,false);
                break;
            case 2:
                mHomeViewPager.setCurrentItem(2,false);
                break;
            default:
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mHomeBottomNavBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        FragmentManager manager = getChildFragmentManager();
        manager.putFragment(outState,"NewsFragment", mNewsFragment);
        manager.putFragment(outState,"TragmentTwo", mFragmentTwo);
        manager.putFragment(outState,"TragmentThree", mFragmentThree);
    }

    public void notifyDataChanged() {

    }

    @OnClick(R.id.home_fab)
    public void onClick() {

    }
}
