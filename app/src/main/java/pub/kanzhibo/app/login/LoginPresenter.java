package pub.kanzhibo.app.login;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import pub.kanzhibo.app.api.ApiClient;
import pub.kanzhibo.app.api.RxSchedulers;
import pub.kanzhibo.app.global.Constants;
import pub.kanzhibo.app.model.UserInfo;
import rx.functions.Action1;

/**
 * Created by turbo on 2016/11/2.
 */

public class LoginPresenter extends MvpBasePresenter<LoginView> {
    public void login(String email, String password) {
        //todo 对email和password进行校验
        AVUser.logInInBackground(email, password, new LogInCallback<AVUser>() {
            @Override
            public void done(AVUser avUser, AVException e) {
                if (avUser != null) {
                    getView().loginSuccessful(avUser);
                } else {
                    getView().showError("登陆失败,请检查用户名或者密码");
                }
            }
        });
    }

    public void loginDouYu(String email, String password) {
        ApiClient.getInstance().getLiveApi(Constants.DOUYU_BASE_URL).login(email, password)
                .compose(RxSchedulers.<UserInfo>applySchedulers())
                .subscribe(new Action1<UserInfo>() {
                    @Override
                    public void call(UserInfo userInfo) {
                        getView().loginSuccessful(userInfo);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        getView().showError(throwable.getMessage());
                    }
                });
    }
}
