package com.simple.happilyeverafter.modules.fragments.testfragment;

import android.content.Context;
import android.widget.Toast;

import com.simple.happilyeverafter.adapter.TestAdapter;
import com.simple.happilyeverafter.bean.EBeanType;
import com.simple.happilyeverafter.bean.TestBeanOne;
import com.simple.happilyeverafter.bean.TestBeanTwo;

import java.util.ArrayList;

/**
 * Created by Anthony on 2017/3/16.
 */
public class TestPresenter implements ITestContract.Presenter {


    private Context mContext;
    private ITestContract.View mTestView;
    private ArrayList<TestBeanOne> mTestBeanOneList;
    private ArrayList<TestBeanTwo> mTestBeanTwoList;

    public TestPresenter(Context context, ITestContract.View view) {
        this.mContext = context;
        this.mTestView = view;
    }

    @Override
    public void loadResults(boolean refresh) {

        mTestBeanOneList = new ArrayList<>();
        mTestBeanTwoList = new ArrayList<>();
        ArrayList<Integer> types = new ArrayList<>();

//        types.add(TestAdapter.TYPE_0_h);
//        int i = 0;
//        do {
//            i++;
//            types.add(TestAdapter.TYPE_0);
//            mTestBeanOneList.add(new TestBeanOne("TestBeanOne--" + i));
//        } while (i == 10);
//        types.add(TestAdapter.TYPE_1_h);
//        do {
//            i++;
//            types.add(TestAdapter.TYPE_0);
//            mTestBeanTwoList.add(new TestBeanTwo("TestBeanTwo--" + i));
//        } while (i == 10);
        types.add(TestAdapter.TYPE_0_h);
        types.add(TestAdapter.TYPE_0);
        mTestBeanOneList.add(new TestBeanOne("TestBeanOne--0"));
        types.add(TestAdapter.TYPE_0);
        mTestBeanOneList.add(new TestBeanOne("TestBeanOne--1"));
        types.add(TestAdapter.TYPE_0);
        mTestBeanOneList.add(new TestBeanOne("TestBeanOne--2"));
        types.add(TestAdapter.TYPE_0);
        mTestBeanOneList.add(new TestBeanOne("TestBeanOne--3"));
        types.add(TestAdapter.TYPE_0);
        mTestBeanOneList.add(new TestBeanOne("TestBeanOne--4"));
        types.add(TestAdapter.TYPE_1_h);
        types.add(TestAdapter.TYPE_1);
        mTestBeanTwoList.add(new TestBeanTwo("TestBeanTwo--0"));
        types.add(TestAdapter.TYPE_1);
        mTestBeanTwoList.add(new TestBeanTwo("TestBeanTwo--1"));
        types.add(TestAdapter.TYPE_1);
        mTestBeanTwoList.add(new TestBeanTwo("TestBeanTwo--2"));
        types.add(TestAdapter.TYPE_1);
        mTestBeanTwoList.add(new TestBeanTwo("TestBeanTwo--3"));
        types.add(TestAdapter.TYPE_1);
        mTestBeanTwoList.add(new TestBeanTwo("TestBeanTwo--4"));
        mTestView.showResults(mTestBeanOneList, mTestBeanTwoList, types);
    }

    @Override
    public void startReading(EBeanType type, int position) {

        switch (type) {
            case TYPE_0:
                Toast.makeText(mContext, "第一种类型" + (position - 1), Toast.LENGTH_SHORT).show();
                break;
            case TYPE_1:
                Toast.makeText(mContext, "第二种类型" + (position - mTestBeanOneList.size() - 2), Toast.LENGTH_SHORT).show();
                break;
            default:
                break;

        }

    }

    @Override
    public void checkForFreshData() {

    }

    @Override
    public void feelLucky() {

    }

    public void start() {

    }
}
