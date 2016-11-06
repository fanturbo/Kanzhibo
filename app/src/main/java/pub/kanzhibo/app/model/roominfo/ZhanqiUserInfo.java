package pub.kanzhibo.app.model.roominfo;

import java.util.List;
import java.util.Objects;

/**
 * Created by snail on 16/11/5.
 */
public class ZhanqiUserInfo {

    /**
     * code : 0
     * message : OK
     * data : {"id":"88050","uid":"107608889","nickname":"gogoing","gender":"2","avatar":"https://img2.zhanqi.tv/avatar/51/57e/107608889_1472472879.jpg","code":"11500861","domain":"gogoing","url":"/11500861","title":"Gogoing~再换个小目标上个韩服王者！","gameId":"6","spic":"https://img1.zhanqi.tv/live/20161105/88050_ZFHvJ_2016-11-05-23-47-30.jpg","bpic":"https://img2.zhanqi.tv/live/20161105/88050_ZFHvJ_2016-11-05-23-47-30_big.jpg","online":"1285436","status":"4","level":"2","type":"1","liveTime":"1478330020","hotsLevel":"31","videoId":"88050_ZFHvJ","verscr":"0","publishUrl":"wsrtmp","videoIdKey":"88050_ZFHvJ","flashvars":{"Servers":"eyJsb2ciOnsiaXAiOiIxMTMuMzEuODcuODYiLCJwb3J0IjoxNTAwMX0sImxpc3QiOlt7ImlwIjoiMTIwLjI2LjAuMTM4IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo1OSwiaWQiOjU5fSx7ImlwIjoiMTE0LjIxNS4xNDQuMTgyIiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjoyOCwiaWQiOjI4fSx7ImlwIjoiMTIwLjI2LjYzLjE3NiIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6MjEsImlkIjoyMX0seyJpcCI6IjExNS4yOS4xOTQuMTc5IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo5NiwiaWQiOjk2fSx7ImlwIjoiMTIxLjQyLjE0Mi4xNjAiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjI2LCJpZCI6MjZ9LHsiaXAiOiIxMjMuNTYuMTQ1LjkwIiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjozNCwiaWQiOjM0fSx7ImlwIjoiMTEyLjEyNi44NC45MiIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6ODAsImlkIjo4MH0seyJpcCI6IjE4Mi45Mi4xMjguMjQ5IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo2MywiaWQiOjYzfSx7ImlwIjoiMTIxLjQzLjE5Ni43NyIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6NDEsImlkIjo0MX0seyJpcCI6IjExNS4yOC4yMjYuMTMzIiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjoyOSwiaWQiOjI5fSx7ImlwIjoiMTE1LjI5LjI0NS4xNDQiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjc5LCJpZCI6Nzl9LHsiaXAiOiIxMTUuMjkuMjAxLjI1MyIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6ODYsImlkIjo4Nn0seyJpcCI6IjEyMC41NS4xMTYuMjE5IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo5OCwiaWQiOjk4fSx7ImlwIjoiMTEyLjEyNC45LjM5IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjoyMiwiaWQiOjIyfSx7ImlwIjoiMTIzLjU2LjE1Mi4xOTIiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjMyLCJpZCI6MzJ9LHsiaXAiOiIxMjEuNDMuMjMwLjgyIiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjoyNCwiaWQiOjI0fSx7ImlwIjoiMTEyLjEyNC4xOS4yMDMiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjQ2LCJpZCI6NDZ9LHsiaXAiOiIxMTQuMjE1LjExNy42MCIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6MjcsImlkIjoyN30seyJpcCI6IjExNS4yOC4xMzEuMTk3IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo4NCwiaWQiOjg0fSx7ImlwIjoiMTIwLjU1LjcyLjE2NCIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6MTAzLCJpZCI6MTAzfSx7ImlwIjoiMjE4LjI0NC4xMjguNDgiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjc2LCJpZCI6NzZ9LHsiaXAiOiIxMjMuNTcuMjEyLjQ2IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjozMywiaWQiOjMzfSx7ImlwIjoiMTIzLjU2LjE1Mi4xODMiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjMxLCJpZCI6MzF9LHsiaXAiOiIxMTIuMTI0LjYxLjEwNCIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6NDcsImlkIjo0N30seyJpcCI6IjEyMy41Ny40Ni4yMjMiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjgyLCJpZCI6ODJ9LHsiaXAiOiI0Mi45Ni4xNTQuMTI5IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo4NSwiaWQiOjg1fSx7ImlwIjoiMTEyLjEyNC42MS4xMDYiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjQ4LCJpZCI6NDh9LHsiaXAiOiIxMjAuNTUuNzIuMjU0IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo0NCwiaWQiOjQ0fSx7ImlwIjoiMTIwLjI2LjEzLjIxNCIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6NTgsImlkIjo1OH0seyJpcCI6IjExMi4xMjQuMjAuMzQiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjQ1LCJpZCI6NDV9LHsiaXAiOiIxODIuOTIuMjMyLjE5MCIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6OTIsImlkIjo5Mn0seyJpcCI6IjEyMC41NS4xMTcuMTEzIiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo5NywiaWQiOjk3fSx7ImlwIjoiMTEyLjEyNC40NC4yMDUiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjIzLCJpZCI6MjN9LHsiaXAiOiIxMjAuMjYuMTYuMTc2IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo4OSwiaWQiOjg5fSx7ImlwIjoiMTIzLjU2LjQ3LjE1NSIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6ODEsImlkIjo4MX0seyJpcCI6IjExMi4xMjQuMzguMjI5IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo2NCwiaWQiOjY0fSx7ImlwIjoiMTIxLjQzLjE5Ny4xNTIiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjQyLCJpZCI6NDJ9LHsiaXAiOiIxMTIuMTI2Ljg0LjY1IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo4MywiaWQiOjgzfSx7ImlwIjoiMTEyLjEyNC4xMDAuMzYiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjc4LCJpZCI6Nzh9LHsiaXAiOiIxMjAuMjYuMTYuMzgiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjg3LCJpZCI6ODd9LHsiaXAiOiIxMjMuNTYuMTUyLjI1MyIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6NDAsImlkIjo0MH1dfQ==","ServerIp":[],"ServerPort":[],"ChatRoomId":[],"VideoLevels":"eyJzdHJlYW1VcmwiOiJodHRwOlwvXC93c2hscy5jZG4uemhhbnFpLnR2XC96cWxpdmVcLzg4MDUwX1pGSHZKXC9wbGF5bGlzdC5tM3U4In0=","cdns":"eyJ2aWQiOiI4ODA1MF9aRkh2SiIsImJyb2Nhc3QiOiI0IiwiY2RucyI6MTcxLCJhaWRjZG5zIjoiMTcxfDExIiwib3V0Y2RucyI6IjQyIiwiY2Ruc3JhdGUiOiIiLCJhaWRjZG5zcmF0ZSI6IiIsIm91dGNkbnNyYXRlIjoiIiwicGFyYWxsIjpbXSwicmF0ZSI6IjE3MXwxNzEiLCJyZXZpZXciOiIxMyIsImFjYyI6eyJjZG4iOiI3MiIsImFkZCI6IiIsInZ0IjoiIiwicGxhdGZvcm0iOiIwIiwiYXN0IjoiMCIsImFkdCI6IjE6OTB8Mjo2MHw0OjkwfDg6OTB8MTY6OTB8MzI6MzAiLCJjc3QiOiIwIn19","Status":1,"RoomId":88050,"ComLayer":true,"VideoTitle":"Gogoing~再换个小目标上个韩服王者！","WebHost":"http://www.zhanqi.tv","VideoType":"LIVE","GameId":6,"Online":1285436,"pv":"20161103.01","TuristRate":1,"UseStIp":1,"UseLsIp":1,"Oversee2":1,"AutoCdn":1,"Zqad":0},"gameName":"英雄联盟","gameUrl":"/games/lol","gameIcon":"https://img1.zhanqi.tv/uploads/2015/04/gameicon-2015040111221589633.png","gameBpic":"https://img2.zhanqi.tv/uploads/2016/01/gamebpic-2016012516165888583.jpeg","permission":{"fans":true,"guess":true,"replay":true,"multi":true,"shift":true,"video":true,"firework":true},"fansTitle":"小弟","translateLanguages":"","anchorAttr":{"hots":{"level":"31","fight":"17926939","nowLevelStart":"13600000","nextLevelFight":"21600000"}},"follows":1420635,"fans":71,"isStar":{"isWeek":0,"isMonth":0},"bonus":false}
     */

    private int code;
    private String message;
    /**
     * id : 88050
     * uid : 107608889
     * nickname : gogoing
     * gender : 2
     * avatar : https://img2.zhanqi.tv/avatar/51/57e/107608889_1472472879.jpg
     * code : 11500861
     * domain : gogoing
     * url : /11500861
     * title : Gogoing~再换个小目标上个韩服王者！
     * gameId : 6
     * spic : https://img1.zhanqi.tv/live/20161105/88050_ZFHvJ_2016-11-05-23-47-30.jpg
     * bpic : https://img2.zhanqi.tv/live/20161105/88050_ZFHvJ_2016-11-05-23-47-30_big.jpg
     * online : 1285436
     * status : 4
     * level : 2
     * type : 1
     * liveTime : 1478330020
     * hotsLevel : 31
     * videoId : 88050_ZFHvJ
     * verscr : 0
     * publishUrl : wsrtmp
     * videoIdKey : 88050_ZFHvJ
     * flashvars : {"Servers":"eyJsb2ciOnsiaXAiOiIxMTMuMzEuODcuODYiLCJwb3J0IjoxNTAwMX0sImxpc3QiOlt7ImlwIjoiMTIwLjI2LjAuMTM4IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo1OSwiaWQiOjU5fSx7ImlwIjoiMTE0LjIxNS4xNDQuMTgyIiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjoyOCwiaWQiOjI4fSx7ImlwIjoiMTIwLjI2LjYzLjE3NiIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6MjEsImlkIjoyMX0seyJpcCI6IjExNS4yOS4xOTQuMTc5IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo5NiwiaWQiOjk2fSx7ImlwIjoiMTIxLjQyLjE0Mi4xNjAiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjI2LCJpZCI6MjZ9LHsiaXAiOiIxMjMuNTYuMTQ1LjkwIiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjozNCwiaWQiOjM0fSx7ImlwIjoiMTEyLjEyNi44NC45MiIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6ODAsImlkIjo4MH0seyJpcCI6IjE4Mi45Mi4xMjguMjQ5IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo2MywiaWQiOjYzfSx7ImlwIjoiMTIxLjQzLjE5Ni43NyIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6NDEsImlkIjo0MX0seyJpcCI6IjExNS4yOC4yMjYuMTMzIiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjoyOSwiaWQiOjI5fSx7ImlwIjoiMTE1LjI5LjI0NS4xNDQiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjc5LCJpZCI6Nzl9LHsiaXAiOiIxMTUuMjkuMjAxLjI1MyIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6ODYsImlkIjo4Nn0seyJpcCI6IjEyMC41NS4xMTYuMjE5IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo5OCwiaWQiOjk4fSx7ImlwIjoiMTEyLjEyNC45LjM5IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjoyMiwiaWQiOjIyfSx7ImlwIjoiMTIzLjU2LjE1Mi4xOTIiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjMyLCJpZCI6MzJ9LHsiaXAiOiIxMjEuNDMuMjMwLjgyIiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjoyNCwiaWQiOjI0fSx7ImlwIjoiMTEyLjEyNC4xOS4yMDMiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjQ2LCJpZCI6NDZ9LHsiaXAiOiIxMTQuMjE1LjExNy42MCIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6MjcsImlkIjoyN30seyJpcCI6IjExNS4yOC4xMzEuMTk3IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo4NCwiaWQiOjg0fSx7ImlwIjoiMTIwLjU1LjcyLjE2NCIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6MTAzLCJpZCI6MTAzfSx7ImlwIjoiMjE4LjI0NC4xMjguNDgiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjc2LCJpZCI6NzZ9LHsiaXAiOiIxMjMuNTcuMjEyLjQ2IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjozMywiaWQiOjMzfSx7ImlwIjoiMTIzLjU2LjE1Mi4xODMiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjMxLCJpZCI6MzF9LHsiaXAiOiIxMTIuMTI0LjYxLjEwNCIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6NDcsImlkIjo0N30seyJpcCI6IjEyMy41Ny40Ni4yMjMiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjgyLCJpZCI6ODJ9LHsiaXAiOiI0Mi45Ni4xNTQuMTI5IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo4NSwiaWQiOjg1fSx7ImlwIjoiMTEyLjEyNC42MS4xMDYiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjQ4LCJpZCI6NDh9LHsiaXAiOiIxMjAuNTUuNzIuMjU0IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo0NCwiaWQiOjQ0fSx7ImlwIjoiMTIwLjI2LjEzLjIxNCIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6NTgsImlkIjo1OH0seyJpcCI6IjExMi4xMjQuMjAuMzQiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjQ1LCJpZCI6NDV9LHsiaXAiOiIxODIuOTIuMjMyLjE5MCIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6OTIsImlkIjo5Mn0seyJpcCI6IjEyMC41NS4xMTcuMTEzIiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo5NywiaWQiOjk3fSx7ImlwIjoiMTEyLjEyNC40NC4yMDUiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjIzLCJpZCI6MjN9LHsiaXAiOiIxMjAuMjYuMTYuMTc2IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo4OSwiaWQiOjg5fSx7ImlwIjoiMTIzLjU2LjQ3LjE1NSIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6ODEsImlkIjo4MX0seyJpcCI6IjExMi4xMjQuMzguMjI5IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo2NCwiaWQiOjY0fSx7ImlwIjoiMTIxLjQzLjE5Ny4xNTIiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjQyLCJpZCI6NDJ9LHsiaXAiOiIxMTIuMTI2Ljg0LjY1IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo4MywiaWQiOjgzfSx7ImlwIjoiMTEyLjEyNC4xMDAuMzYiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjc4LCJpZCI6Nzh9LHsiaXAiOiIxMjAuMjYuMTYuMzgiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjg3LCJpZCI6ODd9LHsiaXAiOiIxMjMuNTYuMTUyLjI1MyIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6NDAsImlkIjo0MH1dfQ==","ServerIp":[],"ServerPort":[],"ChatRoomId":[],"VideoLevels":"eyJzdHJlYW1VcmwiOiJodHRwOlwvXC93c2hscy5jZG4uemhhbnFpLnR2XC96cWxpdmVcLzg4MDUwX1pGSHZKXC9wbGF5bGlzdC5tM3U4In0=","cdns":"eyJ2aWQiOiI4ODA1MF9aRkh2SiIsImJyb2Nhc3QiOiI0IiwiY2RucyI6MTcxLCJhaWRjZG5zIjoiMTcxfDExIiwib3V0Y2RucyI6IjQyIiwiY2Ruc3JhdGUiOiIiLCJhaWRjZG5zcmF0ZSI6IiIsIm91dGNkbnNyYXRlIjoiIiwicGFyYWxsIjpbXSwicmF0ZSI6IjE3MXwxNzEiLCJyZXZpZXciOiIxMyIsImFjYyI6eyJjZG4iOiI3MiIsImFkZCI6IiIsInZ0IjoiIiwicGxhdGZvcm0iOiIwIiwiYXN0IjoiMCIsImFkdCI6IjE6OTB8Mjo2MHw0OjkwfDg6OTB8MTY6OTB8MzI6MzAiLCJjc3QiOiIwIn19","Status":1,"RoomId":88050,"ComLayer":true,"VideoTitle":"Gogoing~再换个小目标上个韩服王者！","WebHost":"http://www.zhanqi.tv","VideoType":"LIVE","GameId":6,"Online":1285436,"pv":"20161103.01","TuristRate":1,"UseStIp":1,"UseLsIp":1,"Oversee2":1,"AutoCdn":1,"Zqad":0}
     * gameName : 英雄联盟
     * gameUrl : /games/lol
     * gameIcon : https://img1.zhanqi.tv/uploads/2015/04/gameicon-2015040111221589633.png
     * gameBpic : https://img2.zhanqi.tv/uploads/2016/01/gamebpic-2016012516165888583.jpeg
     * permission : {"fans":true,"guess":true,"replay":true,"multi":true,"shift":true,"video":true,"firework":true}
     * fansTitle : 小弟
     * translateLanguages :
     * anchorAttr : {"hots":{"level":"31","fight":"17926939","nowLevelStart":"13600000","nextLevelFight":"21600000"}}
     * follows : 1420635
     * fans : 71
     * isStar : {"isWeek":0,"isMonth":0}
     * bonus : false
     */

    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;
        private String uid;
        private String nickname;
        private String gender;
        private String avatar;
        private String code;
        private String domain;
        private String url;
        private String title;
        private String gameId;
        private String spic;
        private String bpic;
        private String online;
        private String status;
        private String level;
        private String type;
        private String liveTime;
        private String hotsLevel;
        private String videoId;
        private String verscr;
        private String publishUrl;
        private String videoIdKey;
        /**
         * Servers : eyJsb2ciOnsiaXAiOiIxMTMuMzEuODcuODYiLCJwb3J0IjoxNTAwMX0sImxpc3QiOlt7ImlwIjoiMTIwLjI2LjAuMTM4IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo1OSwiaWQiOjU5fSx7ImlwIjoiMTE0LjIxNS4xNDQuMTgyIiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjoyOCwiaWQiOjI4fSx7ImlwIjoiMTIwLjI2LjYzLjE3NiIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6MjEsImlkIjoyMX0seyJpcCI6IjExNS4yOS4xOTQuMTc5IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo5NiwiaWQiOjk2fSx7ImlwIjoiMTIxLjQyLjE0Mi4xNjAiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjI2LCJpZCI6MjZ9LHsiaXAiOiIxMjMuNTYuMTQ1LjkwIiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjozNCwiaWQiOjM0fSx7ImlwIjoiMTEyLjEyNi44NC45MiIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6ODAsImlkIjo4MH0seyJpcCI6IjE4Mi45Mi4xMjguMjQ5IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo2MywiaWQiOjYzfSx7ImlwIjoiMTIxLjQzLjE5Ni43NyIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6NDEsImlkIjo0MX0seyJpcCI6IjExNS4yOC4yMjYuMTMzIiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjoyOSwiaWQiOjI5fSx7ImlwIjoiMTE1LjI5LjI0NS4xNDQiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjc5LCJpZCI6Nzl9LHsiaXAiOiIxMTUuMjkuMjAxLjI1MyIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6ODYsImlkIjo4Nn0seyJpcCI6IjEyMC41NS4xMTYuMjE5IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo5OCwiaWQiOjk4fSx7ImlwIjoiMTEyLjEyNC45LjM5IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjoyMiwiaWQiOjIyfSx7ImlwIjoiMTIzLjU2LjE1Mi4xOTIiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjMyLCJpZCI6MzJ9LHsiaXAiOiIxMjEuNDMuMjMwLjgyIiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjoyNCwiaWQiOjI0fSx7ImlwIjoiMTEyLjEyNC4xOS4yMDMiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjQ2LCJpZCI6NDZ9LHsiaXAiOiIxMTQuMjE1LjExNy42MCIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6MjcsImlkIjoyN30seyJpcCI6IjExNS4yOC4xMzEuMTk3IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo4NCwiaWQiOjg0fSx7ImlwIjoiMTIwLjU1LjcyLjE2NCIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6MTAzLCJpZCI6MTAzfSx7ImlwIjoiMjE4LjI0NC4xMjguNDgiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjc2LCJpZCI6NzZ9LHsiaXAiOiIxMjMuNTcuMjEyLjQ2IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjozMywiaWQiOjMzfSx7ImlwIjoiMTIzLjU2LjE1Mi4xODMiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjMxLCJpZCI6MzF9LHsiaXAiOiIxMTIuMTI0LjYxLjEwNCIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6NDcsImlkIjo0N30seyJpcCI6IjEyMy41Ny40Ni4yMjMiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjgyLCJpZCI6ODJ9LHsiaXAiOiI0Mi45Ni4xNTQuMTI5IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo4NSwiaWQiOjg1fSx7ImlwIjoiMTEyLjEyNC42MS4xMDYiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjQ4LCJpZCI6NDh9LHsiaXAiOiIxMjAuNTUuNzIuMjU0IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo0NCwiaWQiOjQ0fSx7ImlwIjoiMTIwLjI2LjEzLjIxNCIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6NTgsImlkIjo1OH0seyJpcCI6IjExMi4xMjQuMjAuMzQiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjQ1LCJpZCI6NDV9LHsiaXAiOiIxODIuOTIuMjMyLjE5MCIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6OTIsImlkIjo5Mn0seyJpcCI6IjEyMC41NS4xMTcuMTEzIiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo5NywiaWQiOjk3fSx7ImlwIjoiMTEyLjEyNC40NC4yMDUiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjIzLCJpZCI6MjN9LHsiaXAiOiIxMjAuMjYuMTYuMTc2IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo4OSwiaWQiOjg5fSx7ImlwIjoiMTIzLjU2LjQ3LjE1NSIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6ODEsImlkIjo4MX0seyJpcCI6IjExMi4xMjQuMzguMjI5IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo2NCwiaWQiOjY0fSx7ImlwIjoiMTIxLjQzLjE5Ny4xNTIiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjQyLCJpZCI6NDJ9LHsiaXAiOiIxMTIuMTI2Ljg0LjY1IiwicG9ydCI6MTUwMTAsImNoYXRyb29tX2lkIjo4MywiaWQiOjgzfSx7ImlwIjoiMTEyLjEyNC4xMDAuMzYiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjc4LCJpZCI6Nzh9LHsiaXAiOiIxMjAuMjYuMTYuMzgiLCJwb3J0IjoxNTAxMCwiY2hhdHJvb21faWQiOjg3LCJpZCI6ODd9LHsiaXAiOiIxMjMuNTYuMTUyLjI1MyIsInBvcnQiOjE1MDEwLCJjaGF0cm9vbV9pZCI6NDAsImlkIjo0MH1dfQ==
         * ServerIp : []
         * ServerPort : []
         * ChatRoomId : []
         * VideoLevels : eyJzdHJlYW1VcmwiOiJodHRwOlwvXC93c2hscy5jZG4uemhhbnFpLnR2XC96cWxpdmVcLzg4MDUwX1pGSHZKXC9wbGF5bGlzdC5tM3U4In0=
         * cdns : eyJ2aWQiOiI4ODA1MF9aRkh2SiIsImJyb2Nhc3QiOiI0IiwiY2RucyI6MTcxLCJhaWRjZG5zIjoiMTcxfDExIiwib3V0Y2RucyI6IjQyIiwiY2Ruc3JhdGUiOiIiLCJhaWRjZG5zcmF0ZSI6IiIsIm91dGNkbnNyYXRlIjoiIiwicGFyYWxsIjpbXSwicmF0ZSI6IjE3MXwxNzEiLCJyZXZpZXciOiIxMyIsImFjYyI6eyJjZG4iOiI3MiIsImFkZCI6IiIsInZ0IjoiIiwicGxhdGZvcm0iOiIwIiwiYXN0IjoiMCIsImFkdCI6IjE6OTB8Mjo2MHw0OjkwfDg6OTB8MTY6OTB8MzI6MzAiLCJjc3QiOiIwIn19
         * Status : 1
         * RoomId : 88050
         * ComLayer : true
         * VideoTitle : Gogoing~再换个小目标上个韩服王者！
         * WebHost : http://www.zhanqi.tv
         * VideoType : LIVE
         * GameId : 6
         * Online : 1285436
         * pv : 20161103.01
         * TuristRate : 1
         * UseStIp : 1
         * UseLsIp : 1
         * Oversee2 : 1
         * AutoCdn : 1
         * Zqad : 0
         */

        private FlashvarsBean flashvars;
        private String gameName;
        private String gameUrl;
        private String gameIcon;
        private String gameBpic;
        /**
         * fans : true
         * guess : true
         * replay : true
         * multi : true
         * shift : true
         * video : true
         * firework : true
         */

        private PermissionBean permission;
        private String fansTitle;
        private String translateLanguages;
        /**
         * hots : {"level":"31","fight":"17926939","nowLevelStart":"13600000","nextLevelFight":"21600000"}
         */

        private AnchorAttrBean anchorAttr;
        private Object follows;
        private int fans;
        /**
         * isWeek : 0
         * isMonth : 0
         */

        private IsStarBean isStar;
        private boolean bonus;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getGameId() {
            return gameId;
        }

        public void setGameId(String gameId) {
            this.gameId = gameId;
        }

        public String getSpic() {
            return spic;
        }

        public void setSpic(String spic) {
            this.spic = spic;
        }

        public String getBpic() {
            return bpic;
        }

        public void setBpic(String bpic) {
            this.bpic = bpic;
        }

        public String getOnline() {
            return online;
        }

        public void setOnline(String online) {
            this.online = online;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLiveTime() {
            return liveTime;
        }

        public void setLiveTime(String liveTime) {
            this.liveTime = liveTime;
        }

        public String getHotsLevel() {
            return hotsLevel;
        }

        public void setHotsLevel(String hotsLevel) {
            this.hotsLevel = hotsLevel;
        }

        public String getVideoId() {
            return videoId;
        }

        public void setVideoId(String videoId) {
            this.videoId = videoId;
        }

        public String getVerscr() {
            return verscr;
        }

        public void setVerscr(String verscr) {
            this.verscr = verscr;
        }

        public String getPublishUrl() {
            return publishUrl;
        }

        public void setPublishUrl(String publishUrl) {
            this.publishUrl = publishUrl;
        }

        public String getVideoIdKey() {
            return videoIdKey;
        }

        public void setVideoIdKey(String videoIdKey) {
            this.videoIdKey = videoIdKey;
        }

        public FlashvarsBean getFlashvars() {
            return flashvars;
        }

        public void setFlashvars(FlashvarsBean flashvars) {
            this.flashvars = flashvars;
        }

        public String getGameName() {
            return gameName;
        }

        public void setGameName(String gameName) {
            this.gameName = gameName;
        }

        public String getGameUrl() {
            return gameUrl;
        }

        public void setGameUrl(String gameUrl) {
            this.gameUrl = gameUrl;
        }

        public String getGameIcon() {
            return gameIcon;
        }

        public void setGameIcon(String gameIcon) {
            this.gameIcon = gameIcon;
        }

        public String getGameBpic() {
            return gameBpic;
        }

        public void setGameBpic(String gameBpic) {
            this.gameBpic = gameBpic;
        }

        public PermissionBean getPermission() {
            return permission;
        }

        public void setPermission(PermissionBean permission) {
            this.permission = permission;
        }

        public String getFansTitle() {
            return fansTitle;
        }

        public void setFansTitle(String fansTitle) {
            this.fansTitle = fansTitle;
        }

        public String getTranslateLanguages() {
            return translateLanguages;
        }

        public void setTranslateLanguages(String translateLanguages) {
            this.translateLanguages = translateLanguages;
        }

        public AnchorAttrBean getAnchorAttr() {
            return anchorAttr;
        }

        public void setAnchorAttr(AnchorAttrBean anchorAttr) {
            this.anchorAttr = anchorAttr;
        }

        public Object getFollows() {
            return follows;
        }

        public void setFollows(Object follows) {
            this.follows = follows;
        }

        public int getFans() {
            return fans;
        }

        public void setFans(int fans) {
            this.fans = fans;
        }

        public IsStarBean getIsStar() {
            return isStar;
        }

        public void setIsStar(IsStarBean isStar) {
            this.isStar = isStar;
        }

        public boolean isBonus() {
            return bonus;
        }

        public void setBonus(boolean bonus) {
            this.bonus = bonus;
        }

        public static class FlashvarsBean {
            private String Servers;
            private String VideoLevels;
            private String cdns;
            private int Status;
            private int RoomId;
            private boolean ComLayer;
            private String VideoTitle;
            private String WebHost;
            private String VideoType;
            private int GameId;
            private int Online;
            private String pv;
            private int TuristRate;
            private int UseStIp;
            private int UseLsIp;
            private int Oversee2;
            private int AutoCdn;
            private int Zqad;
            private List<?> ServerIp;
            private List<?> ServerPort;
            private List<?> ChatRoomId;

            public String getServers() {
                return Servers;
            }

            public void setServers(String Servers) {
                this.Servers = Servers;
            }

            public String getVideoLevels() {
                return VideoLevels;
            }

            public void setVideoLevels(String VideoLevels) {
                this.VideoLevels = VideoLevels;
            }

            public String getCdns() {
                return cdns;
            }

            public void setCdns(String cdns) {
                this.cdns = cdns;
            }

            public int getStatus() {
                return Status;
            }

            public void setStatus(int Status) {
                this.Status = Status;
            }

            public int getRoomId() {
                return RoomId;
            }

            public void setRoomId(int RoomId) {
                this.RoomId = RoomId;
            }

            public boolean isComLayer() {
                return ComLayer;
            }

            public void setComLayer(boolean ComLayer) {
                this.ComLayer = ComLayer;
            }

            public String getVideoTitle() {
                return VideoTitle;
            }

            public void setVideoTitle(String VideoTitle) {
                this.VideoTitle = VideoTitle;
            }

            public String getWebHost() {
                return WebHost;
            }

            public void setWebHost(String WebHost) {
                this.WebHost = WebHost;
            }

            public String getVideoType() {
                return VideoType;
            }

            public void setVideoType(String VideoType) {
                this.VideoType = VideoType;
            }

            public int getGameId() {
                return GameId;
            }

            public void setGameId(int GameId) {
                this.GameId = GameId;
            }

            public int getOnline() {
                return Online;
            }

            public void setOnline(int Online) {
                this.Online = Online;
            }

            public String getPv() {
                return pv;
            }

            public void setPv(String pv) {
                this.pv = pv;
            }

            public int getTuristRate() {
                return TuristRate;
            }

            public void setTuristRate(int TuristRate) {
                this.TuristRate = TuristRate;
            }

            public int getUseStIp() {
                return UseStIp;
            }

            public void setUseStIp(int UseStIp) {
                this.UseStIp = UseStIp;
            }

            public int getUseLsIp() {
                return UseLsIp;
            }

            public void setUseLsIp(int UseLsIp) {
                this.UseLsIp = UseLsIp;
            }

            public int getOversee2() {
                return Oversee2;
            }

            public void setOversee2(int Oversee2) {
                this.Oversee2 = Oversee2;
            }

            public int getAutoCdn() {
                return AutoCdn;
            }

            public void setAutoCdn(int AutoCdn) {
                this.AutoCdn = AutoCdn;
            }

            public int getZqad() {
                return Zqad;
            }

            public void setZqad(int Zqad) {
                this.Zqad = Zqad;
            }

            public List<?> getServerIp() {
                return ServerIp;
            }

            public void setServerIp(List<?> ServerIp) {
                this.ServerIp = ServerIp;
            }

            public List<?> getServerPort() {
                return ServerPort;
            }

            public void setServerPort(List<?> ServerPort) {
                this.ServerPort = ServerPort;
            }

            public List<?> getChatRoomId() {
                return ChatRoomId;
            }

            public void setChatRoomId(List<?> ChatRoomId) {
                this.ChatRoomId = ChatRoomId;
            }
        }

        public static class PermissionBean {
            private boolean fans;
            private boolean guess;
            private boolean replay;
            private boolean multi;
            private boolean shift;
            private boolean video;
            private boolean firework;

            public boolean isFans() {
                return fans;
            }

            public void setFans(boolean fans) {
                this.fans = fans;
            }

            public boolean isGuess() {
                return guess;
            }

            public void setGuess(boolean guess) {
                this.guess = guess;
            }

            public boolean isReplay() {
                return replay;
            }

            public void setReplay(boolean replay) {
                this.replay = replay;
            }

            public boolean isMulti() {
                return multi;
            }

            public void setMulti(boolean multi) {
                this.multi = multi;
            }

            public boolean isShift() {
                return shift;
            }

            public void setShift(boolean shift) {
                this.shift = shift;
            }

            public boolean isVideo() {
                return video;
            }

            public void setVideo(boolean video) {
                this.video = video;
            }

            public boolean isFirework() {
                return firework;
            }

            public void setFirework(boolean firework) {
                this.firework = firework;
            }
        }

        public static class AnchorAttrBean {
            /**
             * level : 31
             * fight : 17926939
             * nowLevelStart : 13600000
             * nextLevelFight : 21600000
             */

            private HotsBean hots;

            public HotsBean getHots() {
                return hots;
            }

            public void setHots(HotsBean hots) {
                this.hots = hots;
            }

            public static class HotsBean {
                private String level;
                private String fight;
                private String nowLevelStart;
                private String nextLevelFight;

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public String getFight() {
                    return fight;
                }

                public void setFight(String fight) {
                    this.fight = fight;
                }

                public String getNowLevelStart() {
                    return nowLevelStart;
                }

                public void setNowLevelStart(String nowLevelStart) {
                    this.nowLevelStart = nowLevelStart;
                }

                public String getNextLevelFight() {
                    return nextLevelFight;
                }

                public void setNextLevelFight(String nextLevelFight) {
                    this.nextLevelFight = nextLevelFight;
                }
            }
        }

        public static class IsStarBean {
            private int isWeek;
            private int isMonth;

            public int getIsWeek() {
                return isWeek;
            }

            public void setIsWeek(int isWeek) {
                this.isWeek = isWeek;
            }

            public int getIsMonth() {
                return isMonth;
            }

            public void setIsMonth(int isMonth) {
                this.isMonth = isMonth;
            }
        }
    }
}
