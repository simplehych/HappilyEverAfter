package com.simple.commonlibrary.manager;

import android.app.Activity;
import android.content.Context;

import java.util.Stack;

/**
 * Activity管理类
 * <p>
 * Created by hych on 2017/4/12.
 */

public class ActivityManager {

    private static Stack<Activity> sActivityStack;
    private volatile static ActivityManager sInstance;

    private ActivityManager() {

    }

    /**
     * 单一实例
     */
    public static ActivityManager getInstance() {
        if (sInstance == null) {
            synchronized (ActivityManager.class) {
                if (sInstance == null) {
                    sInstance = new ActivityManager();
                    sInstance.sActivityStack = new Stack();
                }
            }

        }
        return sInstance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (sActivityStack == null) {
            sActivityStack = new Stack<Activity>();
        }
        sActivityStack.add(activity);
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        try {
            Activity activity = sActivityStack.lastElement();
            return activity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取当前Activity的前一个Activity
     */
    public Activity preActivity() {
        int index = sActivityStack.size() - 2;
        if (index < 0) {
            return null;
        }
        Activity activity = sActivityStack.get(index);
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        Activity activity = sActivityStack.lastElement();
        finishActivity(activity);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            sActivityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * 移除指定的Activity
     */
    public void removeActivity(Activity activity) {
        if (activity != null) {
            sActivityStack.remove(activity);
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        try {
            for (Activity activity : sActivityStack) {
                if (activity.getClass().equals(cls)) {
                    finishActivity(activity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = sActivityStack.size(); i < size; i++) {
            if (null != sActivityStack.get(i)) {
                sActivityStack.get(i).finish();
            }
        }
        sActivityStack.clear();
    }

    /**
     * 返回到指定的activity
     *
     * @param cls
     */
    public void returnToActivity(Class<?> cls) {
        while (sActivityStack.size() != 0)
            if (sActivityStack.peek().getClass() == cls) {
                break;
            } else {
                finishActivity(sActivityStack.peek());
            }
    }


    /**
     * 是否已经打开指定的activity
     *
     * @param cls
     * @return
     */
    public boolean isOpenActivity(Class<?> cls) {
        if (sActivityStack != null) {
            for (int i = 0, size = sActivityStack.size(); i < size; i++) {
                if (cls == sActivityStack.peek().getClass()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 退出应用程序
     *
     * @param context      上下文
     * @param isBackground 是否开开启后台运行
     */
    public void AppExit(Context context, Boolean isBackground) {
        try {
            finishAllActivity();
            android.app.ActivityManager activityMgr = (android.app.ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.restartPackage(context.getPackageName());
        } catch (Exception e) {

        } finally {
            if (!isBackground) {
                System.exit(0);
            }
        }
    }
}
