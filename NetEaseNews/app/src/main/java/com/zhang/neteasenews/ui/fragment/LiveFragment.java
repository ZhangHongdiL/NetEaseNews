package com.zhang.neteasenews.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.LiveListViewEntity;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.adapter.LiveListViewAdapter;
import com.zhang.neteasenews.utils.Values;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 直播界面Fragment
 */
public class LiveFragment extends AbsBaseFragment implements VolleyResult {

    private Context context;
    private ListView listView;
    private List<LiveListViewEntity.T1462958418713Bean> datas;
    private LiveListViewAdapter liveListViewAdapter;

    public static LiveFragment newInstance() {

        Bundle args = new Bundle();

        LiveFragment fragment = new LiveFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_live;
    }

    @Override
    protected void initViews() {
        listView = byView(R.id.fragment_live_lv);
    }

    @Override
    protected void initDatas() {
        VolleyInstance.getInstance().startRequest(Values.LIVEURL, this);
        datas = new ArrayList<>();
        liveListViewAdapter = new LiveListViewAdapter(context);
        listView.setAdapter(liveListViewAdapter);
    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        LiveListViewEntity liveListViewEntity = gson.fromJson(resultStr, LiveListViewEntity.class);
        List<LiveListViewEntity.T1462958418713Bean> datas = liveListViewEntity.getT1462958418713();
        liveListViewAdapter.setDatas(datas);
    }

    @Override
    public void failure() {

    }
}
