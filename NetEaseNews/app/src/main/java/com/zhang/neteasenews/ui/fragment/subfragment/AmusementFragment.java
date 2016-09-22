package com.zhang.neteasenews.ui.fragment.subfragment;

import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.subentity.AmusementEntity;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.adapter.subadapter.AmusementAdapter;
import com.zhang.neteasenews.ui.fragment.AbsBaseFragment;
import com.zhang.neteasenews.utils.Values;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dllo on 16/9/22.
 * 新闻界面娱乐页
 */
public class AmusementFragment extends AbsBaseFragment implements VolleyResult {

    private ListView listView;
    private AmusementAdapter amusementAdapter;
    private List<AmusementEntity.T1348648517839Bean> datas;

    public static AmusementFragment newInstance() {
        
        Bundle args = new Bundle();
        
        AmusementFragment fragment = new AmusementFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.fragment_news_headline;
    }

    @Override
    protected void initViews() {
        listView = byView(R.id.fragment_news_headline_lv);
    }

    @Override
    protected void initDatas() {
        datas = new ArrayList<>();
        amusementAdapter = new AmusementAdapter(context);
        listView.setAdapter(amusementAdapter);
        VolleyInstance.getInstance().startRequest(Values.AMUSEMENTURL, this);
    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        AmusementEntity amusementEntity = gson.fromJson(resultStr, AmusementEntity.class);
        datas = amusementEntity.getT1348648517839();
        amusementAdapter.setDatas(datas);
    }

    @Override
    public void failure() {

    }
}
