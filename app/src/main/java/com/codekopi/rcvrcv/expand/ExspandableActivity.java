package com.codekopi.rcvrcv.expand;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
  private static final String FRAGMENT_TAG_DATA_PROVIDER = "data provider";
  private static final String FRAGMENT_LIST_VIEW = "list view";
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_exspandable);


    if (savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction()
          .add(new ExampleExpandableDataProviderFragment(), FRAGMENT_TAG_DATA_PROVIDER)
          .commit();
      getSupportFragmentManager().beginTransaction()
          .add(R.id.container, new ExpadableFragment(), FRAGMENT_LIST_VIEW)
          .commit();
    }

  }
  public AbstractExpandableDataProvider getDataProvider() {
    final Fragment fragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_DATA_PROVIDER);
    return ((ExampleExpandableDataProviderFragment) fragment).getDataProvider();
  }
}
