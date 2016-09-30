package com.zhang.neteasenews.model.entity.topicsubentity;

import java.util.List;

/**
 * Created by dllo on 16/9/30.
 * 话题界面话题的头布局的实体类
 */
public class ThemeHeadEntity {

    /**
     * focusNum : 774
     * picUrl : http://dingyue.nosdn.127.net/yc9oMICXJsEJCWjV1iChAUvMwqU9Vp1xE9vnnr6gbImmd1466490021437.jpeg
     * topicId : SJ06427989324096969100
     * topicName : 皇马
     */

    private List<话题Bean> 话题;

    public List<话题Bean> get话题() {
        return 话题;
    }

    public void set话题(List<话题Bean> 话题) {
        this.话题 = 话题;
    }

    public static class 话题Bean {
        private int focusNum;
        private String picUrl;
        private String topicId;
        private String topicName;

        public int getFocusNum() {
            return focusNum;
        }

        public void setFocusNum(int focusNum) {
            this.focusNum = focusNum;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getTopicId() {
            return topicId;
        }

        public void setTopicId(String topicId) {
            this.topicId = topicId;
        }

        public String getTopicName() {
            return topicName;
        }

        public void setTopicName(String topicName) {
            this.topicName = topicName;
        }
    }
}
