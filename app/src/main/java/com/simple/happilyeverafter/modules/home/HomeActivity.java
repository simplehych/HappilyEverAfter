package com.simple.happilyeverafter.modules.home;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.simple.happilyeverafter.R;
import com.simple.happilyeverafter.modules.SnackBarActivity;
import com.simple.happilyeverafter.modules.fragments.testfragment.TestFragment;
import com.simple.happilyeverafter.modules.fragments.testfragment.TestPresenter;
import com.simple.sharelib.testbase.BaseActivity;
import com.simple.sharelib.testbase.IBaseView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Anthony on 2017/3/14.
 */
public class HomeActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener, NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.home_nav_view)
    NavigationView mNavigationView;
    @BindView(R.id.home_toolbar)
    Toolbar mHomeToolbar;
    @BindView(R.id.home_content)
    FrameLayout mHomeContent;
    @BindView(R.id.home_bottom_nav_bar)
    BottomNavigationBar mBottomNavBar;
    @BindView(R.id.home_fab_btn)
    FloatingActionButton mFabBtn;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    private ViewPager mViewPager;
    private FragmentManager mFragmentManager = getSupportFragmentManager();
    private BadgeItem mBadgeItem;
    private int lastSelectedNavBottomPos = 0;
    private boolean isShowBadge = true;//show BadgeItem or hide
    private TestFragment mTestFragment;

    public static final String ACTION_FRAGMENT01 = "com.simple.happilyeverafter.modules.fragments.fragment01";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initView();

        if (savedInstanceState != null) {
            mTestFragment = (TestFragment) mFragmentManager.getFragment(savedInstanceState, "TestFragment");
        } else {
            mTestFragment = TestFragment.newInstance();
        }

        if (!mTestFragment.isAdded()) {
            mFragmentManager.beginTransaction()
                    .add(R.id.home_content, mTestFragment, "TestFragment")
                    .commit();
        }

        showFragment01();
    }

    private void initView() {
        //Navigation-DrawerLayout
        initNavigationDrawerLayout();
        //Navigation-BottomBar
        initNavigationBottomBar();
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void initNavigationDrawerLayout() {
        setSupportActionBar(mHomeToolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mHomeToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);
        //设置默认选中的item
        mNavigationView.setCheckedItem(R.id.nav_item_1);
    }

    private void initNavigationBottomBar() {

        mBottomNavBar.clearAll();
        /**
         * FloatingActionButton attach to NavigationBottomBar
         */
        mBottomNavBar.setFab(mFabBtn);
        /**
         * NavigationBottomBar show number BadgeItem
         */
        mBadgeItem = new BadgeItem()
                .setBorderWidth(4)
                .setBackgroundColorResource(R.color.blue)
                .setText("" + lastSelectedNavBottomPos)
                .setHideOnSelect(isShowBadge);
        /**
         * set Mode for BottomNavigationBar
         *      1.MODE_FIXED
         *      2.MODE_SHIFTING
         */
        mBottomNavBar.setMode(BottomNavigationBar.MODE_FIXED);
        /**
         * set BackgroundStyle for BottomNavigationBar
         *      1.BACKGROUND_STYLE_STATIC
         *      2.BACKGROUND_STYLE_RIPPLE
         */
        mBottomNavBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        /**
         * set Number for BottomNavigationBar
         */
        int navBottomCount = 5;
        switch (navBottomCount) {
            case 3:
                mBottomNavBar
                        .addItem(new BottomNavigationItem(R.drawable.ic_location_on_white_24dp, "Nearby").setActiveColorResource(R.color.orange).setBadgeItem(mBadgeItem))
                        .addItem(new BottomNavigationItem(R.drawable.ic_find_replace_white_24dp, "Find").setActiveColorResource(R.color.teal))
                        .addItem(new BottomNavigationItem(R.drawable.ic_favorite_white_24dp, "Categories").setActiveColorResource(R.color.blue))
                        .setFirstSelectedPosition(lastSelectedNavBottomPos > 2 ? 2 : lastSelectedNavBottomPos)
                        .initialise();
                break;
            case 4:
                mBottomNavBar
                        .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "Home").setActiveColorResource(R.color.orange).setBadgeItem(mBadgeItem))
                        .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "Books").setActiveColorResource(R.color.teal))
                        .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "Music").setActiveColorResource(R.color.blue))
                        .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "Movies & TV").setActiveColorResource(R.color.brown))
                        .setFirstSelectedPosition(lastSelectedNavBottomPos > 3 ? 3 : lastSelectedNavBottomPos)
                        .initialise();
                break;
            default:
                mBottomNavBar
                        .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "Home").setActiveColorResource(R.color.orange))
                        .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "Books").setActiveColorResource(R.color.teal))
                        .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "Music").setActiveColorResource(R.color.blue))
                        .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "Movies & TV").setActiveColorResource(R.color.brown))
                        .addItem(new BottomNavigationItem(R.drawable.ic_videogame_asset_white_24dp, "Games").setActiveColorResource(R.color.grey))
                        .setFirstSelectedPosition(lastSelectedNavBottomPos)
                        .initialise();
                break;
        }
        mBottomNavBar.setTabSelectedListener(this);
    }

    private void showFragment01() {

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.show(mTestFragment);
        fragmentTransaction.commit();

        mHomeToolbar.setTitle("testFragment01");

        if (mTestFragment.isAdded()) {
            mTestFragment.notifyDataChanged();
        }
    }
    private void hideFragment01() {

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.hide(mTestFragment);
        fragmentTransaction.commit();

        mHomeToolbar.setTitle("");

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
        String string = null;
        switch (id) {
            case R.id.nav_item_1:
                string = "nav_item_1";
                break;
            case R.id.nav_item_2:
                string = "nav_item_2";
                break;
            case R.id.nav_item_3:
                string = "nav_item_3";
                break;
            case R.id.nav_setting:
                string = "设置";
                break;
            case R.id.nav_about:
                string = "关于";
                break;
        }
        if (!TextUtils.isEmpty(string)) {
            Toast.makeText(HomeActivity.this, "你点击了" + string, Toast.LENGTH_SHORT).show();
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.home_action_menu, menu);
//        //false hide or true show,
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        switch (id) {
//            case R.id.menu_github:
//                String url = "https://github.com/Ashok-Varma/BottomNavigation";
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//                return true;
//            case R.id.action_settings:
//                startActivity(new Intent(this, SnackBarActivity.class));
//                return true;
//            case R.id.action_another:
//                Toast.makeText(this, "action_another", Toast.LENGTH_SHORT).show();
//                return true;
//            default:
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }


    @Override
    public void onTabSelected(int position) {
        lastSelectedNavBottomPos = position;
        if (mBadgeItem != null) {
            mBadgeItem.setText(Integer.toString(position));
        }

        switch (position) {
            case 0:
                showFragment01();
                break;
            default:
                hideFragment01();
                break;
        }

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @OnClick(R.id.home_fab_btn)
    public void onClick() {
        /**
         * test function
         *  0: BottomNavigationBar toggle
         *  1: pop SnackBar
         */
        int i = 1;
        switch (i) {
            case 0:
                if (mBottomNavBar != null) {
                    mBottomNavBar.toggle();
                }
                break;
            case 1:
                final Snackbar snackbar = Snackbar.make(mHomeContent, "Fab SnackBar test", Snackbar.LENGTH_SHORT);
                snackbar.setAction("dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                });
                snackbar.show();
                break;
            case 3:
                break;
            default:
                break;
        }

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mTestFragment.isAdded()) {
            getSupportFragmentManager().putFragment(outState, "TestFragment", mTestFragment);
        }
    }
}
