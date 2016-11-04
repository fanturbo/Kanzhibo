package pub.kanzhibo.app.model.searchliveuser;

/**
 * Created by snail on 16/10/30.
 * 正在直播的
 */
public class UserHuyaLive {

    /**
     * aid : 7186418
     * gameId : 1
     * gameName : 英雄联盟
     * game_channel : 99425467
     * game_imgUrl : http://huyaimg.dwstatic.com/avatar/1029/21/77aed1c053f4a4938ffaf9b618aa06_180_135.jpg?1385633936
     * game_introduction : 西门剑姬屠杀白金段
     * game_nick : 正恒丶西门
     * game_privateHost : ximen
     * game_roomName : ┊西　门 ¨18-23点直播 新浪微博:西门电竞孔子”
     * game_screenshot : http://screenshot.dwstatic.com/yysnapshot/a781a5d8e5defda753c442706cb77905dcbb53ea
     * game_shortChannel : 90010
     * game_subChannel : 2330849298
     * game_total_count : 265557
     * liveSourceType : 0
     * screen_type : 0
     */

    private int aid;
    private int gameId;
    private String gameName;
    private int game_channel;
    private String game_imgUrl;
    private String game_introduction;
    private String game_nick;
    private String game_privateHost;
    private String game_roomName;
    private String game_screenshot;
    private int game_shortChannel;
    private long game_subChannel;
    private int game_total_count;
    private String liveSourceType;
    private int screen_type;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getGame_channel() {
        return game_channel;
    }

    public void setGame_channel(int game_channel) {
        this.game_channel = game_channel;
    }

    public String getGame_imgUrl() {
        return game_imgUrl;
    }

    public void setGame_imgUrl(String game_imgUrl) {
        this.game_imgUrl = game_imgUrl;
    }

    public String getGame_introduction() {
        return game_introduction;
    }

    public void setGame_introduction(String game_introduction) {
        this.game_introduction = game_introduction;
    }

    public String getGame_nick() {
        return game_nick;
    }

    public void setGame_nick(String game_nick) {
        this.game_nick = game_nick;
    }

    public String getGame_privateHost() {
        return game_privateHost;
    }

    public void setGame_privateHost(String game_privateHost) {
        this.game_privateHost = game_privateHost;
    }

    public String getGame_roomName() {
        return game_roomName;
    }

    public void setGame_roomName(String game_roomName) {
        this.game_roomName = game_roomName;
    }

    public String getGame_screenshot() {
        return game_screenshot;
    }

    public void setGame_screenshot(String game_screenshot) {
        this.game_screenshot = game_screenshot;
    }

    public int getGame_shortChannel() {
        return game_shortChannel;
    }

    public void setGame_shortChannel(int game_shortChannel) {
        this.game_shortChannel = game_shortChannel;
    }

    public long getGame_subChannel() {
        return game_subChannel;
    }

    public void setGame_subChannel(long game_subChannel) {
        this.game_subChannel = game_subChannel;
    }

    public int getGame_total_count() {
        return game_total_count;
    }

    public void setGame_total_count(int game_total_count) {
        this.game_total_count = game_total_count;
    }

    public String getLiveSourceType() {
        return liveSourceType;
    }

    public void setLiveSourceType(String liveSourceType) {
        this.liveSourceType = liveSourceType;
    }

    public int getScreen_type() {
        return screen_type;
    }

    public void setScreen_type(int screen_type) {
        this.screen_type = screen_type;
    }
}
