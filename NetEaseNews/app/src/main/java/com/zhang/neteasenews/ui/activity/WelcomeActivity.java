package com.zhang.neteasenews.ui.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhang.neteasenews.R;

/**
 * Created by dllo on 16/10/12.
 * 欢迎页的Activity
 */
public class WelcomeActivity extends AbsBaseActivity{

    private TextView welcomeTv;
    private ImageView welcomeIv;
    private WelcomeTask welcomeTask;

    @Override
    protected int setLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initViews() {
        welcomeIv = byView(R.id.welcome_iv);
        welcomeTv = byView(R.id.welcome_tv);
    }

    @Override
    protected void initDatas() {
        welcomeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTo(WelcomeActivity.this, MainActivity.class);
                welcomeTask.cancel(true);
                finish();
            }
        });
        welcomeTask = new WelcomeTask();
        welcomeTask.execute(0);
    }

    public class WelcomeTask extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected Integer doInBackground(Integer... params) {
            int all = params[0];
            int now = 3;
            while (now >= all) {
                publishProgress(now);
                now--;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return R.string.turn_enter;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            welcomeTv.setText(String.valueOf(values[0]));
        }

        @Override
        protected void onPostExecute(Integer s) {
            super.onPostExecute(s);
            welcomeTv.setText(s);
            goTo(WelcomeActivity.this, MainActivity.class);
            finish();
        }
    }
}
