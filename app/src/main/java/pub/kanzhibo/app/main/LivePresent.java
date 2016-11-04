package pub.kanzhibo.app.main;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVRelation;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.SaveCallback;

import java.util.ArrayList;
import java.util.List;

import pub.kanzhibo.app.App;
import pub.kanzhibo.app.api.ApiClient;
import pub.kanzhibo.app.api.RxSchedulers;
import pub.kanzhibo.app.base.BaseRxLcePresenter;
import pub.kanzhibo.app.common.EmptyException;
import pub.kanzhibo.app.gloabal.Constants;
import pub.kanzhibo.app.model.PlatForm;
import pub.kanzhibo.app.model.roominfo.DouYuUserInfo;
import pub.kanzhibo.app.model.searchliveuser.LiveUser;
import pub.kanzhibo.app.model.searchliveuser.LiveUserPanda;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

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
            if (e instanceof NullPointerException) {
                getView().showError(new EmptyException(), false);
            } else {
                getView().showError(e, false);
            }
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
        //todo 网络请求嵌套
        getView().showLoading(pullToRefresh);
        if (App.isLogIn()) {
            AVObject todoFolder = AVObject.createWithoutData("_User", AVUser.getCurrentUser().getObjectId());
            AVRelation<AVObject> relation = todoFolder.getRelation("followLiveUser");
            AVQuery<AVObject> query = relation.getQuery();
            query.findInBackground(new FindCallback<AVObject>() {
                @Override
                public void done(List<AVObject> list, AVException e) {
                    if (isViewAttached()) {
                        //参考：http://blog.csdn.net/lzyzsd/article/details/44094895
                        Observable.just(list)
                                .flatMap(new Func1<List<AVObject>, Observable<List<LiveUser>>>() {
                                    @Override
                                    public Observable<List<LiveUser>> call(List<AVObject> avObjects) {
                                        final List<LiveUser> liveUsers = new ArrayList<LiveUser>();
                                        for (AVObject avObject : avObjects) {
                                            String uid = (String) avObject.get("uid");
                                            int platForm = avObject.getInt("platform");
                                            switch (platForm) {
                                                case 1:
                                                    ApiClient.getInstance().getLiveApi(Constants.DOUYU_BASE_URL).getDouyuRoomInfo(uid)
                                                            .map(new Func1<DouYuUserInfo, LiveUser>() {
                                                                @Override
                                                                public LiveUser call(DouYuUserInfo douyuUserInfo) {
                                                                    DouYuUserInfo.DataEntity entity = douyuUserInfo.getData();
                                                                    LiveUser liveUser = new LiveUser();
                                                                    liveUser.setUserName(entity.getOwner_name());
                                                                    liveUser.setUid(entity.getRoom_id());
                                                                    liveUser.setPlatform(PlatForm.DOUYU);
                                                                    liveUser.setHasFocus(false);
                                                                    liveUser.setRoomTitle(entity.getRoom_name());
                                                                    liveUser.setUserIconUrl(entity.getAvatar());
                                                                    liveUser.setViewersCount("关注人数:" + entity.getFans_num());
                                                                    liveUser.setStatus("1".equals(entity.getRoom_status()) ? "在直播" : "未开播");
                                                                    return liveUser;
                                                                }
                                                            })
                                                            .compose(RxSchedulers.<LiveUser>applySchedulers())
                                                            .subscribe(new Action1<LiveUser>() {
                                                                @Override
                                                                public void call(LiveUser liveUser) {
                                                                    liveUsers.add(liveUser);
                                                                }
                                                            });
                                                    break;
                                                case 2:
                                                    break;
                                                case 3:
                                                    break;
                                                case 4:
                                                    break;
                                                case 5:
                                                    break;
                                            }
                                        }
                                        return liveUsers;
                                    }
                                }).subscribe(subscriber);
                        //根据uid和platform查出关注的主播的信息
                        //合并查询到的所有的主播信息列表
                        //工程量有点大
                    }
                }
            });
        } else {
            //展示热门的主播列表
        }
    }
}
