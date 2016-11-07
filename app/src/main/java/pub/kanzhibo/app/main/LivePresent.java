package pub.kanzhibo.app.main;

import android.util.Log;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVRelation;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.SaveCallback;
import com.sdsmdg.tastytoast.TastyToast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import pub.kanzhibo.app.App;
import pub.kanzhibo.app.api.ApiClient;
import pub.kanzhibo.app.api.RxSchedulers;
import pub.kanzhibo.app.base.BaseRxLcePresenter;
import pub.kanzhibo.app.common.EmptyException;
import pub.kanzhibo.app.gloabal.Constants;
import pub.kanzhibo.app.model.DouyuBigData;
import pub.kanzhibo.app.model.PlatForm;
import pub.kanzhibo.app.model.roominfo.DouYuUserInfo;
import pub.kanzhibo.app.model.roominfo.PandaUserInfo;
import pub.kanzhibo.app.model.roominfo.ZhanqiUserInfo;
import pub.kanzhibo.app.model.searchliveuser.LiveUser;
import pub.kanzhibo.app.model.searchliveuser.LiveUserPanda;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.subjects.Subject;

/**
 * Created by snail on 16/10/30.
 */
public class LivePresent extends BaseRxLcePresenter<LiveView, List<LiveUser>> {

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

    public void getFollow(boolean pullToRefresh, int page) {
        //查询关注的主播
        //根据uid和platform查出关注的主播的信息
        //合并查询到的所有的主播信息列表
        //工程量有点大 ----toList方法害死人,参考http://blog.csdn.net/lzyzsd/article/details/44094895
        //最关键的是from是将list挨个emit出来,如何才能将这些item再组装回去呢?toList!!
        //网络请求嵌套 这儿用到了leanCloud的sdk,所以麻烦了点.
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
                        Observable.from(list)
                                .flatMap(new Func1<AVObject, Observable<LiveUser>>() {
                                    @Override
                                    public Observable<LiveUser> call(AVObject avObject) {
                                        String uid = (String) avObject.get("uid");
                                        int platForm = avObject.getInt("platform");
                                        switch (platForm) {
                                            case 1:
                                                return ApiClient.getInstance()
                                                        .getLiveApi(Constants.DOUYU_BASE_URL)
                                                        .getDouyuRoomInfo(uid)
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
                                                        });
                                            case 2:
//                                                return ApiClient.getInstance()
//                                                        .getLiveApi(Constants.HUYA_BASE_URL);
                                                break;
                                            case 3:
                                                return ApiClient.getInstance()
                                                        .getLiveApi(Constants.ZHANQI_BASE_URL)
                                                        .getZhanqiRoomInfo(uid + ".json")
                                                        .map(new Func1<ZhanqiUserInfo, LiveUser>() {
                                                            @Override
                                                            public LiveUser call(ZhanqiUserInfo zhanqiUserInfo) {
                                                                ZhanqiUserInfo.DataBean entity = zhanqiUserInfo.getData();
                                                                LiveUser liveUser = new LiveUser();
                                                                liveUser.setUserName(entity.getNickname());
                                                                liveUser.setUid(entity.getId());
                                                                liveUser.setPlatform(PlatForm.ZHANQI);
                                                                liveUser.setHasFocus(false);
                                                                liveUser.setRoomTitle(entity.getTitle());
                                                                liveUser.setUserIconUrl(entity.getAvatar());
                                                                liveUser.setViewersCount("关注人数:" + entity.getFollows());
                                                                liveUser.setStatus("4".equals(entity.getStatus()) ? "在直播" : "未开播");
                                                                return liveUser;
                                                            }
                                                        }).doOnError(new Action1<Throwable>() {
                                                            @Override
                                                            public void call(Throwable throwable) {
                                                                throwable.printStackTrace();
                                                            }
                                                        });
                                            case 4:
                                                return ApiClient.getInstance()
                                                        .getLiveApi(Constants.PANDA_BASE_URL)
                                                        .getPandaRoomInfo(uid)
                                                        .map(new Func1<PandaUserInfo, LiveUser>() {
                                                            @Override
                                                            public LiveUser call(PandaUserInfo pandaUserInfo) {
                                                                PandaUserInfo.DataBean.InfoBean.RoominfoBean entity = pandaUserInfo.getData().getInfo().getRoominfo();
                                                                LiveUser liveUser = new LiveUser();
                                                                liveUser.setUserName(pandaUserInfo.getData().getInfo().getHostinfo().getName());
                                                                liveUser.setUid(entity.getId());
                                                                liveUser.setPlatform(PlatForm.PANDA);
                                                                liveUser.setHasFocus(false);
                                                                liveUser.setRoomTitle(entity.getName());
                                                                liveUser.setUserIconUrl(pandaUserInfo.getData().getInfo().getHostinfo().getAvatar());
                                                                liveUser.setViewersCount("观看人数:" + entity.getPerson_num());
                                                                liveUser.setStatus("1".equals("2") ? "在直播" : "未开播");
                                                                return liveUser;
                                                            }
                                                        });
                                            case 5:
                                                return ApiClient.getInstance()
                                                        .getLiveApi(Constants.QUANMIN_BASE_URL)
                                                        .getQuanminRoomInfo(uid)
                                                        .map(new Func1<ResponseBody, LiveUser>() {
                                                            @Override
                                                            public LiveUser call(ResponseBody responseBody) {
                                                                String responseJsonStr = null;
                                                                LiveUser liveUser = new LiveUser();
                                                                try {
                                                                    responseJsonStr = new String(responseBody.bytes());
                                                                    JSONObject jsonObject = new JSONObject(responseJsonStr);
                                                                    liveUser.setUserName(jsonObject.getString("nick"));
                                                                    liveUser.setUid(jsonObject.getString("uid"));
                                                                    liveUser.setPlatform(PlatForm.QUANMIN);
                                                                    liveUser.setHasFocus(true);
                                                                    liveUser.setRoomTitle(jsonObject.getString("title"));
                                                                    liveUser.setUserIconUrl(jsonObject.getString("avatar"));
                                                                    liveUser.setViewersCount("关注人数:" + jsonObject.getString("follow"));
                                                                    liveUser.setStatus(jsonObject.getBoolean("play_status") ? "在直播" : "未开播");
                                                                } catch (IOException e1) {
                                                                    e1.printStackTrace();
                                                                } catch (JSONException e1) {
                                                                    e1.printStackTrace();
                                                                }

                                                                return liveUser;
                                                            }
                                                        }).doOnError(new Action1<Throwable>() {
                                                            @Override
                                                            public void call(Throwable throwable) {
                                                                throwable.printStackTrace();
                                                            }
                                                        });
                                        }
                                        return null;
                                    }
                                })
                                .toList()
                                .compose(RxSchedulers.<List<LiveUser>>applySchedulers())
                                .subscribe(getSubscriber());
                    }
                }
            });
        } else {
            //todo 未登录状态下展示热门的主播列表
            ApiClient.getInstance()
                    .getLiveApi(Constants.DOUYU_BASE_URL)
                    .getBigData()
                    .map(new Func1<DouyuBigData, List<LiveUser>>() {
                        @Override
                        public List<LiveUser> call(DouyuBigData zhanqiUserInfo) {
                            List<DouyuBigData.DataEntity> entityList = zhanqiUserInfo.getData();
                            List<LiveUser> liveUsers = new ArrayList<>();
                            for (DouyuBigData.DataEntity entity : entityList) {
                                LiveUser liveUser = new LiveUser();
                                liveUser.setUserName(entity.getNickname());
                                liveUser.setUid(entity.getOwner_uid());
                                liveUser.setPlatform(PlatForm.DOUYU);
                                liveUser.setHasFocus(false);
                                liveUser.setRoomTitle(entity.getRoom_name());
                                liveUser.setUserIconUrl(entity.getAvatar_small());
                                liveUser.setViewersCount("关注人数:" + entity.getOnline());
                                liveUser.setStatus("在直播");
                                liveUsers.add(liveUser);
                            }
                            return liveUsers;
                        }
                    })
                    .compose(RxSchedulers.<List<LiveUser>>applySchedulers())
                    .subscribe(getSubscriber());
        }

    }

    public Subscriber<List<LiveUser>> getSubscriber() {
        return new Subscriber<List<LiveUser>>() {
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
