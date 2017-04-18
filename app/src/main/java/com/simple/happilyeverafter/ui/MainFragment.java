package com.simple.happilyeverafter.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simple.commonlibrary.base.BaseMainFragment;
import com.simple.commonlibrary.event.BottomBarEvent;
import com.simple.commonlibrary.rx.RxManager;
import com.simple.happilyeverafter.R;
import com.simple.happilyeverafter.ui.bottombar.BottomBar;
import com.simple.happilyeverafter.ui.bottombar.BottomBarTab;

import me.yokeyword.fragmentation.SupportFragment;
import rx.functions.Action1;

/**
 * Created by hych on 2017/4/14 17:15.
 */

public class MainFragment extends BaseMainFragment {
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOURTH = 3;

    private SupportFragment[] mFragments = new SupportFragment[4];
    private BottomBar mBottomBar;

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (savedInstanceState == null) {
            mFragments[FIRST] = MainFragment1.newInstance();
            mFragments[SECOND] = MainFragment2.newInstance();
            mFragments[THIRD] = MainFragment3.newInstance();
            mFragments[FOURTH] = MainFragment4.newInstance();

            loadMultipleRootFragment(R.id.container_main_fl, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOURTH]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题
            // 这里我们需要拿到mFragments的引用,也可以通过getSupportFragmentManager.getFragments()自行进行判断查找(效率更高些),用下面的方法查找更方便些
            mFragments[FIRST] = findFragment(MainFragment1.class);
            mFragments[SECOND] = findFragment(MainFragment2.class);
            mFragments[THIRD] = findFragment(MainFragment3.class);
            mFragments[FOURTH] = findFragment(MainFragment4.class);
        }

        initBottomBar(view);

        RxManager.on(BottomBarEvent.class.getName(), new Action1<BottomBarEvent>() {
            @Override
            public void call(BottomBarEvent bottomBarEvent) {
                boolean showBottomBar = bottomBarEvent.isShowBottomBar();
                if (showBottomBar) {
                    mBottomBar.show();
                } else {
                    mBottomBar.hide();
                }
            }
        });

        return view;
    }

    private void initBottomBar(View view) {
        mBottomBar = (BottomBar) view.findViewById(R.id.bottomBar);

        mBottomBar.addItem(new BottomBarTab(_mActivity, R.mipmap.ic_launcher))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.ic_launcher))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.ic_launcher))
                .addItem(new BottomBarTab(_mActivity, R.mipmap.ic_launcher));

        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position], mFragments[prePosition]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {
                SupportFragment currentFragment = mFragments[position];
                int count = currentFragment.getChildFragmentManager().getBackStackEntryCount();

//                // 如果不在该类别Fragment的主页,则回到主页;
//                if (count > 1) {
//                    if (currentFragment instanceof ZhihuFirstFragment) {
//                        currentFragment.popToChild(FirstHomeFragment.class, false);
//                    } else if (currentFragment instanceof ZhihuSecondFragment) {
//                        currentFragment.popToChild(ViewPagerFragment.class, false);
//                    } else if (currentFragment instanceof ZhihuThirdFragment) {
//                        currentFragment.popToChild(ShopFragment.class, false);
//                    } else if (currentFragment instanceof ZhihuFourthFragment) {
//                        currentFragment.popToChild(MeFragment.class, false);
//                    }
//                    return;
//                }


                // 这里推荐使用EventBus来实现 -> 解耦
                if (count == 1) {
                    // 在FirstPagerFragment中接收, 因为是嵌套的孙子Fragment 所以用EventBus比较方便
                    // 主要为了交互: 重选tab 如果列表不在顶部则移动到顶部,如果已经在顶部,则刷新
//                    EventBus.getDefault().post(new TabSelectedEvent(position));
                }
            }
        });
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_main;
    }

    @Override
    public void initView() {

    }

}
