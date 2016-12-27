package pub.kanzhibo.app.login;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.avos.avoscloud.AVUser;
import com.hwangjr.rxbus.RxBus;

import butterknife.BindView;
import butterknife.OnClick;
import pub.kanzhibo.app.App;
import pub.kanzhibo.app.R;
import pub.kanzhibo.app.base.BaseFragment;
import pub.kanzhibo.app.common.CommonActivity;
import pub.kanzhibo.app.model.UserInfo;
import pub.kanzhibo.app.model.event.LoginEvent;
import pub.kanzhibo.app.model.event.RegisterEvent;
import pub.kanzhibo.app.util.SharedPreferencesUtils;

/**
 * 登录界面
 */
public class LoginFragment extends BaseFragment<LoginView, LoginPresenter> implements LoginView {

    @BindView(R.id.auto_ctv_username)
    AutoCompleteTextView mUserName;
    @BindView(R.id.auto_ctv_password)
    EditText mPasswordView;
    @BindView(R.id.login_progress)
    ProgressBar mProgressView;
    @BindView(R.id.login_form)
    ScrollView mLoginFormView;
    @BindView(R.id.btn_login)
    Button mLoginButton;
    @BindView(R.id.btn_register)
    Button mRegisterButton;
    @BindView(R.id.tv_error)
    TextView tvError;
    private ProgressDialog mProgressDialog;

    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_login;
    }

    @OnClick(R.id.btn_login)
    void login() {
        showLoading();
        Bundle bundle = getArguments();
        String userName = mUserName.getText().toString().trim();
        String password = mPasswordView.getText().toString().trim();
        if (bundle != null) {
            String from = bundle.getString("from");
            if ("douyu".equals(from)) {
                if(userName.isEmpty() || password.isEmpty()){
                    tvError.setText("亲,输入帐号和密码啊!");
                    mProgressDialog.dismiss();
                    return;
                }
                ((LoginPresenter) presenter).loginDouYu(userName, password);
                mRegisterButton.setVisibility(View.GONE);
            } else {
                ((LoginPresenter) presenter).login(userName, password);
            }
        } else {
            ((LoginPresenter) presenter).login(userName, password);
        }

    }

    @OnClick(R.id.btn_register)
    void register() {
        RxBus.get().post(new RegisterEvent(false));
    }

    @Override
    public void showError(String errMessage) {
        mProgressDialog.dismiss();
        tvError.setText(errMessage + "");
    }

    @Override
    public void showLoading() {
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setCanceledOnTouchOutside(true);
        mProgressDialog.setMessage("拼命加载中...");
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    @Override
    public void loginSuccessful(AVUser user) {
        mProgressDialog.dismiss();
        App.logIn();
        RxBus.get().post(new LoginEvent(user));
        getActivity().finish();
    }

    @Override
    public void loginSuccessful(UserInfo userInfo) {
        mProgressDialog.dismiss();
        SharedPreferencesUtils.saveToken(getActivity(), userInfo.getData().getToken());
        Intent intent = new Intent(getActivity(), CommonActivity.class);
        intent.putExtra("Fragment", "FollowFragment");
        startActivity(intent);
    }
}
