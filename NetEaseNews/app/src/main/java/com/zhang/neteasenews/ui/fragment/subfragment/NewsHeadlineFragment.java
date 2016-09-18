package com.zhang.neteasenews.ui.fragment.subfragment;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.subentity.HeadlineEntity;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.adapter.subadapter.NewsHeadlineAdapter;
import com.zhang.neteasenews.ui.fragment.AbsBaseFragment;
import com.zhang.neteasenews.utils.Values;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 新闻头条的Fragment
 */
public class NewsHeadlineFragment extends AbsBaseFragment implements VolleyResult {

    private Context context;
    private NewsHeadlineAdapter newsHeadlineAdapter;
    private List<HeadlineEntity.T1348647909107Bean> datas;
    private ListView listView;

    public static NewsHeadlineFragment newInstance() {
        
        Bundle args = new Bundle();
        
        NewsHeadlineFragment fragment = new NewsHeadlineFragment();
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
        return R.layout.fragment_news_headline;
    }

    @Override
    protected void initViews() {
        listView = byView(R.id.fragment_news_headline_lv);
    }

    @Override
    protected void initDatas() {
        VolleyInstance.getInstance().startRequest(Values.HEADLINEURL, this);
        datas = new ArrayList<>();
        newsHeadlineAdapter = new NewsHeadlineAdapter(context);
        listView.setAdapter(newsHeadlineAdapter);
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
