package com.zhang.neteasenews.ui.adapter.topicsubadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.topicsubentity.ThemeEntity;
import com.zhang.neteasenews.utils.ScreenSizeUtils;
import com.zhang.neteasenews.utils.Values;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dllo on 16/9/20.
 * 话题界面话题的适配器
 */
public class ThemeAdapter extends BaseAdapter {

    private Context context;
    private ThemeEntity.DataBean dataBean;
    private LayoutInflater inflater;
    private int height;

    // 四个人
//    private ThemeEntity.DataBean.RecomendExpertBean recomendExpertBean;
//    private List<ThemeEntity.DataBean.SubjectListBean> datas;
    private List datas;

    public ThemeAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setDatas(ThemeEntity.DataBean dataBean) {
        this.dataBean = dataBean;
//        recomendExpertBean = dataBean.getRecomendExpert();
        datas = dataBean.getSubjectList();
        datas.add(dataBean.getRecomendExpert().getPosition() - 1, dataBean.getRecomendExpert().getExpertList());
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public Object getItem(int position) {
        // ListView  0   1  2  3  4 5 6 7 8 9 10
        // 显示数据  单独  0  1  2  3 4 5 6 7 8 9 get(0,1)
        return datas == null ? null : datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == dataBean.getRecomendExpert().getPosition() - 1) {
            return Values.THEME_POSITION;// 四个人
        } else if (dataBean.getSubjectList().get(position).getType() == 1) {
            return Values.THEME_THREE;
        } else {
            return Values.THEME_TWO;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int type = getItemViewType(position);
        TwoViewHolder twoViewHolder = null;
        ThreeViewHolder threeViewHolder = null;
        PositionViewHolder positionViewHolder = null;
        if (convertView == null) {
            switch (type) {
                case Values.THEME_TWO:// 2个评论 接口getType==0
                    convertView = inflater.inflate(R.layout.item_fra_topic_theme_two, parent, false);
                    twoViewHolder = new TwoViewHolder(convertView);
                    convertView.setTag(twoViewHolder);
                    break;
                case Values.THEME_THREE:// 3张图片 接口getType==1
                    convertView = inflater.inflate(R.layout.item_fra_topic_theme_three, parent, false);
                    threeViewHolder = new ThreeViewHolder(convertView);
                    convertView.setTag(threeViewHolder);
                    break;
                case Values.THEME_POSITION:// 4个人
                    convertView = inflater.inflate(R.layout.item_topic_theme_choiceness, parent, false);
                    // 为每行设置高度
                    height = ScreenSizeUtils.getScreenSize(context, ScreenSizeUtils.ScreenState.HEIGHT);
                    ViewGroup.LayoutParams params = convertView.getLayoutParams();
                    params.height = height / 3;
                    convertView.setLayoutParams(params);
                    positionViewHolder = new PositionViewHolder(convertView);
                    convertView.setTag(positionViewHolder);
                    break;
            }
        } else {
            switch (type) {
                case Values.THEME_TWO:
                    twoViewHolder = (TwoViewHolder) convertView.getTag();
                    break;
                case Values.THEME_THREE:
                    threeViewHolder = (ThreeViewHolder) convertView.getTag();
                    break;
                case Values.THEME_POSITION:
                    positionViewHolder = (PositionViewHolder) convertView.getTag();
                    break;
            }
        }
        ThemeEntity.DataBean.SubjectListBean subjectListBean = null;
        if (position != dataBean.getRecomendExpert().getPosition() - 1) {
            subjectListBean = ((ThemeEntity.DataBean.SubjectListBean) (datas.get(position)));
        }
        switch (type) {
            case Values.THEME_TWO:// 2个评论
                twoViewHolder.twoTitleTv.setText("#" + subjectListBean.getName() + "#");
                twoViewHolder.upTv.setText("\"" + subjectListBean.getTalkContent().get(0).getContent() + "\"");
                twoViewHolder.downTv.setText("\"" + subjectListBean.getTalkContent().get(1).getContent() + "\"");
                Glide.with(context).load(subjectListBean.getTalkContent().get(0).getUserHeadPicUrl().toString()).error(R.mipmap.netease_small).into(twoViewHolder.upCiv);
                Glide.with(context).load(subjectListBean.getTalkContent().get(1).getUserHeadPicUrl().toString()).error(R.mipmap.netease_small).into(twoViewHolder.downCiv);
                twoViewHolder.twoSourceTv.setText(subjectListBean.getClassification());
                twoViewHolder.twoAttentionTv.setText(subjectListBean.getConcernCount() + "关注");
                twoViewHolder.twoAskTv.setText(subjectListBean.getTalkCount() + "讨论");
                break;
            case Values.THEME_THREE:
                threeViewHolder.threeTitleTv.setText("#" + subjectListBean.getName() + "#");
                Glide.with(context).load(subjectListBean.getTalkPicture().get(0).toString()).error(R.mipmap.netease_big).into(threeViewHolder.leftImg);
                Glide.with(context).load(subjectListBean.getTalkPicture().get(1).toString()).error(R.mipmap.netease_big).into(threeViewHolder.middleImg);
                Glide.with(context).load(subjectListBean.getTalkPicture().get(2).toString()).error(R.mipmap.netease_big).into(threeViewHolder.rightImg);
                threeViewHolder.threeSourceTv.setText(subjectListBean.getClassification());
                threeViewHolder.threeAttentionTv.setText(subjectListBean.getConcernCount() + "关注");
                threeViewHolder.threeAskTv.setText(subjectListBean.getTalkCount() + "讨论");
                break;
            case Values.THEME_POSITION:
                dataBean.getRecomendExpert().setExpertList((List<ThemeEntity.DataBean.RecomendExpertBean.ExpertListBean>) datas.get(3));
                positionViewHolder.oneNameTv.setText(dataBean.getRecomendExpert().getExpertList().get(0).getName());
                positionViewHolder.twoNameTv.setText(dataBean.getRecomendExpert().getExpertList().get(1).getName());
                positionViewHolder.threeNameTv.setText(dataBean.getRecomendExpert().getExpertList().get(2).getName());
                positionViewHolder.fourNameTv.setText(dataBean.getRecomendExpert().getExpertList().get(3).getName());
                Glide.with(context).load(dataBean.getRecomendExpert().getExpertList().get(0).getHeadpicurl()).error(R.mipmap.netease_small).into(positionViewHolder.oneImg);
                Glide.with(context).load(dataBean.getRecomendExpert().getExpertList().get(1).getHeadpicurl()).error(R.mipmap.netease_small).into(positionViewHolder.twoImg);
                Glide.with(context).load(dataBean.getRecomendExpert().getExpertList().get(2).getHeadpicurl()).error(R.mipmap.netease_small).into(positionViewHolder.threeImg);
                Glide.with(context).load(dataBean.getRecomendExpert().getExpertList().get(3).getHeadpicurl()).error(R.mipmap.netease_small).into(positionViewHolder.fourImg);
                int concern1 = dataBean.getRecomendExpert().getExpertList().get(0).getConcernCount();
                int concern2 = dataBean.getRecomendExpert().getExpertList().get(1).getConcernCount();
                int concern3 = dataBean.getRecomendExpert().getExpertList().get(2).getConcernCount();
                int concern4 = dataBean.getRecomendExpert().getExpertList().get(3).getConcernCount();
                float finalConcern;
                int a = concern1 / 10000;
                int b = (concern1 % 10000) / 1000;
                if (concern1 >= 10000) {
                    finalConcern = (float) a + (float) (b * 0.1);
                    positionViewHolder.oneConTv.setText(finalConcern + "万关注");
                } else {
                    positionViewHolder.oneConTv.setText(concern1 + "关注");
                }
                int c = concern2 / 10000;
                int d = (concern2 % 10000) / 1000;
                if (concern2 >= 10000) {
                    finalConcern = (float) c + (float) (d * 0.1);
                    positionViewHolder.twoConTv.setText(finalConcern + "万关注");
                } else {
                    positionViewHolder.twoConTv.setText(concern2 + "关注");
                }
                int e = concern3 / 10000;
                int f = (concern3 % 10000) / 1000;
                if (concern3 >= 10000) {
                    finalConcern = (float) e + (float) (f * 0.1);
                    positionViewHolder.threeConTv.setText(finalConcern + "万关注");
                } else {
                    positionViewHolder.threeConTv.setText(concern3 + "关注");
                }
                int h = concern4 / 10000;
                int i = (concern4 % 10000) / 1000;
                if (concern4 >= 10000) {
                    finalConcern = (float) h + (float) (i * 0.1);
                    positionViewHolder.fourConTv.setText(finalConcern + "万关注");
                } else {
                    positionViewHolder.fourConTv.setText(concern4 + "关注");
                }
                break;
        }
        return convertView;
    }

    class TwoViewHolder {
        TextView twoTitleTv, upTv, downTv, twoSourceTv, twoAttentionTv, twoAskTv;
        CircleImageView upCiv, downCiv;

        public TwoViewHolder(View view) {
            twoTitleTv = (TextView) view.findViewById(R.id.theme_two_title_tv);
            upTv = (TextView) view.findViewById(R.id.theme_two_up_tv);
            downTv = (TextView) view.findViewById(R.id.theme_two_down_tv);
            twoSourceTv = (TextView) view.findViewById(R.id.theme_two_source_tv);
            twoAttentionTv = (TextView) view.findViewById(R.id.theme_two_attention_tv);
            twoAskTv = (TextView) view.findViewById(R.id.theme_two_ask_tv);
            upCiv = (CircleImageView) view.findViewById(R.id.theme_two_up_civ);
            downCiv = (CircleImageView) view.findViewById(R.id.theme_two_down_civ);
        }
    }

    class ThreeViewHolder {
        TextView threeTitleTv, threeSourceTv, threeAttentionTv, threeAskTv;
        ImageView leftImg, middleImg, rightImg;

        public ThreeViewHolder(View view) {
            threeTitleTv = (TextView) view.findViewById(R.id.theme_three_title_tv);
            threeSourceTv = (TextView) view.findViewById(R.id.theme_three_source_tv);
            threeAttentionTv = (TextView) view.findViewById(R.id.theme_three_attention_tv);
            threeAskTv = (TextView) view.findViewById(R.id.theme_three_ask_tv);
            leftImg = (ImageView) view.findViewById(R.id.theme_three_left_img);
            middleImg = (ImageView) view.findViewById(R.id.theme_three_middle_img);
            rightImg = (ImageView) view.findViewById(R.id.theme_three_right_img);
        }
    }

    class PositionViewHolder {
        ImageView oneImg, twoImg, threeImg, fourImg;
        TextView oneNameTv, twoNameTv, threeNameTv, fourNameTv, oneConTv, twoConTv, threeConTv, fourConTv;

        public PositionViewHolder(View view) {
            oneImg = (CircleImageView) view.findViewById(R.id.theme_position_4_one_img);
            oneNameTv = (TextView) view.findViewById(R.id.theme_position_4_one_name_tv);
            oneConTv = (TextView) view.findViewById(R.id.theme_position_4_one_concern_tv);
            twoImg = (CircleImageView) view.findViewById(R.id.theme_position_4_two_img);
            twoNameTv = (TextView) view.findViewById(R.id.theme_position_4_two_name_tv);
            twoConTv = (TextView) view.findViewById(R.id.theme_position_4_two_concern_tv);
            threeImg = (CircleImageView) view.findViewById(R.id.theme_position_4_three_img);
            threeNameTv = (TextView) view.findViewById(R.id.theme_position_4_three_name_tv);
            threeConTv = (TextView) view.findViewById(R.id.theme_position_4_three_concern_tv);
            fourImg = (CircleImageView) view.findViewById(R.id.theme_position_4_four_img);
            fourNameTv = (TextView) view.findViewById(R.id.theme_position_4_four_name_tv);
            fourConTv = (TextView) view.findViewById(R.id.theme_position_4_four_concern_tv);
        }
    }
}
