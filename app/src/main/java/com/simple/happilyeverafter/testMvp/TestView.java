package com.simple.happilyeverafter.testmvp;

import android.os.Bundle;
import android.widget.TextView;

import com.simple.happilyeverafter.R;
import com.simple.sharelib.testbase.BaseActivity;
import com.simple.sharelib.testbase.IBaseView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestView extends BaseActivity<IBaseView,TestPresenter> {


    @BindView(R.id.test_txt)
    TextView mTestTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        mTestTxt.setText("ButterKnife");
        mPresenter.fetch();
    }

    @Override
    protected TestPresenter createPresenter() {
        return new TestPresenter(this);
    }

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_test;
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
