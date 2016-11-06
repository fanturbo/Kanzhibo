package pub.kanzhibo.app;

import android.app.Application;
import android.content.Context;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVObject;

//import com.tencent.bugly.crashreport.CrashReport;

import pub.kanzhibo.app.util.SharedPreferencesUtils;

import static pub.kanzhibo.app.gloabal.Constants.Key.ISLOGIN;


/**
 * 微社区Demo的Application，如果需要自行处理友盟消息推送过来的信息，那么需要在Application中进行设置。
 */
public class App extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
//        CrashReport.initCrashReport(getApplicationContext(), "900057711", false);
        AVOSCloud.initialize(this, "CIVyV1zRVPbkMQC88fyO9cuW-gzGzoHsz", "Tqbvbhznm5vc1BYdzMTXHeVd");
    }

    public static boolean isLogIn() {
        return SharedPreferencesUtils.getBoolean(context, ISLOGIN, false);
    }

    public static void logIn() {
        SharedPreferencesUtils.saveBoolean(context, ISLOGIN, true);
    }

    public static void logOut() {
        SharedPreferencesUtils.saveBoolean(context, ISLOGIN, false);
    }
}
