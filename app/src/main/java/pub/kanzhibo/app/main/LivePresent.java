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

import java.util.List;

import pub.kanzhibo.app.App;
import pub.kanzhibo.app.api.ApiClient;
import pub.kanzhibo.app.base.BaseRxLcePresenter;
import pub.kanzhibo.app.common.EmptyException;
import pub.kanzhibo.app.model.liveuser.LiveUser;
import rx.Observable;
import rx.Subscriber;

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
        getView().showLoading(pullToRefresh);
        if (App.isLogIn()) {
            AVObject todoFolder = AVObject.createWithoutData("_User", AVUser.getCurrentUser().getObjectId());
            AVRelation<AVObject> relation = todoFolder.getRelation("followLiveUser");
            AVQuery<AVObject> query = relation.getQuery();
            query.findInBackground(new FindCallback<AVObject>() {
                @Override
                public void done(List<AVObject> list, AVException e) {
                    if (isViewAttached()) {
                        if (list == null || list.size() == 0) {
                            getView().showError(new EmptyException(), false);
                        }
                        //根据uid和platform查出关注的主播的信息
//                        ApiClient.getInstance().getLiveApi()
//                        getView().setData(list);
                        getView().showContent();
                        getView().stopRefresh();
                    }
                }
            });
        } else {
            //展示热门的主播列表
        }
    }
}
