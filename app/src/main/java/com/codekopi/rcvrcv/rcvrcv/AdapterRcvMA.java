package com.codekopi.rcvrcv.rcvrcv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.codekopi.rcvrcv.Listener;
import com.codekopi.rcvrcv.R;
import com.codekopi.rcvrcv.rcvrcv.model.CustomerAdvisor;
import java.util.List;

/**
 * Created by GeekGarden on 28/08/2017.
 */

public class AdapterRcvMA extends RecyclerView.Adapter<AdapterRcvMA.Holder> {
  private Context mContext;
  private List<String>mList;
  private Listener listener;
  public AdapterRcvMA(Context mContext, List<String> mList,Listener listener) {
    this.mContext = mContext;
    this.mList = mList;
    this.listener = listener;
  }


  @Override
  public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.rcv_ma,parent,false);
    return new Holder(view);
  }

  @Override
  public void onBindViewHolder(Holder holder, int position) {
    holder.tvText.setText("MA "+position);
  }
  private List<String> getMlist(){
    return mList;
  }
  private void UpdateListItem(List<String> list){
    this.mList = list;
    notifyDataSetChanged();
  }
  @Override
  public int getItemCount() {
    return mList.size();
  }

  public class Holder extends RecyclerView.ViewHolder {
    @BindView(R.id.tvNameMekanik)TextView tvText;
    public Holder(View itemView) {
      super(itemView);
      ButterKnife.bind(this,itemView);
    }
  }
}
