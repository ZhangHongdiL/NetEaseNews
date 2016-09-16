package com.zhang.neteasenews.utils;

/**
 * Created by dllo on 16/9/16.
 * popupwindow里RecyclerView的行点击接口
 */
public interface PopupRecyclerItemLongClick {

    /**
     * @param position 长点击的行布局位置
     * @param str 行布局上的数据实体类
     */
    void OnRvItemLongClick(int position, String str);
}
