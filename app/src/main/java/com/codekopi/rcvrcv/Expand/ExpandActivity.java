package com.codekopi.rcvrcv.Expand;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.codekopi.rcvrcv.R;
import com.codekopi.rcvrcv.common.data.AbstractAddRemoveExpandableDataProvider;
import com.codekopi.rcvrcv.common.fragment.ExampleAddRemoveExpandableDataProviderFragment;

public class ExpandActivity extends AppCompatActivity {
  private static final String FRAGMENT_TAG_DATA_PROVIDER = "data provider";
  private static final String FRAGMENT_LIST_VIEW = "list view";
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_expand);
    if (savedInstanceState == null) {
      getSupportFragmentManager().beginTransaction()
          .add(new ExampleAddRemoveExpandableDataProviderFragment(), FRAGMENT_TAG_DATA_PROVIDER)
          .commit();
      getSupportFragmentManager().beginTransaction()
          .add(R.id.container, new ExpandFragment(), FRAGMENT_LIST_VIEW)
          .commit();
    }
  }
  public AbstractAddRemoveExpandableDataProvider getDataProvider() {
    final Fragment fragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_DATA_PROVIDER);
    return ((ExampleAddRemoveExpandableDataProviderFragment) fragment).getDataProvider();
  }
}
