package pub.kanzhibo.app.douyu;

import android.support.design.widget.Snackbar;
import android.util.Log;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.concurrent.TimeUnit;

import pub.kanzhibo.app.App;
import pub.kanzhibo.app.api.ApiClient;
import pub.kanzhibo.app.api.RxSchedulers;
import pub.kanzhibo.app.global.Constants;
import pub.kanzhibo.app.model.FollowLive;
import pub.kanzhibo.app.model.UserInfo;
import pub.kanzhibo.app.util.SharedPreferencesUtils;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * Created by turbo on 2016/12/26.
 */

public class FollowPresenter extends MvpBasePresenter<FollowView> {

    public void getFollow(final boolean refresh, final String token,final String limit,final String offset) {
        getView().showLoading(refresh);
        Observable
                .defer(new Func0<Observable<FollowLive>>() {
                    @Override
                    public Observable<FollowLive> call() {
                        return ApiClient.getInstance().getLiveApi(Constants.DOUYU_BASE_URL).getFollow(token,limit,offset);
                    }
                })
                .retryWhen(new RetryWithDelay(3, 1000))
                .compose(RxSchedulers.<FollowLive>applySchedulers())
                .subscribe(new Action1<FollowLive>() {
                               @Override
                               public void call(FollowLive followLive) {
                                   getView().setData(followLive.getData());
                               }
                           }
                        , new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                               getView().showError(throwable,refresh);
                            }
                        }
                );
    }

    class RetryWithDelay implements
            Func1<Observable<? extends Throwable>, Observable<?>> {

        private final int maxRetries;
        private final int retryDelayMillis;
        private int retryCount;

        public RetryWithDelay(int maxRetries, int retryDelayMillis) {
            this.maxRetries = maxRetries;
            this.retryDelayMillis = retryDelayMillis;
            this.retryCount = 0;
        }

        @Override
        public Observable<?> call(Observable<? extends Throwable> attempts) {
            return attempts.flatMap(new Func1<Throwable, Observable<?>>() {
                @Override
                public Observable<?> call(final Throwable throwable) {
                    if (++retryCount <= maxRetries) {
                        if (throwable instanceof Exception) {
                            //// TODO: 2016/12/20 有待改进
                            Log.i("======", "重新登录");
                            //重新登录
                            ApiClient.getInstance().getLiveApi(Constants.DOUYU_BASE_URL).login(SharedPreferencesUtils.getDouyuUserName(App.getContext()), SharedPreferencesUtils.getDouyuPassword(App.getContext()))
                                    .compose(RxSchedulers.<UserInfo>applySchedulers())
                                    .subscribe(new Action1<UserInfo>() {
                                        @Override
                                        public void call(UserInfo userInfo) {
                                            SharedPreferencesUtils.saveToken(App.getContext(), userInfo.getData().getToken());
                                        }
                                    });
                            return Observable.timer(retryDelayMillis,
                                    TimeUnit.MILLISECONDS);
                        }
                    }
                    return Observable.error(throwable);
                }
            });
        }
    }
}
