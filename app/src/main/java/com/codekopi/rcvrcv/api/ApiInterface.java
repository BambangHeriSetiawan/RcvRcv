package com.codekopi.rcvrcv.api;

import com.codekopi.rcvrcv.api.model.ResponseDummy;
import retrofit2.http.GET;
import rx.Observable;


/**
 * Created by GeekGarden on 04/09/2017.
 */

public interface ApiInterface {

  @GET
  Observable<ResponseDummy> getDummyData();

}
