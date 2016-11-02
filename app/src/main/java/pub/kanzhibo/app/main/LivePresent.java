package pub.kanzhibo.app.main;

import android.content.DialogInterface;
import android.util.Log;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVRelation;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.FindCallback;
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
import pub.kanzhibo.app.base.BaseRxLcePresenter;
import pub.kanzhibo.app.gloabal.Constants;
import pub.kanzhibo.app.model.liveuser.LiveUser;
import pub.kanzhibo.app.model.liveuser.UserHuyaLive;
import pub.kanzhibo.app.model.liveuser.UserHuyaPlay;
import pub.kanzhibo.app.util.DialogHelp;
import pub.kanzhibo.app.util.SharedPreferencesUtils;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

import static pub.kanzhibo.app.gloabal.Constants.Key.SAVE_WHERE;

/**
 * Created by snail on 16/10/30.
 */
public class LivePresent extends BaseRxLcePresenter<LiveView, List<LiveUser>> {

    private Subscriber<List<LiveUser>> subscriber = new Subscriber<List<LiveUser>>() {
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
                getView().setData(liveUsers);
                getView().showContent();
                getView().stopRefresh();
            }
        }
    };

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

    public void getFollow(boolean pullToRefresh) {
        // 查询关注的主播
        AVQuery<AVObject> query = new AVQuery<>("LiveUser");
        query.whereEqualTo("priority", 0);
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                List<AVObject> priorityEqualsZeroTodos = list;// 符合 priority = 0 的 Todo 数组
            }
        });
    }
}
