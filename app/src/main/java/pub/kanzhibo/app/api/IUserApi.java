package pub.kanzhibo.app.api;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import pub.kanzhibo.app.model.liveuser.LiveUserDouYu;
import pub.kanzhibo.app.model.liveuser.LiveUserPanda;
import pub.kanzhibo.app.model.liveuser.LiveUserQuanmin;
import pub.kanzhibo.app.model.liveuser.LiveUserZhanqi;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by snail on 16/10/30.
 */
public interface IUserApi {
    /**
     * 获取熊猫tv直播房间信息
     *
     * @param roomid
     * @return
     */
    @GET("/api_room_v2?roomid=497942")
    Observable<LiveUserPanda> getPandaRoomInfo(@Query("roomid") String roomid);

}
