package com.simple.happilyeverafter.testMvp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.simple.happilyeverafter.R;
import com.simple.sharelib.base.BaseActivity;
import com.simple.sharelib.base.IBaseView;


import butterknife.BindView;

public class TestView extends BaseActivity<IBaseView, TestPresenter> {


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
        Toast.makeText(this,"loadDataSuccess",Toast.LENGTH_SHORT).show();
        mTestTxt.setText("loadDataSuccess");
    }

    @Override
    public void failure() {
        Toast.makeText(this,"loadDataFail",Toast.LENGTH_SHORT).show();
        mTestTxt.setText("loadDataFail");
    }
}
