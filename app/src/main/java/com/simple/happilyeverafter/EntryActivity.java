package com.simple.happilyeverafter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.simple.commonlibrary.base.BaseSupportActivity;
import com.simple.commonlibrary.base.BaseSupportFragment;
import com.simple.commonlibrary.base.BaseSwipeBackActivity;
import com.simple.happilyeverafter.ui.SplashFragment;

import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import me.yokeyword.fragmentation.helper.FragmentLifecycleCallbacks;

/**
 * Created by hych on 2017/4/14 16:25.
 */

public class EntryActivity extends BaseSupportActivity implements BaseSupportFragment.OnBackToFirstListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);

        // 可以监听该Activity下的所有Fragment的18个 生命周期方法
        registerFragmentLifecycleCallbacks(new FragmentLifecycleCallbacks() {

            @Override
            public void onFragmentSupportVisible(SupportFragment fragment) {
                Log.i("MainActivity", "onFragmentSupportVisible--->" + fragment.getClass().getSimpleName());
            }
        });

        if (savedInstanceState == null) {
            loadRootFragment(R.id.entry, SplashFragment.newInstance());
        }
    }

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        // 设置默认Fragment动画  默认竖向(和安卓5.0以上的动画相同)
//        return super.onCreateFragmentAnimator();
        // 设置横向(和安卓4.x动画相同)
        return new DefaultHorizontalAnimator();
        // 设置自定义动画
//        return new FragmentAnimator(enter,exit,popEnter,popExit);
    }

    @Override
    public void onBackToFirstFragment() {
        finish();
    }
}
