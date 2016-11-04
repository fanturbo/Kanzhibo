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

import com.hwangjr.rxbus.RxBus;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.BindView;
import butterknife.OnClick;
import pub.kanzhibo.app.App;
import pub.kanzhibo.app.R;
import pub.kanzhibo.app.base.BaseLceFragment;
import pub.kanzhibo.app.common.EmptyException;
import pub.kanzhibo.app.model.searchliveuser.LiveUser;

import java.util.List;

/**
 * 关注的主播列表Fragment
 */
public class LiveUserFragment extends BaseLceFragment<SwipeRefreshLayout, List<LiveUser>, LiveView, LivePresent>
        implements LiveView, SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private LiveUserAdapter liveUserAdapter;
    @BindView(R.id.relative_default_search)
    AutoRelativeLayout defaultSearchRelative;
    @BindView(R.id.iv_empty_tips)
    ImageView emptyTipsIv;
    @BindView(R.id.tv_empty_tips)
    TextView emptyTipsTv;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_liveuser_list;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        contentView.setOnRefreshListener(this);
        RxBus.get().register(this);
        AnimationDrawable frameAnim = (AnimationDrawable) getResources().getDrawable(R.drawable.empty_bike);
        emptyTipsIv.setBackgroundDrawable(frameAnim);
        ((Animatable) emptyTipsIv.getBackground()).start();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData(false);
    }

    @Override
    public void setData(List<LiveUser> data) {
        liveUserAdapter = new LiveUserAdapter(data);
        recyclerView.setAdapter(liveUserAdapter);
        liveUserAdapter.notifyDataSetChanged();
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        if (App.isLogIn()) {
            defaultSearchRelative.setVisibility(View.GONE);
            presenter.getFollow(pullToRefresh);
        } else {
            emptyTipsTv.setText("这个页面展示的是关注的主播列表，如果不需要登录点击自行车");
        }
    }

    @OnClick(R.id.iv_empty_tips)
    public void clickEmpty() {
        presenter.getFollow(false);
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return "抱歉,没有找到相关主播";
    }

    @Override
    public LivePresent createPresenter() {
        return new LivePresent();
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
}
