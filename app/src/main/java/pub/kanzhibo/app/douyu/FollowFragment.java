package pub.kanzhibo.app.douyu;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hwangjr.rxbus.RxBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import pub.kanzhibo.app.R;
import pub.kanzhibo.app.base.BaseFragment;
import pub.kanzhibo.app.base.BaseLceFragment;
import pub.kanzhibo.app.common.widget.SwipeRefreshLoadMoreLayout;
import pub.kanzhibo.app.model.FollowLive;
import pub.kanzhibo.app.model.UserInfo;
import pub.kanzhibo.app.util.SharedPreferencesUtils;

/**
 * 斗鱼关注的直播页面
 */
public class FollowFragment extends BaseLceFragment<SwipeRefreshLoadMoreLayout, List<FollowLive.DataBean>, FollowView, FollowPresenter> implements FollowView {


    @BindView(R.id.recyclerview_follow)
    RecyclerView recyclerviewFollow;
    private FollowUserAdapter mFollowUserAdapter;
    private List<FollowLive.DataBean> mFollowUserList;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerviewFollow.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        contentView.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                loadData(true);
            }
        });
        RxBus.get().register(this);
        loadData(true);
    }

    @Override
    public FollowPresenter createPresenter() {
        return new FollowPresenter();
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_follow;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        return rootView;
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return e.getMessage();
    }

    @Override
    public void setData(List<FollowLive.DataBean> data) {
        if (mFollowUserAdapter == null) {
            mFollowUserList = new ArrayList<>();
            mFollowUserList.addAll(data);
            mFollowUserAdapter = new FollowUserAdapter(R.layout.item_follow_user,mFollowUserList);
            recyclerviewFollow.setAdapter(mFollowUserAdapter);
        } else {
            mFollowUserList.addAll(data);
        }
        mFollowUserAdapter.notifyDataSetChanged();
        showContent();
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.getFollow(pullToRefresh, SharedPreferencesUtils.getToken(getActivity()), "20", "");
    }
}
