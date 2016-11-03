package pub.kanzhibo.app.search;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.zhy.autolayout.AutoRelativeLayout;

import java.net.UnknownHostException;
import java.util.List;

import butterknife.BindView;
import pub.kanzhibo.app.App;
import pub.kanzhibo.app.R;
import pub.kanzhibo.app.base.BaseLceFragment;
import pub.kanzhibo.app.base.BaseSearchPresent;
import pub.kanzhibo.app.common.CommonActivity;
import pub.kanzhibo.app.common.widget.ToggleButton;
import pub.kanzhibo.app.main.LiveUserAdapter;
import pub.kanzhibo.app.model.PlatForm;
import pub.kanzhibo.app.model.event.FollowEvent;
import pub.kanzhibo.app.model.event.SearchEvent;
import pub.kanzhibo.app.model.liveuser.LiveUser;
import pub.kanzhibo.app.search.present.DouyuSearchPresent;
import pub.kanzhibo.app.search.present.HuyaSearchPresent;
import pub.kanzhibo.app.search.present.PandaSearchPresent;
import pub.kanzhibo.app.search.present.QuanminSearchPresent;
import pub.kanzhibo.app.search.present.ZhanqiSearchPresent;
import pub.kanzhibo.app.util.DialogHelp;
import pub.kanzhibo.app.util.SharedPreferencesUtils;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

import static android.app.Activity.RESULT_OK;
import static pub.kanzhibo.app.gloabal.Constants.Key.LOGIN_REQUEST_CODE;
import static pub.kanzhibo.app.gloabal.Constants.Key.SAVE_WHERE;
import static pub.kanzhibo.app.gloabal.Constants.Key.SELECT_SAVE_WHERE;

/**
 * 搜索主播Fragment
 */
public class SearchUserFragment extends BaseLceFragment<SwipeRefreshLayout, List<LiveUser>, SearchView, BaseSearchPresent>
        implements SearchView, SwipeRefreshLayout.OnRefreshListener, LiveUserAdapter.LiveUserFollowListner {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    //todo 添加搜索默认页面
//    @BindView(R.id.recyclerview_history)
//    RecyclerView histroyRecyclerView;
    @BindView(R.id.relative_default_search)
    AutoRelativeLayout defaultSearchRelative;
    @BindView(R.id.iv_empty_tips)
    ImageView emptyTipsIv;
    @BindView(R.id.tv_empty_tips)
    TextView emptyTipsTv;
    private LiveUserAdapter liveUserAdapter;
    private PlatForm mPlatForm;
    private String mSearchKey;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_liveuser_list;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RxBus.get().register(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnItemTouchListener(new OnItemClickListener() {

            @Override
            public void SimpleOnItemClick(BaseQuickAdapter adapter, View view, int position) {
                //todo 使用webview播放视频
            }
        });
        contentView.setOnRefreshListener(this);
        emptyTipsTv.setText("还木有进行搜索");
        loadData(false);
    }

    @Override
    public void setData(List<LiveUser> data) {
        liveUserAdapter = new LiveUserAdapter(data);
        liveUserAdapter.setLiveUserFollowListner(this);
        recyclerView.setAdapter(liveUserAdapter);
        liveUserAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        //显示空界面
        if (!pullToRefresh)
            defaultSearchRelative.setVisibility(View.VISIBLE);
        presenter.searchUser(false, mSearchKey, 0);
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        if (e instanceof UnknownHostException) {
            return "哎呀，网络异常了";
        }
        return "抱歉,没有找到相关主播";
    }

    @Override
    public BaseSearchPresent createPresenter() {
        mPlatForm = (PlatForm) getArguments().getSerializable("platform");
        switch (mPlatForm) {
            case HUYA:
                return new HuyaSearchPresent();
            case ZHANQI:
                return new ZhanqiSearchPresent();
            case PANDA:
                return new PandaSearchPresent();
            case QUANMIN:
                return new QuanminSearchPresent();
            default:
                return new DouyuSearchPresent();
        }
    }

    //刷新
    @Override
    public void onRefresh() {
        loadData(true);
    }

    @Override
    public void stopRefresh() {
        contentView.setRefreshing(false);
    }

    @Override
    public void showContent() {
        super.showContent();
        stopRefresh();
    }

    @Override
    public void showLoading(boolean pullToRefresh) {
        super.showLoading(pullToRefresh);
    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
        super.showError(e, pullToRefresh);
        stopRefresh();
    }

    @Override
    protected void onErrorViewClicked() {
        super.onErrorViewClicked();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        RxBus.get().unregister(this);
    }

    @Subscribe
    public void searchUser(SearchEvent searchEvent) {
        //todo 确保每个平台的page都是从0开始的
        defaultSearchRelative.setVisibility(View.GONE);
        mSearchKey = searchEvent.getSearchKey();
        presenter.searchUser(false, mSearchKey, 0);
    }

    @Subscribe
    public void followUser(final FollowEvent followEvent) {
        //5个列表重用的同一个Fragment，所以当通知fragment执行关注操作时，会通知5个SearchUserFragment对象
        //所以用platform做了区分

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == LOGIN_REQUEST_CODE && resultCode == RESULT_OK) {
            loadData(true);
        }
    }

    @Override
    public void onFollow(boolean followStatus, LiveUser liveUser) {
        presenter.followLive(followStatus, liveUser);
    }
}
