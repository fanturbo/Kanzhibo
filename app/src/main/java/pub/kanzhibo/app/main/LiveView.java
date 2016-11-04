package pub.kanzhibo.app.main;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import java.util.List;

import pub.kanzhibo.app.model.searchliveuser.LiveUser;

/**
 * Created by snail on 16/10/30.
 */
public interface LiveView extends MvpLceView<List<LiveUser>> {
    void stopRefresh();
}
