package com.codekopi.rcvrcv.rcvrcv.viewholder;


import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bignerdranch.expandablerecyclerview.ParentViewHolder;
import com.codekopi.rcvrcv.R;
import com.codekopi.rcvrcv.rcvrcv.model.CustomerAdvisor;

/**
 * Created by GeekGarden on 28/08/2017.
 */

public class VieholderCA extends ParentViewHolder {
  @BindView(R.id.tvNameCA)TextView tvNameCA;
  public VieholderCA(View itemView) {
    super(itemView);
    ButterKnife.bind(this,itemView);
  }
  public void bind(CustomerAdvisor customerAdvisor){
    tvNameCA.setText(customerAdvisor.getName());
  }
}
