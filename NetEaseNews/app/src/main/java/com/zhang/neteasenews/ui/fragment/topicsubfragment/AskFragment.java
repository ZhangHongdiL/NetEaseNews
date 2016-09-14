package com.zhang.neteasenews.ui.fragment.topicsubfragment;

import android.widget.ListView;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.ui.fragment.AbsBaseFragment;

/**
 * Created by dllo on 16/9/10.
 */
public class AskFragment extends AbsBaseFragment{

    private ListView askLv;

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

    }
}
