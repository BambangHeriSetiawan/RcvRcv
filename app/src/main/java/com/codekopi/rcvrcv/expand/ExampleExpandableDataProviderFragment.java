package com.codekopi.rcvrcv.expand;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by GeekGarden on 29/08/2017.
 */

public class ExampleExpandableDataProviderFragment extends Fragment {
  private ExampleExpandableDataProvider mDataProvider;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);  // keep the mDataProvider instance
    mDataProvider = new ExampleExpandableDataProvider();
  }
  public AbstractExpandableDataProvider getDataProvider() {
    return mDataProvider;
  }
}
