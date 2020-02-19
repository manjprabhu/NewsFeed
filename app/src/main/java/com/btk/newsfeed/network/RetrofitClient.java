package com.btk.newsfeed.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://newsapi.org/v2/";
    public static final String API_KEY = "6afcca8a53c447398041d61545310e3f";
    private static Retrofit INSTANCE;
    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    private static OkHttpClient okHttpClient;

    public static Retrofit getInstance() {

        loggingInterceptor.level(HttpLoggingInterceptor.Level.BASIC);
        loggingInterceptor.level(HttpLoggingInterceptor.Level.BODY);
        loggingInterceptor.level(HttpLoggingInterceptor.Level.HEADERS);

        if(okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30,TimeUnit.SECONDS)
                    .build();
        }

        if(INSTANCE == null) {
            INSTANCE = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();

        }
        return INSTANCE;
    }
}
