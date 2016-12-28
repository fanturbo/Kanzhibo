package pub.kanzhibo.app.douyu;

import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import pub.kanzhibo.app.R;
import pub.kanzhibo.app.model.FollowLive;
import pub.kanzhibo.app.model.event.DouyuFollowLiveData;


/**
 * Created by turbo on 2016/12/26.
 */

public class FollowUserAdapter extends BaseQuickAdapter<DouyuFollowLiveData, BaseViewHolder> {
    public FollowUserAdapter(int layoutResId, List<DouyuFollowLiveData> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, DouyuFollowLiveData dataBean) {
        baseViewHolder.setText(R.id.tv_nickname, dataBean.getNickname())
                .setText(R.id.tv_roomname, dataBean.getName());
        final FrameLayout frameRoomSrc = (FrameLayout) baseViewHolder.getConvertView().findViewById(R.id.frame_room_src);
        SimpleTarget target = new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(Drawable resource, GlideAnimation glideAnimation) {
                frameRoomSrc.setBackground(resource);
            }
        };
        Glide.with(mContext).load(dataBean.getRoom_src()).into(target);
    }
}
