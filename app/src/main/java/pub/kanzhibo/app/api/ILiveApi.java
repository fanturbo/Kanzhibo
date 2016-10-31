package pub.kanzhibo.app.api;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import pub.kanzhibo.app.model.liveuser.LiveUserDouYu;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by snail on 16/10/30.
 */
public interface ILiveApi {
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
    Observable<ResponseBody> searchZhanqi(@Query("q") String searchKey, @Query("page") int rows);

    /**
     * 斗鱼
     *
     * @param searchKey
     * @param limit
     * @param offset
     * @return
     */
    @GET("/api/v1/searchNew/{search_string}/1")
    Observable<ResponseBody> searchDouyu(@Path("search_string") String searchKey, @Query("limit") int limit, @Query("offset") int offset);

    /**
     * 全民
     * @param requestBody
     * @return
     */
    @GET("/site/search")
    Observable<ResponseBody> searchQuanmin(@Body RequestBody requestBody);

    /**
     * 熊猫
     *
     * @param searchKey
     * @param pageno
     * @param pagenum
     * @param status
     * @return
     */
    @GET("http://api.m.panda.tv/ajax_search?__version=2.0.2.1493&__plat=android&__channel=xiaomi")
    Observable<ResponseBody> searchPanda(@Query("keyword") String searchKey, @Query("pageno") int pageno, @Query("pagenum") int pagenum, @Query("status") int status);
}
