package com.zhang.neteasenews.model.net;

/**
 * Created by dllo on 16/9/13.
 * 网络请求结果接口
 */
public interface VolleyResult {
    void success(String resultStr);

    void failure();
}
