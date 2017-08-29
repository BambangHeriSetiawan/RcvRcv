package com.codekopi.rcvrcv.expand;

import android.content.Context;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codekopi.rcvrcv.R;
import com.h6ah4i.android.widget.advrecyclerview.animator.GeneralItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.animator.RefactoredDefaultItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.decoration.ItemShadowDecorator;
import com.h6ah4i.android.widget.advrecyclerview.decoration.SimpleListDividerDecorator;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils;

public class ExpadableFragment extends Fragment implements RecyclerViewExpandableItemManager.OnGroupCollapseListener,
    RecyclerViewExpandableItemManager.OnGroupExpandListener {
  private static final String SAVED_STATE_EXPANDABLE_ITEM_MANAGER = "RecyclerViewExpandableItemManager";
  private RecyclerView mRecyclerView;
  private RecyclerView.LayoutManager mLayoutManager;
  private RecyclerView.Adapter mWrappedAdapter;
  private RecyclerViewExpandableItemManager mRecyclerViewExpandableItemManager;
  public ExpadableFragment() {
    super();
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_expadable, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mRecyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view);
    mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

    final Parcelable eimSavedState = (savedInstanceState != null) ? savedInstanceState.getParcelable(SAVED_STATE_EXPANDABLE_ITEM_MANAGER) : null;
    mRecyclerViewExpandableItemManager = new RecyclerViewExpandableItemManager(eimSavedState);
    mRecyclerViewExpandableItemManager.setOnGroupExpandListener(this);
    mRecyclerViewExpandableItemManager.setOnGroupCollapseListener(this);

    //adapter
    final ExpandableAdapter myItemAdapter = new ExpandableAdapter(getDataProvider());

    mWrappedAdapter = mRecyclerViewExpandableItemManager.createWrappedAdapter(myItemAdapter);       // wrap for expanding

    final GeneralItemAnimator animator = new RefactoredDefaultItemAnimator();

    // Change animations are enabled by default since support-v7-recyclerview v22.
    // Need to disable them when using animation indicator.
    animator.setSupportsChangeAnimations(false);

    mRecyclerView.setLayoutManager(mLayoutManager);
    mRecyclerView.setAdapter(mWrappedAdapter);  // requires *wrapped* adapter
    mRecyclerView.setItemAnimator(animator);
    mRecyclerView.setHasFixedSize(false);
// additional decorations
    //noinspection StatementWithEmptyBody
    if (supportsViewElevation()) {
      // Lollipop or later has native drop shadow feature. ItemShadowDecorator is not required.
    } else {
      mRecyclerView.addItemDecoration(new ItemShadowDecorator((NinePatchDrawable) ContextCompat
          .getDrawable(getContext(), R.drawable.material_shadow_z1)));
    }
    mRecyclerView.addItemDecoration(new SimpleListDividerDecorator(ContextCompat.getDrawable(getContext(), R.drawable.list_divider_h), true));

    mRecyclerViewExpandableItemManager.attachRecyclerView(mRecyclerView);
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    // save current state to support screen rotation, etc...
    if (mRecyclerViewExpandableItemManager != null) {
      outState.putParcelable(
          SAVED_STATE_EXPANDABLE_ITEM_MANAGER,
          mRecyclerViewExpandableItemManager.getSavedState());
    }
  }

  @Override
  public void onDestroyView() {
    if (mRecyclerViewExpandableItemManager != null) {
      mRecyclerViewExpandableItemManager.release();
      mRecyclerViewExpandableItemManager = null;
    }

    if (mRecyclerView != null) {
      mRecyclerView.setItemAnimator(null);
      mRecyclerView.setAdapter(null);
      mRecyclerView = null;
    }

    if (mWrappedAdapter != null) {
      WrapperAdapterUtils.releaseAll(mWrappedAdapter);
      mWrappedAdapter = null;
    }
    mLayoutManager = null;
    super.onDestroyView();
  }

  private boolean supportsViewElevation() {
    return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP);
  }

  @Override
  public void onGroupCollapse(int groupPosition, boolean fromUser, Object payload) {

  }

  @Override
  public void onGroupExpand(int groupPosition, boolean fromUser, Object payload) {
    if (fromUser) {
      adjustScrollPositionOnGroupExpanded(groupPosition);
    }
  }

  private void adjustScrollPositionOnGroupExpanded(int groupPosition) {
    int childItemHeight = getActivity().getResources().getDimensionPixelSize(R.dimen.list_item_height);
    int topMargin = (int) (getActivity().getResources().getDisplayMetrics().density * 16); // top-spacing: 16dp
    int bottomMargin = topMargin; // bottom-spacing: 16dp

    mRecyclerViewExpandableItemManager.scrollToGroup(groupPosition, childItemHeight, topMargin, bottomMargin);
  }


  public AbstractExpandableDataProvider getDataProvider() {
    return ((ExspandableActivity) getActivity()).getDataProvider();
  }
}
