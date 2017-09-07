package com.codekopi.rcvrcv.dragdrop;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.codekopi.rcvrcv.Listener;
import com.codekopi.rcvrcv.R;
import com.codekopi.rcvrcv.model.antrian.details.RepairOrder;
import com.codekopi.rcvrcv.dragdrop.AdapterAntrianTop.Holder;
import java.util.List;

/**
 * Created by GeekGarden on 28/08/2017.
 */

public class AdapterAntrianTop extends Adapter<Holder> {



  private Context mContext;
  private List<RepairOrder> mList;
  private Listener listener;

  public AdapterAntrianTop(Context mContext, List<RepairOrder> mList, Listener listener) {
    this.mContext = mContext;
    this.mList = mList;
    this.listener = listener;
  }

  @Override
  public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.item_queue, parent, false);
    return new Holder(view);
  }

  @Override
  public void onBindViewHolder(Holder holder, int position) {
    RepairOrder ro = getMlist(position);
    holder.tvNoPkb.setText(ro.getNumber());
    holder.tvNopol.setText(ro.getLicensePlate());
    holder.imgStart.setVisibility(View.GONE);
    holder.lytMekanik.setVisibility(View.GONE);
  }

  private RepairOrder getMlist(int pos) {
    return mList.get(pos);
  }

  public void UpdateListItem(List<RepairOrder> list) {
    this.mList = list;
    notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    return mList.size();
  }

  public class Holder extends ViewHolder {

    @BindView(R.id.tvNoPkb)
    TextView tvNoPkb;
    @BindView(R.id.tvNopol)
    TextView tvNopol;
    @BindView(R.id.tvNameAntrina)
    TextView tvNameAntrina;
    @BindView(R.id.imgStart)
    ImageView imgStart;
    @BindView(R.id.lytMekanik)
    LinearLayout lytMekanik;
    public Holder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
