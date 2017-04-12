package com.simple.commonlibrary.test.base;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Anthony on 2017/3/17.
 */
public class BaseViewPager extends ViewPager {

    private boolean mIsCanSlide = true;

    public BaseViewPager(Context context) {
        super(context);
    }

    public BaseViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setIsCanSlide(boolean isCanSlide) {
        this.mIsCanSlide = isCanSlide;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (mIsCanSlide) {
            return super.onInterceptTouchEvent(event);
        } else {
            return false;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        if (mIsCanSlide)
            return super.onTouchEvent(arg0);
        else
            return false;
    }
}
