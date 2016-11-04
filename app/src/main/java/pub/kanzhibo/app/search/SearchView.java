package pub.kanzhibo.app.search;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import java.util.List;

import pub.kanzhibo.app.model.searchliveuser.LiveUser;

/**
 * Created by snail on 16/10/30.
 */
public interface SearchView extends MvpLceView<List<LiveUser>> {
    void stopRefresh();
}
