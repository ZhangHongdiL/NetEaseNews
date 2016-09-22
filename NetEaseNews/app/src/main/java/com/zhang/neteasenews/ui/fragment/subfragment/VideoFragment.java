package com.zhang.neteasenews.ui.fragment.subfragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.subentity.VideoEntity;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.adapter.subadapter.VideoAdapter;
import com.zhang.neteasenews.ui.fragment.AbsBaseFragment;
import com.zhang.neteasenews.utils.Values;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 新闻的视频界面
 */
public class VideoFragment extends AbsBaseFragment implements VolleyResult {

    private RecyclerView recyclerView;
    private VideoAdapter videoAdapter;
    private List<VideoEntity.视频Bean> datas;

    public static VideoFragment newInstance() {

        Bundle args = new Bundle();

        VideoFragment fragment = new VideoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_news_video;
    }

    @Override
    protected void initViews() {
        recyclerView = byView(R.id.fragment_news_video_rv);
    }

    @Override
    protected void initDatas() {
        datas = new ArrayList<>();
        videoAdapter = new VideoAdapter(context);
        recyclerView.setAdapter(videoAdapter);
        GridLayoutManager glm = new GridLayoutManager(context, 2);
        recyclerView.setLayoutManager(glm);
        VolleyInstance.getInstance().startRequest(Values.VIDEOURL, this);
    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        VideoEntity entity = gson.fromJson(resultStr, VideoEntity.class);
        datas = entity.get视频();
        videoAdapter.setDatas(datas);
    }

    @Override
    public void failure() {

    }
}
