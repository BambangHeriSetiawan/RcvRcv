package com.codekopi.rcvrcv.rcvrcv.viewholder;

import android.content.ClipData;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.codekopi.rcvrcv.R;
import com.codekopi.rcvrcv.rcvrcv.model.AntrianService;
import com.codekopi.rcvrcv.rcvrcv.model.CustomerAdvisor;

/**
 * Created by GeekGarden on 28/08/2017.
 */

public class VieholderAntrian extends ChildViewHolder  {

  /**
   * Default constructor.
   *
   * @param itemView The {@link View} being hosted in this ViewHolder
   */

  @BindView(R.id.tvNameAntrina) TextView tvNameAntrina;
  @BindView(R.id.imgDrag) ImageView imgDrag;
  public VieholderAntrian(@NonNull View itemView) {
    super(itemView);
    ButterKnife.bind(this,itemView);
  }
  public void bind(AntrianService service){
    tvNameAntrina.setText(service.getName());

  }


}
