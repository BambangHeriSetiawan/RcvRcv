package com.codekopi.rcvrcv.expand;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.codekopi.rcvrcv.R;
import com.codekopi.rcvrcv.rcvrcv.model.AntrianService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExspandableActivity extends AppCompatActivity {
  private ExpandableAdapter adapter1;
  private ExpandableAdapter adapter2;

  @BindView(R.id.rcvCA)
  RecyclerView rcvCA;
  @BindView(R.id.rcvMA)
  RecyclerView rcvMA;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_exspandable);
    ButterKnife.bind(this);
    Item i1 = new Item(1);
    Item i2 = new Item(2);
    Item i3 = new Item(3);
    Item i4 = new Item(4);
    List<Item> itemList = Arrays.asList(i1,i2,i3,i4);

    Items tes1 = new Items(1,itemList);
    Items tes2 = new Items(2,itemList);
    Items tes3 = new Items(3,itemList);
    Items tes4 = new Items(4,itemList);
    List<Items> items = Arrays.asList(tes1,tes2,tes3,tes4);
    adapter1 = new ExpandableAdapter(items,getApplicationContext());
    rcvCA.setAdapter(adapter1);
    rcvCA.setLayoutManager(new LinearLayoutManager(this));

    /*adapter1 = new ExpandableAdapter(getApplicationContext(),listMa);
    adapter2 = new ExpandableAdapter(getApplicationContext(),listMa);

    rcvMA.setAdapter(adapter2);
    rcvMA.setLayoutManager(new LinearLayoutManager(this));*/
  }
}
