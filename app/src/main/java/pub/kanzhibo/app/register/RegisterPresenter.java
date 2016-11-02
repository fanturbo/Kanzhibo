package pub.kanzhibo.app.register;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SignUpCallback;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.jakewharton.rxbinding.widget.RxTextView;

import pub.kanzhibo.app.base.BaseRxLcePresenter;
import pub.kanzhibo.app.model.Login;

/**
 * Created by turbo on 2016/11/2.
 */

public class RegisterPresenter extends MvpBasePresenter<RegisterView> {
    public void register(String email, String password) {
        //todo 使用RxBind是否可以对email进行校验
        AVUser user = new AVUser();// 新建 AVUser 对象实例
        user.setUsername(email);// 设置用户名
        user.setPassword(password);// 设置密码
        user.setEmail(email);// 设置邮箱
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(AVException e) {
                if (e == null) {
                    // 注册成功
                    getView().registerSuccessful();
                } else {
                    // 失败的原因可能有多种，常见的是用户名已经存在。
                    String errMessage = "";
                    switch (e.getCode()) {
                        case 202:
                        case 203:
                            errMessage = "电子邮箱已被注册！";
                            break;

                    }
                    getView().showError(errMessage);
                }
            }
        });
    }
}
