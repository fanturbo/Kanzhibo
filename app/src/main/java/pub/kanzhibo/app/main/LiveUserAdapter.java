package pub.kanzhibo.app.main;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hwangjr.rxbus.RxBus;
import com.sdsmdg.tastytoast.TastyToast;

import java.util.Arrays;
import java.util.List;

import pub.kanzhibo.app.R;
import pub.kanzhibo.app.common.widget.ToggleButton;
import pub.kanzhibo.app.model.event.FollowEvent;
import pub.kanzhibo.app.model.liveuser.LiveUser;
import pub.kanzhibo.app.util.DialogHelp;
import pub.kanzhibo.app.util.SharedPreferencesUtils;

import static pub.kanzhibo.app.gloabal.Constants.Key.SAVE_WHERE;
import static pub.kanzhibo.app.gloabal.Constants.Key.SELECT_SAVE_WHERE;

/**
 * Created by turbo on 2016/10/28.
 * 搜索页面也是用这个adapter
 */

public class LiveUserAdapter extends BaseQuickAdapter<LiveUser, BaseViewHolder> {


    //自定义一个关注的监听事件
    private LiveUserFollowListner liveUserFollowListner;

    public LiveUserFollowListner getLiveUserFollowListner() {
        return liveUserFollowListner;
    }

    public void setLiveUserFollowListner(LiveUserFollowListner liveUserFollowListner) {
        this.liveUserFollowListner = liveUserFollowListner;
    }

    public LiveUserAdapter(List<LiveUser> data) {
        super(R.layout.item_fragment_live_user, data);
    }

    @Override
    protected void convert(final BaseViewHolder viewHolder, final LiveUser liveUser) {
        //如果需要获取position viewHolder.getLayoutPosition()
        viewHolder.setText(R.id.tv_username, liveUser.getUserName())
                .setText(R.id.tv_roomtitle, liveUser.getRoomTitle())
                .setText(R.id.tv_viewercount, liveUser.getViewersCount())
                .setText(R.id.tv_live_status, liveUser.getStatus());

        ((ToggleButton) viewHolder.getView(R.id.togglebutton_focus)).setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                liveUserFollowListner.onFollow(on, liveUser);
            }
        });
        Glide.with(mContext).load(liveUser.getUserIconUrl()).crossFade().into((ImageView) viewHolder.getView(R.id.roundimage_roombackgroud));
    }

    public interface LiveUserFollowListner {
        public void onFollow(boolean followStatus, LiveUser liveUser);
    }
}
