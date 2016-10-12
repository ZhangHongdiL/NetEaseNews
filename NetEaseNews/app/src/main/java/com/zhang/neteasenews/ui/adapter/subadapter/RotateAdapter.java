package com.zhang.neteasenews.ui.adapter.subadapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.subentity.HeadlineEntity;

import java.util.List;

/**
 * Created by dllo on 16/9/19.
 * 轮播图的适配器
 */
public class RotateAdapter extends PagerAdapter {

    private List<HeadlineEntity.T1348647909107Bean.AdsBean> datas;
    private Context context;
    private LayoutInflater inflater;

    public RotateAdapter(List<HeadlineEntity.T1348647909107Bean.AdsBean> datas, Context context) {
        this.datas = datas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public RotateAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<HeadlineEntity.T1348647909107Bean.AdsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        // 为了让ViewPager到最后一页不会像翻书一样回到第一页
        // 设置页数为int最大值,这样向下滑动永远都是下一页
        return datas == null ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // position是int最大值所以这里可能是几百甚至上千,因此取余避免数组越界
        int newPosition = position % datas.size();
        View convertView = inflater.inflate(R.layout.item_fragment_news_rotate, container, false);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.item_fragment_news_rotate_iv);
        TextView textView = (TextView) convertView.findViewById(R.id.item_fragment_news_rotate_tv);
        textView.setText(datas.get(newPosition).getTitle());
        Picasso.with(context).load(datas.get(newPosition).getImgsrc()).error(R.mipmap.netease_big).into(imageView);
        container.addView(convertView);
        return convertView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
