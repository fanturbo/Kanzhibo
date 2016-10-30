package pub.kanzhibo.app.api;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import pub.kanzhibo.app.model.liveuser.LiveUserDouYu;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by snail on 16/10/30.
 */
public interface IDouyuLiveApi {
    @GET("?m=Search&do=getSearchContent&uid=0&app=11&v=4&typ=-5")
    Observable<ResponseBody> searchDouyu(@Query("q") String searchKey,@Query("rows") String rows);
}
