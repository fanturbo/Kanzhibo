package pub.kanzhibo.app.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.zhy.autolayout.AutoRelativeLayout;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;
import pub.kanzhibo.app.R;
import pub.kanzhibo.app.base.BaseLceFragment;
import pub.kanzhibo.app.base.BaseSearchPresent;
import pub.kanzhibo.app.common.widget.SwipeRefreshLoadMoreLayout;
import pub.kanzhibo.app.main.LiveUserAdapter;
import pub.kanzhibo.app.model.PlatForm;
import pub.kanzhibo.app.model.event.SearchEvent;
import pub.kanzhibo.app.model.searchliveuser.LiveUser;
import pub.kanzhibo.app.search.present.DouyuSearchPresent;
import pub.kanzhibo.app.search.present.HuyaSearchPresent;
import pub.kanzhibo.app.search.present.PandaSearchPresent;
import pub.kanzhibo.app.search.present.QuanminSearchPresent;
import pub.kanzhibo.app.search.present.ZhanqiSearchPresent;

import static android.app.Activity.RESULT_OK;
import static pub.kanzhibo.app.global.Constants.Key.LOGIN_REQUEST_CODE;

/**
 * 搜索主播Fragment
 */
public class SearchUserFragment extends BaseLceFragment<SwipeRefreshLoadMoreLayout, List<LiveUser>, SearchView, BaseSearchPresent>
        implements SearchView, LiveUserAdapter.LiveUserFollowListner {


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
    private int mPageIndex;
    private List<LiveUser> mLiveUserList;

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
        contentView.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout ptrFrameLayout) {
                mPageIndex++;
                presenter.searchUser(true, mSearchKey, mPageIndex);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                mPageIndex = 0;
                loadData(true);
            }
        });
        emptyTipsTv.setText("还木有进行搜索");
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
        //显示空界面
        if (!pullToRefresh) {
            defaultSearchRelative.setVisibility(View.VISIBLE);
        } else {
            mPageIndex = 0;
            if (mLiveUserList != null)
                mLiveUserList.clear();
            liveUserAdapter = null;
        }
        presenter.searchUser(pullToRefresh, mSearchKey, mPageIndex);
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

    @Override
    public void stopRefresh() {
        contentView.refreshComplete();
    }

    @Override
    public void showContent() {
        super.showContent();
        stopRefresh();
    }

    @Override
    public void showLoading(boolean pullToRefresh) {
        if (!pullToRefresh) {
            super.showLoading(pullToRefresh);
        }
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
        mPageIndex = 0;
        if (mLiveUserList != null) {
            mLiveUserList.clear();
        }
        presenter.searchUser(false, mSearchKey, mPageIndex);
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
