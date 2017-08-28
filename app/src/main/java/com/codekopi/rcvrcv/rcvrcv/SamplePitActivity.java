package com.codekopi.rcvrcv.rcvrcv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter.ExpandCollapseListener;
import com.codekopi.rcvrcv.R;
import com.codekopi.rcvrcv.rcvrcv.model.AntrianService;
import com.codekopi.rcvrcv.rcvrcv.model.CustomerAdvisor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SamplePitActivity extends AppCompatActivity {
  private AdapterRcvCA adapterRcvCA;
  private AdapterRcvMA adapterRcvMA;
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
    rcvCA.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
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
    /*adapterRcvCA = new AdapterRcvCA(this,customerAdvisor);
    adapterRcvCA.setExpandCollapseListener(new ExpandCollapseListener() {
      @Override
      public void onParentExpanded(int parentPosition) {
        rcvCA.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
      }

      @Override
      public void onParentCollapsed(int parentPosition) {
        rcvCA.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
      }
    });
    rcvCA.setAdapter(adapterRcvCA);*/
    for (int i = 0; i < customerAdvisor.size(); i++) {
      LinearLayout linearLayout = new LinearLayout(this);
      linearLayout.setOrientation(LinearLayout.VERTICAL);
      final RecyclerView rv = new RecyclerView(this);
      TextView tv = new TextView(this);
      tv.setText(customerAdvisor.get(i).getName());
      adapterRcvCA = new AdapterRcvCA(this,customerAdvisor);

      rv.setId(R.id.idRcv+i);
      rv.setBackground(getResources().getDrawable(R.drawable.bg));
      rv.setLayoutManager(new LinearLayoutManager(this,LinearLayout.HORIZONTAL,false));
      rv.setAdapter(adapterRcvCA);
      linearLayout.addView(tv);
      linearLayout.addView(rv);
      lyt_top.addView(linearLayout);

    }
  }
}
