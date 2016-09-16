package com.zhang.neteasenews.utils;

/**
 * Created by dllo on 16/9/16.
 * popupwindow里RecyclerView的行点击接口
 */
public interface PopupRecyclerItemClick {

    /**
     * @param position 点击的行布局位置
     * @param str 行布局上的数据实体类
     */
    void onRvItemClickListener (int position, String str);
}
