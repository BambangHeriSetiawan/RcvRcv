package com.codekopi.rcvrcv.expand;


import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.codekopi.rcvrcv.R;
import com.codekopi.rcvrcv.expand.ExpandableAdapter.ChildHolder;
import com.codekopi.rcvrcv.expand.ExpandableAdapter.Holder;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder;
import java.net.ConnectException;
import java.util.List;

/**
 * Created by GeekGarden on 29/08/2017.
 */

public class ExpandableAdapter extends AbstractExpandableItemAdapter<Holder,ChildHolder> {
  private List<Items> mItems;
  private Context mContext;

  public ExpandableAdapter(List<Items> mItems, Context mContext) {
    this.mItems = mItems;
    this.mContext = mContext;
    setHasStableIds(true);
  }

  @Override
  public int getGroupCount() {
    return mItems.size();
  }

  @Override
  public int getChildCount(int groupPosition) {
    return mItems.get(groupPosition).getItemList().size();
  }

  @Override
  public long getGroupId(int groupPosition) {
    return mItems.get(groupPosition).getId();
  }

  @Override
  public long getChildId(int groupPosition, int childPosition) {
    return mItems.get(groupPosition).getItemList().get(childPosition).getId();
  }

  @Override
  public Holder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.item_rcv_ca,parent,false);
    return new Holder(view);
  }

  @Override
  public ChildHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.item_rcv_ca,parent,false);
    return new ChildHolder(view);
  }

  @Override
  public void onBindGroupViewHolder(Holder holder, int groupPosition, int viewType) {

  }

  @Override
  public void onBindChildViewHolder(ChildHolder holder, int groupPosition, int childPosition, int viewType) {

  }

  @Override
  public boolean onCheckCanExpandOrCollapseGroup(Holder holder, int groupPosition, int x, int y, boolean expand) {
    return false;
  }

  public class ChildHolder extends AbstractExpandableItemViewHolder{

    public ChildHolder(View itemView) {
      super(itemView);
    }
  }

  public class Holder extends AbstractExpandableItemViewHolder{

    public Holder(View itemView) {
      super(itemView);
    }
  }
}
