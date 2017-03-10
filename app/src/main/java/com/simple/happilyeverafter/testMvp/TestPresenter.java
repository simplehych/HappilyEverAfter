package com.simple.happilyeverafter.testMvp;

import com.simple.sharelib.Base.BasePresenter;
import com.simple.sharelib.Base.IBaseModel;
import com.simple.sharelib.Base.IBaseView;

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
