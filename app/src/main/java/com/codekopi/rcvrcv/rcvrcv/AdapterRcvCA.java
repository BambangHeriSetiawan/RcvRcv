package com.codekopi.rcvrcv.rcvrcv;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.codekopi.rcvrcv.R;
import com.codekopi.rcvrcv.rcvrcv.model.AntrianService;
import com.codekopi.rcvrcv.rcvrcv.model.CustomerAdvisor;
import com.codekopi.rcvrcv.rcvrcv.viewholder.VieholderAntrian;
import com.codekopi.rcvrcv.rcvrcv.viewholder.VieholderCA;
import java.util.List;

/**
 * Created by GeekGarden on 28/08/2017.
 */

public class AdapterRcvCA  extends ExpandableRecyclerAdapter<CustomerAdvisor,AntrianService,VieholderCA,VieholderAntrian>{

  private LayoutInflater mInflater;
  public AdapterRcvCA(Context context,@NonNull List<CustomerAdvisor> parentList) {
    super(parentList);
    this.mInflater = LayoutInflater.from(context);
  }

  @NonNull
  @Override
  public VieholderCA onCreateParentViewHolder(@NonNull ViewGroup parentViewGroup, int viewType) {
    View view = mInflater.inflate(R.layout.queue_pit, parentViewGroup,false);
    return new VieholderCA(view);
  }

  @NonNull
  @Override
  public VieholderAntrian onCreateChildViewHolder(@NonNull ViewGroup childViewGroup, int viewType) {
    View view = mInflater.inflate(R.layout.item_rcv_ca,childViewGroup,false);
    return new VieholderAntrian(view);
  }

  @Override
  public void onBindParentViewHolder(@NonNull VieholderCA parentViewHolder, int parentPosition,
      @NonNull CustomerAdvisor parent) {
    parentViewHolder.bind(parent);

  }

  @Override
  public void onBindChildViewHolder(@NonNull VieholderAntrian childViewHolder, int parentPosition,
      int childPosition, @NonNull AntrianService child) {
    childViewHolder.bind(child);
  }
}
