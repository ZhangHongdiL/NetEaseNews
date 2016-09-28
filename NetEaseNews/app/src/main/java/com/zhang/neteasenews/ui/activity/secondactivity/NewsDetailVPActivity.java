package com.zhang.neteasenews.ui.activity.secondactivity;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.ui.activity.AbsBaseActivity;

public class NewsDetailVPActivity extends AbsBaseActivity implements View.OnClickListener {

    private ViewPager detailVp;
    private ImageView backIv, pointsIv, shareIv;
    private EditText writeEt;
    private TextView titleTv, positionTv, totalTv, contentTv, replyTv;

    @Override
    protected int setLayout() {
        return R.layout.act_news_detail_vp;
    }

    @Override
    protected void initViews() {
        detailVp = byView(R.id.act_detail_vp);
        backIv = byView(R.id.act_detail_vp_back_img);
        pointsIv = byView(R.id.act_detail_vp_points_img);
        shareIv = byView(R.id.act_detail_vp_share_iv);
        titleTv = byView(R.id.act_detail_vp_title_tv);
        positionTv = byView(R.id.act_detail_vp_position_tv);
        totalTv = byView(R.id.act_detail_vp_total_tv);
        contentTv = byView(R.id.act_detail_vp_content_tv);
        replyTv = byView(R.id.act_detail_vp_reply_tv);
        writeEt = byView(R.id.act_detail_vp_write_et);
    }

    @Override
    protected void initDatas() {
        backIv.setOnClickListener(this);
        pointsIv.setOnClickListener(this);
        shareIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.act_detail_vp_back_img:
                finish();
                break;
            case R.id.act_detail_vp_points_img:
                break;
            case R.id.act_detail_vp_share_iv:
                break;
        }
    }
}
