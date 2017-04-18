package com.simple.commonlibrary.arouter;

import android.content.Context;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * 用户中心内容提供接口
 * Created by hych on 2017/4/17 14:25.
 */
public interface IUserProvider extends IProvider {

    /**
     *
     * @return
     */
    boolean isLogin();
}
