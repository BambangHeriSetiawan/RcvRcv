package com.codekopi.rcvrcv.dragdrop.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bignerdranch.expandablerecyclerview.ChildViewHolder;
import com.codekopi.rcvrcv.R;
import com.codekopi.rcvrcv.dragdrop.model.AntrianService;

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
  /*@BindView(R.id.imgDrag) ImageView imgDrag;*/
  public VieholderAntrian(@NonNull View itemView) {
    super(itemView);
    ButterKnife.bind(this,itemView);
  }
  public void bind(AntrianService service){
    tvNameAntrina.setText(service.getName());

  }


}
