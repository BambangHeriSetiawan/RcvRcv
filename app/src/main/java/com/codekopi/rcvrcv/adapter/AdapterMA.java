package com.codekopi.rcvrcv.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/**
 * Created by GeekGarden on 25/08/2017.
 */

public class AdapterMA extends RecyclerView.Adapter<AdapterMA.Holder> {
  private List<String> mListCA;
  private Context context;

  public AdapterMA(List<String> mListCA, Context context) {
    this.mListCA = mListCA;
    this.context = context;
  }

  @Override
  public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
    return null;
  }

  @Override
  public void onBindViewHolder(Holder holder, int position) {

  }

  @Override
  public int getItemCount() {
    return 0;
  }

  public class Holder extends RecyclerView.ViewHolder {

    public Holder(View itemView) {
      super(itemView);
    }
  }
}
