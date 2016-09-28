package com.zhang.neteasenews.utils;

/**
 * Created by dllo on 16/9/28.
 * RecyclerView的行长按点击接口
 */
public interface RecyclerViewItemLongClick<T> {

    /**
     * @param position 长点击的行布局位置
     * @param t 泛型(行布局上的数据实体类)
     */
    void OnRvItemLongClick(int position, T t);
}
