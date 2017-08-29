package com.codekopi.rcvrcv.expand;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.codekopi.rcvrcv.R;
import com.codekopi.rcvrcv.expand.AbstractExpandableDataProvider.BaseData;
import com.codekopi.rcvrcv.expand.AbstractExpandableDataProvider.Item;
import com.codekopi.rcvrcv.expand.ExpandableAdapter.ChildHolder;
import com.codekopi.rcvrcv.expand.ExpandableAdapter.Holder;
import com.h6ah4i.android.widget.advrecyclerview.expandable.ExpandableItemConstants;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder;

/**
 * Created by GeekGarden on 29/08/2017.
 */

public class ExpandableAdapter extends AbstractExpandableItemAdapter<Holder, ChildHolder> {

  private static final String TAG = "MyExpandableItemAdapter";

  public ExpandableAdapter(
      AbstractExpandableDataProvider dataProvider) {
    mProvider = dataProvider;

    // ExpandableItemAdapter requires stable ID, and also
    // have to implement the getGroupItemId()/getChildItemId() methods appropriately.
    setHasStableIds(true);
  }


  private interface Expandable extends ExpandableItemConstants {
  }

  private AbstractExpandableDataProvider mProvider;


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
    final BaseData item = mProvider.getGroupItem(groupPosition);

    // set text
    holder.text1.setText(item.getText());

    // mark as clickable
    holder.itemView.setClickable(true);

    // set background resource (target view ID: container)
    final int expandState = holder.getExpandStateFlags();

    if ((expandState & ExpandableItemConstants.STATE_FLAG_IS_UPDATED) != 0) {
      int bgResId;
      boolean isExpanded;
      boolean animateIndicator = ((expandState & Expandable.STATE_FLAG_HAS_EXPANDED_STATE_CHANGED)
          != 0);

      if ((expandState & Expandable.STATE_FLAG_IS_EXPANDED) != 0) {
        bgResId = R.drawable.bg_group_item_expanded_state;
        isExpanded = true;
      } else {
        bgResId = R.drawable.bg_group_item_normal_state;
        isExpanded = false;
      }

      holder.container.setBackgroundResource(bgResId);

      holder.mIndicator.setExpandedState(isExpanded, animateIndicator);
    }
  }

  @Override
  public void onBindChildViewHolder(ChildHolder holder, int groupPosition, int childPosition,
      int viewType) {
// group item
    final Item item = mProvider.getChildItem(groupPosition, childPosition);

    // set text
    holder.text1.setText(item.getText());

    // set background resource (target view ID: container)
    int bgResId;
    bgResId = R.drawable.bg_item_normal_state;
    holder.container.setBackgroundResource(bgResId);
  }

  @Override
  public boolean onCheckCanExpandOrCollapseGroup(Holder holder, int groupPosition, int x, int y,
      boolean expand) {
    // check the item is *not* pinned
    if (mProvider.getGroupItem(groupPosition).isPinned()) {
      // return false to raise View.OnClickListener#onClick() event
      return false;
    }

    // check is enabled
    if (!(holder.itemView.isEnabled() && holder.itemView.isClickable())) {
      return false;
    }
    return true;
  }

  public class ChildHolder extends AbstractExpandableItemViewHolder {
    @BindView(android.R.id.text1)
    TextView text1;
    @BindView(R.id.container)
    FrameLayout container;
    public ChildHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }

  public class Holder extends AbstractExpandableItemViewHolder {

    @BindView(android.R.id.text1)
    TextView text1;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.indicator)
    ExpandableItemIndicator mIndicator;

    public Holder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }
}
