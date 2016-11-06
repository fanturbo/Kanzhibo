package pub.kanzhibo.app.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.feedback.Comment;
import com.avos.avoscloud.feedback.FeedbackAgent;
import com.avos.avoscloud.feedback.FeedbackThread;
import com.bumptech.glide.Glide;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.List;

import pub.kanzhibo.app.App;
import pub.kanzhibo.app.R;
import pub.kanzhibo.app.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import pub.kanzhibo.app.common.CommonActivity;
import pub.kanzhibo.app.common.WebViewActivity;
import pub.kanzhibo.app.gloabal.Constants;
import pub.kanzhibo.app.model.event.LoginEvent;
import pub.kanzhibo.app.search.SearchActivity;
import pub.kanzhibo.app.util.DialogHelp;
import pub.kanzhibo.app.util.SharedPreferencesUtils;

import static pub.kanzhibo.app.gloabal.Constants.Key.LOGIN_REQUEST_CODE;
import static pub.kanzhibo.app.gloabal.Constants.Key.SAVE_WHERE;
import static pub.kanzhibo.app.gloabal.Constants.Key.SELECT_SAVE_WHERE;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar mToolBar;
    @BindView(R.id.fab)
    FloatingActionButton mFloatingActionButton;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.frame_main_content)
    FrameLayout frameMainContent;
    TextView usernameTV;
    ImageView userIconIV;
    FeedbackAgent agent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        RxBus.get().register(this);
        setSupportActionBar(mToolBar);
        initFeedBack();
        initToolbar();
        initView();
    }

    private void initFeedBack() {
        agent = new FeedbackAgent(this);
        agent.getDefaultThread().sync(new FeedbackThread.SyncCallback() {
            @Override
            public void onCommentsSend(List<Comment> list, AVException e) {
            }

            @Override
            public void onCommentsFetch(List<Comment> list, AVException e) {
                //todo啥时候调用这个啊，已经看了，为啥还是老是出来
                TastyToast.makeText(MainActivity.this, "开发者回复了你的反馈", 1, 3);
            }
        });
    }

    private void initView() {
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolBar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_main_content, new LiveUserFragment());
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            startActivity(new Intent(this, SearchActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    private void initToolbar() {
        mToolBar.inflateMenu(R.menu.menu_main);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_login) {
            if (!App.isLogIn()) {
                Intent intent = new Intent(this, CommonActivity.class);
                intent.putExtra("Fragment", "login");
                startActivityForResult(intent, LOGIN_REQUEST_CODE);
            } else {
                App.logOut();
                RxBus.get().post(new LoginEvent(null));
            }
        } else if (id == R.id.nav_save_data) {
            final int index = Integer.parseInt(SharedPreferencesUtils.getString(App.context, SAVE_WHERE, "0"));
            final int[] tempSelectedIndex = {index};
            DialogHelp.getSelectSaveDataDialog(this, true, index, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    switch (i) {
                        case 0:
                            tempSelectedIndex[0] = 0;
                            break;
                        case 1:
                            tempSelectedIndex[0] = 1;
                            break;
                        case DialogInterface.BUTTON_POSITIVE:
                            SharedPreferencesUtils.saveString(App.context, SAVE_WHERE, "" + tempSelectedIndex[0]);
                            SharedPreferencesUtils.saveBoolean(App.context, SELECT_SAVE_WHERE, true);
                            //执行保存操作
                            break;
                    }
                }
            });
        } else if (id == R.id.nav_feedback) {
            agent.startDefaultThreadActivity();
        } else if(id == R.id.nav_about){
            Intent intent = new Intent(this, WebViewActivity.class);
            intent.putExtra(Constants.Key.WEB_TITLE,"关于");
            intent.putExtra(Constants.Key.WEB_URL,"https://github.com/xturbofan");
            startActivity(intent);
        } else if(id == R.id.nav_setting){
            TastyToast.makeText(this,"未完成此功能",0,3);
        }
        userIconIV = (ImageView) navigationView.findViewById(R.id.iv_userIcon);
        usernameTV = (TextView) navigationView.findViewById(R.id.tv_username);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Subscribe
    public void showUserInfo(LoginEvent loginEvent) {
        if(loginEvent.getUser()!=null) {
            Glide.with(this).load("").into(userIconIV);
            usernameTV.setText(loginEvent.getUser().getUsername() + "");
        }else{
            userIconIV.setImageResource(R.mipmap.ic_launcher);
            usernameTV.setText("");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().unregister(this);
    }

    private long mExitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                TastyToast.makeText(this, "再按一次退出程序", 0, 2);
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
