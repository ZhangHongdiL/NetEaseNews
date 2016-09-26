package com.zhang.neteasenews.ui.adapter.subadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.subentity.PictureEntity;
import com.zhang.neteasenews.utils.ScreenSizeUtils;
import com.zhang.neteasenews.utils.Values;

import java.util.List;

/**
 * Created by dllo on 16/9/22.
 * 新闻界面图片的适配器
 */
public class PictureAdapter extends BaseAdapter {

    private Context context;
    private List<PictureEntity> datas;
    private LayoutInflater inflater;
    private int a, b, c, type; // a 为获取到数据"setid" 余 2 的值; b 为获取数据时每条数据的图片个数; c为获取到pics的个数
    private int height;

    public PictureAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(List<PictureEntity> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas == null ? null : datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        a = Integer.valueOf(datas.get(position).getSetid()) % 2;
        b = Integer.valueOf(datas.get(position).getImgsum());
        c = datas.get(position).getPics().size();
        if (c == 0 || a == 0) {
            return Values.PICTURE_TYPE_ONE;
        } else {
            return Values.PICTURE_TYPE_THREE;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        OnePicHolder onePicHolder = null;
        ThreePicHolder threePicHolder = null;
        type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case Values.PICTURE_TYPE_ONE:
                    convertView = inflater.inflate(R.layout.item_picture_one_img, parent, false);
                    // 为每行设置高度
                    height = ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.HEIGHT);
                    ViewGroup.LayoutParams params = convertView.getLayoutParams();
                    params.height = height / 3;
                    convertView.setLayoutParams(params);

                    onePicHolder = new OnePicHolder(convertView);
                    convertView.setTag(onePicHolder);
                    break;
                case Values.PICTURE_TYPE_THREE:
                    convertView = inflater.inflate(R.layout.item_picture_three_img, parent, false);
                    // 为每行设置高度
                    height = ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.HEIGHT);
                    ViewGroup.LayoutParams params1 = convertView.getLayoutParams();
                    params1.height = height / 3;
                    convertView.setLayoutParams(params1);

                    threePicHolder = new ThreePicHolder(convertView);
                    convertView.setTag(threePicHolder);
                    break;
            }
        } else {
            switch (type) {
                case Values.PICTURE_TYPE_ONE:
                    onePicHolder = (OnePicHolder) convertView.getTag();
                    break;
                case Values.PICTURE_TYPE_THREE:
                    threePicHolder = (ThreePicHolder) convertView.getTag();
                    break;
            }
        }
        PictureEntity entity = (PictureEntity) getItem(position);
        if (entity != null) {
            switch (type) {
                case Values.PICTURE_TYPE_ONE:
                    onePicHolder.titleTv.setText(entity.getSetname());
                    onePicHolder.replyTv.setText(entity.getReplynum() + "跟帖");
                    onePicHolder.picsTv.setText(entity.getImgsum() + "pics");
                    Glide.with(context).load(entity.getCover()).error(R.mipmap.netease_big).into(onePicHolder.oneImg);
                    break;
                case Values.PICTURE_TYPE_THREE:
                    threePicHolder.titleTv.setText(entity.getSetname());
                    threePicHolder.replyTv.setText(entity.getReplynum() + "跟帖");
                    threePicHolder.picsTv.setText(entity.getImgsum() + "pics");
                    Glide.with(context).load(entity.getPics().get(0)).error(R.mipmap.netease_big).into(threePicHolder.bigImg);
                    Glide.with(context).load(entity.getPics().get(1)).error(R.mipmap.netease_big).into(threePicHolder.upImg);
                    Glide.with(context).load(entity.getPics().get(2)).error(R.mipmap.netease_big).into(threePicHolder.downImg);
                    break;
            }
        }
        return convertView;
    }

    class OnePicHolder {
        ImageView oneImg;
        TextView titleTv, replyTv, picsTv;

        public OnePicHolder(View v) {
            titleTv = (TextView) v.findViewById(R.id.item_picture_one_title_tv);
            replyTv = (TextView) v.findViewById(R.id.item_picture_one_reply_tv);
            picsTv = (TextView) v.findViewById(R.id.item_picture_one_pics_tv);
            oneImg = (ImageView) v.findViewById(R.id.item_picture_one_img);
        }
    }

    class ThreePicHolder {
        ImageView bigImg, upImg, downImg;
        TextView titleTv, replyTv, picsTv;

        public ThreePicHolder(View v) {
            bigImg = (ImageView) v.findViewById(R.id.item_picture_three_big_img);
            upImg = (ImageView) v.findViewById(R.id.item_picture_three_up_img);
            downImg = (ImageView) v.findViewById(R.id.item_picture_three_down_img);
            titleTv = (TextView) v.findViewById(R.id.item_picture_three_title_tv);
            replyTv = (TextView) v.findViewById(R.id.item_picture_three_reply_tv);
            picsTv = (TextView) v.findViewById(R.id.item_picture_three_pics_tv);
        }
    }
}
