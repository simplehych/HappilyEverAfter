package com.simple.happilyeverafter.modules.fragments.testfragment;

import com.simple.happilyeverafter.bean.EBeanType;
import com.simple.happilyeverafter.bean.TestBeanOne;
import com.simple.happilyeverafter.bean.TestBeanTwo;
import com.simple.sharelib.base.IBasePresenter;
import com.simple.sharelib.base.IBaseView;

import java.util.ArrayList;

/**
 * Created by Anthony on 2017/3/16.
 */
public interface ITestContract {

    interface View extends IBaseView {

        void showResults(ArrayList<TestBeanOne> testBeanOneList, ArrayList<TestBeanTwo> testBeanTwoList, ArrayList<Integer> types);

        void notifyDataChanged();

        void showLoading();

        void stopLoading();

    }

    interface Presenter extends IBasePresenter {

        void loadResults(boolean refresh);

        void startReading(EBeanType type, int position);

        void checkForFreshData();

        void feelLucky();

    }
}
