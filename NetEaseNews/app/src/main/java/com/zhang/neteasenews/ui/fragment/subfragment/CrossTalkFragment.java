package com.zhang.neteasenews.ui.fragment.subfragment;

import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.subentity.CrossTalkEntity;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.adapter.subadapter.CrossTalkAdapter;
import com.zhang.neteasenews.ui.fragment.AbsBaseFragment;
import com.zhang.neteasenews.utils.Values;
import com.zhang.neteasenews.view.PullDownListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/18.
 * 新闻界面段子的Fragment
 */
public class CrossTalkFragment extends AbsBaseFragment implements VolleyResult {

    private PullDownListView listView;
    private List<CrossTalkEntity.段子Bean> datas;
    private CrossTalkAdapter crossTalkAdapter;

    private RadioGroup radioGroup;
    private TextView zanTv, noZanTv;
    private CrossTalkEntity crossTalkEntity;

    public static CrossTalkFragment newInstance() {

        Bundle args = new Bundle();

        CrossTalkFragment fragment = new CrossTalkFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_news_crosstalk_lv;
    }

    @Override
    protected void initViews() {
        listView = byView(R.id.fragment_news_crosstalk_lv);
    }

    @Override
    protected void initDatas() {
        VolleyInstance.getInstance().startRequest(Values.CROSSTALKURL, this);
        datas = new ArrayList<>();
        crossTalkAdapter = new CrossTalkAdapter(context);
        listView.setAdapter(crossTalkAdapter);

        View view = LayoutInflater.from(context).inflate(R.layout.item_fra_news_ct_lv, null);
        zanTv = (TextView) view.findViewById(R.id.item_fra_news_ct_zan_tv);
        noZanTv = (TextView)view.findViewById(R.id.item_fra_news_ct_nozan_tv);
        radioGroup = (RadioGroup) view.findViewById(R.id.item_fra_news_ct_rg);
        /**
         * 点赞的
         */
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.item_fra_news_ct_zan_rb:
                        int zanCount = Integer.valueOf(zanTv.getText().toString());
                        zanCount = zanCount + 1;
                        zanTv.setText(zanCount + "");
                        break;
                    case R.id.item_fra_news_ct_nozan_rb:
                        int noZanCount = Integer.valueOf(noZanTv.getText().toString());
                        noZanCount = noZanCount + 1;
                        noZanTv.setText(noZanCount + "");
                        break;
                }
            }
        });
    }

    @Override
    public void success(String resultStr) {
        Gson gson = new Gson();
        crossTalkEntity = gson.fromJson(resultStr, CrossTalkEntity.class);
        datas = crossTalkEntity.get段子();
        crossTalkAdapter.setDatas(datas);
        listView.setonRefreshListener(new PullDownListView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new AsyncTask<Void, Void, Void>() {
                    protected Void doInBackground(Void... params) {
                        try {
                            Thread.sleep(2000);
                            VolleyInstance.getInstance().startRequest(Values.CROSSTALKURL, new VolleyResult() {
                                @Override
                                public void success(String resultStr) {
                                    Gson gson = new Gson();
                                    crossTalkEntity = gson.fromJson(resultStr, CrossTalkEntity.class);
                                    datas = crossTalkEntity.get段子();
                                    crossTalkAdapter.setDatas(datas);
                                }

                                @Override
                                public void failure() {
                                    Toast.makeText(context, "网络不给力", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void result) {

                        crossTalkAdapter.notifyDataSetChanged();
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
