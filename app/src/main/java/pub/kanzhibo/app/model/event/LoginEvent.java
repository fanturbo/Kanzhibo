package pub.kanzhibo.app.model.event;

import com.avos.avoscloud.AVUser;
import com.hwangjr.rxbus.annotation.Produce;

/**
 * Created by turbo on 2016/10/31.
 */

public class LoginEvent {
    private AVUser user;

    public LoginEvent(AVUser user) {
        this.user = user;
    }

    public void setUser(AVUser user) {
        this.user = user;
    }

    @Produce
    public AVUser getUser() {
        return this.user;
    }
}
