package com.simple.happilyeverafter.test.XXX.main;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.launcher.ARouter;
import com.simple.happilyeverafter.R;
import com.simple.happilyeverafter.test.XXX.fragments.homefragment.HomeFragment;
import com.simple.happilyeverafter.test.XXX.fragments.testfragment.TestFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Anthony on 2017/3/14.
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.main_nav_view)
    NavigationView mNavigationView;
    @BindView(R.id.main_content)
    FrameLayout mMainContent;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    private FragmentManager mFragmentManager = getSupportFragmentManager();
    private HomeFragment mHomeFragment;
    private TestFragment mTestFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ARouter.getInstance().build("/test/1").navigation();

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        if (savedInstanceState != null) {
            mHomeFragment = (HomeFragment) mFragmentManager.getFragment(savedInstanceState, "HomeFragment");
            mTestFragment = (TestFragment) mFragmentManager.getFragment(savedInstanceState, "TestFragment");
        } else {
            mHomeFragment = HomeFragment.newInstance();
            mTestFragment = TestFragment.newInstance();
        }

        if (!mHomeFragment.isAdded()) {
            mFragmentManager.beginTransaction()
                    .add(R.id.main_content, mHomeFragment, "HomeFragment")
                    .commit();
        }

        if (!mTestFragment.isAdded()) {
            mFragmentManager.beginTransaction()
                    .add(R.id.main_content, mTestFragment, "TestFragment")
                    .commit();
        }
        showHomeFragment();
    }

    private void initView() {
        //Navigation-DrawerLayout
        initNavigationDrawerLayout();
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void initNavigationDrawerLayout() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);
        //设置默认选中的item
        mNavigationView.setCheckedItem(R.id.nav_item_1);
    }

    private void showHomeFragment() {

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.show(mHomeFragment);
        fragmentTransaction.hide(mTestFragment);
        fragmentTransaction.commit();

        if (mHomeFragment.isAdded()) {
            mHomeFragment.notifyDataChanged();
        }
    }

    private void showTestFragment() {

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.show(mTestFragment);
        fragmentTransaction.hide(mHomeFragment);
        fragmentTransaction.commit();

        if (mTestFragment.isAdded()) {
            mTestFragment.notifyDataChanged();
        }
    }


    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_item_1:
                showHomeFragment();
                break;
            case R.id.nav_item_2:
                showTestFragment();
                break;
            case R.id.nav_item_3:
                break;
            case R.id.nav_setting:
                break;
            case R.id.nav_about:
                break;
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mTestFragment.isAdded()) {
            mFragmentManager.putFragment(outState, "TestFragment", mTestFragment);
        }

        if (mHomeFragment.isAdded()) {
            mFragmentManager.putFragment(outState, "HomeFragment", mHomeFragment);
        }
    }
}
