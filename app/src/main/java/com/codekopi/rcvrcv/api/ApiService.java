package com.codekopi.rcvrcv.api;

/**
 * Created by GeekGarden on 04/09/2017.
 */

public class ApiService {
public final static String BASE_URL = "https://bambangherisetiawan.github.io/json/";
public static ApiInterface getervice(){
  return ApiClinet.getClient(BASE_URL).create(ApiInterface.class);
}
}
