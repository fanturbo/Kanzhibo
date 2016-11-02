package pub.kanzhibo.app.login;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import pub.kanzhibo.app.model.Login;

/**
 * Created by turbo on 2016/11/2.
 */

public interface LoginView extends MvpView {

    public void showError(String errMessage);

    public void showLoading();

    public void loginSuccessful();
}
