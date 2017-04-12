package com.simple.commonlibrary.base;

/**
 * MVP模式-基础V
 * <p>
 * Created by hych on 2017/4/12.
 */

public interface BaseView {
    void startLoading(String message);

    void endLoading(String message);

    void showMessage(String message);
}
