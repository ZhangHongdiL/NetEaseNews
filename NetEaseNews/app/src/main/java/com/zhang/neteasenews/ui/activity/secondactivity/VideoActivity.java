package com.zhang.neteasenews.ui.activity.secondactivity;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.ui.activity.AbsBaseActivity;

public class VideoActivity extends AbsBaseActivity {

    private WebView webView;

    @Override
    protected int setLayout() {
        return R.layout.activity_video;
    }

    @Override
    protected void initViews() {
        webView = byView(R.id.video_wv);
    }

    @Override
    protected void initDatas() {
        /**
         * 设置WebView在当前Activity显示, 不跳转浏览器
         */
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.endsWith(".mp4")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(Uri.parse(url), "video/*");
                    view.getContext().startActivity(intent);

                    return true;
                } else {
                    return super.shouldOverrideUrlLoading(view, url);
                }
            }

            @Override
            public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
                return false;
            }
        });
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        Log.d("vvv", url);
        webView.loadUrl(url);
    }
}
