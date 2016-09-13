package com.zhang.neteasenews.model.net;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.zhang.neteasenews.ui.app.NetEaseNewsApp;

/**
 * Created by dllo on 16/9/12.
 * 网络请求的单例
 */
public class VolleyInstance {

    private static VolleyInstance instance;
    private RequestQueue requestQueue;

    private VolleyInstance() {
        requestQueue = Volley.newRequestQueue(NetEaseNewsApp.getContext());
    }

    public static VolleyInstance getInstance(){
        if (instance == null) {
            synchronized (VolleyInstance.class){
                if (instance == null) {
                    instance = new VolleyInstance();
                }
            }
        }
        return instance;
    }

    public void startRequest(String url, final VolleyResult result) {
        StringRequest str = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // 如果请求成功, 将数据返回到接口中
                result.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // 如果请求失败, 通知调用者请求失败
                result.failure();
            }
        });
        requestQueue.add(str);
    }
}
