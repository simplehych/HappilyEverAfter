package com.simple.happilyeverafter.arouter;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 新建一个Activity用于监听Schame事件
 * 监听到Schame事件之后直接传递给ARouter即可
 * 也可以做一些自定义玩法，比方说改改URL之类的
 * http://www.example.com/test/1
 * <p>
 * Created by hych on 2017/4/11.
 */

public class SchameFilterActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 外面用户点击的URL
        Uri uri = getIntent().getData();
        // 直接传递给ARouter即可
        ARouter.getInstance().build(uri).navigation();
        finish();
    }
}