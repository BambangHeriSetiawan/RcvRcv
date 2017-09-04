package com.codekopi.rcvrcv.rcvrcv;


import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnClickListener;
import android.view.View.OnDragListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.bignerdranch.expandablerecyclerview.ExpandableRecyclerAdapter;
import com.codekopi.rcvrcv.R;
import com.codekopi.rcvrcv.rcvrcv.model.AntrianService;
import com.codekopi.rcvrcv.rcvrcv.model.CustomerAdvisor;
import com.codekopi.rcvrcv.rcvrcv.viewholder.VieholderAntrian;
import com.codekopi.rcvrcv.rcvrcv.viewholder.VieholderCA;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import java.util.List;

/**
 * Created by GeekGarden on 28/08/2017.
 */

public class AdapterRcvCA  extends ExpandableRecyclerAdapter<CustomerAdvisor,AntrianService,VieholderCA,VieholderAntrian> implements
    OnTouchListener, OnDragListener, OnLongClickListener {
  public static String TAG = AdapterRcvCA.class.getSimpleName();
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
  public void onBindChildViewHolder(@NonNull final VieholderAntrian childViewHolder, int parentPosition,
      int childPosition, @NonNull final AntrianService child) {
    childViewHolder.bind(child);
    childViewHolder.itemView.setOnLongClickListener(this);
   /* childViewHolder.itemView.setOnTouchListener(this);
    childViewHolder.itemView.setOnDragListener(this);*/
  }


  @Override
  public boolean onTouch(View view, MotionEvent motionEvent) {
    switch (motionEvent.getAction()) {
      case MotionEvent.ACTION_DOWN:
        ClipData data = ClipData.newPlainText("","");
        View.DragShadowBuilder builder = new DragShadowBuilder(view);

        if (VERSION.SDK_INT>=VERSION_CODES.N){
          view.startDragAndDrop(data,builder,view,0);
        }else {
          view.startDrag(data,builder,view,0);
        }
        return true;
    }
    return false;
  }

  @Override
  public boolean onDrag(View view, DragEvent dragEvent) {
    switch (dragEvent.getAction()) {
      case DragEvent.ACTION_DRAG_STARTED:
        Log.e("onDrag", "AdapterRcvCA" + dragEvent.getAction());
        return true;
      case DragEvent.ACTION_DROP:
        Log.e("onDrag", "AdapterRcvCA" + dragEvent.getAction());
        return true;
      default:
          return false;
    }
  }

  @SuppressLint("ResourceAsColor")
  @Override
  public boolean onLongClick(View view) {
    ChildViewHolder viewHolder = new ChildViewHolder(view);
    viewHolder.itemView.setOnTouchListener(this);
    viewHolder.itemView.setOnDragListener(this);
    return true;
  }
}
