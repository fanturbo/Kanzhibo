package pub.kanzhibo.app.model.liveuser;

import java.util.List;

/**
 * Created by turbo on 2016/10/28.
 */

public class LiveUserDouYu {


    /**
     * error : 0
     * data : {"count":200,"room":[{"room_id":"255865","room_src":"https://rpic.douyucdn.cn/a1610/30/22/255865_161030223356.jpg","vertical_src":"https://rpic.douyucdn.cn/a1610/30/22/255865_161030223356.jpg","isVertical":0,"cate_id":"55","room_name":"今晚继续休息\u2026\u2026","show_status":"2","subject":"","show_time":"1477821152","owner_uid":"16493832","specific_catalog":"infiwang","specific_status":"1","vod_quality":"0","nickname":"Infi小王","online":0,"child_id":"245","avatar":"https://apic.douyucdn.cn/upload/avatar/016/49/38/32_avatar_big.jpg","avatar_mid":"https://apic.douyucdn.cn/upload/avatar/016/49/38/32_avatar_middle.jpg","avatar_small":"https://apic.douyucdn.cn/upload/avatar/016/49/38/32_avatar_small.jpg","jumpUrl":"","icon_data":{"status":5,"icon_url":"","icon_width":0,"icon_height":0},"url":"/infiwang","game_url":"/directory/game/mszb","game_name":"魔兽争霸","fans":"116564","ranktype":0}]}
     */

    private int error;
    /**
     * count : 200
     * room : [{"room_id":"255865","room_src":"https://rpic.douyucdn.cn/a1610/30/22/255865_161030223356.jpg","vertical_src":"https://rpic.douyucdn.cn/a1610/30/22/255865_161030223356.jpg","isVertical":0,"cate_id":"55","room_name":"今晚继续休息\u2026\u2026","show_status":"2","subject":"","show_time":"1477821152","owner_uid":"16493832","specific_catalog":"infiwang","specific_status":"1","vod_quality":"0","nickname":"Infi小王","online":0,"child_id":"245","avatar":"https://apic.douyucdn.cn/upload/avatar/016/49/38/32_avatar_big.jpg","avatar_mid":"https://apic.douyucdn.cn/upload/avatar/016/49/38/32_avatar_middle.jpg","avatar_small":"https://apic.douyucdn.cn/upload/avatar/016/49/38/32_avatar_small.jpg","jumpUrl":"","icon_data":{"status":5,"icon_url":"","icon_width":0,"icon_height":0},"url":"/infiwang","game_url":"/directory/game/mszb","game_name":"魔兽争霸","fans":"116564","ranktype":0}]
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
        private int count;
        /**
         * room_id : 255865
         * room_src : https://rpic.douyucdn.cn/a1610/30/22/255865_161030223356.jpg
         * vertical_src : https://rpic.douyucdn.cn/a1610/30/22/255865_161030223356.jpg
         * isVertical : 0
         * cate_id : 55
         * room_name : 今晚继续休息……
         * show_status : 2
         * subject :
         * show_time : 1477821152
         * owner_uid : 16493832
         * specific_catalog : infiwang
         * specific_status : 1
         * vod_quality : 0
         * nickname : Infi小王
         * online : 0
         * child_id : 245
         * avatar : https://apic.douyucdn.cn/upload/avatar/016/49/38/32_avatar_big.jpg
         * avatar_mid : https://apic.douyucdn.cn/upload/avatar/016/49/38/32_avatar_middle.jpg
         * avatar_small : https://apic.douyucdn.cn/upload/avatar/016/49/38/32_avatar_small.jpg
         * jumpUrl :
         * icon_data : {"status":5,"icon_url":"","icon_width":0,"icon_height":0}
         * url : /infiwang
         * game_url : /directory/game/mszb
         * game_name : 魔兽争霸
         * fans : 116564
         * ranktype : 0
         */

        private List<RoomEntity> room;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<RoomEntity> getRoom() {
            return room;
        }

        public void setRoom(List<RoomEntity> room) {
            this.room = room;
        }

        public static class RoomEntity {
            private String room_id;
            private String room_src;
            private String vertical_src;
            private int isVertical;
            private String cate_id;
            private String room_name;
            private String show_status;//在线状态 1在线 2不在线
            private String subject;
            private String show_time;
            private String owner_uid;
            private String specific_catalog;
            private String specific_status;
            private String vod_quality;
            private String nickname;
            private int online;
            private String child_id;
            private String avatar;
            private String avatar_mid;
            private String avatar_small;
            private String jumpUrl;
            /**
             * status : 5
             * icon_url :
             * icon_width : 0
             * icon_height : 0
             */

            private IconDataEntity icon_data;
            private String url;
            private String game_url;
            private String game_name;
            private String fans;
            private int ranktype;

            public String getRoom_id() {
                return room_id;
            }

            public void setRoom_id(String room_id) {
                this.room_id = room_id;
            }

            public String getRoom_src() {
                return room_src;
            }

            public void setRoom_src(String room_src) {
                this.room_src = room_src;
            }

            public String getVertical_src() {
                return vertical_src;
            }

            public void setVertical_src(String vertical_src) {
                this.vertical_src = vertical_src;
            }

            public int getIsVertical() {
                return isVertical;
            }

            public void setIsVertical(int isVertical) {
                this.isVertical = isVertical;
            }

            public String getCate_id() {
                return cate_id;
            }

            public void setCate_id(String cate_id) {
                this.cate_id = cate_id;
            }

            public String getRoom_name() {
                return room_name;
            }

            public void setRoom_name(String room_name) {
                this.room_name = room_name;
            }

            public String getShow_status() {
                return show_status;
            }

            public void setShow_status(String show_status) {
                this.show_status = show_status;
            }

            public String getSubject() {
                return subject;
            }

            public void setSubject(String subject) {
                this.subject = subject;
            }

            public String getShow_time() {
                return show_time;
            }

            public void setShow_time(String show_time) {
                this.show_time = show_time;
            }

            public String getOwner_uid() {
                return owner_uid;
            }

            public void setOwner_uid(String owner_uid) {
                this.owner_uid = owner_uid;
            }

            public String getSpecific_catalog() {
                return specific_catalog;
            }

            public void setSpecific_catalog(String specific_catalog) {
                this.specific_catalog = specific_catalog;
            }

            public String getSpecific_status() {
                return specific_status;
            }

            public void setSpecific_status(String specific_status) {
                this.specific_status = specific_status;
            }

            public String getVod_quality() {
                return vod_quality;
            }

            public void setVod_quality(String vod_quality) {
                this.vod_quality = vod_quality;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getOnline() {
                return online;
            }

            public void setOnline(int online) {
                this.online = online;
            }

            public String getChild_id() {
                return child_id;
            }

            public void setChild_id(String child_id) {
                this.child_id = child_id;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getAvatar_mid() {
                return avatar_mid;
            }

            public void setAvatar_mid(String avatar_mid) {
                this.avatar_mid = avatar_mid;
            }

            public String getAvatar_small() {
                return avatar_small;
            }

            public void setAvatar_small(String avatar_small) {
                this.avatar_small = avatar_small;
            }

            public String getJumpUrl() {
                return jumpUrl;
            }

            public void setJumpUrl(String jumpUrl) {
                this.jumpUrl = jumpUrl;
            }

            public IconDataEntity getIcon_data() {
                return icon_data;
            }

            public void setIcon_data(IconDataEntity icon_data) {
                this.icon_data = icon_data;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getGame_url() {
                return game_url;
            }

            public void setGame_url(String game_url) {
                this.game_url = game_url;
            }

            public String getGame_name() {
                return game_name;
            }

            public void setGame_name(String game_name) {
                this.game_name = game_name;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public int getRanktype() {
                return ranktype;
            }

            public void setRanktype(int ranktype) {
                this.ranktype = ranktype;
            }

            public static class IconDataEntity {
                private int status;
                private String icon_url;
                private int icon_width;
                private int icon_height;

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getIcon_url() {
                    return icon_url;
                }

                public void setIcon_url(String icon_url) {
                    this.icon_url = icon_url;
                }

                public int getIcon_width() {
                    return icon_width;
                }

                public void setIcon_width(int icon_width) {
                    this.icon_width = icon_width;
                }

                public int getIcon_height() {
                    return icon_height;
                }

                public void setIcon_height(int icon_height) {
                    this.icon_height = icon_height;
                }
            }
        }
    }
}
