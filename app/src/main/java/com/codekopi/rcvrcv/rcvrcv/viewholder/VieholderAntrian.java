package com.codekopi.rcvrcv.rcvrcv.viewholder;

import android.support.annotation.NonNull;
import android.view.View;
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

public class VieholderAntrian extends ChildViewHolder {

  /**
   * Default constructor.
   *
   * @param itemView The {@link View} being hosted in this ViewHolder
   */
  @BindView(R.id.tvNameCA) TextView tvNameCA;
  @BindView(R.id.tvNameAntrina) TextView tvNameAntrina;
  public VieholderAntrian(@NonNull View itemView) {
    super(itemView);
    ButterKnife.bind(this,itemView);
  }
  public void bind(AntrianService service){
    tvNameCA.setText(service.getType());
    tvNameAntrina.setText(service.getName());

  }
}
