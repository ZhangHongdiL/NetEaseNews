package com.zhang.neteasenews.ui.activity.secondactivity;

import android.widget.ImageView;
import android.widget.ListView;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.CollectionEntity;
import com.zhang.neteasenews.ui.activity.AbsBaseActivity;
import com.zhang.neteasenews.ui.adapter.ActCollectionAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/10/10.
 * 收藏的二级界面
 */
public class CollectionActivity extends AbsBaseActivity {

    private ListView listView;
    private ActCollectionAdapter adapter;
    private ImageView back;
    private List<CollectionEntity> datas;

    @Override
    protected int setLayout() {
        return R.layout.act_collection;
    }

    @Override
    protected void initViews() {
        back = byView(R.id.act_collection_back);
        listView = byView(R.id.act_collection_lv);
    }

    @Override
    protected void initDatas() {
        adapter = new ActCollectionAdapter(this);
        datas = new ArrayList<>();
        adapter.setDatas(datas);
        listView.setAdapter(adapter);
    }
}
