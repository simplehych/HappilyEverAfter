package com.simple.happilyeverafter.test.XXX.fragments.testfragment;

import com.simple.happilyeverafter.test.XXX.bean.EBeanType;
import com.simple.happilyeverafter.test.XXX.bean.TestBeanOne;
import com.simple.happilyeverafter.test.XXX.bean.TestBeanTwo;
import com.simple.commonlibrary.test.base.IBasePresenter;
import com.simple.commonlibrary.test.base.IBaseView;

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
