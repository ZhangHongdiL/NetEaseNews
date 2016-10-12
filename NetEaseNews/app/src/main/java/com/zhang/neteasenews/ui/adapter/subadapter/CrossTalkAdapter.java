package com.zhang.neteasenews.ui.adapter.subadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.model.entity.subentity.CrossTalkEntity;

import java.util.List;

/**
 * Created by dllo on 16/9/18.
 * 新闻界面段子的适配器
 */
public class CrossTalkAdapter extends BaseAdapter {

    private Context context;
    private List<CrossTalkEntity.段子Bean> datas;

    public CrossTalkAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<CrossTalkEntity.段子Bean> datas) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewHolder listViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_fra_news_ct_lv, parent, false);
            listViewHolder = new ListViewHolder(convertView);
            convertView.setTag(listViewHolder);
        } else {
            listViewHolder = (ListViewHolder) convertView.getTag();
        }
        CrossTalkEntity.段子Bean ctEntity = (CrossTalkEntity.段子Bean) getItem(position);
        listViewHolder.contentTv.setText(ctEntity.getDigest());
        listViewHolder.zanTv.setText(ctEntity.getUpTimes() + "");
        listViewHolder.noZanTv.setText(ctEntity.getDownTimes() + "");
        listViewHolder.replyTv.setText(ctEntity.getReplyCount() + "");
        return convertView;
    }

    class ListViewHolder{
        private TextView contentTv, zanTv, noZanTv, replyTv;
        public ListViewHolder(View view){
            contentTv = (TextView) view.findViewById(R.id.item_fra_news_ct_content);
            zanTv = (TextView) view.findViewById(R.id.item_fra_news_ct_zan_tv);
            noZanTv = (TextView) view.findViewById(R.id.item_fra_news_ct_nozan_tv);
            replyTv = (TextView) view.findViewById(R.id.item_fra_news_ct_reply_tv);
        }
    }
}
