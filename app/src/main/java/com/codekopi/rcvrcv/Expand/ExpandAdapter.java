package com.codekopi.rcvrcv.Expand;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.codekopi.rcvrcv.R;
import com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemConstants;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder;

/**
 * Created by GeekGarden on 25/08/2017.
 */

public class ExpandAdapter extends AbstractExpandableItemAdapter<ExpandAdapter.Holder,ExpandAdapter.ChildHolder> {
  public static abstract class MyBaseExpandeHolder extends AbstractExpandableItemViewHolder{
    public FrameLayout mContainer;
    public TextView mTextView;
    public MyBaseExpandeHolder(View v){
      super(v);
      mContainer = (FrameLayout) v.findViewById(R.id.container);
      mTextView = (TextView) v.findViewById(android.R.id.text1);

    }
  }
  public class ChildHolder  extends MyBaseExpandeHolder{

     public ChildHolder(View v) {
      super(v);
    }
  }

  public class Holder extends MyBaseExpandeHolder {

    public Holder(View v) {
      super(v);
    }
  }
  @Override
  public int getGroupCount() {
    return 0;
  }

  @Override
  public int getChildCount(int groupPosition) {
    return 0;
  }

  @Override
  public long getGroupId(int groupPosition) {
    return 0;
  }

  @Override
  public long getChildId(int groupPosition, int childPosition) {
    return 0;
  }

  @Override
  public Holder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
    return null;
  }

  @Override
  public ChildHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
    return null;
  }

  @Override
  public void onBindGroupViewHolder(Holder holder, int groupPosition, int viewType) {

  }

  @Override
  public void onBindChildViewHolder(ChildHolder holder, int groupPosition, int childPosition,
      int viewType) {

  }

  @Override
  public boolean onCheckCanExpandOrCollapseGroup(Holder holder, int groupPosition, int x, int y,
      boolean expand) {
    return false;
  }

  private interface Expandable extends ExpandableItemConstants{

  }

}
