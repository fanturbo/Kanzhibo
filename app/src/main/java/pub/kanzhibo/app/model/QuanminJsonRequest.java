package pub.kanzhibo.app.model;

/**
 * Created by turbo on 2016/11/1.
 */

public class QuanminJsonRequest {

    /**
     * device : 862374032398188
     * v : 2.1.3
     * screen : 2
     * ch : xiaomi
     * sh : 1280
     * p : {"size":10,"key":"lyn","page":0,"categoryId":0}
     * sw : 720
     * uid : a7514f777d03
     * net : 0
     * ver : 4
     * os : 1
     */

    private String device;
    private String v;
    private String screen;
    private String ch;
    private int sh;
    /**
     * size : 10
     * key : lyn
     * page : 0
     * categoryId : 0
     */

    private PEntity p;
    private int sw;
    private String uid;
    private String net;
    private String ver;
    private String os;

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public int getSh() {
        return sh;
    }

    public void setSh(int sh) {
        this.sh = sh;
    }

    public PEntity getP() {
        return p;
    }

    public void setP(PEntity p) {
        this.p = p;
    }

    public int getSw() {
        return sw;
    }

    public void setSw(int sw) {
        this.sw = sw;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNet() {
        return net;
    }

    public void setNet(String net) {
        this.net = net;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public static class PEntity {
        private int size;
        private String key;
        private int page;
        private int categoryId;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }
    }
}
