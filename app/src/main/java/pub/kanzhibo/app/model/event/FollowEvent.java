package pub.kanzhibo.app.model.event;

import com.hwangjr.rxbus.annotation.Produce;

import pub.kanzhibo.app.model.searchliveuser.LiveUser;

/**
 * Created by turbo on 2016/10/31.
 */

public class FollowEvent {
    private boolean follow;
    private LiveUser liveUser;

    public FollowEvent(boolean follow,LiveUser liveUser) {
        this.follow = follow;
        this.liveUser = liveUser;
    }

    public void setfollow(boolean follow) {
        this.follow = follow;
    }

    @Produce
    public boolean getfollow() {
        return this.follow;
    }

    public LiveUser getLiveUser() {
        return liveUser;
    }

    public void setLiveUser(LiveUser liveUser) {
        this.liveUser = liveUser;
    }
}
