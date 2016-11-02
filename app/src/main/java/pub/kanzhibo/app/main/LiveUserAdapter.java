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
import com.sdsmdg.tastytoast.TastyToast;

import java.util.Arrays;
import java.util.List;

import pub.kanzhibo.app.R;
import pub.kanzhibo.app.common.widget.ToggleButton;
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


    private ToggleButton.OnToggleChanged onToggleChangedListernr;

    public LiveUserAdapter(List<LiveUser> data) {
        super(R.layout.item_fragment_live_user, data);
    }

    public ToggleButton.OnToggleChanged getOnToggleChangedListernr() {
        return onToggleChangedListernr;
    }

    public void setOnToggleChangedListernr(ToggleButton.OnToggleChanged onToggleChangedListernr) {
        this.onToggleChangedListernr = onToggleChangedListernr;
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, LiveUser liveUser) {
        //如果需要获取position viewHolder.getLayoutPosition()
        viewHolder.setText(R.id.tv_username, liveUser.getUserName())
                .setText(R.id.tv_roomtitle, liveUser.getRoomTitle())
                .setText(R.id.tv_viewercount, liveUser.getViewersCount())
                .setText(R.id.tv_live_status, liveUser.getStatus());

        ((ToggleButton) viewHolder.getView(R.id.togglebutton_focus)).setOnToggleChanged(onToggleChangedListernr);
        Glide.with(mContext).load(liveUser.getUserIconUrl()).crossFade().into((ImageView) viewHolder.getView(R.id.roundimage_roombackgroud));
    }
}
