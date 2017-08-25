package com.codekopi.rcvrcv.Expand;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.codekopi.rcvrcv.R;


import com.codekopi.rcvrcv.common.data.AbstractAddRemoveExpandableDataProvider;
import com.codekopi.rcvrcv.common.widget.ExpandableItemIndicator;
import com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemConstants;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder;

/**
 * Created by GeekGarden on 25/08/2017.
 */

public class ExpandAdapter extends AbstractExpandableItemAdapter<ExpandAdapter.Holder,ExpandAdapter.ChildHolder> {
  private static final String TAG = "MyExpandableItemAdapter";
  private AbstractAddRemoveExpandableDataProvider mProvider;
  private RecyclerViewExpandableItemManager mExpandableItemManager;

  private interface Expandable extends ExpandableItemConstants{

  }
  public static abstract class MyBaseExpandeHolder extends AbstractExpandableItemViewHolder{
    public FrameLayout mContainer;
    public TextView mTextView;
    public MyBaseExpandeHolder(View v){
      super(v);
      mContainer = (FrameLayout) v.findViewById(R.id.container);
      mTextView = (TextView) v.findViewById(android.R.id.text1);

    }
  }
  public class Holder extends MyBaseExpandeHolder {
    public ExpandableItemIndicator mIndicator;
    public Holder(View v) {
      super(v);
      mIndicator =  v.findViewById(R.id.indicator);
    }
  }
  public class ChildHolder  extends MyBaseExpandeHolder{

     public ChildHolder(View v) {
      super(v);

    }
  }
  public ExpandAdapter (RecyclerViewExpandableItemManager expandableItemManager, AbstractAddRemoveExpandableDataProvider dataProvider){
    this.mExpandableItemManager = expandableItemManager;
    this.mProvider = dataProvider;
    setHasStableIds(true);
  }

  @Override
  public int getGroupCount() {
    return mProvider.getGroupCount();
  }

  @Override
  public int getChildCount(int groupPosition) {
    return mProvider.getChildCount(groupPosition);
  }

  @Override
  public long getGroupId(int groupPosition) {
    return mProvider.getGroupItem(groupPosition).getGroupId();
  }

  @Override
  public long getChildId(int groupPosition, int childPosition) {
    return mProvider.getChildItem(groupPosition, childPosition).getChildId();
  }
  @Override
  public int getGroupItemViewType(int groupPosition) {
    return 0;
  }

  @Override
  public int getChildItemViewType(int groupPosition, int childPosition) {
    return 0;
  }

  @Override
  public Holder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
    final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    final View v = inflater.inflate(R.layout.list_group_item, parent, false);
    return new Holder(v);
  }

  @Override
  public ChildHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
    final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    final View v = inflater.inflate(R.layout.list_item, parent, false);
    return new ChildHolder(v);
  }

  @Override
  public void onBindGroupViewHolder(Holder holder, int groupPosition, int viewType) {
// child item
    final AbstractAddRemoveExpandableDataProvider.BaseData item = mProvider.getGroupItem(groupPosition);

    // set text
    holder.mTextView.setText(item.getText());

    // mark as clickable
    holder.itemView.setClickable(true);

    // set background resource (target view ID: container)
    final int expandState = holder.getExpandStateFlags();
    if ((expandState & Expandable.STATE_FLAG_IS_UPDATED) != 0) {
      int bgResId;
      boolean isExpanded;
      boolean animateIndicator = ((expandState & Expandable.STATE_FLAG_HAS_EXPANDED_STATE_CHANGED) != 0);

      if ((expandState & Expandable.STATE_FLAG_IS_EXPANDED) != 0) {
        bgResId = R.drawable.bg_swipe_item_neutral;
        isExpanded = true;
      } else {
        bgResId = R.drawable.bg_swipe_item_neutral;
        isExpanded = false;
      }

      holder.mContainer.setBackgroundResource(bgResId);
      holder.mIndicator.setExpandedState(isExpanded, animateIndicator);
    } else {
      Log.d("TAG", "teste");
    }
  }

  @Override
  public void onBindChildViewHolder(ChildHolder holder, int groupPosition, int childPosition,
      int viewType) {
    final AbstractAddRemoveExpandableDataProvider.ChildData item = mProvider.getChildItem(groupPosition, childPosition);

    // set text
    holder.mTextView.setText(item.getText());

    // set background resource (target view ID: container)
    int bgResId;
    bgResId = R.drawable.bg_swipe_item_neutral;
    holder.mContainer.setBackgroundResource(bgResId);
  }

  @Override
  public boolean onCheckCanExpandOrCollapseGroup(Holder holder, int groupPosition, int x, int y,
      boolean expand) {
    // check is enabled
    if (!(holder.itemView.isEnabled() && holder.itemView.isClickable())) {
      return false;
    }

    return true;
  }
  @Override
  public boolean getInitialGroupExpandedState(int groupPosition) {
    // NOTE:
    // This method can also be used to control initial state of group items.
    // Make sure to call `setDefaultGroupsExpandedState(false)` to take effect.
    return false;
  }

  // NOTE: This method is called from Fragment
  public void addGroupAndChildItemsBottom(int groupCount, int childCount) {
    int groupPosition = mProvider.getGroupCount();

    for (int i = 0; i < groupCount; i++) {
      // add group
      mProvider.addGroupItem(groupPosition + i);
      // add children
      for (int j = 0; j < childCount; j++) {
        mProvider.addChildItem(groupPosition + i, j);
      }
    }

    mExpandableItemManager.notifyGroupItemRangeInserted(groupPosition, groupCount);
  }

  // NOTE: This method is called from Fragment
  public void removeGroupItemsBottom(int count) {
    int groupCount = mProvider.getGroupCount();

    count = Math.min(count, groupCount);

    int groupPosition = groupCount - count;

    for (int i = 0; i < count; i++) {
      mProvider.removeGroupItem(groupPosition);
    }

    mExpandableItemManager.notifyGroupItemRangeRemoved(groupPosition, count);
  }

  // NOTE: This method is called from Fragment
  public void clearGroupItems() {
    int groupCount = mProvider.getGroupCount();

    mProvider.clear();

    mExpandableItemManager.notifyGroupItemRangeRemoved(0, groupCount);
  }
}