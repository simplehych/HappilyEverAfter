package com.simple.happilyeverafter.test.XXX.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simple.commonlibrary.test.base.BaseFragment;
import com.simple.happilyeverafter.R;

import java.util.ArrayList;
/**
 * Created by Anthony on 2017/3/17.
 */
public class FragmentFour extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        ArrayList<String> imgList = new ArrayList<>();
        imgList.add("");
        imgList.add("");
        imgList.add("");

//
//        //    compile 'com.github.qdxxxx:BezierViewPager:v1.0.2'
//
//        CardPagerAdapter cardAdapter = new CardPagerAdapter(getContext());
//        cardAdapter.addImgUrlList(imgList);  //放置图片url的list
//
//        BezierViewPager viewPager = (BezierViewPager) view.findViewById(R.id.view_page);
//        viewPager.setAdapter(cardAdapter);
//
//        BezierRoundView bezRound = (BezierRoundView) view.findViewById(R.id.bezRound);
//        bezRound.attach2ViewPage(viewPager);
    }
}
