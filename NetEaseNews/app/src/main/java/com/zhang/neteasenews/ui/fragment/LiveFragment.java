package com.zhang.neteasenews.ui.fragment;

import android.content.Context;
import android.widget.ListView;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.LiveListViewEntity;
import com.zhang.neteasenews.ui.adapter.LiveListViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class LiveFragment extends AbsBaseFragment {

    private Context context;
    private ListView listView;
    private List<LiveListViewEntity> datas;
    private LiveListViewAdapter liveListViewAdapter;

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
        datas = new ArrayList<>();
        liveListViewAdapter = new LiveListViewAdapter(context);
        for (int i = 0; i < 10; i++) {
            datas.add(new LiveListViewEntity("标题" + i, R.mipmap.ic_launcher, "多少人参加" + i));
        }
        liveListViewAdapter.setDatas(datas);
        listView.setAdapter(liveListViewAdapter);
    }

    @Override
    protected void initDatas() {

    }
}
