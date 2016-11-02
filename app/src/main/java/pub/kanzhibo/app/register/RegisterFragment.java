package pub.kanzhibo.app.register;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import pub.kanzhibo.app.R;
import pub.kanzhibo.app.base.BaseFragment;
import pub.kanzhibo.app.model.event.RegisterEvent;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends BaseFragment<RegisterView, RegisterPresenter> implements RegisterView {

    @BindView(R.id.auto_ctv_username)
    AutoCompleteTextView mUserName;
    @BindView(R.id.auto_ctv_password)
    EditText mPasswordView;
    @BindView(R.id.login_progress)
    ProgressBar mProgressView;
    @BindView(R.id.login_form)
    ScrollView mLoginFormView;
    @BindView(R.id.btn_register)
    Button mRegisterButton;
    @BindView(R.id.tv_error)
    TextView tvError;
    private ProgressDialog mProgressDialog;

    @Override
    public RegisterPresenter createPresenter() {
        return new RegisterPresenter();
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_register;
    }

    @OnClick(R.id.btn_register)
    void register() {
        showProgress();
        ((RegisterPresenter) presenter).register(mUserName.getText().toString().trim(), mPasswordView.getText().toString().trim());
    }

    @Override
    public void showError(String errMessage) {
        if (mProgressDialog != null)
            mProgressDialog.dismiss();
        tvError.setText(errMessage + "");
    }

    @Override
    public void showProgress() {
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setCanceledOnTouchOutside(true);
        mProgressDialog.setMessage("拼命加载中...");
        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    @Override
    public void registerSuccessful() {
        mProgressDialog.dismiss();
        RxBus.get().post(new RegisterEvent(true));
    }

    @Override
    public void onResume() {
        super.onResume();
        mUserName.setText("");
        mPasswordView.setText("");
    }
}
