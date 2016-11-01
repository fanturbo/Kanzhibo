package pub.kanzhibo.app.model.liveuser;

import java.util.List;

/**
 * Created by turbo on 2016/10/28.
 */

public class LiveUserZhanqi {

    /**
     * code : 0
     * message :
     * cnt : 236
     * data : [{"id":"room-729","title":"天王<em>SKY<\/em>直播中","nickname":"WE.<em>Sky<\/em>","code":"327","domain":"sky","type":"ROOMS","avatar":"http://pic.cdn.zhanqi.tv/avatar/00/000/0_0000000000.jpg","spic":"http://dlpic.cdn.zhanqi.tv/live/20150731/729_BaLAd_2015-07-31-08-26-12.jpg","status":"0","url":"/sky","gameName":"英雄联盟","gameUrl":"/games/lol","docTag":{"online":"0","follows":46840,"gender":"2"},"verscr":0,"gameId":"6","uid":549638,"videos":{"cnt":0,"videos":[]}}]
     */

    private int code;
    private String message;
    private int cnt;
    /**
     * id : room-729
     * title : 天王<em>SKY</em>直播中
     * nickname : WE.<em>Sky</em>
     * code : 327
     * domain : sky
     * type : ROOMS
     * avatar : http://pic.cdn.zhanqi.tv/avatar/00/000/0_0000000000.jpg
     * spic : http://dlpic.cdn.zhanqi.tv/live/20150731/729_BaLAd_2015-07-31-08-26-12.jpg
     * status : 0
     * url : /sky
     * gameName : 英雄联盟
     * gameUrl : /games/lol
     * docTag : {"online":"0","follows":46840,"gender":"2"}
     * verscr : 0
     * gameId : 6
     * uid : 549638
     * videos : {"cnt":0,"videos":[]}
     */

    private List<DataEntity> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity {
        private String id;
        private String title;
        private String nickname;
        private String code;
        private String domain;
        private String type;
        private String avatar;
        private String spic;
        private String status;//在线状态 1在线 0不在线
        private String url;
        private String gameName;
        private String gameUrl;
        /**
         * online : 0
         * follows : 46840
         * gender : 2
         */

        private DocTagEntity docTag;
        private int verscr;
        private String gameId;
        private int uid;
        /**
         * cnt : 0
         * videos : []
         */

        private VideosEntity videos;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getSpic() {
            return spic;
        }

        public void setSpic(String spic) {
            this.spic = spic;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getGameName() {
            return gameName;
        }

        public void setGameName(String gameName) {
            this.gameName = gameName;
        }

        public String getGameUrl() {
            return gameUrl;
        }

        public void setGameUrl(String gameUrl) {
            this.gameUrl = gameUrl;
        }

        public DocTagEntity getDocTag() {
            return docTag;
        }

        public void setDocTag(DocTagEntity docTag) {
            this.docTag = docTag;
        }

        public int getVerscr() {
            return verscr;
        }

        public void setVerscr(int verscr) {
            this.verscr = verscr;
        }

        public String getGameId() {
            return gameId;
        }

        public void setGameId(String gameId) {
            this.gameId = gameId;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public VideosEntity getVideos() {
            return videos;
        }

        public void setVideos(VideosEntity videos) {
            this.videos = videos;
        }

        public static class DocTagEntity {
            private String online;
            private int follows;
            private String gender;

            public String getOnline() {
                return online;
            }

            public void setOnline(String online) {
                this.online = online;
            }

            public int getFollows() {
                return follows;
            }

            public void setFollows(int follows) {
                this.follows = follows;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }
        }

        public static class VideosEntity {
            private int cnt;
            private List<?> videos;

            public int getCnt() {
                return cnt;
            }

            public void setCnt(int cnt) {
                this.cnt = cnt;
            }

            public List<?> getVideos() {
                return videos;
            }

            public void setVideos(List<?> videos) {
                this.videos = videos;
            }
        }
    }
}
