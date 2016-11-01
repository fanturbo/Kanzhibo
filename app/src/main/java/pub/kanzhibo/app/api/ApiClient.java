package pub.kanzhibo.app.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by snail on 16/10/30.
 */
public class ApiClient {
    private static final int DEFAULT_TIMEOUT = 10000;

    private static Retrofit retrofit;

    private static ILiveApi mLiveApi;

    private static ApiClient apiClient;

    public static ApiClient getInstance() {
        if (apiClient == null) {
            apiClient = new ApiClient();
        }
        return apiClient;
    }

    public ILiveApi getLiveApi(String baseUrl) {
//        return mLiveApi == null ? configRetrofit(ILiveApi.class) : mLiveApi;
        return configRetrofit(ILiveApi.class,baseUrl);
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
