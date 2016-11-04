package pub.kanzhibo.app.model.roominfo;

import java.util.List;

/**
 * Created by turbo on 2016/11/4.
 */

public class DouYuUserInfo {

    /**
     * error : 0
     * data : {"room_id":"255865","room_thumb":"https://rpic.douyucdn.cn/a1611/03/21/255865_161103210330.jpg","cate_id":"55","cate_name":"魔兽争霸","room_name":"16:00霸王传说","room_status":"2","owner_name":"Infi小王","avatar":"https://apic.douyucdn.cn/upload/avatar/016/49/38/32_avatar_big.jpg?rltime","online":0,"owner_weight":"24.16t","fans_num":"117078","start_time":"2016-11-03 15:59","gift":[{"id":"196","name":"火箭","type":"2","pc":500,"gx":5000,"desc":"赠送网站广播并派送出神秘宝箱","intro":"我们的征途是星辰大海","mimg":"http://staticlive.douyucdn.cn/upload/dygift/1606/26f802520cf0e4d8a645259bbc1aadf3.png","himg":"http://staticlive.douyucdn.cn/upload/dygift/1606/39b578b3cb8645b54f9a1001c392a237.gif"},{"id":"195","name":"飞机","type":"2","pc":100,"gx":1000,"desc":"赠送房间广播并赠送道具宝箱","intro":"主播带我飞","mimg":"http://staticlive.douyucdn.cn/upload/dygift/1606/76dd0d8c803b133467e4f0196c7d071d.png","himg":"http://staticlive.douyucdn.cn/upload/dygift/1606/93daef170894a9d6bd8495fa0f81e165.gif"},{"id":"194","name":"666","type":"2","pc":6,"gx":60,"desc":"","intro":"主播这么6，你麻麻知道吗","mimg":"http://staticlive.douyucdn.cn/upload/dygift/1606/9c30da343dc3b1e65156ae0570603d06.png","himg":"http://staticlive.douyucdn.cn/upload/dygift/1606/6681d1a713ece37912a1dac339c9fb29.gif"},{"id":"193","name":"弱鸡","type":"2","pc":0.2,"gx":2,"desc":"","intro":"真是太鶸拉~","mimg":"http://staticlive.douyucdn.cn/upload/dygift/1606/3cecdd879dc9e9ec5f0c77099201ca94.png","himg":"http://staticlive.douyucdn.cn/upload/dygift/1606/e144b05fd7dec1b194909e02b6dff92f.gif"},{"id":"192","name":"赞","type":"2","pc":0.1,"gx":1,"desc":"","intro":"赞一个！","mimg":"http://staticlive.douyucdn.cn/upload/dygift/1606/d1ebe78032472a3146b5f8e717ead680.png","himg":"http://staticlive.douyucdn.cn/upload/dygift/1606/b09488ff5ebe85c4f66e72e27b53d517.gif"},{"id":"191","name":"100鱼丸","type":"1","pc":100,"gx":1,"desc":"","intro":"绝佳的增重美食","mimg":"http://staticlive.douyucdn.cn/upload/dygift/1606/37a913eb1d9b3e8e6278d8a309696d58.png","himg":"http://staticlive.douyucdn.cn/upload/dygift/1606/072dc9aea67fb42f095f973c8e0a183e.png"}]}
     */

    private int error;
    /**
     * room_id : 255865
     * room_thumb : https://rpic.douyucdn.cn/a1611/03/21/255865_161103210330.jpg
     * cate_id : 55
     * cate_name : 魔兽争霸
     * room_name : 16:00霸王传说
     * room_status : 2
     * owner_name : Infi小王
     * avatar : https://apic.douyucdn.cn/upload/avatar/016/49/38/32_avatar_big.jpg?rltime
     * online : 0
     * owner_weight : 24.16t
     * fans_num : 117078
     * start_time : 2016-11-03 15:59
     * gift : [{"id":"196","name":"火箭","type":"2","pc":500,"gx":5000,"desc":"赠送网站广播并派送出神秘宝箱","intro":"我们的征途是星辰大海","mimg":"http://staticlive.douyucdn.cn/upload/dygift/1606/26f802520cf0e4d8a645259bbc1aadf3.png","himg":"http://staticlive.douyucdn.cn/upload/dygift/1606/39b578b3cb8645b54f9a1001c392a237.gif"},{"id":"195","name":"飞机","type":"2","pc":100,"gx":1000,"desc":"赠送房间广播并赠送道具宝箱","intro":"主播带我飞","mimg":"http://staticlive.douyucdn.cn/upload/dygift/1606/76dd0d8c803b133467e4f0196c7d071d.png","himg":"http://staticlive.douyucdn.cn/upload/dygift/1606/93daef170894a9d6bd8495fa0f81e165.gif"},{"id":"194","name":"666","type":"2","pc":6,"gx":60,"desc":"","intro":"主播这么6，你麻麻知道吗","mimg":"http://staticlive.douyucdn.cn/upload/dygift/1606/9c30da343dc3b1e65156ae0570603d06.png","himg":"http://staticlive.douyucdn.cn/upload/dygift/1606/6681d1a713ece37912a1dac339c9fb29.gif"},{"id":"193","name":"弱鸡","type":"2","pc":0.2,"gx":2,"desc":"","intro":"真是太鶸拉~","mimg":"http://staticlive.douyucdn.cn/upload/dygift/1606/3cecdd879dc9e9ec5f0c77099201ca94.png","himg":"http://staticlive.douyucdn.cn/upload/dygift/1606/e144b05fd7dec1b194909e02b6dff92f.gif"},{"id":"192","name":"赞","type":"2","pc":0.1,"gx":1,"desc":"","intro":"赞一个！","mimg":"http://staticlive.douyucdn.cn/upload/dygift/1606/d1ebe78032472a3146b5f8e717ead680.png","himg":"http://staticlive.douyucdn.cn/upload/dygift/1606/b09488ff5ebe85c4f66e72e27b53d517.gif"},{"id":"191","name":"100鱼丸","type":"1","pc":100,"gx":1,"desc":"","intro":"绝佳的增重美食","mimg":"http://staticlive.douyucdn.cn/upload/dygift/1606/37a913eb1d9b3e8e6278d8a309696d58.png","himg":"http://staticlive.douyucdn.cn/upload/dygift/1606/072dc9aea67fb42f095f973c8e0a183e.png"}]
     */

    private DataEntity data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        private String room_id;
        private String room_thumb;
        private String cate_id;
        private String cate_name;
        private String room_name;
        private String room_status;
        private String owner_name;
        private String avatar;
        private int online;
        private String owner_weight;
        private String fans_num;
        private String start_time;
        /**
         * id : 196
         * name : 火箭
         * type : 2
         * pc : 500
         * gx : 5000
         * desc : 赠送网站广播并派送出神秘宝箱
         * intro : 我们的征途是星辰大海
         * mimg : http://staticlive.douyucdn.cn/upload/dygift/1606/26f802520cf0e4d8a645259bbc1aadf3.png
         * himg : http://staticlive.douyucdn.cn/upload/dygift/1606/39b578b3cb8645b54f9a1001c392a237.gif
         */

        private List<GiftEntity> gift;

        public String getRoom_id() {
            return room_id;
        }

        public void setRoom_id(String room_id) {
            this.room_id = room_id;
        }

        public String getRoom_thumb() {
            return room_thumb;
        }

        public void setRoom_thumb(String room_thumb) {
            this.room_thumb = room_thumb;
        }

        public String getCate_id() {
            return cate_id;
        }

        public void setCate_id(String cate_id) {
            this.cate_id = cate_id;
        }

        public String getCate_name() {
            return cate_name;
        }

        public void setCate_name(String cate_name) {
            this.cate_name = cate_name;
        }

        public String getRoom_name() {
            return room_name;
        }

        public void setRoom_name(String room_name) {
            this.room_name = room_name;
        }

        public String getRoom_status() {
            return room_status;
        }

        public void setRoom_status(String room_status) {
            this.room_status = room_status;
        }

        public String getOwner_name() {
            return owner_name;
        }

        public void setOwner_name(String owner_name) {
            this.owner_name = owner_name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getOnline() {
            return online;
        }

        public void setOnline(int online) {
            this.online = online;
        }

        public String getOwner_weight() {
            return owner_weight;
        }

        public void setOwner_weight(String owner_weight) {
            this.owner_weight = owner_weight;
        }

        public String getFans_num() {
            return fans_num;
        }

        public void setFans_num(String fans_num) {
            this.fans_num = fans_num;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public List<GiftEntity> getGift() {
            return gift;
        }

        public void setGift(List<GiftEntity> gift) {
            this.gift = gift;
        }

        public static class GiftEntity {
            private String id;
            private String name;
            private String type;
            private float pc;
            private float gx;
            private String desc;
            private String intro;
            private String mimg;
            private String himg;

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

            public float getPc() {
                return pc;
            }

            public void setPc(int pc) {
                this.pc = pc;
            }

            public float getGx() {
                return gx;
            }

            public void setGx(int gx) {
                this.gx = gx;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getMimg() {
                return mimg;
            }

            public void setMimg(String mimg) {
                this.mimg = mimg;
            }

            public String getHimg() {
                return himg;
            }

            public void setHimg(String himg) {
                this.himg = himg;
            }
        }
    }
}
