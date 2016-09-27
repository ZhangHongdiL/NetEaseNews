package com.zhang.neteasenews.ui.fragment.subfragment;

import android.os.AsyncTask;
import android.os.Bundle;

import com.google.gson.Gson;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.subentity.AmusementEntity;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.adapter.subadapter.AmusementAdapter;
import com.zhang.neteasenews.ui.fragment.AbsBaseFragment;
import com.zhang.neteasenews.utils.Values;
import com.zhang.neteasenews.view.PullDownListView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dllo on 16/9/22.
 * 新闻界面娱乐页
 */
public class AmusementFragment extends AbsBaseFragment implements VolleyResult, PullDownListView.OnRefreshListener {

    private AmusementAdapter amusementAdapter;
    private List<AmusementEntity.T1348648517839Bean> datas;

    /**
     * 下拉刷新
     */
    private PullDownListView lv;

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
        lv = byView(R.id.fragment_news_headline_lv);
    }

    @Override
    protected void initDatas() {
        datas = new ArrayList<>();
        amusementAdapter = new AmusementAdapter(context);
        lv.setAdapter(amusementAdapter);
        VolleyInstance.getInstance().startRequest(Values.AMUSEMENTURL, this);

        lv.setonRefreshListener(this);
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

    @Override
    public void onRefresh() {
//        Toast.makeText(context, "aaa", Toast.LENGTH_SHORT).show();
        new AsyncTask<Void, Void, Void>() {
            protected Void doInBackground(Void... params) {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                amusementAdapter.notifyDataSetChanged();
                lv.onRefreshComplete();
            }
        }.execute(null, null, null);
    }


}
