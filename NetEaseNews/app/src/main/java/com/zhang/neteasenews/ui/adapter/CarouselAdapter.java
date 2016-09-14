package com.zhang.neteasenews.ui.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.HeadlineEntity;

import java.util.List;

/**
 * Created by dllo on 16/9/14.
 */
public class CarouselAdapter extends PagerAdapter {

    private Context context;
    private List<HeadlineEntity.T1348647909107Bean.AdsBean> datas;
    private LayoutInflater inflater;

    public CarouselAdapter(Context context, List<HeadlineEntity.T1348647909107Bean.AdsBean> datas) {
        this.context = context;
        this.datas = datas;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<HeadlineEntity.T1348647909107Bean.AdsBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        //为了让ViewPager到最后一页不会像翻书一样回到第一页,设置页数为int最大值,这样向下滑动永远都是下一页
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
        View convertView = inflater.inflate(R.layout.item_act_carousel_vp, container, false);
        ImageView carouselImg = (ImageView) convertView.findViewById(R.id.item_act_carousel_img);
        TextView carouselTv = (TextView) convertView.findViewById(R.id.item_act_carousel_tv);
        Picasso.with(context).load(datas.get(newPosition).getImgsrc()).into(carouselImg);
        carouselTv.setText(datas.get(newPosition).getTitle());

        container.addView(convertView);
        return convertView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }
}
