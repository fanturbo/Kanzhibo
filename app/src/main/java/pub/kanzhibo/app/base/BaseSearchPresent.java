package pub.kanzhibo.app.base;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import pub.kanzhibo.app.api.ApiClient;
import pub.kanzhibo.app.api.RxSchedulers;
import pub.kanzhibo.app.gloabal.Constants;
import pub.kanzhibo.app.model.liveuser.LiveUser;
import pub.kanzhibo.app.model.liveuser.UserHuyaLive;
import pub.kanzhibo.app.model.liveuser.UserHuyaPlay;
import pub.kanzhibo.app.search.SearchView;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;

/**
 * Created by snail on 16/10/30.
 */
public abstract class BaseSearchPresent extends BaseRxLcePresenter<SearchView, List<LiveUser>> {

    //todo 关于设计模式----presenter

    protected Subscription subscription;

    public abstract void searchUser(final boolean pullToRefresh, String searchKey, int page);

    protected void preRequest(boolean pullToRefresh) {
        getView().showLoading(pullToRefresh);
        if (subscription != null && subscription.isUnsubscribed())
            subscription.unsubscribe();
    }
    public Subscriber<List<LiveUser>> getSubscriber() {
        return subscriber = new Subscriber<List<LiveUser>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                getView().showError(e, false);
            }

            @Override
            public void onNext(List<LiveUser> liveUsers) {
                if (isViewAttached()) {
                    if(liveUsers.size()==0){
                        getView().showError(null,false);
                    }else {
                        getView().setData(liveUsers);
                        getView().showContent();
                        getView().stopRefresh();
                    }
                }
            }
        };
    }
}
