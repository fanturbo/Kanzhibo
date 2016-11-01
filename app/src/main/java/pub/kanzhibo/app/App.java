package pub.kanzhibo.app;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;

import com.tencent.bugly.crashreport.CrashReport;


/**
 * 微社区Demo的Application，如果需要自行处理友盟消息推送过来的信息，那么需要在Application中进行设置。
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashReport.initCrashReport(getApplicationContext(), "900057711", false);
        AVOSCloud.initialize(this, "CIVyV1zRVPbkMQC88fyO9cuW-gzGzoHsz", "Tqbvbhznm5vc1BYdzMTXHeVd");
    }
}
