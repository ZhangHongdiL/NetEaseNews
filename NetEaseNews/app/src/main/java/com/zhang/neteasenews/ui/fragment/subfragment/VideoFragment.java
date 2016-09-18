package com.zhang.neteasenews.ui.fragment.subfragment;

import android.os.Bundle;

import com.zhang.neteasenews.ui.fragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/14.
 * 新闻的视频界面
 */
public class VideoFragment extends AbsBaseFragment{

    public static VideoFragment newInstance() {

        Bundle args = new Bundle();

        VideoFragment fragment = new VideoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return 0;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDatas() {

    }
}
