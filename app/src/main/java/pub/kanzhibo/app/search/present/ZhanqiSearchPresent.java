package pub.kanzhibo.app.search.present;

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
import pub.kanzhibo.app.base.BaseSearchPresent;
import pub.kanzhibo.app.gloabal.Constants;
import pub.kanzhibo.app.model.PlatForm;
import pub.kanzhibo.app.model.liveuser.LiveUser;
import pub.kanzhibo.app.model.liveuser.LiveUserDouYu;
import pub.kanzhibo.app.model.liveuser.LiveUserZhanqi;
import pub.kanzhibo.app.model.liveuser.UserHuyaLive;
import pub.kanzhibo.app.model.liveuser.UserHuyaPlay;
import rx.functions.Func1;

/**
 * Created by snail on 16/10/30.
 */
public class ZhanqiSearchPresent extends BaseSearchPresent {

    @Override
    public void searchUser(final boolean pullToRefresh, String searchKey, int page) {
        preRequest(pullToRefresh);
        subscription = ApiClient.getInstance().getLiveApi(Constants.ZHANQI_BASE_URL)
                .searchZhanqi(searchKey, page + 1)
                .map(new Func1<LiveUserZhanqi, List<LiveUser>>() {
                    @Override
                    public List<LiveUser> call(LiveUserZhanqi liveUserZhanqi) {
                        List<LiveUser> result = new ArrayList<LiveUser>();
                        if (liveUserZhanqi.getCode() == 0 && liveUserZhanqi.getData() != null && liveUserZhanqi.getData().size() > 0) {
                            for (LiveUserZhanqi.DataEntity entity : liveUserZhanqi.getData()) {
                                LiveUser liveUser = new LiveUser();
                                liveUser.setUid(entity.getId());
                                liveUser.setPlatform(PlatForm.ZHANQI);
                                liveUser.setUserName(entity.getNickname());
                                //todo 应该查询本地数据库
                                liveUser.setHasFocus(false);
                                liveUser.setRoomTitle(entity.getTitle());
                                liveUser.setUserIconUrl(entity.getAvatar());
                                liveUser.setViewersCount("关注人数:" + entity.getDocTag().getFollows());
                                liveUser.setStatus("0".equals(entity.getStatus()) ? "在直播" : "未开播");
                                result.add(liveUser);
                            }
                        }
                        return result;
                    }
                })
                .compose(RxSchedulers.<List<LiveUser>>applySchedulers())
                .subscribe(getSubscriber());
    }
}
