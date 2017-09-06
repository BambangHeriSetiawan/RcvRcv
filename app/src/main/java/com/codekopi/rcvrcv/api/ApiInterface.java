package com.codekopi.rcvrcv.api;

import com.codekopi.rcvrcv.api.model.ResponseDummy;
import com.codekopi.rcvrcv.api.model.model.ResponseAntrian;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;


/**
 * Created by GeekGarden on 04/09/2017.
 */

public interface ApiInterface {


  @Headers("Accept:application/json")
  @GET("maintenances/queues")
  Observable<ResponseAntrian> getAntrian(@Header("Authorization")String authorization);

}
