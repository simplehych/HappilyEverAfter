package com.simple.sharelib.base;

import android.view.View;

/**
 * Created by Anthony on 2017/3/16.
 */
public interface IBaseView<T> {
    /**
     * set the presenter of mvp
     * @param presenter
     */
    void setPresenter(T presenter);

    /**
     * init the views for activity or fragment
     * @param view
     */
    void initViews(View view);
}
