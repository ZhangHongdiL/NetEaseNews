package com.zhang.neteasenews.model.entity.subentity;

import java.util.List;

/**
 * Created by dllo on 16/9/29.
 * 新闻界面搜索的热词的实体类
 */
public class SearchHotEntity {

    /**
     * hotWord : 居民举报饭店光污染
     */

    private List<HotWordListBean> hotWordList;

    public List<HotWordListBean> getHotWordList() {
        return hotWordList;
    }

    public void setHotWordList(List<HotWordListBean> hotWordList) {
        this.hotWordList = hotWordList;
    }

    public static class HotWordListBean {
        private String hotWord;

        public String getHotWord() {
            return hotWord;
        }

        public void setHotWord(String hotWord) {
            this.hotWord = hotWord;
        }
    }
}
