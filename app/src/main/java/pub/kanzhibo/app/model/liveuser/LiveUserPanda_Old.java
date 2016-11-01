package pub.kanzhibo.app.model.liveuser;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by turbo on 2016/10/28.
 * 手机端返回数据格式-暂不使用
 */

public class LiveUserPanda_Old {

    /**
     * errno : 0
     * errmsg :
     * data : {"items":[{"md5":"ab1a82caa7f2dfdd","nickname":"钛度Sky","roomid":"5555","hostid":"43254052","name":"人皇Sky的直播间","style":"","class":"war3","classification":"魔兽DOTA1","person_num":"65","bamboos":"4136973","fans":"62164","status":"3","content":"","pictures":{"img":"http://i7.pdim.gs/45/78b22671501bfad5a163c7814e04fe94/w338/h190.jpg","qrcode":"http://i8.pdim.gs/1230cad731f7cc395e15f62722e05c51.png"},"updatetime":"2016-11-01 10:50:02","reliable":"1","sex":"0","province":"0","url_footprint":"CAAQABgAMAFCAA==","se":{"prefix":1,"docId":815496,"sort0":62164},"display_type":"1","tag":"","tag_switch":"1","tag_color":"1"}],"total":"186"}
     * authseq :
     */

    private int errno;
    private String errmsg;
    /**
     * items : [{"md5":"ab1a82caa7f2dfdd","nickname":"钛度Sky","roomid":"5555","hostid":"43254052","name":"人皇Sky的直播间","style":"","class":"war3","classification":"魔兽DOTA1","person_num":"65","bamboos":"4136973","fans":"62164","status":"3","content":"","pictures":{"img":"http://i7.pdim.gs/45/78b22671501bfad5a163c7814e04fe94/w338/h190.jpg","qrcode":"http://i8.pdim.gs/1230cad731f7cc395e15f62722e05c51.png"},"updatetime":"2016-11-01 10:50:02","reliable":"1","sex":"0","province":"0","url_footprint":"CAAQABgAMAFCAA==","se":{"prefix":1,"docId":815496,"sort0":62164},"display_type":"1","tag":"","tag_switch":"1","tag_color":"1"}]
     * total : 186
     */

    private DataEntity data;
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

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getAuthseq() {
        return authseq;
    }

    public void setAuthseq(String authseq) {
        this.authseq = authseq;
    }

    public static class DataEntity {
        private String total;
        /**
         * md5 : ab1a82caa7f2dfdd
         * nickname : 钛度Sky
         * roomid : 5555
         * hostid : 43254052
         * name : 人皇Sky的直播间
         * style :
         * class : war3
         * classification : 魔兽DOTA1
         * person_num : 65
         * bamboos : 4136973
         * fans : 62164
         * status : 3
         * content :
         * pictures : {"img":"http://i7.pdim.gs/45/78b22671501bfad5a163c7814e04fe94/w338/h190.jpg","qrcode":"http://i8.pdim.gs/1230cad731f7cc395e15f62722e05c51.png"}
         * updatetime : 2016-11-01 10:50:02
         * reliable : 1
         * sex : 0
         * province : 0
         * url_footprint : CAAQABgAMAFCAA==
         * se : {"prefix":1,"docId":815496,"sort0":62164}
         * display_type : 1
         * tag :
         * tag_switch : 1
         * tag_color : 1
         */

        private List<ItemsEntity> items;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public List<ItemsEntity> getItems() {
            return items;
        }

        public void setItems(List<ItemsEntity> items) {
            this.items = items;
        }

        public static class ItemsEntity {
            private String md5;
            private String nickname;
            private String roomid;
            private String hostid;
            private String name;
            private String style;
            @SerializedName("class")
            private String classX;
            private String classification;
            private String person_num;
            private String bamboos;
            private String fans;
            private String status;
            private String content;
            /**
             * img : http://i7.pdim.gs/45/78b22671501bfad5a163c7814e04fe94/w338/h190.jpg
             * qrcode : http://i8.pdim.gs/1230cad731f7cc395e15f62722e05c51.png
             */

            private PicturesEntity pictures;
            private String updatetime;
            private String reliable;
            private String sex;
            private String province;
            private String url_footprint;
            /**
             * prefix : 1
             * docId : 815496
             * sort0 : 62164
             */

            private SeEntity se;
            private String display_type;
            private String tag;
            private String tag_switch;
            private String tag_color;

            public String getMd5() {
                return md5;
            }

            public void setMd5(String md5) {
                this.md5 = md5;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getRoomid() {
                return roomid;
            }

            public void setRoomid(String roomid) {
                this.roomid = roomid;
            }

            public String getHostid() {
                return hostid;
            }

            public void setHostid(String hostid) {
                this.hostid = hostid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getStyle() {
                return style;
            }

            public void setStyle(String style) {
                this.style = style;
            }

            public String getClassX() {
                return classX;
            }

            public void setClassX(String classX) {
                this.classX = classX;
            }

            public String getClassification() {
                return classification;
            }

            public void setClassification(String classification) {
                this.classification = classification;
            }

            public String getPerson_num() {
                return person_num;
            }

            public void setPerson_num(String person_num) {
                this.person_num = person_num;
            }

            public String getBamboos() {
                return bamboos;
            }

            public void setBamboos(String bamboos) {
                this.bamboos = bamboos;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public PicturesEntity getPictures() {
                return pictures;
            }

            public void setPictures(PicturesEntity pictures) {
                this.pictures = pictures;
            }

            public String getUpdatetime() {
                return updatetime;
            }

            public void setUpdatetime(String updatetime) {
                this.updatetime = updatetime;
            }

            public String getReliable() {
                return reliable;
            }

            public void setReliable(String reliable) {
                this.reliable = reliable;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getUrl_footprint() {
                return url_footprint;
            }

            public void setUrl_footprint(String url_footprint) {
                this.url_footprint = url_footprint;
            }

            public SeEntity getSe() {
                return se;
            }

            public void setSe(SeEntity se) {
                this.se = se;
            }

            public String getDisplay_type() {
                return display_type;
            }

            public void setDisplay_type(String display_type) {
                this.display_type = display_type;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getTag_switch() {
                return tag_switch;
            }

            public void setTag_switch(String tag_switch) {
                this.tag_switch = tag_switch;
            }

            public String getTag_color() {
                return tag_color;
            }

            public void setTag_color(String tag_color) {
                this.tag_color = tag_color;
            }

            public static class PicturesEntity {
                private String img;
                private String qrcode;

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getQrcode() {
                    return qrcode;
                }

                public void setQrcode(String qrcode) {
                    this.qrcode = qrcode;
                }
            }

            public static class SeEntity {
                private int prefix;
                private int docId;
                private int sort0;

                public int getPrefix() {
                    return prefix;
                }

                public void setPrefix(int prefix) {
                    this.prefix = prefix;
                }

                public int getDocId() {
                    return docId;
                }

                public void setDocId(int docId) {
                    this.docId = docId;
                }

                public int getSort0() {
                    return sort0;
                }

                public void setSort0(int sort0) {
                    this.sort0 = sort0;
                }
            }
        }
    }
}
