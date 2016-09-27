package com.zhang.neteasenews.ui.fragment.subfragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.subentity.ChoicenessEntity;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.adapter.subadapter.ChoicenessAdapter;
import com.zhang.neteasenews.ui.fragment.AbsBaseFragment;
import com.zhang.neteasenews.utils.Values;
import com.zhang.neteasenews.view.PullDownListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/21.
 * 新闻界面精选页
 */
public class ChoicenessFragment extends AbsBaseFragment implements VolleyResult {

    private PullDownListView listView;
    private ChoicenessAdapter choicenessAdapter;
    private List<ChoicenessEntity.T1467284926140Bean> datas;
//    private View headView;

    public static ChoicenessFragment newInstance() {

        Bundle args = new Bundle();

        ChoicenessFragment fragment = new ChoicenessFragment();
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
//        headView = LayoutInflater.from(context).inflate(R.layout.item_fra_news_ch_head, null);
//        ImageView headImg = (ImageView) headView.findViewById(R.id.item_fra_news_ch_head_img);
//        TextView headTv = (TextView) headView.findViewById(R.id.item_fra_news_ch_head_tv);
    }

    @Override
    protected void initDatas() {
        datas = new ArrayList<>();
        choicenessAdapter = new ChoicenessAdapter(context);
        listView.setAdapter(choicenessAdapter);
//        listView.addHeaderView(headView);
        VolleyInstance.getInstance().startRequest(Values.CHOICENESSURL, this);
    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        ChoicenessEntity choicenessEntity = gson.fromJson(resultStr, ChoicenessEntity.class);
        datas = choicenessEntity.getT1467284926140();
        choicenessAdapter.setDatas(datas);
        listView.setonRefreshListener(new PullDownListView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new AsyncTask<Void, Void, Void>() {
                    protected Void doInBackground(Void... params) {
                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void result) {
                        choicenessAdapter.notifyDataSetChanged();
                        listView.onRefreshComplete();
                    }
                }.execute(null, null, null);
            }
        });
    }

    @Override
    public void failure() {

    }
}
