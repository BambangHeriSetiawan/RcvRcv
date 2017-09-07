package com.codekopi.rcvrcv.dragdrop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.codekopi.rcvrcv.R;
import com.codekopi.rcvrcv.dragdrop.AdapterAntrian.Holder;
import com.codekopi.rcvrcv.model.antrian.Datum;
import java.util.List;

/**
 * Created by GeekGarden on 28/08/2017.
 */

public class AdapterAntrian extends Adapter<Holder> {


  private Context mContext;
  private List<Datum> mList;
  private OnAtrianClickListener listener;

  public AdapterAntrian(Context mContext, List<Datum> mList, OnAtrianClickListener listener) {
    this.mContext = mContext;
    this.mList = mList;
    this.listener = listener;
  }

  @Override
  public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.item_pit, parent, false);
    Holder holder = new Holder(view, this.listener);
    return holder;
  }

  @Override
  public void onBindViewHolder(Holder holder, int position) {
    Datum pit = getMlist(position);
    /*holder.tvText.setText(pit.getName());*/
    int countPit = pit.getRepairOrders().size();
    holder.tvNameCA.setText(pit.getName());
    holder.tvJmlhQueue.setText(""+countPit);
  }

  private Datum getMlist(int pos) {
    return mList.get(pos);
  }

  public void UpdateListItem(List<Datum> list) {
    this.mList = list;
    notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    return mList.size();
  }

  public class Holder extends ViewHolder implements OnClickListener {

    OnAtrianClickListener listener;
    @BindView(R.id.tvNameCA)
    TextView tvNameCA;
    @BindView(R.id.tvJmlhQueue)
    TextView tvJmlhQueue;
    public Holder(View itemView, OnAtrianClickListener listener) {
      super(itemView);
      ButterKnife.bind(this,itemView);
      this.listener = listener;
      itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
      Datum datum = getMlist(getAdapterPosition());
      this.listener.AntrianClickListener(String.valueOf(datum.getId()));
    }
  }

  public interface OnAtrianClickListener {

    void AntrianClickListener(String id);
  }
}
