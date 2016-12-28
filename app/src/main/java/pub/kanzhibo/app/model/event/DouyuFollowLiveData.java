package pub.kanzhibo.app.model.event;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by snail on 16/12/28.
 */
public class DouyuFollowLiveData extends RealmObject{
    @PrimaryKey
    private String id;
    private String room_id;
    private String room_src;
    private String vertical_src;
    private int isVertical;
    private String cate_id;
    private String nickname;
    private String show_status;
    private String owner_uid;
    private String name;
    private String game_tag_id;
    private String game_tag_name;
    private String owner;
    private String owner_avatar_small;
    private String owner_avatar_middle;
    private String owner_avatar_big;
    private String remind_status;
    private String live_status;
    private int online;
    private String show_time;
    private String fans;
    private int ranktype;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getRoom_src() {
        return room_src;
    }

    public void setRoom_src(String room_src) {
        this.room_src = room_src;
    }

    public String getVertical_src() {
        return vertical_src;
    }

    public void setVertical_src(String vertical_src) {
        this.vertical_src = vertical_src;
    }

    public int getIsVertical() {
        return isVertical;
    }

    public void setIsVertical(int isVertical) {
        this.isVertical = isVertical;
    }

    public String getCate_id() {
        return cate_id;
    }

    public void setCate_id(String cate_id) {
        this.cate_id = cate_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getShow_status() {
        return show_status;
    }

    public void setShow_status(String show_status) {
        this.show_status = show_status;
    }

    public String getOwner_uid() {
        return owner_uid;
    }

    public void setOwner_uid(String owner_uid) {
        this.owner_uid = owner_uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGame_tag_id() {
        return game_tag_id;
    }

    public void setGame_tag_id(String game_tag_id) {
        this.game_tag_id = game_tag_id;
    }

    public String getGame_tag_name() {
        return game_tag_name;
    }

    public void setGame_tag_name(String game_tag_name) {
        this.game_tag_name = game_tag_name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner_avatar_small() {
        return owner_avatar_small;
    }

    public void setOwner_avatar_small(String owner_avatar_small) {
        this.owner_avatar_small = owner_avatar_small;
    }

    public String getOwner_avatar_middle() {
        return owner_avatar_middle;
    }

    public void setOwner_avatar_middle(String owner_avatar_middle) {
        this.owner_avatar_middle = owner_avatar_middle;
    }

    public String getOwner_avatar_big() {
        return owner_avatar_big;
    }

    public void setOwner_avatar_big(String owner_avatar_big) {
        this.owner_avatar_big = owner_avatar_big;
    }

    public String getRemind_status() {
        return remind_status;
    }

    public void setRemind_status(String remind_status) {
        this.remind_status = remind_status;
    }

    public String getLive_status() {
        return live_status;
    }

    public void setLive_status(String live_status) {
        this.live_status = live_status;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public String getShow_time() {
        return show_time;
    }

    public void setShow_time(String show_time) {
        this.show_time = show_time;
    }

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public int getRanktype() {
        return ranktype;
    }

    public void setRanktype(int ranktype) {
        this.ranktype = ranktype;
    }
}
