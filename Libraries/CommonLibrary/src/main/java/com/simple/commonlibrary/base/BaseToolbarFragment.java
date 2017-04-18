package com.simple.commonlibrary.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.simple.commonlibrary.R;
import com.simple.commonlibrary.base.fragmentation.BaseSupportFragment;

/**
 * Created by hych on 2017/4/14 16:37.
 */

public abstract class BaseToolbarFragment extends BaseSupportFragment {

    private Toolbar mToolbar;
    private boolean showToolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.common_fragment_base, container, false);

        mToolbar = (Toolbar) view.findViewById(R.id.common_toolbar);
        if (showToolbar) {
            initToolbarNav(mToolbar, "设置", true, true, "下一步");
            mToolbar.setVisibility(View.VISIBLE);
        } else {
            mToolbar.setVisibility(View.GONE);
        }
        return view;
    }

    /**
     * 设置顶部ToolBar
     *
     * @param title    显示标题
     * @param isBack   显示返回键
     * @param showMenu 显示功能菜单栏
     * @param next     显示下一步按钮
     */
    protected void initToolbarNav(Toolbar toolbar, String title, boolean isBack, final boolean showMenu, final String next) {
        if (toolbar != null) {

            toolbar.setTitleTextColor(Color.WHITE);
            toolbar.inflateMenu(com.simple.commonlibrary.R.menu.common_toolbar_menu);

            if (title != null) {//显示标题
                toolbar.setTitle(title);
            }

            if (isBack) { //显示返回键
                toolbar.setNavigationIcon(R.mipmap.common_ic_arrow_back);
                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        _mActivity.onBackPressed();
                    }
                });
            }
            if (showMenu) { //显示功能菜单栏
                toolbar.getMenu().getItem(0).setVisible(true);
                toolbar.getMenu().getItem(1).setVisible(true);
            } else {
                toolbar.getMenu().getItem(0).setVisible(false);
                toolbar.getMenu().getItem(1).setVisible(false);
            }

            if (next != null) {//显示下一步按钮
                toolbar.getMenu().getItem(2).setVisible(true);
            } else {
                toolbar.getMenu().getItem(2).setVisible(false);
            }

            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    int itemId = item.getItemId();
                    if (itemId == R.id.action_0 && showMenu) {
                        Toast.makeText(_mActivity, "action_test_0", Toast.LENGTH_SHORT).show();

                    } else if (itemId == R.id.action_1 && showMenu) {
                        Toast.makeText(_mActivity, "action_test_1", Toast.LENGTH_SHORT).show();

                    } else if (itemId == R.id.next && next != null) {
                        Toast.makeText(_mActivity, "下一步", Toast.LENGTH_SHORT).show();

                    }
                    return true;
                }
            });
        }
    }

    public void setShowToolbar(boolean showToolbar) {
        this.showToolbar = showToolbar;
    }
}
