package com.codekopi.rcvrcv.firebase;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.codekopi.rcvrcv.R;

/**
 * Created by GeekGarden on 28/08/2017.
 */

public class RcvViewHolder extends RecyclerView.ViewHolder {
  @BindView(R.id.tvOne)
  TextView tvOne;
  public RcvViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this,itemView);
  }
}
