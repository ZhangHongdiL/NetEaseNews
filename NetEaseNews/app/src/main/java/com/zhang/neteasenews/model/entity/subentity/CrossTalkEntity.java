package com.zhang.neteasenews.model.entity.subentity;

import java.util.List;

/**
 * Created by dllo on 16/9/18.
 * 新闻界面的段子的实体类
 */
public class CrossTalkEntity {

    /**
     * adtype : 0
     * boardid : comment_bbs
     * clkNum : 0
     * digest : 老婆开面包车走进2米2临时限高通道，有点紧张，楼主鼓励道：没问题能过。车一到限高杆只见老婆紧握方向盘，头一埋，车顺利通过。老婆抬头忙问：快看车顶过没？楼主肯定的说：过了。幸亏你及时埋头。
     * docid : BVR40PC890010PC9
     * downTimes : 42
     * imgType : 0
     * picCount : 0
     * program : HY
     * prompt : 成功为您推荐20条新内容
     * recType : 0
     * replyCount : 0
     * replyid : BVR40PC890010PC9
     * source : 糗事百科
     * title : 老婆开面包车走进2米2临时限高通道
     * upTimes : 72
     */

    private List<段子Bean> 段子;

    public List<段子Bean> get段子() {
        return 段子;
    }

    public void set段子(List<段子Bean> 段子) {
        this.段子 = 段子;
    }

    public static class 段子Bean {
        private int adtype;
        private String boardid;
        private int clkNum;
        private String digest;
        private String docid;
        private int downTimes;
        private int imgType;
        private int picCount;
        private String program;
        private String prompt;
        private int recType;
        private int replyCount;
        private String replyid;
        private String source;
        private String title;
        private int upTimes;

        public int getAdtype() {
            return adtype;
        }

        public void setAdtype(int adtype) {
            this.adtype = adtype;
        }

        public String getBoardid() {
            return boardid;
        }

        public void setBoardid(String boardid) {
            this.boardid = boardid;
        }

        public int getClkNum() {
            return clkNum;
        }

        public void setClkNum(int clkNum) {
            this.clkNum = clkNum;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public int getDownTimes() {
            return downTimes;
        }

        public void setDownTimes(int downTimes) {
            this.downTimes = downTimes;
        }

        public int getImgType() {
            return imgType;
        }

        public void setImgType(int imgType) {
            this.imgType = imgType;
        }

        public int getPicCount() {
            return picCount;
        }

        public void setPicCount(int picCount) {
            this.picCount = picCount;
        }

        public String getProgram() {
            return program;
        }

        public void setProgram(String program) {
            this.program = program;
        }

        public String getPrompt() {
            return prompt;
        }

        public void setPrompt(String prompt) {
            this.prompt = prompt;
        }

        public int getRecType() {
            return recType;
        }

        public void setRecType(int recType) {
            this.recType = recType;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public String getReplyid() {
            return replyid;
        }

        public void setReplyid(String replyid) {
            this.replyid = replyid;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUpTimes() {
            return upTimes;
        }

        public void setUpTimes(int upTimes) {
            this.upTimes = upTimes;
        }
    }
}
