package pub.kanzhibo.app.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState;

import pub.kanzhibo.app.R;
import pub.kanzhibo.app.base.BaseLceFragment;
import pub.kanzhibo.app.model.liveuser.LiveUser;

import java.util.List;

/**
 * 主播列表Fragment
 */
public class LiveUserFragment extends BaseLceFragment<RecyclerView,List<LiveUser>,LiveView,LivePresent> {


    @Override
    protected int getLayoutRes() {
        return 0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_liveuser_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }
        return view;
    }

    @Override
    public LceViewState<List<LiveUser>, LiveView> createViewState() {
        return new LceViewState() {
            @Override
            public void apply(MvpView view, boolean retained) {

            }

            @Override
            public void setStateShowContent(Object loadedData) {

            }

            @Override
            public void setStateShowError(Throwable e, boolean pullToRefresh) {

            }

            @Override
            public void setStateShowLoading(boolean pullToRefresh) {

            }
        };
    }
    @Override
    public void setData(List<LiveUser> data) {

    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.getHuyaLiveUser();
    }

    @Override
    public List<LiveUser> getData() {
        return null;
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return "抱歉,没有找到相关主播";
    }

    @Override
    public LivePresent createPresenter() {
        return new LivePresent();
    }
}
