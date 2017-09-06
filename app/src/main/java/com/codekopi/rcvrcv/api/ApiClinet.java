package com.codekopi.rcvrcv.api;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by GeekGarden on 04/09/2017.
 */

public class ApiClinet {
private static Retrofit retrofit = null;
public static Retrofit getClient(String baseUrl){
  HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
  loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
  OkHttpClient okHttpClient = new OkHttpClient.Builder()
      .retryOnConnectionFailure(true)
      .readTimeout(10, TimeUnit.MINUTES)
      .connectTimeout(10, TimeUnit.MINUTES)
      .addInterceptor(loggingInterceptor)
      .build();
  if (retrofit == null){
    retrofit = new Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build();
  }
  return retrofit;
}
}
