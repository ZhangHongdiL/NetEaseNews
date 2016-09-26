package com.zhang.neteasenews.ui.fragment.topicsubfragment;

import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.topicsubentity.ThemeEntity;
import com.zhang.neteasenews.model.net.VolleyInstance;
import com.zhang.neteasenews.model.net.VolleyResult;
import com.zhang.neteasenews.ui.adapter.topicsubadapter.ThemeAdapter;
import com.zhang.neteasenews.ui.fragment.AbsBaseFragment;
import com.zhang.neteasenews.utils.Values;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 话题界面话题的Fragment
 */
public class ThemeFragment extends AbsBaseFragment implements VolleyResult {
    private List<ThemeEntity.DataBean> datas;
    private ListView listView;
    private ThemeAdapter themeAdapter;
    @Override
    protected int setLayout() {
        return R.layout.fragment_topic_theme;
    }

    @Override
    protected void initViews() {
        listView = byView(R.id.fragment_topic_theme_lv);
    }

    @Override
    protected void initDatas() {
        datas = new ArrayList<>();
        themeAdapter = new ThemeAdapter(context);
        listView.setAdapter(themeAdapter);
        VolleyInstance.getInstance().startRequest(Values.THEMEURL, this);
    }

    @Override
    public void success(String resultStr) {
//        Log.d("ThemeFragment", );
        Gson gson = new Gson();
        ThemeEntity themeEntity = gson.fromJson(resultStr, ThemeEntity.class);
        ThemeEntity.DataBean dataBean = themeEntity.getData();

        themeAdapter.setDatas(dataBean);
    }

    @Override
    public void failure() {

    }
}
