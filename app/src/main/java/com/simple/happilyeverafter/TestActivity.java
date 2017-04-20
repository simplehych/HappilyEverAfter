package com.simple.happilyeverafter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.simple.commonlibrary.arouter.RouterManager;
import com.simple.happilyeverafter.ui.MainFragment;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;

/**
 * Created by hych on 2017/4/17 16:47.
 */

public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
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
                        ARouter.getInstance().build(RouterManager.USER_TEST).navigation();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                    }
                });

        new String();

    }

    String[] mArray =
    public void zero() {
        int sum = 0;
        for (int i = 0; i < mArray.length; ++i) {
            sum += mArray[i].mSplat;
        }
    }

    // 相对zero()来说，这种写法会更快些，在存在JIT的情况下速度几乎和two()速度一样快。
    public void one() {
        int sum = 0;
        // 1) 通过本地化变量，减少查询，在不存在JIT的手机下，优化较明显。
        String[] localArray = mArray;
        // 2) 获取队列长度，减少每次遍历访问变量的长度，有效优化。
        int len = localArray.length;

        for (int i = 0; i < len; ++i) {
            sum += localArray[i].mSplat;
        }
    }

    // 在无JIT的设备中，是最快的遍历方式，在存在JIT的设备中，与one()差不多快。
    public void two() {
        int sum = 0;
        for (String a : mArray) {
            sum += a.mSplat;
        }
    }
}
