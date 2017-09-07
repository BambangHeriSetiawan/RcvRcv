package com.codekopi.rcvrcv.api;


import com.codekopi.rcvrcv.model.antrian.ResponseAntrian;
import com.codekopi.rcvrcv.model.antrian.details.ResponseAntrianDetails;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;


/**
 * Created by GeekGarden on 04/09/2017.
 */

public interface ApiInterface {


  @Headers("Accept:application/json")
  @GET("maintenances/queues")
  Observable<ResponseAntrian> getAntrian(@Header("Authorization")String authorization);

  @GET("maintenances/queues/{id}")
  Observable<ResponseAntrianDetails> getAntrianById(@Header("Authorization")String authorization,@Path("id") String id);

}
