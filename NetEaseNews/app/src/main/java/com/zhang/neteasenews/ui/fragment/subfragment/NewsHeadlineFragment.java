package com.zhang.neteasenews.ui.fragment.subfragment;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.HeadlineEntity;
import com.zhang.neteasenews.ui.adapter.NewsHeadlineAdapter;
import com.zhang.neteasenews.ui.fragment.AbsBaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class NewsHeadlineFragment extends AbsBaseFragment {

    private Context context;
    private NewsHeadlineAdapter newsHeadlineAdapter;
    private List<HeadlineEntity> datas;
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
        datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datas.add(new HeadlineEntity(R.mipmap.ic_launcher, "标题" + i, "时间" + i, "跟帖数" + i));
        }
        newsHeadlineAdapter = new NewsHeadlineAdapter(context);
        newsHeadlineAdapter.setDatas(datas);
        listView.setAdapter(newsHeadlineAdapter);
    }

    @Override
    protected void initDatas() {

    }
}
