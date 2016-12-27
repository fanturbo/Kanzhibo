package pub.kanzhibo.app.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.kanzhibo.app.R;
import pub.kanzhibo.app.base.BaseActivity;
import pub.kanzhibo.app.base.BaseFragment;
import pub.kanzhibo.app.douyu.FollowFragment;
import pub.kanzhibo.app.login.LoginFragment;
import pub.kanzhibo.app.model.event.RegisterEvent;
import pub.kanzhibo.app.register.RegisterFragment;

public class CommonActivity extends BaseActivity {
    @BindView(R.id.btn_option)
    Button btnOption;
    private SparseArray<Fragment> fragmentList;
    @BindView(R.id.tv_title)
    TextView mTitleTV;
    int mIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        RxBus.get().register(this);
        fragmentList = new SparseArray<Fragment>();
        LoginFragment loginFragment = new LoginFragment();
        Bundle bundle = new Bundle();
        bundle.putString("from", "douyu");
        loginFragment.setArguments(bundle);
        fragmentList.put(0, new LoginFragment());
        fragmentList.put(1, new RegisterFragment());
        fragmentList.put(2, loginFragment);
        fragmentList.put(3, new FollowFragment());
        switch (intent.getStringExtra("Fragment")) {
            case "login":
                mIndex = 0;
                mTitleTV.setText("登录");
                break;
            case "register":
                mIndex = 1;
                mTitleTV.setText("注册");
                break;
            case "douyuLogin":
                mIndex = 2;
                mTitleTV.setText("登录斗鱼");
                break;
            case "FollowFragment":
                mIndex = 3;
                mTitleTV.setText("我的斗鱼关注");
                btnOption.setVisibility(View.VISIBLE);
                break;
        }
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer, fragmentList.get(mIndex))
                .commit();
    }

    @OnClick(R.id.ib_back)
    void back() {
        this.finish();
    }

    @OnClick(R.id.btn_option)
    void option() {
        if (getIntent() != null && "FollowFragment".equals(getIntent().getStringExtra("Fragment"))) {
            //todo 导入斗鱼关注的直播
        }
    }

    @Subscribe
    public void registerCallBack(RegisterEvent registerEvent) {
        if (registerEvent.getRegsiterStatus()) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, fragmentList.get(0))
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, fragmentList.get(1))
                    .commit();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }
}
