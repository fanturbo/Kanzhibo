package pub.kanzhibo.app.main;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState;
import com.hwangjr.rxbus.RxBus;
import com.hwangjr.rxbus.annotation.Subscribe;

import butterknife.BindView;
import pub.kanzhibo.app.App;
import pub.kanzhibo.app.R;
import pub.kanzhibo.app.base.BaseLceFragment;
import pub.kanzhibo.app.common.CommonActivity;
import pub.kanzhibo.app.common.widget.ToggleButton;
import pub.kanzhibo.app.model.event.FollowEvent;
import pub.kanzhibo.app.model.liveuser.LiveUser;
import pub.kanzhibo.app.util.DialogHelp;
import pub.kanzhibo.app.util.SharedPreferencesUtils;

import java.util.List;

import static pub.kanzhibo.app.gloabal.Constants.Key.ISLOGIN;
import static pub.kanzhibo.app.gloabal.Constants.Key.LOGIN_REQUEST_CODE;
import static pub.kanzhibo.app.gloabal.Constants.Key.SAVE_WHERE;
import static pub.kanzhibo.app.gloabal.Constants.Key.SELECT_SAVE_WHERE;

/**
 * 关注的主播列表Fragment
 */
public class LiveUserFragment extends BaseLceFragment<SwipeRefreshLayout, List<LiveUser>, LiveView, LivePresent>
        implements LiveView, SwipeRefreshLayout.OnRefreshListener {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    private LiveUserAdapter liveUserAdapter;

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
//        presenter.getFollow(pullToRefresh);
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
        super.showError(e, pullToRefresh);
        stopRefresh();
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

    @Subscribe
    public void followUser(FollowEvent followEvent) {
        //todo 当dialog确定结果时才继续往下执行
        DialogHelp.getSelectSaveDataDialog(getActivity(), false);
        final int index = Integer.parseInt(SharedPreferencesUtils.getString(getActivity(), SAVE_WHERE, "0"));
        //根据选择的方式进行保存数据 本地or服务器
        if (index == 0) {
            //todo 使用realm保存本地数据
        } else {
            if (App.isLogIn()) {
                presenter.followLive(followEvent.getfollow(), followEvent.getLiveUser());
            } else {
                //跳到登录页面
                Intent intent = new Intent(getActivity(), CommonActivity.class);
                intent.putExtra("Fragment", "login");
                getActivity().startActivityForResult(intent, LOGIN_REQUEST_CODE);
            }
        }
    }
}
