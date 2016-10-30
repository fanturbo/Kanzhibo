package pub.kanzhibo.app.model.liveuser;

/**
 * Created by turbo on 2016/10/28.
 *  正在播放的
 */

public class UserHuyaPlay {

    /**
     * aid : 23865881
     * gameLiveOn : false
     * game_activityCount : 3139231
     * game_avatarUrl180 : http://huyaimg.dwstatic.com/avatar/1083/32/a922f67d41235e26b57daef0b043f5_180_135.jpg
     * game_avatarUrl52 : http://huyaimg.dwstatic.com/avatar/1083/32/a922f67d41235e26b57daef0b043f5_180_135.jpg
     * game_channel : 78941969
     * game_liveLink : http://www.huya.com/miss
     * game_longChannel : 78941969
     * game_nick : Miss大小姐
     * game_profileLink : http://www.huya.com/miss/home
     * game_recommendStatus : 4
     * game_subChannel : 2502884626
     * screen_type : 0
     * uid : 1466346678
     */

    private int aid;
    private boolean gameLiveOn;
    private int game_activityCount;
    private String game_avatarUrl180;
    private String game_avatarUrl52;
    private int game_channel;
    private String game_liveLink;
    private int game_longChannel;
    private String game_nick;
    private String game_profileLink;
    private int game_recommendStatus;
    private long game_subChannel;
    private int screen_type;
    private int uid;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public boolean isGameLiveOn() {
        return gameLiveOn;
    }

    public void setGameLiveOn(boolean gameLiveOn) {
        this.gameLiveOn = gameLiveOn;
    }

    public int getGame_activityCount() {
        return game_activityCount;
    }

    public void setGame_activityCount(int game_activityCount) {
        this.game_activityCount = game_activityCount;
    }

    public String getGame_avatarUrl180() {
        return game_avatarUrl180;
    }

    public void setGame_avatarUrl180(String game_avatarUrl180) {
        this.game_avatarUrl180 = game_avatarUrl180;
    }

    public String getGame_avatarUrl52() {
        return game_avatarUrl52;
    }

    public void setGame_avatarUrl52(String game_avatarUrl52) {
        this.game_avatarUrl52 = game_avatarUrl52;
    }

    public int getGame_channel() {
        return game_channel;
    }

    public void setGame_channel(int game_channel) {
        this.game_channel = game_channel;
    }

    public String getGame_liveLink() {
        return game_liveLink;
    }

    public void setGame_liveLink(String game_liveLink) {
        this.game_liveLink = game_liveLink;
    }

    public int getGame_longChannel() {
        return game_longChannel;
    }

    public void setGame_longChannel(int game_longChannel) {
        this.game_longChannel = game_longChannel;
    }

    public String getGame_nick() {
        return game_nick;
    }

    public void setGame_nick(String game_nick) {
        this.game_nick = game_nick;
    }

    public String getGame_profileLink() {
        return game_profileLink;
    }

    public void setGame_profileLink(String game_profileLink) {
        this.game_profileLink = game_profileLink;
    }

    public int getGame_recommendStatus() {
        return game_recommendStatus;
    }

    public void setGame_recommendStatus(int game_recommendStatus) {
        this.game_recommendStatus = game_recommendStatus;
    }

    public long getGame_subChannel() {
        return game_subChannel;
    }

    public void setGame_subChannel(long game_subChannel) {
        this.game_subChannel = game_subChannel;
    }

    public int getScreen_type() {
        return screen_type;
    }

    public void setScreen_type(int screen_type) {
        this.screen_type = screen_type;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
