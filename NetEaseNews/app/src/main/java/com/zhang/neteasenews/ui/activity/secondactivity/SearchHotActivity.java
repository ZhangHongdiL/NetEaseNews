package com.zhang.neteasenews.ui.activity.secondactivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.subentity.SearchHotEntity;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.activity.AbsBaseActivity;
import com.zhang.neteasenews.ui.adapter.subadapter.SearchHotAdapter;
import com.zhang.neteasenews.utils.Values;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻界面点击搜索的跳转界面
 */
public class SearchHotActivity extends AbsBaseActivity implements VolleyResult, View.OnClickListener {

    private ImageView backImg;
    private TextView moreTv;
    private RecyclerView recyclerView;
    private SearchHotAdapter searchHotAdapter;
    private List<SearchHotEntity.HotWordListBean> datas;

    @Override
    protected int setLayout() {
        return R.layout.activity_search_hot;
    }

    @Override
    protected void initViews() {
        backImg = byView(R.id.act_search_back_img);
        moreTv = byView(R.id.item_search_more_tv);
        recyclerView = byView(R.id.item_search_hot_rl);
    }

    @Override
    protected void initDatas() {
        backImg.setOnClickListener(this);
        moreTv.setOnClickListener(this);
        LinearLayoutManager manager = new LinearLayoutManager(SearchHotActivity.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        datas = new ArrayList<>();
        searchHotAdapter = new SearchHotAdapter(this);
        recyclerView.setAdapter(searchHotAdapter);
        VolleyInstance.getInstance().startRequest(Values.SEARCH_HOTURL, this);
    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        SearchHotEntity entity = gson.fromJson(resultStr, SearchHotEntity.class);
        datas = entity.getHotWordList();
        searchHotAdapter.setDatas(datas);
    }

    @Override
    public void failure() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.act_search_back_img:
                finish();
                break;
            case R.id.item_search_more_tv:
                break;
        }
    }
}
