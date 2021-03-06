package com.simple.happilyeverafter;

import android.os.Bundle;
import android.util.Log;

import com.simple.commonlibrary.base.BaseActivity;
import com.simple.commonlibrary.base.fragmentation.BaseSupportActivity;
import com.simple.happilyeverafter.ui.SplashFragment;

import me.yokeyword.fragmentation.SupportFragment;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import me.yokeyword.fragmentation.helper.FragmentLifecycleCallbacks;

/**
 * Created by hych on 2017/4/14 16:25.
 */

public class EntryActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 可以监听该Activity下的所有Fragment的18个 生命周期方法
        registerFragmentLifecycleCallbacks(new FragmentLifecycleCallbacks() {

            @Override
            public void onFragmentSupportVisible(SupportFragment fragment) {
                Log.i("MainActivity", "onFragmentSupportVisible--->" + fragment.getClass().getSimpleName());
            }
        });

        if (savedInstanceState == null) {
            loadRootFragment(R.id.container_entry_fl, SplashFragment.newInstance());
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_entry;
    }

    @Override
    public void initView() {

    }

}
