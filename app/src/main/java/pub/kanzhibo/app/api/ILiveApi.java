package pub.kanzhibo.app.api;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import pub.kanzhibo.app.model.roominfo.DouYuUserInfo;
import pub.kanzhibo.app.model.roominfo.PandaUserInfo;
import pub.kanzhibo.app.model.roominfo.ZhanqiUserInfo;
import pub.kanzhibo.app.model.searchliveuser.LiveUserDouYu;
import pub.kanzhibo.app.model.searchliveuser.LiveUserPanda;
import pub.kanzhibo.app.model.searchliveuser.LiveUserQuanmin;
import pub.kanzhibo.app.model.searchliveuser.LiveUserZhanqi;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by snail on 16/10/30.
 */
public interface ILiveApi {
    //注：所有的搜索都限制为20条，这是写死的，所以如果使用接口的话请注意这一点

    /**
     * 虎牙
     *
     * @param searchKey
     * @param rows
     * @return
     */
    @GET("?m=Search&do=getSearchContent&uid=0&app=11&v=4&typ=-5")
    Observable<ResponseBody> searchHuya(@Query("q") String searchKey, @Query("rows") int rows);

    /**
     * 战旗
     *
     * @param searchKey
     * @param rows
     * @return
     */
    @GET("/api/touch/search?t=anchor&nums=236&ver=2.6.6&os=3")
    Observable<LiveUserZhanqi> searchZhanqi(@Query("q") String searchKey, @Query("page") int rows);

    /**
     * 斗鱼
     *
     * @param searchKey
     * @param offset    0,10,20
     * @return
     */
    @GET("/api/v1/searchNew/{search_string}/1?limit=20")
    Observable<LiveUserDouYu> searchDouyu(@Path("search_string") String searchKey, @Query("offset") int offset);

    /**
     * 全民
     *
     * @param requestBody
     * @return
     */
    @POST("/site/search")
    Observable<LiveUserQuanmin> searchQuanmin(@Body RequestBody requestBody);

    /**
     * 熊猫
     *
     * @param searchKey
     * @param pageno    //     * @param status    在线状态 2在线 3不在线
     * @return
     */
//    手机端的接口，因为熊猫tv的app是根据是否在线用两个tab分别来展示的，所以需要传个status字段
//    @GET("/ajax_search?__version=2.0.2.1493&__plat=android&__channel=xiaomi&pagenum=20")
//    Observable<LiveUserPanda> searchPanda(@Query("keyword") String searchKey, @Query("pageno") int pageno, @Query("status") int status);
    //这儿是pc端的接口
    @GET("/ajax_search?order_cond=fans&pagenum=20")
    Observable<LiveUserPanda> searchPanda(@Query("name") String searchKey, @Query("pageno") int pageno);

    /**
     * 获取熊猫tv直播房间信息
     *
     * @param roomid
     * @return
     */
    @GET("/ajax_get_liveroom_baseinfo")
    Observable<PandaUserInfo> getPandaRoomInfo(@Query("roomid") String roomid);

    /**
     * 获取斗鱼tv直播房间信息
     *
     * @param roomid
     * @return
     */
    @GET("/api/RoomApi/room/{roomid}")
    Observable<DouYuUserInfo> getDouyuRoomInfo(@Path("roomid") String roomid);

    /**
     * 获取全民tv直播房间信息
     *
     * @param roomid
     * @return
     */
    @GET("/json/rooms/{roomid}/info.json")
    Observable<ResponseBody> getQuanminRoomInfo(@Path("roomid") String roomid);

    /**
     * 获取战旗tv直播房间信息
     *
     * @param roomid
     * @return
     */
    @GET("/api/static/live.roomid/{roomid}")
    Observable<ZhanqiUserInfo> getZhanqiRoomInfo(@Path("roomid") String roomid);

}
