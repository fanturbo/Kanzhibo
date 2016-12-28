package pub.kanzhibo.app.douyu;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import java.util.List;

import pub.kanzhibo.app.model.FollowLive;
import pub.kanzhibo.app.model.event.DouyuFollowLiveData;

/**
 * Created by turbo on 2016/12/26.
 */

public interface FollowView extends MvpLceView<List<DouyuFollowLiveData>> {
    void stopRefresh();
}
