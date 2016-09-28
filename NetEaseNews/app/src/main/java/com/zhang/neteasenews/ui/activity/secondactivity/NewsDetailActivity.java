package com.zhang.neteasenews.ui.activity.secondactivity;

import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.ui.activity.AbsBaseActivity;

/**
 * Created by dllo on 16/9/28.
 * 新闻详情界面
 */
public class NewsDetailActivity extends AbsBaseActivity implements View.OnClickListener {

    private WebView detailWv;
    private ImageView backIv, pointsIv, shareIv;
    private TextView replyTv;
    private EditText writeEt;

    @Override
    protected int setLayout() {
        return R.layout.act_detail_webview;
    }

    @Override
    protected void initViews() {
        detailWv = byView(R.id.act_detail_wv);
        backIv = byView(R.id.act_detail_wv_back_img);
        pointsIv = byView(R.id.act_detail_wv_points_img);
        shareIv = byView(R.id.act_detail_wv_share_iv);
        replyTv = byView(R.id.act_detail_wv_reply_tv);
        writeEt = byView(R.id.act_detail_wv_write_et);
    }

    @Override
    protected void initDatas() {
        backIv.setOnClickListener(this);
        pointsIv.setOnClickListener(this);

        detailWv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

            @Override
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                return false;
            }
        });

        //WebSettings set = detailWv.getSettings();
       // set.setJavaScriptEnabled(true);
        //set.setJavaScriptCanOpenWindowsAutomatically(true);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        Log.d("vvvv", url);
        detailWv.loadUrl(url);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.act_detail_wv_back_img:
                finish();
                break;
        }
    }
}
