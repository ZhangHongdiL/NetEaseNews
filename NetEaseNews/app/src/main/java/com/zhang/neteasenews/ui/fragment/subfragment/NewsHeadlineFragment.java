package com.zhang.neteasenews.ui.fragment.subfragment;

import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.adapter.subadapter.NewsHeadlineAdapter;
import com.zhang.neteasenews.ui.fragment.AbsBaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 新闻头条的Fragment
 */
public class NewsHeadlineFragment extends AbsBaseFragment implements VolleyResult {

    private NewsHeadlineAdapter newsHeadlineAdapter;
    private List<HeadlineEntity.T1348647909107Bean> datas;
    private ListView listView;

    public static NewsHeadlineFragment newInstance(String url) {
        
        Bundle args = new Bundle();
        args.putString("url",url);
        NewsHeadlineFragment fragment = new NewsHeadlineFragment();
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
        newsHeadlineAdapter = new NewsHeadlineAdapter(context);
        listView.setAdapter(newsHeadlineAdapter);
        Bundle bundle = getArguments();
        String allUrl = bundle.getString("url");
        VolleyInstance.getInstance().startRequest(allUrl, this);
    }

    @Override
    public void success(String resultStr) {
//        Log.d("NewsHeadlineFragment", resultStr);
        Gson gson = new Gson();
        HeadlineEntity headlineEntity = gson.fromJson(resultStr, HeadlineEntity.class);
        datas = headlineEntity.getT1348647909107();
        newsHeadlineAdapter.setDatas(datas);

    }

    @Override
    public void failure() {


    }
}
