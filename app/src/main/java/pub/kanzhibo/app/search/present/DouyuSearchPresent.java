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
import pub.kanzhibo.app.model.liveuser.LiveUserPanda;
import pub.kanzhibo.app.model.liveuser.UserHuyaLive;
import pub.kanzhibo.app.model.liveuser.UserHuyaPlay;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by snail on 16/10/30.
 */
public class DouyuSearchPresent extends BaseSearchPresent {

    @Override
    public void searchUser(final boolean pullToRefresh, String searchKey, int page) {
        preRequest(pullToRefresh);
        //todo 关于设计模式----presenter
        subscription = ApiClient.getInstance().getLiveApi(Constants.DOUYU_BASE_URL)
                .searchDouyu(searchKey, page * 10)
                .map(new Func1<LiveUserDouYu, List<LiveUser>>() {
                    @Override
                    public List<LiveUser> call(LiveUserDouYu liveUserDouYu) {
                        List<LiveUser> result = new ArrayList<LiveUser>();
                        if (liveUserDouYu.getError() == 0 && liveUserDouYu.getData().getRoom() != null && liveUserDouYu.getData().getRoom().size() > 0) {
                            for (LiveUserDouYu.DataEntity.RoomEntity entity : liveUserDouYu.getData().getRoom()) {
                                LiveUser liveUser = new LiveUser();
                                liveUser.setUserName(entity.getNickname());
                                liveUser.setUid(entity.getRoom_id());
                                //todo 应该查询本地数据库
                                liveUser.setPlatform(PlatForm.DOUYU);
                                liveUser.setHasFocus(false);
                                liveUser.setRoomTitle(entity.getRoom_name());
                                liveUser.setUserIconUrl(entity.getAvatar());
                                liveUser.setViewersCount("关注人数:" + entity.getFans());
                                liveUser.setStatus("1".equals(entity.getShow_status()) ? "在直播" : "未开播");
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
