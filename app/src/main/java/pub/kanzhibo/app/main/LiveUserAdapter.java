package pub.kanzhibo.app.main;

import android.support.annotation.AnimRes;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import pub.kanzhibo.app.R;
import pub.kanzhibo.app.common.widget.ToggleButton;
import pub.kanzhibo.app.model.searchliveuser.LiveUser;

/**
 * Created by turbo on 2016/10/28.
 * 搜索页面也是用这个adapter
 */

public class LiveUserAdapter extends BaseQuickAdapter<LiveUser, BaseViewHolder> {


    //自定义一个关注的监听事件
    private LiveUserFollowListner liveUserFollowListner;
    protected int mLastPosition = -1;

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
        if (liveUser.isHasFocus()) {
            ((ToggleButton) viewHolder.getView(R.id.togglebutton_focus)).setToggleOn();
        }
        ((ToggleButton) viewHolder.getView(R.id.togglebutton_focus)).setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                liveUserFollowListner.onFollow(on, liveUser);
            }
        });
        Glide.with(mContext).load(liveUser.getUserIconUrl()).crossFade().into((ImageView) viewHolder.getView(R.id.roundimage_roombackgroud));
        setItemAppearAnimation(viewHolder,viewHolder.getAdapterPosition(), R.anim.anim_bottom_in);
    }
    protected void setItemAppearAnimation(RecyclerView.ViewHolder holder, int position, @AnimRes int type) {
        if (position > mLastPosition/* && !isFooterPosition(position)*/) {
            Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), type);
            holder.itemView.startAnimation(animation);
            mLastPosition = position;
        }
    }
    public interface LiveUserFollowListner {
        public void onFollow(boolean followStatus, LiveUser liveUser);
    }
}
