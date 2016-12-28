package pub.kanzhibo.app.model.event;

import com.hwangjr.rxbus.annotation.Produce;

import pub.kanzhibo.app.model.UserInfo;

/**
 * Created by snail on 16/12/28.
 */
public class DouyuLoginEvent {
    private UserInfo user;

    public DouyuLoginEvent(UserInfo user) {
        this.user = user;
    }

    public void setUserInfo(UserInfo user) {
        this.user = user;
    }

    @Produce
    public UserInfo getUserInfo() {
        return this.user;
    }
}
