package pub.kanzhibo.app.base;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVRelation;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SaveCallback;
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
    //todo BaseRxLcePresenter使用这个的理由？

    protected Subscription subscription;

    public abstract void searchUser(final boolean pullToRefresh, String searchKey, int page);

    public void followLive(final boolean follow, LiveUser liveUser) {
        //根据follow添加或者删除关注的主播
        final AVObject followUser = new AVObject("LiveUser");
        followUser.put("uid", liveUser.getUid());
        followUser.put("platform", liveUser.getPlatform().getPlatform());
        followUser.saveInBackground(new SaveCallback() {
            @Override
            public void done(AVException e) {
                AVRelation<AVObject> relation = AVUser.getCurrentUser().getRelation("followLiveUser");// 新建一个 AVRelation
                relation.add(followUser);
                AVUser.getCurrentUser().saveInBackground();
            }
        });
    }


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
                    if (liveUsers.size() == 0) {
                        getView().showError(null, false);
                    } else {
                        getView().setData(liveUsers);
                        getView().showContent();
                        getView().stopRefresh();
                    }
                }
            }
        };
    }
}
