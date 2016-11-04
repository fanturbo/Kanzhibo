package pub.kanzhibo.app.search.present;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.RequestBody;
import pub.kanzhibo.app.api.ApiClient;
import pub.kanzhibo.app.api.RxSchedulers;
import pub.kanzhibo.app.base.BaseSearchPresent;
import pub.kanzhibo.app.gloabal.Constants;
import pub.kanzhibo.app.model.PlatForm;
import pub.kanzhibo.app.model.searchliveuser.LiveUser;
import pub.kanzhibo.app.model.searchliveuser.LiveUserQuanmin;
import rx.functions.Func1;

/**
 * Created by snail on 16/10/30.
 */
public class QuanminSearchPresent extends BaseSearchPresent {

    @Override
    public void searchUser(final boolean pullToRefresh, String searchKey, int page) {
        preRequest(pullToRefresh);
        String jsonStr = "{\"device\":\" 9799abf2a99657ca  \",\"v\":\"2.1.3\",\"screen\":\"2\",\"ch\":\"xiaomi\",\"sh\":1280,\"p\":{\"size\":20,\"key\":\"" + searchKey + "\",\"page\":" + page + ",\"categoryId\":0},\"sw\":720,\"uid\":\"a7514f777d03\",\"net\":\"0\",\"ver\":\"4\",\"os\":\"1\"}";
        RequestBody body = null;
        try {
            body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), (new JSONObject(jsonStr)).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        subscription = ApiClient.getInstance().getLiveApi(Constants.QUANMIN_BASE_URL)
                .searchQuanmin(body)
                .map(new Func1<LiveUserQuanmin, List<LiveUser>>() {
                    @Override
                    public List<LiveUser> call(LiveUserQuanmin liveUserQuanmin) {
                        List<LiveUser> result = new ArrayList<LiveUser>();
                        if (liveUserQuanmin.getCode() == 200 && liveUserQuanmin.getData().getTotal() > 0) {
                            List<LiveUserQuanmin.DataEntity.ItemsEntity> items = liveUserQuanmin.getData().getItems();
                            for (LiveUserQuanmin.DataEntity.ItemsEntity entity : items) {
                                LiveUser liveUser = new LiveUser();
                                liveUser.setUid(entity.getUid()+"");
                                liveUser.setPlatform(PlatForm.QUANMIN);
                                liveUser.setUserName(entity.getNick());
                                //todo 应该查询本地数据库
                                liveUser.setHasFocus(false);
                                liveUser.setRoomTitle(entity.getTitle());
                                liveUser.setUserIconUrl(entity.getAvatar());
                                liveUser.setViewersCount("观看人数:" + entity.getView());
                                liveUser.setStatus(entity.isPlay_status() ? "在直播" : "未开播");
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
