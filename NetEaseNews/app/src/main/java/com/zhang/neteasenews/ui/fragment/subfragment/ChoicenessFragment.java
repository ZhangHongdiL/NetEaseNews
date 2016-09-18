package com.zhang.neteasenews.ui.fragment.subfragment;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.subentity.ChoicenessEntity;
import com.zhang.neteasenews.model.entity.subentity.HeadlineEntity;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.adapter.subadapter.ChoicenessAdapter;
import com.zhang.neteasenews.ui.adapter.subadapter.NewsHeadlineAdapter;
import com.zhang.neteasenews.ui.fragment.AbsBaseFragment;
import com.zhang.neteasenews.utils.Values;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/14.
 * 新闻的精选界面
 */
public class ChoicenessFragment extends AbsBaseFragment implements VolleyResult {

    private Context context;
    private ListView listView;
    private List<ChoicenessEntity.T1467284926140Bean> datas;
    private ChoicenessAdapter choicenessAdapter;

    public static ChoicenessFragment newInstance() {

        Bundle args = new Bundle();

        ChoicenessFragment fragment = new ChoicenessFragment();
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
        VolleyInstance.getInstance().startRequest(Values.CHOICENESSURL, this);
        datas = new ArrayList<>();
        choicenessAdapter = new ChoicenessAdapter(context);
        listView.setAdapter(choicenessAdapter);
    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        ChoicenessEntity choicenessEntity = gson.fromJson(resultStr, ChoicenessEntity.class);
        datas = choicenessEntity.getT1467284926140();
        choicenessAdapter.setDatas(datas);
    }

    @Override
    public void failure() {

    }
}
