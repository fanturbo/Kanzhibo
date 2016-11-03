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
import pub.kanzhibo.app.model.liveuser.LiveUserPanda;
import pub.kanzhibo.app.model.liveuser.UserHuyaLive;
import pub.kanzhibo.app.model.liveuser.UserHuyaPlay;
import rx.functions.Func1;

/**
 * Created by snail on 16/10/30.
 */
public class PandaSearchPresent extends BaseSearchPresent {

    @Override
    public void searchUser(final boolean pullToRefresh, String searchKey, int page) {
        //熊猫tv的接口有点特殊--app接口特殊，已经转换为pc端接口
        //todo 现在展示的图片是直播截图，并不是用户头像，整合两个请求到一起getPandaRoomInfo
        preRequest(pullToRefresh);
        subscription = ApiClient.getInstance().getLiveApi(Constants.PANDA_BASE_URL)
                .searchPanda(searchKey, page)
                .map(new Func1<LiveUserPanda, List<LiveUser>>() {
                    @Override
                    public List<LiveUser> call(LiveUserPanda liveUserPanda) {
                        List<LiveUser> result = new ArrayList<LiveUser>();
                        if (liveUserPanda.getErrno() == 0 && Integer.parseInt(liveUserPanda.getData().getTotal()) > 0) {
                            List<LiveUserPanda.DataEntity.ItemsEntity> items = liveUserPanda.getData().getItems();
                            for (LiveUserPanda.DataEntity.ItemsEntity entity : items) {
                                LiveUser liveUser = new LiveUser();
                                liveUser.setUid(entity.getRoomid());
                                liveUser.setPlatform(PlatForm.PANDA);
                                liveUser.setUserName(entity.getNickname());
                                //todo 应该查询本地数据库
                                liveUser.setHasFocus(false);
                                liveUser.setRoomTitle(entity.getName());
                                liveUser.setUserIconUrl(entity.getPictures().getImg());
                                liveUser.setViewersCount("关注人数:" + entity.getFans());
                                liveUser.setStatus("2".equals(entity.getStatus()) ? "在直播" : "未开播");
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
