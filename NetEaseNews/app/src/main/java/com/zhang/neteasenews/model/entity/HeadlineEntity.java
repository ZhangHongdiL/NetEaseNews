package com.zhang.neteasenews.model.entity;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 */
public class HeadlineEntity {

    /**
     * ads : [{"imgsrc":"http://cms-bucket.nosdn.127.net/37631833862e4fa88ae82dca867aa53220160913160915.jpeg","subtitle":"","tag":"photoset","title":"住建部否认海绵城市试点失败 称在推进","url":"00AP0001|2197605"},{"imgsrc":"http://cms-bucket.nosdn.127.net/ea97d6ecf03f4c3680dc40dd606e427920160913120917.jpeg","subtitle":"","tag":"photoset","title":"青岛一村过中秋现场发500万现金","url":"00AP0001|2197560"},{"imgsrc":"http://cms-bucket.nosdn.127.net/b9e303b979974822a6effc0a4790086320160913112644.jpeg","subtitle":"","tag":"photoset","title":"快播涉黄被判罚1千万 王欣等4人获刑","url":"00AP0001|2197534"},{"imgsrc":"http://cms-bucket.nosdn.127.net/e4cdced39138456f84a05462823aa70f20160913105138.jpeg","subtitle":"","tag":"photoset","title":"图片故事：无腿少年上学记","url":"00AP0001|2197515"},{"imgsrc":"http://cms-bucket.nosdn.127.net/6fb67d5dbf0041a9a9fb826e63ec9a1b20160913172428.jpeg","subtitle":"","tag":"photoset","title":"印控克什米尔民众宰牲节间与警察冲突","url":"00AO0001|2197629"}]
     * adtype : 0
     * clkNum : 0
     * docid : C0GU79DP00963VRO
     * downTimes : 0
     * hasAD : 1
     * hasHead : 1
     * id : C0GU79DP00963VRO
     * img : http://cms-bucket.nosdn.127.net/1ee2d211b3bf4433b3a9032dce87e06120160909103717.jpeg
     * imgType : 0
     * imgsrc : http://cms-bucket.nosdn.127.net/1ee2d211b3bf4433b3a9032dce87e06120160909103717.jpeg
     * lmodify : 2016-09-13 13:14:09
     * picCount : 0
     * program : LMA1
     * prompt : 成功为您推荐10条新内容
     * ptime : 2016-09-09 09:43:47
     * recType : 0
     * recprog : base
     * replyCount : 55
     * source : 网易
     * template : normal1
     * title : 用你旅行的旧扎记缓一段全新的Free旅程，换吗？
     * upTimes : 0
     */

    private List<T1348647909107Bean> T1348647909107;

    public List<T1348647909107Bean> getT1348647909107() {
        return T1348647909107;
    }

    public void setT1348647909107(List<T1348647909107Bean> T1348647909107) {
        this.T1348647909107 = T1348647909107;
    }

    public static class T1348647909107Bean {
        private int adtype;
        private int clkNum;
        private String docid;
        private int downTimes;
        private int hasAD;
        private int hasHead;
        private String id;
        private String img;
        private int imgType;
        private String imgsrc;
        private String lmodify;
        private int picCount;
        private String program;
        private String prompt;
        private String ptime;
        private int recType;
        private String recprog;
        private int replyCount;
        private String source;
        private String template;
        private String title;
        private int upTimes;
        /**
         * imgsrc : http://cms-bucket.nosdn.127.net/37631833862e4fa88ae82dca867aa53220160913160915.jpeg
         * subtitle :
         * tag : photoset
         * title : 住建部否认海绵城市试点失败 称在推进
         * url : 00AP0001|2197605
         */

        private List<AdsBean> ads;

        public int getAdtype() {
            return adtype;
        }

        public void setAdtype(int adtype) {
            this.adtype = adtype;
        }

        public int getClkNum() {
            return clkNum;
        }

        public void setClkNum(int clkNum) {
            this.clkNum = clkNum;
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

        public int getHasAD() {
            return hasAD;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public int getHasHead() {
            return hasHead;
        }

        public void setHasHead(int hasHead) {
            this.hasHead = hasHead;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getImgType() {
            return imgType;
        }

        public void setImgType(int imgType) {
            this.imgType = imgType;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getLmodify() {
            return lmodify;
        }

        public void setLmodify(String lmodify) {
            this.lmodify = lmodify;
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

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public int getRecType() {
            return recType;
        }

        public void setRecType(int recType) {
            this.recType = recType;
        }

        public String getRecprog() {
            return recprog;
        }

        public void setRecprog(String recprog) {
            this.recprog = recprog;
        }

        public int getReplyCount() {
            return replyCount;
        }

        public void setReplyCount(int replyCount) {
            this.replyCount = replyCount;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
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

        public List<AdsBean> getAds() {
            return ads;
        }

        public void setAds(List<AdsBean> ads) {
            this.ads = ads;
        }

        public static class AdsBean {
            private String imgsrc;
            private String subtitle;
            private String tag;
            private String title;
            private String url;

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
