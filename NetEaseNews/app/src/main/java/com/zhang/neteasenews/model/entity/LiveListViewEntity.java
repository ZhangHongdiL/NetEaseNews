package com.zhang.neteasenews.model.entity;

import java.util.List;

/**
 * Created by dllo on 16/9/10.
 * 直播界面的实体类
 */
public class LiveListViewEntity {

    /**
     * hasCover : false
     * hasHead : 1
     * hasImg : 1
     * digest :
     * hasIcon : false
     * docid : twAcEVxkMct5lJVR
     * title : 丁磊直播首秀:水下开机试iPhone7
     * TAGS : 直播预告
     * order : 1
     * priority : 70
     * lmodify : 2016-09-16 11:00:00
     * TAG : 直播预告
     * template : normal1
     * skipID : 95908
     * alias : newlive
     * skipType : live
     * cid : C1462958359578
     * editor : []
     * hasAD : 1
     * source : 网易原创
     * imgType : 1
     * live_info : {"pano":false,"end_time":"2016-09-16 14:00:00","user_count":370453,"start_time":"2016-09-16 11:00:00","roomId":95908,"mutiVideo":false,"type":0,"video":false}
     * tname : 直播
     * imgsrc : http://cms-bucket.nosdn.127.net/47552b6047724721b61ece3dcf8bd24820160913192549.jpg
     * ename : newlive
     * ptime : 2016-09-16 11:00:00
     */

    private List<T1462958418713Bean> T1462958418713;

    public List<T1462958418713Bean> getT1462958418713() {
        return T1462958418713;
    }

    public void setT1462958418713(List<T1462958418713Bean> T1462958418713) {
        this.T1462958418713 = T1462958418713;
    }

    public static class T1462958418713Bean {
        private boolean hasCover;
        private int hasHead;
        private int hasImg;
        private String digest;
        private boolean hasIcon;
        private String docid;
        private String title;
        private String TAGS;
        private int order;
        private int priority;
        private String lmodify;
        private String TAG;
        private String template;
        private String skipID;
        private String alias;
        private String skipType;
        private String cid;
        private int hasAD;
        private String source;
        private int imgType;
        /**
         * pano : false
         * end_time : 2016-09-16 14:00:00
         * user_count : 370453
         * start_time : 2016-09-16 11:00:00
         * roomId : 95908
         * mutiVideo : false
         * type : 0
         * video : false
         */

        private LiveInfoBean live_info;
        private String tname;
        private String imgsrc;
        private String ename;
        private String ptime;
        private List<?> editor;

        public boolean isHasCover() {
            return hasCover;
        }

        public void setHasCover(boolean hasCover) {
            this.hasCover = hasCover;
        }

        public int getHasHead() {
            return hasHead;
        }

        public void setHasHead(int hasHead) {
            this.hasHead = hasHead;
        }

        public int getHasImg() {
            return hasImg;
        }

        public void setHasImg(int hasImg) {
            this.hasImg = hasImg;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public boolean isHasIcon() {
            return hasIcon;
        }

        public void setHasIcon(boolean hasIcon) {
            this.hasIcon = hasIcon;
        }

        public String getDocid() {
            return docid;
        }

        public void setDocid(String docid) {
            this.docid = docid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTAGS() {
            return TAGS;
        }

        public void setTAGS(String TAGS) {
            this.TAGS = TAGS;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public String getLmodify() {
            return lmodify;
        }

        public void setLmodify(String lmodify) {
            this.lmodify = lmodify;
        }

        public String getTAG() {
            return TAG;
        }

        public void setTAG(String TAG) {
            this.TAG = TAG;
        }

        public String getTemplate() {
            return template;
        }

        public void setTemplate(String template) {
            this.template = template;
        }

        public String getSkipID() {
            return skipID;
        }

        public void setSkipID(String skipID) {
            this.skipID = skipID;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getSkipType() {
            return skipType;
        }

        public void setSkipType(String skipType) {
            this.skipType = skipType;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public int getHasAD() {
            return hasAD;
        }

        public void setHasAD(int hasAD) {
            this.hasAD = hasAD;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public int getImgType() {
            return imgType;
        }

        public void setImgType(int imgType) {
            this.imgType = imgType;
        }

        public LiveInfoBean getLive_info() {
            return live_info;
        }

        public void setLive_info(LiveInfoBean live_info) {
            this.live_info = live_info;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getEname() {
            return ename;
        }

        public void setEname(String ename) {
            this.ename = ename;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public List<?> getEditor() {
            return editor;
        }

        public void setEditor(List<?> editor) {
            this.editor = editor;
        }

        public static class LiveInfoBean {
            private boolean pano;
            private String end_time;
            private int user_count;
            private String start_time;
            private int roomId;
            private boolean mutiVideo;
            private int type;
            private boolean video;

            public boolean isPano() {
                return pano;
            }

            public void setPano(boolean pano) {
                this.pano = pano;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public int getUser_count() {
                return user_count;
            }

            public void setUser_count(int user_count) {
                this.user_count = user_count;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public int getRoomId() {
                return roomId;
            }

            public void setRoomId(int roomId) {
                this.roomId = roomId;
            }

            public boolean isMutiVideo() {
                return mutiVideo;
            }

            public void setMutiVideo(boolean mutiVideo) {
                this.mutiVideo = mutiVideo;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public boolean isVideo() {
                return video;
            }

            public void setVideo(boolean video) {
                this.video = video;
            }
        }
    }
}
