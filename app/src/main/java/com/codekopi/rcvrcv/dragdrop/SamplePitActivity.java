package com.codekopi.rcvrcv.dragdrop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.codekopi.rcvrcv.R;
import com.codekopi.rcvrcv.api.ApiInterface;
import com.codekopi.rcvrcv.api.ApiService;
import com.codekopi.rcvrcv.api.Constan;
import com.codekopi.rcvrcv.model.antrian.Datum;
import com.codekopi.rcvrcv.model.antrian.details.RepairOrder;
import com.codekopi.rcvrcv.model.antrian.ResponseAntrian;
import com.codekopi.rcvrcv.model.antrian.details.ResponseAntrianDetails;
import com.codekopi.rcvrcv.dragdrop.AdapterAntrian.OnAtrianClickListener;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;


public class SamplePitActivity extends AppCompatActivity {


  LinearLayout llm1;
  @BindView(R.id.rcvAntrian)
  RecyclerView rcvAntrian;
  @BindView(R.id.rcvAntrianTop)
  RecyclerView rcvAntrianTop;
  @BindView(R.id.rcvMekanik)
  RecyclerView rcvMekanik;
  @BindView(R.id.rcvAntrianBot)
  RecyclerView rcvAntrianBot;

  private AdapterAntrian adapterAntrian;
  private AdapterAntrianTop adapterAntrianTop;
  private ApiInterface mApi;
  private Observable<ResponseAntrian> observable;
  private Observable<ResponseAntrianDetails> datumObservable;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sample_pit);
    ButterKnife.bind(this);
    mApi = ApiService.getService();


    initRcvAntrian();
    initRcvMekanik();
    initRcvAntrianTop();
    initRcvAntrianBot();

  }

  private void initRcvAntrianBot() {

  }

  private void initRcvMekanik() {

  }

  private void getDataMekanik() {
    getDataMekanik();
  }

  private void initRcvAntrianTop() {
    rcvAntrianTop.setHasFixedSize(true);
    rcvAntrianTop.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
    adapterAntrianTop = new AdapterAntrianTop(getApplicationContext(),new ArrayList<RepairOrder>(),null);
    rcvAntrianTop.setAdapter(adapterAntrianTop);

  }

  private void initRcvAntrian() {
    getDataAndtian();
    rcvAntrian.setHasFixedSize(true);
    rcvAntrian.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
    adapterAntrian = new AdapterAntrian(getApplicationContext(), new ArrayList<Datum>(),
        new OnAtrianClickListener() {
          @Override
          public void AntrianClickListener(String id) {
            getRepairOrder(id);
          }
        });
    rcvAntrian.setAdapter(adapterAntrian);

  }

  private void getRepairOrder(String id) {
    adapterAntrianTop = new AdapterAntrianTop(getApplicationContext(),new ArrayList<RepairOrder>(),null);
    datumObservable = mApi.getAntrianById(Constan.ACCESS_TOKEN,id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    datumObservable.subscribe(datum -> {
      adapterAntrianTop.UpdateListItem(datum.getData().getRepairOrders());
    },throwable -> {
      Log.e("getRepairOrder", "SamplePitActivity" + throwable.getMessage());
    },() -> {
      Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
    });
    rcvAntrianTop.setAdapter(adapterAntrianTop);
  }

  private void getDataAndtian() {
    observable = mApi.getAntrian(Constan.ACCESS_TOKEN).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(responseAntrian -> {
          adapterAntrian.UpdateListItem(responseAntrian.getData());
        }, throwable -> {
          Log.e("getDataAndtian", "SamplePitActivity" + throwable.getMessage());
        }, () -> {
          Toast.makeText(this, "Completed", Toast.LENGTH_SHORT).show();
        });
    }
}
