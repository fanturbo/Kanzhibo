package pub.kanzhibo.app.model.searchliveuser;

import pub.kanzhibo.app.model.PlatForm;

/**
 * Created by turbo on 2016/10/28.
 */
public class LiveUser {
    //平台
    PlatForm platform;
    //uid
    String uid;
    //主播用户名
    String userName;
    //直播间名称
    String roomTitle;
    //直播状态 根据各个平台的返回转成两种状态:在直播,未开播
    String status;
    //观众人数
    String viewersCount;
    //是否关注
    boolean hasFocus;
    //用户头像
    String userIconUrl;
    //房间背景图片
    String roomBackgroudUrl;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getViewersCount() {
        return viewersCount;
    }

    public void setViewersCount(String viewersCount) {
        this.viewersCount = viewersCount;
    }

    public boolean isHasFocus() {
        return hasFocus;
    }

    public void setHasFocus(boolean hasFocus) {
        this.hasFocus = hasFocus;
    }

    public String getUserIconUrl() {
        return userIconUrl;
    }

    public void setUserIconUrl(String userIconUrl) {
        this.userIconUrl = userIconUrl;
    }

    public String getRoomBackgroudUrl() {
        return roomBackgroudUrl;
    }

    public void setRoomBackgroudUrl(String roomBackgroudUrl) {
        this.roomBackgroudUrl = roomBackgroudUrl;
    }

    public PlatForm getPlatform() {
        return platform;
    }

    public void setPlatform(PlatForm platform) {
        this.platform = platform;
    }
}
