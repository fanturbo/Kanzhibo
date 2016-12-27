package pub.kanzhibo.app.model;

/**
 * Created by snail on 16/12/19.
 */
public class UserInfo {

    /**
     * error : 0
     * data : {"uid":"63369167","username":"63369167","nickname":"war3bbs","email":false,"qq":"","mobile_phone":"","phone_status":"0","email_status":"0","lastlogin":"1481896016","avatar":{"small":"http://apic.douyucdn.cn/upload/avatar/default/09_small.jpg?rltime","middle":"http://apic.douyucdn.cn/upload/avatar/default/09_middle.jpg?rltime","big":"http://apic.douyucdn.cn/upload/avatar/default/09_big.jpg?rltime"},"has_room":"0","groupid":"1","is_own_room":"0","location":{"province":"","city":""},"sex":"0","birthday":"0","gold1":"0","score":"0","level":{"current":{"lv":1,"pic":"user1.gif","mpic":"cn01.png","name":"菜鸟","pic_url":"https://staticlive.douyucdn.cn/common/douyu/images/classimg/user1.gif?v=v66254","score":0},"next":{"lv":2,"pic":"user2.gif","mpic":"brass05.png","name":"黄铜5","pic_url":"https://staticlive.douyucdn.cn/common/douyu/images/classimg/user2.gif?v=v66254","score":100}},"userlevel":{"cur_score":0,"next_level_score":10,"lv":1,"is_full":0},"follow":"10","ios_gold_switch":1,"gold":"0.0","ident_status":"0","token":"63369167_bb889775f9574666","token_exp":1483022058}
     */

    private int error;
    /**
     * uid : 63369167
     * username : 63369167
     * nickname : war3bbs
     * email : false
     * qq :
     * mobile_phone :
     * phone_status : 0
     * email_status : 0
     * lastlogin : 1481896016
     * avatar : {"small":"http://apic.douyucdn.cn/upload/avatar/default/09_small.jpg?rltime","middle":"http://apic.douyucdn.cn/upload/avatar/default/09_middle.jpg?rltime","big":"http://apic.douyucdn.cn/upload/avatar/default/09_big.jpg?rltime"}
     * has_room : 0
     * groupid : 1
     * is_own_room : 0
     * location : {"province":"","city":""}
     * sex : 0
     * birthday : 0
     * gold1 : 0
     * score : 0
     * level : {"current":{"lv":1,"pic":"user1.gif","mpic":"cn01.png","name":"菜鸟","pic_url":"https://staticlive.douyucdn.cn/common/douyu/images/classimg/user1.gif?v=v66254","score":0},"next":{"lv":2,"pic":"user2.gif","mpic":"brass05.png","name":"黄铜5","pic_url":"https://staticlive.douyucdn.cn/common/douyu/images/classimg/user2.gif?v=v66254","score":100}}
     * userlevel : {"cur_score":0,"next_level_score":10,"lv":1,"is_full":0}
     * follow : 10
     * ios_gold_switch : 1
     * gold : 0.0
     * ident_status : 0
     * token : 63369167_bb889775f9574666
     * token_exp : 1483022058
     */

    private DataBean data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String uid;
        private String username;
        private String nickname;
        private boolean email;
        private String qq;
        private String mobile_phone;
        private String phone_status;
        private String email_status;
        private String lastlogin;
        /**
         * small : http://apic.douyucdn.cn/upload/avatar/default/09_small.jpg?rltime
         * middle : http://apic.douyucdn.cn/upload/avatar/default/09_middle.jpg?rltime
         * big : http://apic.douyucdn.cn/upload/avatar/default/09_big.jpg?rltime
         */

        private AvatarBean avatar;
        private String has_room;
        private String groupid;
        private String is_own_room;
        /**
         * province :
         * city :
         */

        private LocationBean location;
        private String sex;
        private String birthday;
        private String gold1;
        private String score;
        /**
         * current : {"lv":1,"pic":"user1.gif","mpic":"cn01.png","name":"菜鸟","pic_url":"https://staticlive.douyucdn.cn/common/douyu/images/classimg/user1.gif?v=v66254","score":0}
         * next : {"lv":2,"pic":"user2.gif","mpic":"brass05.png","name":"黄铜5","pic_url":"https://staticlive.douyucdn.cn/common/douyu/images/classimg/user2.gif?v=v66254","score":100}
         */

        private LevelBean level;
        /**
         * cur_score : 0
         * next_level_score : 10
         * lv : 1
         * is_full : 0
         */

        private UserlevelBean userlevel;
        private String follow;
        private int ios_gold_switch;
        private String gold;
        private String ident_status;
        private String token;
        private int token_exp;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public boolean isEmail() {
            return email;
        }

        public void setEmail(boolean email) {
            this.email = email;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getMobile_phone() {
            return mobile_phone;
        }

        public void setMobile_phone(String mobile_phone) {
            this.mobile_phone = mobile_phone;
        }

        public String getPhone_status() {
            return phone_status;
        }

        public void setPhone_status(String phone_status) {
            this.phone_status = phone_status;
        }

        public String getEmail_status() {
            return email_status;
        }

        public void setEmail_status(String email_status) {
            this.email_status = email_status;
        }

        public String getLastlogin() {
            return lastlogin;
        }

        public void setLastlogin(String lastlogin) {
            this.lastlogin = lastlogin;
        }

        public AvatarBean getAvatar() {
            return avatar;
        }

        public void setAvatar(AvatarBean avatar) {
            this.avatar = avatar;
        }

        public String getHas_room() {
            return has_room;
        }

        public void setHas_room(String has_room) {
            this.has_room = has_room;
        }

        public String getGroupid() {
            return groupid;
        }

        public void setGroupid(String groupid) {
            this.groupid = groupid;
        }

        public String getIs_own_room() {
            return is_own_room;
        }

        public void setIs_own_room(String is_own_room) {
            this.is_own_room = is_own_room;
        }

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getGold1() {
            return gold1;
        }

        public void setGold1(String gold1) {
            this.gold1 = gold1;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public LevelBean getLevel() {
            return level;
        }

        public void setLevel(LevelBean level) {
            this.level = level;
        }

        public UserlevelBean getUserlevel() {
            return userlevel;
        }

        public void setUserlevel(UserlevelBean userlevel) {
            this.userlevel = userlevel;
        }

        public String getFollow() {
            return follow;
        }

        public void setFollow(String follow) {
            this.follow = follow;
        }

        public int getIos_gold_switch() {
            return ios_gold_switch;
        }

        public void setIos_gold_switch(int ios_gold_switch) {
            this.ios_gold_switch = ios_gold_switch;
        }

        public String getGold() {
            return gold;
        }

        public void setGold(String gold) {
            this.gold = gold;
        }

        public String getIdent_status() {
            return ident_status;
        }

        public void setIdent_status(String ident_status) {
            this.ident_status = ident_status;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getToken_exp() {
            return token_exp;
        }

        public void setToken_exp(int token_exp) {
            this.token_exp = token_exp;
        }

        public static class AvatarBean {
            private String small;
            private String middle;
            private String big;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getMiddle() {
                return middle;
            }

            public void setMiddle(String middle) {
                this.middle = middle;
            }

            public String getBig() {
                return big;
            }

            public void setBig(String big) {
                this.big = big;
            }
        }

        public static class LocationBean {
            private String province;
            private String city;

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }
        }

        public static class LevelBean {
            /**
             * lv : 1
             * pic : user1.gif
             * mpic : cn01.png
             * name : 菜鸟
             * pic_url : https://staticlive.douyucdn.cn/common/douyu/images/classimg/user1.gif?v=v66254
             * score : 0
             */

            private CurrentBean current;
            /**
             * lv : 2
             * pic : user2.gif
             * mpic : brass05.png
             * name : 黄铜5
             * pic_url : https://staticlive.douyucdn.cn/common/douyu/images/classimg/user2.gif?v=v66254
             * score : 100
             */

            private NextBean next;

            public CurrentBean getCurrent() {
                return current;
            }

            public void setCurrent(CurrentBean current) {
                this.current = current;
            }

            public NextBean getNext() {
                return next;
            }

            public void setNext(NextBean next) {
                this.next = next;
            }

            public static class CurrentBean {
                private int lv;
                private String pic;
                private String mpic;
                private String name;
                private String pic_url;
                private int score;

                public int getLv() {
                    return lv;
                }

                public void setLv(int lv) {
                    this.lv = lv;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getMpic() {
                    return mpic;
                }

                public void setMpic(String mpic) {
                    this.mpic = mpic;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPic_url() {
                    return pic_url;
                }

                public void setPic_url(String pic_url) {
                    this.pic_url = pic_url;
                }

                public int getScore() {
                    return score;
                }

                public void setScore(int score) {
                    this.score = score;
                }
            }

            public static class NextBean {
                private int lv;
                private String pic;
                private String mpic;
                private String name;
                private String pic_url;
                private int score;

                public int getLv() {
                    return lv;
                }

                public void setLv(int lv) {
                    this.lv = lv;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getMpic() {
                    return mpic;
                }

                public void setMpic(String mpic) {
                    this.mpic = mpic;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPic_url() {
                    return pic_url;
                }

                public void setPic_url(String pic_url) {
                    this.pic_url = pic_url;
                }

                public int getScore() {
                    return score;
                }

                public void setScore(int score) {
                    this.score = score;
                }
            }
        }

        public static class UserlevelBean {
            private int cur_score;
            private int next_level_score;
            private int lv;
            private int is_full;

            public int getCur_score() {
                return cur_score;
            }

            public void setCur_score(int cur_score) {
                this.cur_score = cur_score;
            }

            public int getNext_level_score() {
                return next_level_score;
            }

            public void setNext_level_score(int next_level_score) {
                this.next_level_score = next_level_score;
            }

            public int getLv() {
                return lv;
            }

            public void setLv(int lv) {
                this.lv = lv;
            }

            public int getIs_full() {
                return is_full;
            }

            public void setIs_full(int is_full) {
                this.is_full = is_full;
            }
        }
    }
}
