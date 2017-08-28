package com.codekopi.rcvrcv.firebase;


import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

/**
 * Created by GeekGarden on 28/08/2017.
 */

public class AdapterRcvFirebase extends FirebaseRecyclerAdapter<ListTiket,RcvViewHolder> {

  private Context mContext;
  public AdapterRcvFirebase(Class<ListTiket> modelClass, int modelLayout,
      Class<RcvViewHolder> viewHolderClass, Query query, Context context) {
    super(modelClass, modelLayout, viewHolderClass, query);
    this.mContext = context;
  }

  @Override
  protected void populateViewHolder(RcvViewHolder viewHolder, ListTiket model, int position) {
    final String key = getRef(position).getKey();
    viewHolder.tvOne.setText(model.getNamaCustomer());
    viewHolder.itemView.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(mContext, ""+key, Toast.LENGTH_SHORT).show();
      }
    });
  }
}
