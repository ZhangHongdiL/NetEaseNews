package com.zhang.neteasenews.ui.adapter.popupwindowadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.utils.RecyclerViewItemClick;
import com.zhang.neteasenews.utils.RecyclerViewItemLongClick;

import java.util.List;

/**
 * Created by dllo on 16/9/16.
 */
public class NewsPwAdapter extends RecyclerView.Adapter<NewsPwAdapter.NewsPwHolder>{

    private Context context;
    private List<String> datas;
    // 点击
    private RecyclerViewItemClick popupRecyclerItemClick;
    // 长按点击
    private RecyclerViewItemLongClick popupRecyclerItemLongClick;

    public void setPopupRecyclerItemClick(RecyclerViewItemClick popupRecyclerItemClick) {
        this.popupRecyclerItemClick = popupRecyclerItemClick;
    }

    public void setPopupRecyclerItemLongClick(RecyclerViewItemLongClick popupRecyclerItemLongClick) {
        this.popupRecyclerItemLongClick = popupRecyclerItemLongClick;
    }

    public NewsPwAdapter(Context context) {
        this.context = context;
    }

    public void setDatas(List<String> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public NewsPwHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news_pw, parent, false);
        NewsPwHolder newsPwHolder = new NewsPwHolder(view);
        return newsPwHolder;
    }

    @Override
    public void onBindViewHolder(NewsPwHolder holder, int position) {
        holder.pwTv.setText(datas.get(position));

        holder.pwTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.pwTv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    class NewsPwHolder extends RecyclerView.ViewHolder {
        private TextView pwTv;
        public NewsPwHolder(View itemView) {
            super(itemView);
            pwTv = (TextView) itemView.findViewById(R.id.item_news_pw_tv);
        }
    }
}
