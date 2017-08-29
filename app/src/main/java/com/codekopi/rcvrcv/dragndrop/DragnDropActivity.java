package com.codekopi.rcvrcv.dragndrop;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.codekopi.rcvrcv.R;
import com.codekopi.rcvrcv.rcvrcv.AdapterRcvMA;
import java.util.ArrayList;
import java.util.List;

public class DragnDropActivity extends AppCompatActivity {
  private AdapterRcvMA adapterRcvMA;
  @BindView(R.id.lyt_top)  LinearLayout lytTop;
  @BindView(R.id.sc_top)  NestedScrollView scTop;
  @BindView(R.id.lyt_down)  LinearLayout lytDown;
  @BindView(R.id.sc_down)  NestedScrollView scDown;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dragn_drop);
    ButterKnife.bind(this);
    List<String> listMa = new ArrayList<>();
    listMa.add("MA ");
    listMa.add("MA ");
    listMa.add("MA ");
    listMa.add("MA ");
    listMa.add("MA ");
    listMa.add("MA ");
    listMa.add("MA ");
    listMa.add("MA ");
    listMa.add("MA ");
    int data = listMa.size();
    for (int i = 0; i < data; i++) {
      adapterRcvMA = new AdapterRcvMA(this,listMa,null);
      LayoutParams params = new LayoutParams(500,600);
      LinearLayout.LayoutParams linearParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.MATCH_PARENT);
      TextView tvUp = new TextView(this);
      tvUp.setText("CA "+i);
      TextView tvDown = new TextView(this);
      tvDown.setText("MA "+i);
      LinearLayout llmTop = new LinearLayout(this);
      LinearLayout llmDown = new LinearLayout(this);
      llmTop.setLayoutParams(linearParam);
      llmDown.setLayoutParams(linearParam);
      RecyclerView rcvTop = new RecyclerView(this);
      RecyclerView rcvDown = new RecyclerView(this);
      rcvTop.setLayoutParams(params);
      rcvDown.setLayoutParams(params);
      rcvTop.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
      rcvDown.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
      rcvDown.setAdapter(adapterRcvMA);
      rcvTop.setAdapter(adapterRcvMA);
      llmTop.addView(tvUp);
      llmDown.addView(tvDown);
      //llmTop.addView(rcvTop);
      //llmDown.addView(rcvDown);
      lytTop.addView(llmTop);
      lytDown.addView(llmDown);

    }
  }
}
