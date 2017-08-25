package com.codekopi.rcvrcv;

import android.content.ClipData;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.List;

/**
 * Created by GeekGarden on 25/08/2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.Holder> implements
    OnTouchListener {
  private List<String> mlist;
  private Listener listener;

  public ListAdapter(List<String> mlist, Listener listener) {
    this.mlist = mlist;
    this.listener = listener;
  }

  @Override
  public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rcv_ca,parent,false);
    return new Holder(v);
  }

  @Override
  public void onBindViewHolder(Holder holder, int position) {
    holder.tvTest.setText(mlist.get(position));
    holder.cvCa.setTag(position);
    holder.cvCa.setOnTouchListener(this);
    holder.cvCa.setOnDragListener(new DragListener(listener));

  }

  @Override
  public boolean onTouch(View view, MotionEvent motionEvent) {
    switch (motionEvent.getAction()) {
      case MotionEvent.ACTION_DOWN:
        ClipData data = ClipData.newPlainText("","");
        View.DragShadowBuilder builder = new DragShadowBuilder(view);
        if (VERSION.SDK_INT >= VERSION_CODES.N){
          view.startDragAndDrop(data,builder,view,0);
        }else {
          view.startDrag(data,builder,view,0);
        }
        return true;
    }
    return false;
  }
  List<String> getList(){
    return mlist;
  }
  void UpdateList(List<String> list){
    this.mlist = list;
  }
  DragListener getDragInstance(){
    if (listener!=null){
      return new DragListener(listener);}
      else {
      Log.e("getDragInstance", "ListAdapter wasnot initialized");
      return null;}
  }

  public class Holder extends RecyclerView.ViewHolder {
    @BindView(R.id.cv_ca)FrameLayout cvCa;
    @BindView(R.id.tvTest)TextView tvTest;
    public Holder(View itemView) {
      super(itemView);
      ButterKnife.bind(this,itemView);

    }
  }
  @Override
  public int getItemCount() {
    return mlist.size();
  }

}
