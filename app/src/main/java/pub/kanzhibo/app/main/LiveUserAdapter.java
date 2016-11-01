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

/**
 * Created by turbo on 2016/10/28.
 */

public class LiveUserAdapter extends BaseQuickAdapter<LiveUser, BaseViewHolder> {

    public LiveUserAdapter(List<LiveUser> data) {
        super(R.layout.item_fragment_live_user, data);
    }

    @Override
    protected void convert(BaseViewHolder viewHolder, LiveUser liveUser) {
        //如果需要获取position viewHolder.getLayoutPosition()
        viewHolder.setText(R.id.tv_username, liveUser.getUserName())
                .setText(R.id.tv_roomtitle, liveUser.getRoomTitle())
                .setText(R.id.tv_viewercount, liveUser.getViewersCount())
                .setText(R.id.tv_live_status, liveUser.getStatus());

        ((ToggleButton) viewHolder.getView(R.id.togglebutton_focus)).setOnToggleChanged(new ToggleButton.OnToggleChanged() {
            @Override
            public void onToggle(boolean on) {
                //todo待完成
                SharedPreferencesUtils.saveBoolean(mContext, "saveDataLocal", true);
                String[] strings = {"只保存到本地", "保存到服务器"};
                DialogHelp.getSingleChoiceDialog(mContext, "选择保存方式", strings, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        TastyToast.makeText(mContext, "i = " + i, 0, 1);
                        SharedPreferencesUtils.saveBoolean(mContext, "saveDataLocal", true);
                    }
                }).show();
            }
        });
        Glide.with(mContext).load(liveUser.getUserIconUrl()).crossFade().into((ImageView) viewHolder.getView(R.id.roundimage_roombackgroud));

    }
}
