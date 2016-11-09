package pub.kanzhibo.app.model.roominfo;

/**
 * Created by turbo on 2016/11/9.
 * 虎牙在直播的用户信息
 */

public class HuyaUserInfo {

    /**
     * code : 0
     * message :
     * info : {"liveUid":1565011133,"yyid":1764334085,"sex":0,"gameId":393,"gameName":"炉石传说","limit":999999,"aid":27846870,"users":2189,"livePortait":"http://img.huya.com/avatar/1020/e7/fbfe41a034162e679261a3202158c2_180_135.jpg","startTime":1478644300,"liveNick":"炉石丶子非鱼","recommendStatus":0,"liveName":" ┊「ＸＸ冠名」 子非鱼 ¨已经是条咸鱼了         ┊46","subSid":2561162027,"contentIntro":"","scoreIntro":0,"cameraOpen":false,"sid":19001648,"snapshot":"http://screenshot.dwstatic.com/yysnapshot/9dedd4d7f4af1a47b9d176f89b48e788d4f7ca9b?size=240","isPlatinum":1,"live_source_type":0}
     */

    private int code;
    private String message;
    /**
     * liveUid : 1565011133
     * yyid : 1764334085
     * sex : 0
     * gameId : 393
     * gameName : 炉石传说
     * limit : 999999
     * aid : 27846870
     * users : 2189
     * livePortait : http://img.huya.com/avatar/1020/e7/fbfe41a034162e679261a3202158c2_180_135.jpg
     * startTime : 1478644300
     * liveNick : 炉石丶子非鱼
     * recommendStatus : 0
     * liveName :  ┊「ＸＸ冠名」 子非鱼 ¨已经是条咸鱼了         ┊46
     * subSid : 2561162027
     * contentIntro :
     * scoreIntro : 0
     * cameraOpen : false
     * sid : 19001648
     * snapshot : http://screenshot.dwstatic.com/yysnapshot/9dedd4d7f4af1a47b9d176f89b48e788d4f7ca9b?size=240
     * isPlatinum : 1
     * live_source_type : 0
     */

    private InfoEntity info;

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

    public InfoEntity getInfo() {
        return info;
    }

    public void setInfo(InfoEntity info) {
        this.info = info;
    }

    public static class InfoEntity {
        private int liveUid;
        private int yyid;
        private int sex;
        private int gameId;
        private String gameName;
        private int limit;
        private int aid;
        private int users;
        private String livePortait;
        private int startTime;
        private String liveNick;
        private int recommendStatus;
        private String liveName;
        private long subSid;
        private String contentIntro;
        private int scoreIntro;
        private boolean cameraOpen;
        private int sid;
        private String snapshot;
        private int isPlatinum;
        private int live_source_type;

        public int getLiveUid() {
            return liveUid;
        }

        public void setLiveUid(int liveUid) {
            this.liveUid = liveUid;
        }

        public int getYyid() {
            return yyid;
        }

        public void setYyid(int yyid) {
            this.yyid = yyid;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getGameId() {
            return gameId;
        }

        public void setGameId(int gameId) {
            this.gameId = gameId;
        }

        public String getGameName() {
            return gameName;
        }

        public void setGameName(String gameName) {
            this.gameName = gameName;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public int getAid() {
            return aid;
        }

        public void setAid(int aid) {
            this.aid = aid;
        }

        public int getUsers() {
            return users;
        }

        public void setUsers(int users) {
            this.users = users;
        }

        public String getLivePortait() {
            return livePortait;
        }

        public void setLivePortait(String livePortait) {
            this.livePortait = livePortait;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public String getLiveNick() {
            return liveNick;
        }

        public void setLiveNick(String liveNick) {
            this.liveNick = liveNick;
        }

        public int getRecommendStatus() {
            return recommendStatus;
        }

        public void setRecommendStatus(int recommendStatus) {
            this.recommendStatus = recommendStatus;
        }

        public String getLiveName() {
            return liveName;
        }

        public void setLiveName(String liveName) {
            this.liveName = liveName;
        }

        public long getSubSid() {
            return subSid;
        }

        public void setSubSid(long subSid) {
            this.subSid = subSid;
        }

        public String getContentIntro() {
            return contentIntro;
        }

        public void setContentIntro(String contentIntro) {
            this.contentIntro = contentIntro;
        }

        public int getScoreIntro() {
            return scoreIntro;
        }

        public void setScoreIntro(int scoreIntro) {
            this.scoreIntro = scoreIntro;
        }

        public boolean isCameraOpen() {
            return cameraOpen;
        }

        public void setCameraOpen(boolean cameraOpen) {
            this.cameraOpen = cameraOpen;
        }

        public int getSid() {
            return sid;
        }

        public void setSid(int sid) {
            this.sid = sid;
        }

        public String getSnapshot() {
            return snapshot;
        }

        public void setSnapshot(String snapshot) {
            this.snapshot = snapshot;
        }

        public int getIsPlatinum() {
            return isPlatinum;
        }

        public void setIsPlatinum(int isPlatinum) {
            this.isPlatinum = isPlatinum;
        }

        public int getLive_source_type() {
            return live_source_type;
        }

        public void setLive_source_type(int live_source_type) {
            this.live_source_type = live_source_type;
        }
    }
}
