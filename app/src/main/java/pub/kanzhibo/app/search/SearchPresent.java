package pub.kanzhibo.app.search;

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
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by snail on 16/10/30.
 */
public class SearchPresent extends BaseRxLcePresenter<SearchView, List<LiveUser>> {

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
    ;

    void searchUser(final boolean pullToRefresh, String searchKey, int page) {
        getView().showLoading(pullToRefresh);
        //todo 3s后再执行请求操作
        ApiClient.getInstance().getHuyaData(Constants.HUYA_BASE_URL).searchHuya(searchKey, page)
                .map(new Func1<ResponseBody, List<LiveUser>>() {
                    @Override
                    public List<LiveUser> call(ResponseBody responseBody) {
                        List<LiveUser> result = null;
                        String responseJsonStr = null;
                        try {
                            responseJsonStr = new String(responseBody.bytes());
                            JSONObject latestNewsJSON = new JSONObject(responseJsonStr);
                            JSONArray responsePlay = latestNewsJSON.getJSONObject("response").getJSONObject("1").getJSONArray("docs");
                            JSONArray responseLive = latestNewsJSON.getJSONObject("response").getJSONObject("3").getJSONArray("docs");
                            if (responsePlay.length() != 0) {
                                Gson gson = new Gson();
                                UserHuyaPlay[] liveUserHuyas = gson.fromJson(responsePlay.toString(), UserHuyaPlay[].class);
                                result = new ArrayList<LiveUser>();
                                for (int i = 0; i < liveUserHuyas.length; i++) {
                                    LiveUser liveUser = new LiveUser();
                                    liveUser.setUserName(liveUserHuyas[i].getGame_nick());
                                    //todo 应该查询本地数据库
                                    liveUser.setHasFocus(false);
                                    liveUser.setRoomTitle("查询不到相关信息");
                                    liveUser.setUserIconUrl(liveUserHuyas[i].getGame_avatarUrl52());
                                    liveUser.setViewersCount("关注人数" + liveUserHuyas[i].getGame_activityCount());
                                    liveUser.setStatus(liveUserHuyas[i].isGameLiveOn() ? "在直播" : "未开播");
                                    result.add(liveUser);
                                }
                            } else if (responsePlay.length() == 0 && responseLive.length() != 0) {
                                Gson gson = new Gson();
                                UserHuyaLive[] liveUserHuyas = gson.fromJson(responseLive.toString(), UserHuyaLive[].class);
                                result = new ArrayList<LiveUser>();
                                for (int i = 0; i < liveUserHuyas.length; i++) {
                                    LiveUser liveUser = new LiveUser();
                                    liveUser.setUserName(liveUserHuyas[i].getGame_nick());
                                    //todo 应该查询本地数据库
                                    liveUser.setHasFocus(false);
                                    liveUser.setRoomTitle(liveUserHuyas[i].getGame_introduction());
                                    liveUser.setUserIconUrl(liveUserHuyas[i].getGame_imgUrl());
                                    liveUser.setViewersCount("观看人数" + liveUserHuyas[i].getGame_total_count());
                                    liveUser.setStatus("1");
                                    result.add(liveUser);
                                }
                            } else {
                                //未找到直播
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        return result;
                    }
                })
                .compose(RxSchedulers.<List<LiveUser>>applySchedulers())
                .subscribe(subscriber);
    }
}
