package pub.kanzhibo.app.model;

/**
 * Created by turbo on 2016/11/1.
 */

public enum PlatForm {
    DOUYU(1), HUYA(2), ZHANQI(3), PANDA(4), QUANMIN(5);
    // 成员变量
    private int platform;

    // 构造方法
    private PlatForm(int platform) {
        this.platform = platform;
    }

    public int getPlatform() {
        return platform;
    }
}
