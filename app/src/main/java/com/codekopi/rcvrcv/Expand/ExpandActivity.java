package com.codekopi.rcvrcv.Expand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.codekopi.rcvrcv.R;

public class ExpandActivity extends AppCompatActivity {
  private static final String FRAGMENT_TAG_DATA_PROVIDER = "data provider";
  private static final String FRAGMENT_LIST_VIEW = "list view";
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_expand);

  }
}
