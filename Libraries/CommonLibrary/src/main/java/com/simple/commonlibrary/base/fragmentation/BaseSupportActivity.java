package com.simple.commonlibrary.base.fragmentation;

import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * 采用Fragmentation框架，单Activity多fragment
 *
 * Created by hych on 2017/4/14 16:20.
 */

public abstract class BaseSupportActivity extends SupportActivity {

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        // 设置默认Fragment动画  默认竖向(和安卓5.0以上的动画相同)
        return super.onCreateFragmentAnimator();
        // 设置横向(和安卓4.x动画相同)
//        return new DefaultHorizontalAnimator();
        // 设置自定义动画
//        return new FragmentAnimator(common_enter,exit,popEnter,popExit);
    }

}
