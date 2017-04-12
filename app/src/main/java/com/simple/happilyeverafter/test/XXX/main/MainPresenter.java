package com.simple.happilyeverafter.test.XXX.main;

import com.simple.commonlibrary.test.base.testbase.BasePresenter;
import com.simple.commonlibrary.test.base.testbase.IBaseModel;
import com.simple.commonlibrary.test.base.testbase.IBaseView;

/**
 * Created by Anthony on 2017/3/14.
 */
public class MainPresenter extends BasePresenter<IBaseView>  {

    private IBaseView mView;
    private IBaseModel mModel = new MainModel();

    public MainPresenter(IBaseView mView) {
        this.mView = mView;
    }

    public void fetch(){
        mModel.loadData(new IBaseModel.GirlOnLoadListener() {
            @Override
            public void onComplete() {
                mView.success();
            }

            @Override
            public void onFail() {
                mView.failure();
            }
        });

    }

}
