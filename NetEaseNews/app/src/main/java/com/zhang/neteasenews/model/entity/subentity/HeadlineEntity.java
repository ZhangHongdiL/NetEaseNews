package com.zhang.neteasenews.model.entity.subentity;

import java.util.List;

/**
 * Created by dllo on 16/9/19.
 * 新闻界面头条的实体类
 */
public class HeadlineEntity {

    /**
     * ads : [{"imgsrc":"http://cms-bucket.nosdn.127.net/16f72c43a94c434aab955d395e0b71af20160919191056.jpeg","subtitle":"","tag":"doc","title":"看那些无所不能的辣妈们如何玩转生活","url":"C1BA3N8705169QC9"},{"imgsrc":"http://cms-bucket.nosdn.127.net/a97e208126f24400a92a60813bdc816620160919144319.jpeg","subtitle":"","tag":"doc","title":"中国男女乱晒娃时，国外夫妻在晒这个!","url":"C1AN457F05169QC9"},{"imgsrc":"http://cms-bucket.nosdn.127.net/3d797e6b6fc94e5cbea57f91f780e5ec20160919092648.jpeg","subtitle":"","tag":"photoset","title":"河水水位下降 居民开垦河道变\u201c菜园\u201d","url":"00AP0001|2198852"},{"imgsrc":"http://cms-bucket.nosdn.127.net/23ca001962604efe8c2942fcb160280120160919072831.jpeg","subtitle":"","tag":"photoset","title":"三峡升船机试航 游轮\"乘电梯\"翻越大坝","url":"00AP0001|2198803"}]
     * adtype : 0
     * clkNum : 0
     * docid : C0PC9RBM05169CRR
     * downTimes : 0
     * hasAD : 1
     * hasHead : 1
     * id : C0PC9RBM05169CRR
     * img : http://cms-bucket.nosdn.127.net/42349cf13f6a46239831c66b2cc8be0020160919172443.jpeg
     * imgType : 0
     * imgsrc : http://cms-bucket.nosdn.127.net/42349cf13f6a46239831c66b2cc8be0020160919172443.jpeg
     * lmodify : 2016-09-19 19:04:18
     * picCount : 0
     * program : LMA1
     * prompt : 成功为您推荐10条新内容
     * ptime : 2016-09-12 16:25:18
     * recType : 0
     * recprog : base
     * replyCount : 433
     * source : 浪摧小宇宙
     * template : normal1
     * title : 【网易号直播】：从国际空间站看地球
     * upTimes : 16
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
         * imgsrc : http://cms-bucket.nosdn.127.net/16f72c43a94c434aab955d395e0b71af20160919191056.jpeg
         * subtitle :
         * tag : doc
         * title : 看那些无所不能的辣妈们如何玩转生活
         * url : C1BA3N8705169QC9
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
