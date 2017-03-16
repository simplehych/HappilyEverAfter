package com.simple.happilyeverafter.testmvp;


import com.simple.sharelib.testbase.IBaseModel;

/**
 * Created by Anthony on 2017/3/10.
 */
public class TestModel implements IBaseModel {

    @Override
    public void loadData(GirlOnLoadListener listener) {
        double random = Math.random();
        if (random >= 0.5) {
            listener.onComplete();
        } else {
            listener.onFail();
        }
    }
}
