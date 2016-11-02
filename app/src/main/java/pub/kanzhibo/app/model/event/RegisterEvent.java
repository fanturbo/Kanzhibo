package pub.kanzhibo.app.model.event;

import com.hwangjr.rxbus.annotation.Produce;

/**
 * Created by turbo on 2016/11/2.
 */

public class RegisterEvent {
    private boolean regsiterStatus;

    public RegisterEvent(boolean regsiterStatus) {
        this.regsiterStatus = regsiterStatus;
    }

    @Produce
    public boolean getRegsiterStatus() {
        return regsiterStatus;
    }

    public void setRegsiterStatus(boolean regsiterStatus) {
        this.regsiterStatus = regsiterStatus;
    }
}
