package com.simple.happilyeverafter.ui;

import android.os.Bundle;

import com.simple.commonlibrary.base.BaseMainFragment;
import com.simple.happilyeverafter.R;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;

/**
 * Created by hych on 2017/4/14 16:34.
 */

public class SplashFragment extends BaseMainFragment {

    public static SplashFragment newInstance() {
        Bundle args = new Bundle();
        SplashFragment fragment = new SplashFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_splash;
    }

    @Override
    public void initView() {
        final int count = 2;

        Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(count + 1)
                .map(new Func1<Long, Long>() {
                    @Override
                    public Long call(Long aLong) {
                        return count - aLong;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onCompleted() {
                        replaceFragment(MainFragment.newInstance(),false);
                        pop();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                    }
                });


    }

    @Override
    protected boolean showToolbar() {
        return false;
    }
}
