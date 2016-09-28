package com.zhang.neteasenews.ui.activity.secondactivity;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;
import android.widget.VideoView;

import com.zhang.neteasenews.R;
import com.zhang.neteasenews.ui.activity.AbsBaseActivity;

public class VideoActivity extends AbsBaseActivity {

    private VideoView videoView;

    @Override
    protected int setLayout() {
        return R.layout.activity_video;
    }

    @Override
    protected void initViews() {
        videoView = byView(R.id.video_vv);
    }

    @Override
    protected void initDatas() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        Log.d("www", url);
        MediaController controller = new MediaController(this);
        videoView.setMediaController(controller);
        Uri uri = Uri.parse(url);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }
}
