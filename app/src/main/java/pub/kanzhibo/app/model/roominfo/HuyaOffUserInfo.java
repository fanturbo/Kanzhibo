package pub.kanzhibo.app.model.roominfo;

/**
 * Created by turbo on 2016/11/9.
 * 虎牙不在直播的用户信息
 */

public class HuyaOffUserInfo {

    /**
     * uid : 500066171
     * badgeName :
     * name : 董导 董小飒
     * type : 2
     * avatar : http://img.live.yy.com/avatar/1082/64/b3bb6f0caa54e70a0391bceab9e093_180_135.jpg?
     * fans : 366510
     * praiseCount : 0
     * praiseRank : -1
     * privs : 2
     * isFollowed : 0
     * muted : 0
     */

    private DataEntity data;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        private int uid;
        private String badgeName;
        private String name;
        private int type;
        private String avatar;
        private int fans;
        private int praiseCount;
        private int praiseRank;
        private int privs;
        private int isFollowed;
        private int muted;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getBadgeName() {
            return badgeName;
        }

        public void setBadgeName(String badgeName) {
            this.badgeName = badgeName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getFans() {
            return fans;
        }

        public void setFans(int fans) {
            this.fans = fans;
        }

        public int getPraiseCount() {
            return praiseCount;
        }

        public void setPraiseCount(int praiseCount) {
            this.praiseCount = praiseCount;
        }

        public int getPraiseRank() {
            return praiseRank;
        }

        public void setPraiseRank(int praiseRank) {
            this.praiseRank = praiseRank;
        }

        public int getPrivs() {
            return privs;
        }

        public void setPrivs(int privs) {
            this.privs = privs;
        }

        public int getIsFollowed() {
            return isFollowed;
        }

        public void setIsFollowed(int isFollowed) {
            this.isFollowed = isFollowed;
        }

        public int getMuted() {
            return muted;
        }

        public void setMuted(int muted) {
            this.muted = muted;
        }
    }
}
