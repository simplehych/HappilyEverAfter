package com.simple.happilyeverafter.test.XXX.fragments.testfragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.simple.happilyeverafter.R;
import com.simple.happilyeverafter.test.XXX.adapter.TestAdapter;
import com.simple.happilyeverafter.test.XXX.bean.EBeanType;
import com.simple.happilyeverafter.test.XXX.bean.TestBeanOne;
import com.simple.happilyeverafter.test.XXX.bean.TestBeanTwo;
import com.simple.commonlibrary.test.base.BaseFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Anthony on 2017/3/16.
 */
public class TestFragment extends BaseFragment implements ITestContract.View {

    @BindView(R.id.test_swipe_refresh_layout)
    SwipeRefreshLayout mTestSwipeRefreshLayout;
    @BindView(R.id.test_recycler_view)
    RecyclerView mTestRecyclerView;

    private Context mContext;
    private ITestContract.Presenter mTestPresnter;
    private TestAdapter mTestAdapter;

    public static TestFragment newInstance() {
        return new TestFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        ButterKnife.bind(this, view);
        mContext = getActivity();
        initViews(view);
        setHasOptionsMenu(true);

        mTestPresnter = new TestPresenter(mContext,this);

        mTestPresnter.loadResults(false);

        mTestSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mTestPresnter.loadResults(true);
            }
        });
        return view;
    }


    @Override
    public void setPresenter(Object presenter) {
        this.mTestPresnter = (ITestContract.Presenter) presenter;
    }

    @Override
    public void initViews(View view) {
        mTestSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mTestRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.test_frament, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.action_test_0:
                Toast.makeText(mContext, "action_test_0", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_test_1:
                Toast.makeText(mContext, "action_test_1", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void showResults(ArrayList<TestBeanOne> testBeanOneList, ArrayList<TestBeanTwo> testBeanTwoList, ArrayList<Integer> types) {

        if (mTestAdapter == null) {
            mTestAdapter = new TestAdapter(mContext,testBeanOneList,testBeanTwoList,types);
            mTestAdapter.setOnTestItemClickListener(new TestAdapter.OnTestItemClickListener() {
                @Override
                public void onTestItemClick(View view, int position) {
                    int type = mTestRecyclerView.findViewHolderForLayoutPosition(position).getItemViewType();
                    switch (type) {
                        case TestAdapter.TYPE_0:
                            mTestPresnter.startReading(EBeanType.TYPE_0,position);
                            break;
                        case TestAdapter.TYPE_1:
                            mTestPresnter.startReading(EBeanType.TYPE_1,position);
                            break;
                        default:
                            break;
                    }
                }
            });
            mTestRecyclerView.setAdapter(mTestAdapter);
        } else {
            mTestAdapter.notifyDataSetChanged();
        }
        stopLoading();
    }

    @Override
    public void notifyDataChanged() {
        mTestPresnter.loadResults(true);
        mTestAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {
        mTestSwipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void stopLoading() {
        mTestSwipeRefreshLayout.setRefreshing(false);
    }
}
