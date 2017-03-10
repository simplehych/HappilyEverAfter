package com.simple.happilyeverafter.testMvp;

import android.os.Bundle;
import android.widget.TextView;

import com.simple.happilyeverafter.R;
import com.simple.sharelib.Base.BaseView;
import com.simple.sharelib.Base.IBaseView;

import butterknife.BindView;

public class TestView extends BaseView<IBaseView, TestPresenter> {


    @BindView(R.id.test_txt)
    TextView mTestTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.fetch();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected TestPresenter createPresenter() {
        return new TestPresenter(this);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void success() {
        mTestTxt.setText("loadDataSuccess");
    }

    @Override
    public void failure() {
        mTestTxt.setText("loadDataFail");
    }
}
