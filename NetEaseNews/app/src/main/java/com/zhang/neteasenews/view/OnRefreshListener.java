package com.zhang.neteasenews.view;

/**
 * Created by dllo on 16/10/9.
 */
public interface OnRefreshListener {
    /**
     * 下拉刷新
     */
    void onDownPullRefresh();
    /**
     * 上拉加载更多
     */
    void onLoadingMore();
}

