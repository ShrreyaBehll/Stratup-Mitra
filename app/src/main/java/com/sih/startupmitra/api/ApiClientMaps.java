package com.sih.startupmitra.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by himanshusingh on 30/06/17.
 */

public class ApiClientMaps {

    private static final String BASE_URL = "http://122.176.81.234:8001/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {           

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        return retrofit;

    }

    // Cache interceptor ， Uniform cache 60s


}