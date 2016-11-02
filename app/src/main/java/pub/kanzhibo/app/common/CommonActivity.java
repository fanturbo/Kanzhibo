package pub.kanzhibo.app.common;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import pub.kanzhibo.app.R;
import pub.kanzhibo.app.base.BaseActivity;
import pub.kanzhibo.app.base.BaseFragment;
import pub.kanzhibo.app.login.LoginFragment;
import pub.kanzhibo.app.model.event.RegisterEvent;
import pub.kanzhibo.app.register.RegisterFragment;

public class CommonActivity extends BaseActivity {
    //todo toolbar去哪里了？
    private SparseArray<BaseFragment> fragmentList;
    @BindView(R.id.tv_title)
    TextView mTitleTV;
    int mIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        Intent intent = getIntent();
        RxBus.get().register(this);
        fragmentList = new SparseArray<BaseFragment>();
        fragmentList.put(0, new LoginFragment());
        fragmentList.put(1, new RegisterFragment());
        switch (intent.getStringExtra("Fragment")) {
            case "login":
                mIndex = 0;
                mTitleTV.setText("登录");
                break;
            case "register":
                mIndex = 1;
                mTitleTV.setText("注册");
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
