package com.codekopi.rcvrcv.api;

/**
 * Created by GeekGarden on 04/09/2017.
 */

public class ApiService {
public final static String BASE_URL = "http://api.nagamas.dev.geekgarden.id/";
public static ApiInterface getService(){
  return ApiClinet.getClient(BASE_URL).create(ApiInterface.class);
}
}
