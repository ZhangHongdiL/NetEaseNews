package com.zhang.neteasenews.ui.adapter.subadapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.VpDetailEntity;

import java.util.List;

/**
 * Created by dllo on 16/10/9.
 */
public class DetailVpAdapter extends PagerAdapter {

    private Context context;
    private List<VpDetailEntity.PhotosBean> datas;
    private ImageView vpIv;

    public DetailVpAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<VpDetailEntity.PhotosBean> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_detail_vp_img, container,false);
        vpIv = (ImageView) v.findViewById(R.id.vp_detail_iv);
        VpDetailEntity.PhotosBean photosBean = datas.get(position);
        Glide.with(context).load(photosBean.getImgurl()).error(R.mipmap.netease_big).into(vpIv);
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(container.getChildAt(position));
    }
}
