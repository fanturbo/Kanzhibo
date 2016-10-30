package pub.kanzhibo.app.api;

import android.text.TextUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pub.kanzhibo.app.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by snail on 16/10/30.
 */
public class ApiClient {
    private static final int DEFAULT_TIMEOUT = 10000;

    private static Retrofit retrofit;

    private static IDouyuLiveApi mDouyuApi;

    private static ApiClient apiClient;

    public static ApiClient getInstance() {
        if (apiClient == null) {
            apiClient = new ApiClient();
        }
        return apiClient;
    }

    public IDouyuLiveApi getDouyuApi(String baseUrl) {
//        return mDouyuApi == null ? configRetrofit(IDouyuLiveApi.class) : mDouyuApi;
        return configRetrofit(IDouyuLiveApi.class,baseUrl);
    }


    private <T> T configRetrofit(Class<T> service,String baseUrl) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(service);

    }
}
