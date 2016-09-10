package com.zhang.neteasenews.ui.fragment;

import android.content.Context;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.MeListViewEntity;
import com.zhang.neteasenews.ui.adapter.MeListViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class MeFragment extends AbsBaseFragment {

    private Context context;
    private TextView loginTv, setTv;
    private Button readBtn, collectBtn, replyBtn, goldBtn;
    private List<MeListViewEntity> datas;
    private MeListViewAdapter meListViewAdapter;
    private ListView listView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_me;
    }

    @Override
    protected void initViews() {
        loginTv = byView(R.id.fragment_me_login);
        setTv = byView(R.id.fragment_me_set);
        readBtn = byView(R.id.fragment_me_read);
        collectBtn = byView(R.id.fragment_me_collect);
        replyBtn = byView(R.id.fragment_me_reply);
        goldBtn = byView(R.id.fragment_me_gold);

        listView = byView(R.id.fragment_me_lv);
        meListViewAdapter = new MeListViewAdapter(context);
        datas = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            datas.add(new MeListViewEntity(R.mipmap.ic_launcher, "消息" + i));
        }
        meListViewAdapter.setDatas(datas);
        listView.setAdapter(meListViewAdapter);
    }

    @Override
    protected void initDatas() {

    }
}
