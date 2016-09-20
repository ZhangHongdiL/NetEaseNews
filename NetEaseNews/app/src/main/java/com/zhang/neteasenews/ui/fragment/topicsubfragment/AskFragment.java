package com.zhang.neteasenews.ui.fragment.topicsubfragment;

import android.widget.ListView;

import com.google.gson.Gson;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.topicsubentity.AskEntity;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.adapter.topicsubadapter.AskAdapter;
import com.zhang.neteasenews.ui.fragment.AbsBaseFragment;
import com.zhang.neteasenews.utils.Values;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 话题界面问吧的Fragment
 */
public class AskFragment extends AbsBaseFragment implements VolleyResult {

    private ListView askLv;
    private List<AskEntity.DataBean.ExpertListBean> datas;
    private AskAdapter askAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_topic_ask;
    }

    @Override
    protected void initViews() {
        askLv = byView(R.id.fragment_topic_ask_lv);
    }

    @Override
    protected void initDatas() {
        datas = new ArrayList<>();
        askAdapter = new AskAdapter(context);
        askLv.setAdapter(askAdapter);
        VolleyInstance.getInstance().startRequest(Values.ASKURL, this);
    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        AskEntity.DataBean dataBean = gson.fromJson(resultStr, AskEntity.DataBean.class);
        datas = dataBean.getExpertList();
        askAdapter.setDatas(datas);
    }

    @Override
    public void failure() {

    }
}
