package pub.kanzhibo.app.model.searchliveuser;

import java.util.List;

/**
 * Created by turbo on 2016/10/28.
 */

public class LiveUserQuanmin {

    /**
     * code : 200
     * data : {"items":[{"category_name":"颜值控","thumb":"http://image.quanmin.tv/love/e53297d66dcfce8e220ed734463302edjpg?imageView2/2/w/500/","screen":1,"avatar":"http://image.quanmin.tv/avatar/12fa781d0ff940ec002f8ce88d6cbe5e?imageView2/2/w/300/","title":"微小笑Lyn的直播间","is_shield":false,"nick":"微小笑Lyn","uid":7137953,"view":"757","category_id":29,"slug":"","category_slug":"love","play_status":false},{"category_name":"魔兽争霸3","thumb":"http://snap.quanmin.tv/3825020-1477842122-827.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/e226781079118d09220bb69292a24374jpg?imageView2/2/w/300/","title":"今晚打 天梯，看gold league","is_shield":false,"nick":"LYN朴俊","uid":3825020,"view":"6","category_id":19,"slug":"lyn","category_slug":"war3","play_status":false},{"category_name":"魔兽争霸3","thumb":"","screen":0,"avatar":"","title":"LYN精彩比赛集锦","is_shield":false,"nick":"Lyn_K01","uid":5540683,"view":"2","category_id":19,"slug":"","category_slug":"war3","play_status":false}],"total":3,"pageNb":1}
     */

    private int code;
    /**
     * items : [{"category_name":"颜值控","thumb":"http://image.quanmin.tv/love/e53297d66dcfce8e220ed734463302edjpg?imageView2/2/w/500/","screen":1,"avatar":"http://image.quanmin.tv/avatar/12fa781d0ff940ec002f8ce88d6cbe5e?imageView2/2/w/300/","title":"微小笑Lyn的直播间","is_shield":false,"nick":"微小笑Lyn","uid":7137953,"view":"757","category_id":29,"slug":"","category_slug":"love","play_status":false},{"category_name":"魔兽争霸3","thumb":"http://snap.quanmin.tv/3825020-1477842122-827.jpg?imageView2/2/w/390/","screen":0,"avatar":"http://image.quanmin.tv/avatar/e226781079118d09220bb69292a24374jpg?imageView2/2/w/300/","title":"今晚打 天梯，看gold league","is_shield":false,"nick":"LYN朴俊","uid":3825020,"view":"6","category_id":19,"slug":"lyn","category_slug":"war3","play_status":false},{"category_name":"魔兽争霸3","thumb":"","screen":0,"avatar":"","title":"LYN精彩比赛集锦","is_shield":false,"nick":"Lyn_K01","uid":5540683,"view":"2","category_id":19,"slug":"","category_slug":"war3","play_status":false}]
     * total : 3
     * pageNb : 1
     */

    private DataEntity data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        private int total;
        private int pageNb;
        /**
         * category_name : 颜值控
         * thumb : http://image.quanmin.tv/love/e53297d66dcfce8e220ed734463302edjpg?imageView2/2/w/500/
         * screen : 1
         * avatar : http://image.quanmin.tv/avatar/12fa781d0ff940ec002f8ce88d6cbe5e?imageView2/2/w/300/
         * title : 微小笑Lyn的直播间
         * is_shield : false
         * nick : 微小笑Lyn
         * uid : 7137953
         * view : 757
         * category_id : 29
         * slug :
         * category_slug : love
         * play_status : false
         */

        private List<ItemsEntity> items;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPageNb() {
            return pageNb;
        }

        public void setPageNb(int pageNb) {
            this.pageNb = pageNb;
        }

        public List<ItemsEntity> getItems() {
            return items;
        }

        public void setItems(List<ItemsEntity> items) {
            this.items = items;
        }

        public static class ItemsEntity {
            private String category_name;
            private String thumb;//当前直播截图
            private int screen;
            private String avatar;//个人头像
            private String title;//房间名字
            private boolean is_shield;
            private String nick;//昵称
            private int uid;
            private String view;
            private int category_id;
            private String slug;
            private String category_slug;
            private boolean play_status;//是否在线

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public int getScreen() {
                return screen;
            }

            public void setScreen(int screen) {
                this.screen = screen;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public boolean isIs_shield() {
                return is_shield;
            }

            public void setIs_shield(boolean is_shield) {
                this.is_shield = is_shield;
            }

            public String getNick() {
                return nick;
            }

            public void setNick(String nick) {
                this.nick = nick;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getView() {
                return view;
            }

            public void setView(String view) {
                this.view = view;
            }

            public int getCategory_id() {
                return category_id;
            }

            public void setCategory_id(int category_id) {
                this.category_id = category_id;
            }

            public String getSlug() {
                return slug;
            }

            public void setSlug(String slug) {
                this.slug = slug;
            }

            public String getCategory_slug() {
                return category_slug;
            }

            public void setCategory_slug(String category_slug) {
                this.category_slug = category_slug;
            }

            public boolean isPlay_status() {
                return play_status;
            }

            public void setPlay_status(boolean play_status) {
                this.play_status = play_status;
            }
        }
    }
}
