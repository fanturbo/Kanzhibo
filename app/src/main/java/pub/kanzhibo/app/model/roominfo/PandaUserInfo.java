package pub.kanzhibo.app.model.roominfo;

import java.util.List;

/**
 * Created by snail on 16/11/5.
 */
public class PandaUserInfo {

    /**
     * errno : 0
     * errmsg :
     * data : {"info":{"hostinfo":{"rid":48874840,"name":"Coco美七七","avatar":"http://i6.pdim.gs/4f4ebfb53a6fca0b863c65d048f37f24.jpg","bamboos":"349774"},"roominfo":{"id":"582816","name":"清流美七七","type":"1","classification":"户外直播","cate":"hwzb","bulletin":"微博：Coco美七七 粉丝群：316766331 每晚9:00开始直播  跳舞、聊天、段子、互动。","details":"<p>清流美七七，会跳舞的段子手哈哈，努力做好每一天直播，希望大家喜欢。<img src=\"http://img.baidu.com/hi/jx2/j_0063.gif\">微博：Coco美七七 粉丝群：316766331<\/p><p><br><\/p><p><img src=\"http://i5.pdim.gs/9c8829efc298b94f861a3a6ca987073d.jpeg\" width=\"363\" height=\"280\"><img src=\"http://i8.pdim.gs/62c6e0c29b46276b4ce65e9dc7167460.jpeg\" width=\"253\" height=\"306\"><img src=\"http://i5.pdim.gs/3ff29cc86b5a069c6e83189311367a1b.jpeg\" width=\"233\" height=\"307\"><\/p><p><span style=\"text-align: center;\"><\/span><span style=\"text-align: center;\"><\/span><span style=\"text-align: center;\"><\/span><span style=\"text-align: center;\"><\/span><span style=\"text-align: center;\"><\/span><\/p><div><\/div><div><\/div>","person_num":"0","fans":"4615","pictures":{"img":"http://i9.pdim.gs/45/0f4beb65849f855bac06374b5879b1c9/w338/h190.jpg"},"display_type":"1","start_time":"1478327505","end_time":"1478327678","room_type":"1","remind_content":"","remind_time":"0","remind_status":"0"},"userinfo":{"rid":0},"videoinfo":{"name":"dota","time":"31600","stream_addr":{"HD":"1","OD":"1","SD":"1"},"room_key":"a366dec5ca6a6ff19f1c24b8d97c303b","plflag":"2_3","status":"3","sign":"sign","ts":"ts","hardware":"2","slaveflag":["4_7","5_9","6_14","12_24"],"watermark":"1"}}}
     * authseq :
     */

    private int errno;
    private String errmsg;
    /**
     * info : {"hostinfo":{"rid":48874840,"name":"Coco美七七","avatar":"http://i6.pdim.gs/4f4ebfb53a6fca0b863c65d048f37f24.jpg","bamboos":"349774"},"roominfo":{"id":"582816","name":"清流美七七","type":"1","classification":"户外直播","cate":"hwzb","bulletin":"微博：Coco美七七 粉丝群：316766331 每晚9:00开始直播  跳舞、聊天、段子、互动。","details":"<p>清流美七七，会跳舞的段子手哈哈，努力做好每一天直播，希望大家喜欢。<img src=\"http://img.baidu.com/hi/jx2/j_0063.gif\">微博：Coco美七七 粉丝群：316766331<\/p><p><br><\/p><p><img src=\"http://i5.pdim.gs/9c8829efc298b94f861a3a6ca987073d.jpeg\" width=\"363\" height=\"280\"><img src=\"http://i8.pdim.gs/62c6e0c29b46276b4ce65e9dc7167460.jpeg\" width=\"253\" height=\"306\"><img src=\"http://i5.pdim.gs/3ff29cc86b5a069c6e83189311367a1b.jpeg\" width=\"233\" height=\"307\"><\/p><p><span style=\"text-align: center;\"><\/span><span style=\"text-align: center;\"><\/span><span style=\"text-align: center;\"><\/span><span style=\"text-align: center;\"><\/span><span style=\"text-align: center;\"><\/span><\/p><div><\/div><div><\/div>","person_num":"0","fans":"4615","pictures":{"img":"http://i9.pdim.gs/45/0f4beb65849f855bac06374b5879b1c9/w338/h190.jpg"},"display_type":"1","start_time":"1478327505","end_time":"1478327678","room_type":"1","remind_content":"","remind_time":"0","remind_status":"0"},"userinfo":{"rid":0},"videoinfo":{"name":"dota","time":"31600","stream_addr":{"HD":"1","OD":"1","SD":"1"},"room_key":"a366dec5ca6a6ff19f1c24b8d97c303b","plflag":"2_3","status":"3","sign":"sign","ts":"ts","hardware":"2","slaveflag":["4_7","5_9","6_14","12_24"],"watermark":"1"}}
     */

    private DataBean data;
    private String authseq;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getAuthseq() {
        return authseq;
    }

    public void setAuthseq(String authseq) {
        this.authseq = authseq;
    }

    public static class DataBean {
        /**
         * hostinfo : {"rid":48874840,"name":"Coco美七七","avatar":"http://i6.pdim.gs/4f4ebfb53a6fca0b863c65d048f37f24.jpg","bamboos":"349774"}
         * roominfo : {"id":"582816","name":"清流美七七","type":"1","classification":"户外直播","cate":"hwzb","bulletin":"微博：Coco美七七 粉丝群：316766331 每晚9:00开始直播  跳舞、聊天、段子、互动。","details":"<p>清流美七七，会跳舞的段子手哈哈，努力做好每一天直播，希望大家喜欢。<img src=\"http://img.baidu.com/hi/jx2/j_0063.gif\">微博：Coco美七七 粉丝群：316766331<\/p><p><br><\/p><p><img src=\"http://i5.pdim.gs/9c8829efc298b94f861a3a6ca987073d.jpeg\" width=\"363\" height=\"280\"><img src=\"http://i8.pdim.gs/62c6e0c29b46276b4ce65e9dc7167460.jpeg\" width=\"253\" height=\"306\"><img src=\"http://i5.pdim.gs/3ff29cc86b5a069c6e83189311367a1b.jpeg\" width=\"233\" height=\"307\"><\/p><p><span style=\"text-align: center;\"><\/span><span style=\"text-align: center;\"><\/span><span style=\"text-align: center;\"><\/span><span style=\"text-align: center;\"><\/span><span style=\"text-align: center;\"><\/span><\/p><div><\/div><div><\/div>","person_num":"0","fans":"4615","pictures":{"img":"http://i9.pdim.gs/45/0f4beb65849f855bac06374b5879b1c9/w338/h190.jpg"},"display_type":"1","start_time":"1478327505","end_time":"1478327678","room_type":"1","remind_content":"","remind_time":"0","remind_status":"0"}
         * userinfo : {"rid":0}
         * videoinfo : {"name":"dota","time":"31600","stream_addr":{"HD":"1","OD":"1","SD":"1"},"room_key":"a366dec5ca6a6ff19f1c24b8d97c303b","plflag":"2_3","status":"3","sign":"sign","ts":"ts","hardware":"2","slaveflag":["4_7","5_9","6_14","12_24"],"watermark":"1"}
         */

        private InfoBean info;

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public static class InfoBean {
            /**
             * rid : 48874840
             * name : Coco美七七
             * avatar : http://i6.pdim.gs/4f4ebfb53a6fca0b863c65d048f37f24.jpg
             * bamboos : 349774
             */

            private HostinfoBean hostinfo;
            /**
             * id : 582816
             * name : 清流美七七
             * type : 1
             * classification : 户外直播
             * cate : hwzb
             * bulletin : 微博：Coco美七七 粉丝群：316766331 每晚9:00开始直播  跳舞、聊天、段子、互动。
             * details : <p>清流美七七，会跳舞的段子手哈哈，努力做好每一天直播，希望大家喜欢。<img src="http://img.baidu.com/hi/jx2/j_0063.gif">微博：Coco美七七 粉丝群：316766331</p><p><br></p><p><img src="http://i5.pdim.gs/9c8829efc298b94f861a3a6ca987073d.jpeg" width="363" height="280"><img src="http://i8.pdim.gs/62c6e0c29b46276b4ce65e9dc7167460.jpeg" width="253" height="306"><img src="http://i5.pdim.gs/3ff29cc86b5a069c6e83189311367a1b.jpeg" width="233" height="307"></p><p><span style="text-align: center;"></span><span style="text-align: center;"></span><span style="text-align: center;"></span><span style="text-align: center;"></span><span style="text-align: center;"></span></p><div></div><div></div>
             * person_num : 0
             * fans : 4615
             * pictures : {"img":"http://i9.pdim.gs/45/0f4beb65849f855bac06374b5879b1c9/w338/h190.jpg"}
             * display_type : 1
             * start_time : 1478327505
             * end_time : 1478327678
             * room_type : 1
             * remind_content :
             * remind_time : 0
             * remind_status : 0
             */

            private RoominfoBean roominfo;
            /**
             * rid : 0
             */

            private UserinfoBean userinfo;
            /**
             * name : dota
             * time : 31600
             * stream_addr : {"HD":"1","OD":"1","SD":"1"}
             * room_key : a366dec5ca6a6ff19f1c24b8d97c303b
             * plflag : 2_3
             * status : 3
             * sign : sign
             * ts : ts
             * hardware : 2
             * slaveflag : ["4_7","5_9","6_14","12_24"]
             * watermark : 1
             */

            private VideoinfoBean videoinfo;

            public HostinfoBean getHostinfo() {
                return hostinfo;
            }

            public void setHostinfo(HostinfoBean hostinfo) {
                this.hostinfo = hostinfo;
            }

            public RoominfoBean getRoominfo() {
                return roominfo;
            }

            public void setRoominfo(RoominfoBean roominfo) {
                this.roominfo = roominfo;
            }

            public UserinfoBean getUserinfo() {
                return userinfo;
            }

            public void setUserinfo(UserinfoBean userinfo) {
                this.userinfo = userinfo;
            }

            public VideoinfoBean getVideoinfo() {
                return videoinfo;
            }

            public void setVideoinfo(VideoinfoBean videoinfo) {
                this.videoinfo = videoinfo;
            }

            public static class HostinfoBean {
                private int rid;
                private String name;
                private String avatar;
                private String bamboos;

                public int getRid() {
                    return rid;
                }

                public void setRid(int rid) {
                    this.rid = rid;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getBamboos() {
                    return bamboos;
                }

                public void setBamboos(String bamboos) {
                    this.bamboos = bamboos;
                }
            }

            public static class RoominfoBean {
                private String id;
                private String name;
                private String type;
                private String classification;
                private String cate;
                private String bulletin;
                private String details;
                private String person_num;
                private String fans;
                /**
                 * img : http://i9.pdim.gs/45/0f4beb65849f855bac06374b5879b1c9/w338/h190.jpg
                 */

                private PicturesBean pictures;
                private String display_type;
                private String start_time;
                private String end_time;
                private String room_type;
                private String remind_content;
                private String remind_time;
                private String remind_status;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getClassification() {
                    return classification;
                }

                public void setClassification(String classification) {
                    this.classification = classification;
                }

                public String getCate() {
                    return cate;
                }

                public void setCate(String cate) {
                    this.cate = cate;
                }

                public String getBulletin() {
                    return bulletin;
                }

                public void setBulletin(String bulletin) {
                    this.bulletin = bulletin;
                }

                public String getDetails() {
                    return details;
                }

                public void setDetails(String details) {
                    this.details = details;
                }

                public String getPerson_num() {
                    return person_num;
                }

                public void setPerson_num(String person_num) {
                    this.person_num = person_num;
                }

                public String getFans() {
                    return fans;
                }

                public void setFans(String fans) {
                    this.fans = fans;
                }

                public PicturesBean getPictures() {
                    return pictures;
                }

                public void setPictures(PicturesBean pictures) {
                    this.pictures = pictures;
                }

                public String getDisplay_type() {
                    return display_type;
                }

                public void setDisplay_type(String display_type) {
                    this.display_type = display_type;
                }

                public String getStart_time() {
                    return start_time;
                }

                public void setStart_time(String start_time) {
                    this.start_time = start_time;
                }

                public String getEnd_time() {
                    return end_time;
                }

                public void setEnd_time(String end_time) {
                    this.end_time = end_time;
                }

                public String getRoom_type() {
                    return room_type;
                }

                public void setRoom_type(String room_type) {
                    this.room_type = room_type;
                }

                public String getRemind_content() {
                    return remind_content;
                }

                public void setRemind_content(String remind_content) {
                    this.remind_content = remind_content;
                }

                public String getRemind_time() {
                    return remind_time;
                }

                public void setRemind_time(String remind_time) {
                    this.remind_time = remind_time;
                }

                public String getRemind_status() {
                    return remind_status;
                }

                public void setRemind_status(String remind_status) {
                    this.remind_status = remind_status;
                }

                public static class PicturesBean {
                    private String img;

                    public String getImg() {
                        return img;
                    }

                    public void setImg(String img) {
                        this.img = img;
                    }
                }
            }

            public static class UserinfoBean {
                private int rid;

                public int getRid() {
                    return rid;
                }

                public void setRid(int rid) {
                    this.rid = rid;
                }
            }

            public static class VideoinfoBean {
                private String name;
                private String time;
                /**
                 * HD : 1
                 * OD : 1
                 * SD : 1
                 */

                private StreamAddrBean stream_addr;
                private String room_key;
                private String plflag;
                private String status;
                private String sign;
                private String ts;
                private String hardware;
                private String watermark;
                private List<String> slaveflag;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public StreamAddrBean getStream_addr() {
                    return stream_addr;
                }

                public void setStream_addr(StreamAddrBean stream_addr) {
                    this.stream_addr = stream_addr;
                }

                public String getRoom_key() {
                    return room_key;
                }

                public void setRoom_key(String room_key) {
                    this.room_key = room_key;
                }

                public String getPlflag() {
                    return plflag;
                }

                public void setPlflag(String plflag) {
                    this.plflag = plflag;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getSign() {
                    return sign;
                }

                public void setSign(String sign) {
                    this.sign = sign;
                }

                public String getTs() {
                    return ts;
                }

                public void setTs(String ts) {
                    this.ts = ts;
                }

                public String getHardware() {
                    return hardware;
                }

                public void setHardware(String hardware) {
                    this.hardware = hardware;
                }

                public String getWatermark() {
                    return watermark;
                }

                public void setWatermark(String watermark) {
                    this.watermark = watermark;
                }

                public List<String> getSlaveflag() {
                    return slaveflag;
                }

                public void setSlaveflag(List<String> slaveflag) {
                    this.slaveflag = slaveflag;
                }

                public static class StreamAddrBean {
                    private String HD;
                    private String OD;
                    private String SD;

                    public String getHD() {
                        return HD;
                    }

                    public void setHD(String HD) {
                        this.HD = HD;
                    }

                    public String getOD() {
                        return OD;
                    }

                    public void setOD(String OD) {
                        this.OD = OD;
                    }

                    public String getSD() {
                        return SD;
                    }

                    public void setSD(String SD) {
                        this.SD = SD;
                    }
                }
            }
        }
    }
}
