package com.zhang.neteasenews.ui.fragment.topicsubfragment;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.topicsubentity.AskEntity;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.adapter.topicsubadapter.AskAdapter;
import com.zhang.neteasenews.ui.fragment.AbsBaseFragment;
import com.zhang.neteasenews.utils.ScreenSizeUtils;
import com.zhang.neteasenews.utils.Values;
import com.zhang.neteasenews.view.PullDownListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 话题界面问吧的Fragment
 */
public class AskFragment extends AbsBaseFragment implements VolleyResult {

    private PullDownListView askLv;
    private List<AskEntity.DataBean.ExpertListBean> datas;
    private AskAdapter askAdapter;
//    private TextView a4444;
//    private View view;

    @Override
    protected int setLayout() {
        return R.layout.fragment_topic_ask;
    }

    @Override
    protected void initViews() {
        askLv = byView(R.id.fragment_topic_ask_lv);
//        a4444 = byView(R.id.a4444);
//        view = byView(R.id.vvvv);
    }

    @Override
    protected void initDatas() {
        datas = new ArrayList<>();
        askAdapter = new AskAdapter(context);
        askLv.setAdapter(askAdapter);
        VolleyInstance.getInstance().startRequest(Values.ASKURL, this);
//        a4444.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//              popWindow();
//            }
//        });
    }

//    private void popWindow() {
//        final PopupWindow pw = new PopupWindow(context);
//        // 获得屏幕的宽高
//        int width = ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.WIDTH);
//        int height = ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.HEIGHT);
//        pw.setWidth(width);
//        pw.setHeight(height / 6);
//        View view = LayoutInflater.from(context).inflate(R.layout.item_pw_ask, null);
//        pw.setContentView(view);
//        pw.setFocusable(true);
//        pw.setOutsideTouchable(true);
//        pw.showAsDropDown(view);
//    }

    @Override
    public void success(String resultStr) {
//        Log.d("AskFragment", resultStr);
        Gson gson = new Gson();
        AskEntity askEntity = gson.fromJson(resultStr, AskEntity.class);
        AskEntity.DataBean dataBean = askEntity.getData();
        datas = dataBean.getExpertList();
        askAdapter.setDatas(datas);
        askLv.setonRefreshListener(new PullDownListView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        try {
                            Thread.sleep(2000);
                            VolleyInstance.getInstance().startRequest(Values.ASKURL, new VolleyResult() {
                                @Override
                                public void success(String resultStr) {
                                    Gson gson = new Gson();
                                    AskEntity askEntity = gson.fromJson(resultStr, AskEntity.class);
                                    AskEntity.DataBean dataBean = askEntity.getData();
                                    datas = dataBean.getExpertList();
                                    askAdapter.setDatas(datas);
                                }

                                @Override
                                public void failure() {
                                    Toast.makeText(context, "网络不给力", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void result) {
                        askAdapter.notifyDataSetChanged();
                        askLv.onRefreshComplete();
                    }
                }.execute(null, null, null);
            }
        });
    }

    @Override
    public void failure() {

    }
}
