package pub.kanzhibo.app.model;

import java.util.List;

import pub.kanzhibo.app.model.event.DouyuFollowLiveData;

/**
 * Created by snail on 16/12/19.
 */
public class FollowLive {


    /*{
        "error": 903,
            "data": "登录信息已过期，请重新登录"
    }*/
    /**
     * error : 0
     * data : [{"id":"122024","room_id":"122024","room_src":"https://rpic.douyucdn.cn/a1612/19/22/122024_161219223618.jpg","vertical_src":"https://rpic.douyucdn.cn/a1612/19/22/122024_161219223618.jpg","isVertical":0,"cate_id":"55","nickname":"大帝LioN","show_status":"1","owner_uid":"3781256","name":"LioN大帝~非主流猥琐上岛~NEW！","game_tag_id":"55","game_tag_name":"魔兽争霸","owner":"大帝LioN","owner_avatar_small":"https://apic.douyucdn.cn/upload/avatar/face/201605/10/360701b4c49070888234591356fa1b49_small.jpg?rltime","owner_avatar_middle":"https://apic.douyucdn.cn/upload/avatar/face/201605/10/360701b4c49070888234591356fa1b49_middle.jpg?rltime","owner_avatar_big":"https://apic.douyucdn.cn/upload/avatar/face/201605/10/360701b4c49070888234591356fa1b49_big.jpg?rltime","remind_status":"1","live_status":"99","online":10602,"show_time":"1482077407","fans":"124695","ranktype":0}]
     */

    private int error;
    /**
     * id : 122024
     * room_id : 122024
     * room_src : https://rpic.douyucdn.cn/a1612/19/22/122024_161219223618.jpg
     * vertical_src : https://rpic.douyucdn.cn/a1612/19/22/122024_161219223618.jpg
     * isVertical : 0
     * cate_id : 55
     * nickname : 大帝LioN
     * show_status : 1
     * owner_uid : 3781256
     * name : LioN大帝~非主流猥琐上岛~NEW！
     * game_tag_id : 55
     * game_tag_name : 魔兽争霸
     * owner : 大帝LioN
     * owner_avatar_small : https://apic.douyucdn.cn/upload/avatar/face/201605/10/360701b4c49070888234591356fa1b49_small.jpg?rltime
     * owner_avatar_middle : https://apic.douyucdn.cn/upload/avatar/face/201605/10/360701b4c49070888234591356fa1b49_middle.jpg?rltime
     * owner_avatar_big : https://apic.douyucdn.cn/upload/avatar/face/201605/10/360701b4c49070888234591356fa1b49_big.jpg?rltime
     * remind_status : 1
     * live_status : 99
     * online : 10602
     * show_time : 1482077407
     * fans : 124695
     * ranktype : 0
     */

    private List<DouyuFollowLiveData> data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public List<DouyuFollowLiveData> getData() {
        return data;
    }

    public void setData(List<DouyuFollowLiveData> data) {
        this.data = data;
    }
}
