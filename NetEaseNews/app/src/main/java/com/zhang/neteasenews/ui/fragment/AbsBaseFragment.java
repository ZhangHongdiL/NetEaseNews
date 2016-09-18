package com.zhang.neteasenews.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.ui.activity.AbsBaseActivity;

/**
 * Created by dllo on 16/9/10.
 * Fragment的基类
 */
public abstract class AbsBaseFragment extends Fragment {
    private Context context;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initDatas();
    }

    protected abstract int setLayout();

    protected abstract void initViews();

    protected abstract void initDatas();

    /**
     * 简化findViewById
     */
    protected <T extends View> T byView(int resId) {
        return (T) getView().findViewById(resId);
    }

    /**
     * 页面跳转
     */
    protected void goTo(Class<? extends AbsBaseActivity> to) {
        context.startActivity(new Intent(context, to));
        getActivity().overridePendingTransition(R.anim.fra_act_translate, 0);
    }
}
