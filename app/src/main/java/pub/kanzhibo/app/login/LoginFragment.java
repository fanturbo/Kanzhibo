package pub.kanzhibo.app.login;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hwangjr.rxbus.RxBus;

import butterknife.BindView;
import butterknife.OnClick;
import pub.kanzhibo.app.App;
import pub.kanzhibo.app.R;
import pub.kanzhibo.app.base.BaseFragment;
import pub.kanzhibo.app.base.BaseLceFragment;
import pub.kanzhibo.app.model.Login;
import pub.kanzhibo.app.model.event.RegisterEvent;
import pub.kanzhibo.app.register.RegisterPresenter;
import pub.kanzhibo.app.register.RegisterView;

/**
 * A simple {@link Fragment} subclass.
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
    void register() {
        showLoading();
        ((LoginPresenter) presenter).login(mUserName.getText().toString().trim(), mPasswordView.getText().toString().trim());
    }

    @OnClick(R.id.btn_register)
    void login() {
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
    public void loginSuccessful() {
        mProgressDialog.dismiss();
        App.LogIn(true);
        getActivity().finish();
    }
}
