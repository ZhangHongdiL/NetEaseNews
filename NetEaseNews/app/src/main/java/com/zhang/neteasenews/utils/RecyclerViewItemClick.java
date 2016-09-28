package com.zhang.neteasenews.utils;

/**
 * Created by dllo on 16/9/28.
 * RecyclerView的行点击接口
 */
public interface RecyclerViewItemClick<T> {

    /**
     * @param position 点击的行布局位置
     * @param t 泛型(如:行布局上的数据实体类)
     */
    void onRvItemClickListener(int position, T t);
}
