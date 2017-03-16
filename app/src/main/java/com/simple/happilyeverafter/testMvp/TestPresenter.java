package com.simple.happilyeverafter.testmvp;


import com.simple.sharelib.testbase.BasePresenter;
import com.simple.sharelib.testbase.IBaseModel;
import com.simple.sharelib.testbase.IBaseView;

/**
 * Created by Anthony on 2017/3/10.
 */
public class TestPresenter extends BasePresenter<IBaseView> {

    private IBaseView mView;
    private IBaseModel mModel = new TestModel();

    public TestPresenter(IBaseView mView) {
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
