package com.simple.commonlibrary.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by hych on 2017/4/12.
 */

public class ToastUtils {

    private final static String TAG = "Simple";

    public static void showShort(Context context, int resId) {
        String msg = "";
        try {
            msg = context.getResources().getString(resId);
        } catch (Exception e) {
            msg = TAG + ": " + e.getMessage();
        }
        showShort(context, msg);
    }

    public static void showShort(Context context, String msg) {
        if (null == context || null == msg || msg.equals("") || msg.length() == 0) {
            return;
        }
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static void showLong(Context context, int resId) {
        String msg = "";
        try {
            msg = context.getResources().getString(resId);
        } catch (Exception e) {
            msg = TAG + ": " + e.getMessage();
        }
        showLong(context, msg);
    }

    public static void showLong(Context context, String msg) {
        if (null == context || null == msg || msg.equals("") || msg.length() == 0) {
            return;
        }
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
