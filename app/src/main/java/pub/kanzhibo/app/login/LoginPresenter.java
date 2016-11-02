package pub.kanzhibo.app.login;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import pub.kanzhibo.app.base.BaseRxLcePresenter;
import pub.kanzhibo.app.model.Login;

/**
 * Created by turbo on 2016/11/2.
 */

public class LoginPresenter extends MvpBasePresenter<LoginView> {
    public void login(String email, String password) {
        //todo 对email和password进行校验
        AVUser.logInInBackground(email, password, new LogInCallback<AVUser>() {
            @Override
            public void done(AVUser avUser, AVException e) {
                if (avUser != null)
                    getView().loginSuccessful();
            }
        });
    }
}
