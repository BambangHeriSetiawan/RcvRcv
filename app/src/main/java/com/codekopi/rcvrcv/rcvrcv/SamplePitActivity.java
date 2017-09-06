package com.codekopi.rcvrcv.rcvrcv;

import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.codekopi.rcvrcv.R;
import com.codekopi.rcvrcv.api.ApiInterface;
import com.codekopi.rcvrcv.api.ApiService;
import com.codekopi.rcvrcv.api.Constan;
import com.codekopi.rcvrcv.api.model.Pit;
import com.codekopi.rcvrcv.api.model.ResponseDummy;
import com.codekopi.rcvrcv.api.model.model.RepairOrder;
import com.codekopi.rcvrcv.api.model.model.ResponseAntrian;
import com.codekopi.rcvrcv.rcvrcv.model.AntrianService;
import com.codekopi.rcvrcv.rcvrcv.model.CustomerAdvisor;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SamplePitActivity extends AppCompatActivity {

  @BindView(R.id.hsView)
  HorizontalScrollView hsView;
  @BindView(R.id.llm1)
  LinearLayout llm1;
  private AdapterRcvCA adapterRcvCA;
  private AdapterRcvMA adapterRcvMA;
  private ApiInterface mApi;
  private Observable<ResponseAntrian> observable;

  CompositeDisposable disposable;
  @BindView(R.id.rcvCA)
  RecyclerView rcvCA;
  @BindView(R.id.rcvMA)
  RecyclerView rcvMA;
  @BindView(R.id.lyt_top)
  LinearLayout lyt_top;
  LinearLayoutManager layoutManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sample_pit);
    ButterKnife.bind(this);
    mApi = ApiService.getService();
    disposable = new CompositeDisposable();
    layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
    initDummyData();
    //initRcvMA();
    //initRcvCA();

  }

  private void initDummyData() {
    /*observable = mApi.getDummyData(Constan.ACCESS_TOKEN).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
    observable.subscribe();*/
    observable = mApi.getAntrian(Constan.ACCESS_TOKEN).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    observable.subscribe(responseAntrian -> {
      Log.e("initDummyData", "SamplePitActivity" + responseAntrian.getData().size());
      for (int i = 0; i < responseAntrian.getData().size(); i++) {
        createLayoutAntian(i,responseAntrian);
      }
    },throwable -> {
      Log.e("initDummyData", "SamplePitActivity" + throwable.getMessage());
    },() -> {
      Toast.makeText(this, "Completed", Toast.LENGTH_SHORT).show();
    });

  }

  private void createLayoutAntian(int i,
      ResponseAntrian responseAntrian) {
    LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
    View view;
    RecyclerView rv = new RecyclerView(this);
    Log.e("createLayoutAntian", "SamplePitActivity" + responseAntrian.getData().get(i).getRepairOrders().size());
    for (int i1 = 0; i1 < responseAntrian.getData().get(i).getRepairOrders().size(); i1++) {
      RepairOrder repairOrder = responseAntrian.getData().get(i).getRepairOrders().get(i1);
      rv.setHasFixedSize(true);
      rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
      adapterRcvMA = new AdapterRcvMA(getApplicationContext(),new ArrayList<RepairOrder>(),null);
      adapterRcvMA.UpdateListItem(responseAntrian.getData().get(i).getRepairOrders());

    }
    rv.setAdapter(adapterRcvCA);
    view = inflater.inflate(R.layout.antian_cusom_layout,null,false);
    TextView textView = view.findViewById(R.id.text_name_antrian);
    textView.setText(responseAntrian.getData().get(i).getName());

    llm1.addView(view);
    llm1.addView(rv);
  }

  private void genLayoutMA(ResponseDummy value) {
    int count = value.getPit().size();
    for (int i = 0; i < count; i++) {
      RecyclerView rcv = new RecyclerView(this);
      /*rcv.setLayoutParams(new LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
          RecyclerView.LayoutParams.WRAP_CONTENT));*/
      LayoutParams params = new LayoutParams(500,LayoutParams.MATCH_PARENT);
      rcv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
      if (VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
        rcv.setElevation(9);
      }
      rcv.setBackground(getResources().getDrawable(R.drawable.bg));
      rcv.setAdapter(adapterRcvMA);
      CardView cardView = new CardView(this);
      cardView.setLayoutParams(params);
      cardView.addView(rcv);

      /*TextView textView = new TextView(this);
      textView.setText(value.getPit().get(i).getName());*/
      llm1.addView(cardView);
    }
  }

  private void initRcvMA() {
    /*rcvMA.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    adapterRcvMA = new AdapterRcvMA(getApplicationContext(), new ArrayList<Pit>(), null);*/
    //rcvMA.setAdapter(adapterRcvMA);
  }

  private void initRcvCA() {
    GridLayoutManager glm = new GridLayoutManager(this, 2);
    StaggeredGridLayoutManager stg = new StaggeredGridLayoutManager(4,
        StaggeredGridLayoutManager.HORIZONTAL);
    LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    //rcvCA.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    rcvCA.setLayoutManager(llm);
    rcvCA.setHasFixedSize(true);

    AntrianService tes1 = new AntrianService("Test 1", "type 1");
    AntrianService tes2 = new AntrianService("Test 2", "type 2");
    AntrianService tes3 = new AntrianService("Test 3", "type 3");
    AntrianService tes4 = new AntrianService("Test 4", "type 4");
    List<AntrianService> listCaCa = Arrays.asList(tes1, tes2, tes3, tes4);

    CustomerAdvisor ca1 = new CustomerAdvisor("CA 1", listCaCa);
    CustomerAdvisor ca2 = new CustomerAdvisor("CA 2", listCaCa);
    CustomerAdvisor ca3 = new CustomerAdvisor("CA 3", listCaCa);
    List<CustomerAdvisor> customerAdvisor = Arrays.asList(ca1, ca2, ca3);
    adapterRcvCA = new AdapterRcvCA(this, customerAdvisor);
    rcvCA.setAdapter(adapterRcvCA);

  }

}
