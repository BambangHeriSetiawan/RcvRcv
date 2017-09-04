package com.codekopi.rcvrcv.rcvrcv;

import static io.reactivex.android.schedulers.AndroidSchedulers.*;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.codekopi.rcvrcv.R;
import com.codekopi.rcvrcv.api.ApiInterface;
import com.codekopi.rcvrcv.api.ApiService;
import com.codekopi.rcvrcv.api.model.ResponseDummy;
import com.codekopi.rcvrcv.rcvrcv.model.AntrianService;
import com.codekopi.rcvrcv.rcvrcv.model.CustomerAdvisor;


import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;


public class SamplePitActivity extends AppCompatActivity {
  private AdapterRcvCA adapterRcvCA;
  private AdapterRcvMA adapterRcvMA;
  private ApiInterface mApi;

  @BindView(R.id.rcvCA)RecyclerView rcvCA;
  @BindView(R.id.rcvMA)RecyclerView rcvMA;
  @BindView(R.id.lyt_top)LinearLayout lyt_top;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sample_pit);
    ButterKnife.bind(this);
    initRcvMA();
    initRcvCA();
    initDummyData();
  }

  private void initDummyData() {
    mApi = ApiService.getervice();

  }

  private void initRcvMA() {
    rcvMA.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    List<String> listMa = new ArrayList<>();
    listMa.add("MA 1");
    listMa.add("MA 2");
    listMa.add("MA 3");
    listMa.add("MA 4");
    adapterRcvMA = new AdapterRcvMA(getApplicationContext(),listMa,null);
    rcvMA.setAdapter(adapterRcvMA);
  }

  private void initRcvCA() {
    GridLayoutManager glm = new GridLayoutManager(this,2);
    StaggeredGridLayoutManager stg = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.HORIZONTAL);
    LinearLayoutManager llm = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
    //rcvCA.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    rcvCA.setLayoutManager(llm);
    rcvCA.setHasFixedSize(true);

    AntrianService tes1 = new AntrianService("Test 1","type 1");
    AntrianService tes2 = new AntrianService("Test 2","type 2");
    AntrianService tes3 = new AntrianService("Test 3","type 3");
    AntrianService tes4 = new AntrianService("Test 4","type 4");
    List<AntrianService> listCaCa = Arrays.asList(tes1,tes2,tes3,tes4);

    CustomerAdvisor ca1 = new CustomerAdvisor("CA 1",listCaCa);
    CustomerAdvisor ca2 = new CustomerAdvisor("CA 2",listCaCa);
    CustomerAdvisor ca3 = new CustomerAdvisor("CA 3",listCaCa);
    List<CustomerAdvisor> customerAdvisor = Arrays.asList(ca1,ca2,ca3);
    adapterRcvCA = new AdapterRcvCA(this,customerAdvisor);
    rcvCA.setAdapter(adapterRcvCA);

  }
}
