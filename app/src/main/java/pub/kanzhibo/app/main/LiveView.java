package pub.kanzhibo.app.main;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import java.util.List;

import pub.kanzhibo.app.model.liveuser.LiveUser;

/**
 * Created by snail on 16/10/30.
 */
public class LiveView implements MvpLceView<List<LiveUser>> {
    @Override
    public void showLoading(boolean pullToRefresh) {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {

    }

    @Override
    public void setData(List<LiveUser> data) {

    }

    @Override
    public void loadData(boolean pullToRefresh) {

    }
}
