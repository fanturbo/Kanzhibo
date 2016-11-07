package pub.kanzhibo.app.main;

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

import com.bumptech.glide.Glide;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.BindView;
import butterknife.OnClick;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;
import pub.kanzhibo.app.App;
import pub.kanzhibo.app.R;
import pub.kanzhibo.app.base.BaseLceFragment;
import pub.kanzhibo.app.common.EmptyException;
import pub.kanzhibo.app.common.widget.SwipeRefreshLoadMoreLayout;
import pub.kanzhibo.app.model.event.LoginEvent;
import pub.kanzhibo.app.model.searchliveuser.LiveUser;

import java.util.ArrayList;
import java.util.List;

/**
 * 关注的主播列表Fragment
 */
public class LiveUserFragment extends BaseLceFragment<SwipeRefreshLoadMoreLayout, List<LiveUser>, LiveView, LivePresent>
        implements LiveView, LiveUserAdapter.LiveUserFollowListner {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private LiveUserAdapter liveUserAdapter;
    @BindView(R.id.relative_default_search)
    AutoRelativeLayout defaultSearchRelative;
    @BindView(R.id.iv_empty_tips)
    ImageView emptyTipsIv;
    @BindView(R.id.tv_empty_tips)
    TextView emptyTipsTv;
    private int mPageIndex;
    private ArrayList<LiveUser> mLiveUserList;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_liveuser_list;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RxBus.get().register(this);
        AnimationDrawable frameAnim = (AnimationDrawable) getResources().getDrawable(R.drawable.empty_bike);
        emptyTipsIv.setBackgroundDrawable(frameAnim);
        ((Animatable) emptyTipsIv.getBackground()).start();
        loadData(true);
    }

    @Override
    public void setData(List<LiveUser> data) {
        if (liveUserAdapter == null) {
            mLiveUserList = new ArrayList<>();
            mLiveUserList.addAll(data);
            liveUserAdapter = new LiveUserAdapter(mLiveUserList);
            liveUserAdapter.setLiveUserFollowListner(this);
            recyclerView.setAdapter(liveUserAdapter);
        } else {
            mLiveUserList.addAll(data);
        }
        liveUserAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        if (App.isLogIn()) {
            defaultSearchRelative.setVisibility(View.GONE);
            mPageIndex = 0;
            if (mLiveUserList != null)
                mLiveUserList.clear();
            presenter.getFollow(pullToRefresh, mPageIndex);
        } else {
            emptyTipsTv.setText("这个页面展示的是关注的主播列表，如果不需要登录点击自行车");
        }
    }

    @OnClick(R.id.iv_empty_tips)
    public void clickEmpty() {
        presenter.getFollow(false, mPageIndex);
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return "抱歉,没有找到相关主播";
    }

    @Override
    public LivePresent createPresenter() {
        return new LivePresent();
    }

    @Override
    public void stopRefresh() {
        contentView.refreshComplete();
    }

    @Override
    public void showContent() {
        super.showContent();
        stopRefresh();
        contentView.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                loadData(true);
            }
        });
    }

    @Override
    public void showLoading(boolean pullToRefresh) {
        if (!pullToRefresh) {
            super.showLoading(pullToRefresh);
        }
    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
        if (e instanceof EmptyException) {
            defaultSearchRelative.setVisibility(View.VISIBLE);
            emptyTipsTv.setText("虽然你已登录，但是你木有关注任何主播");
        } else {
            super.showError(e, pullToRefresh);
            stopRefresh();
        }
    }

    @Override
    protected void onErrorViewClicked() {
        super.onErrorViewClicked();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        RxBus.get().unregister(this);
    }

    @Override
    public void onFollow(boolean followStatus, LiveUser liveUser) {
        presenter.followLive(followStatus, liveUser);
    }

    @Subscribe
    public void getFollow(LoginEvent loginEvent) {
        if (loginEvent.getUser() != null) {
            loadData(false);
        }
    }
}
