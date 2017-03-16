package com.simple.happilyeverafter.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.simple.happilyeverafter.R;
import com.simple.happilyeverafter.bean.TestBeanOne;
import com.simple.happilyeverafter.bean.TestBeanTwo;
import com.simple.happilyeverafter.testmvp.TestView;

import java.util.ArrayList;

/**
 * Created by Anthony on 2017/3/16.
 */
public class TestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private final LayoutInflater mInflater;

    private ArrayList<TestBeanOne> mTestBeanOneList;
    private ArrayList<TestBeanTwo> mTestBeanTwoList;
    private ArrayList<Integer> mTypes;

    private OnTestItemClickListener mOnTestItemClickListener;

    public static final int TYPE_0_h = 0;
    public static final int TYPE_0 = 1;
    public static final int TYPE_1_h = 2;
    public static final int TYPE_1 = 3;

    public TestAdapter(Context context, ArrayList<TestBeanOne> testBeanOneList,
                       ArrayList<TestBeanTwo> testBeanTwoList, ArrayList<Integer> types) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);

        this.mTestBeanOneList = testBeanOneList;
        this.mTestBeanTwoList = testBeanTwoList;
        this.mTypes = types;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_0_h || viewType == TYPE_1_h) {
            View headItem = mInflater.inflate(R.layout.item_test_head, parent, false);
            return new TestHeadViewHolder(headItem);
        } else {
            View normalItem = mInflater.inflate(R.layout.item_test_normal, parent, false);
            return new TestNormalViewHolder(normalItem, mOnTestItemClickListener);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (mTypes.get(position)) {
            case TYPE_0_h:
                ((TestHeadViewHolder) holder).testHeadType.setText("第一种类型");
                break;
            case TYPE_0:
                if (mTestBeanOneList != null) {
                    TestBeanOne testBeanOne = mTestBeanOneList.get(position - 1);
                    ((TestNormalViewHolder) holder).testNormalTitle.setText(testBeanOne.getTestOne());
                    ((TestNormalViewHolder) holder).testNormalCover.setBackgroundColor(Color.BLUE);
                }
                break;
            case TYPE_1_h:
                ((TestHeadViewHolder) holder).testHeadType.setText("第二种类型");
                break;
            case TYPE_1:
                if (mTestBeanTwoList != null) {
                    TestBeanTwo testBeanTwo = mTestBeanTwoList.get(position - mTestBeanOneList.size() - 2);
                    ((TestNormalViewHolder) holder).testNormalTitle.setText(testBeanTwo.getTestTwo());
                    ((TestNormalViewHolder) holder).testNormalCover.setBackgroundColor(Color.GREEN);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mTypes.get(position);
    }

    @Override
    public int getItemCount() {
        return mTypes.size();
    }

    public class TestNormalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        TextView testNormalTitle;
        ImageView testNormalCover;
        OnTestItemClickListener listener;

        public TestNormalViewHolder(View normalItem, OnTestItemClickListener listener) {
            super(normalItem);
            testNormalTitle = (TextView) normalItem.findViewById(R.id.test_normal_title);
            testNormalCover = (ImageView) normalItem.findViewById(R.id.test_normal_cover);
            this.listener = listener;
            normalItem.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onTestItemClick(v, getLayoutPosition());
            }
        }
    }

    public class TestHeadViewHolder extends RecyclerView.ViewHolder {

        TextView testHeadType;

        public TestHeadViewHolder(View headItem) {
            super(headItem);
            testHeadType = (TextView) headItem.findViewById(R.id.test_head_type);
        }
    }


    public interface OnTestItemClickListener {
        void onTestItemClick(View view, int position);
    }

    public void setOnTestItemClickListener(OnTestItemClickListener listener) {
        this.mOnTestItemClickListener = listener;
    }
}
