package com.codekopi.rcvrcv.Expand;

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
import com.codekopi.rcvrcv.common.data.AbstractAddRemoveExpandableDataProvider;
import com.h6ah4i.android.widget.advrecyclerview.animator.GeneralItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.animator.RefactoredDefaultItemAnimator;
import com.h6ah4i.android.widget.advrecyclerview.decoration.ItemShadowDecorator;
import com.h6ah4i.android.widget.advrecyclerview.decoration.SimpleListDividerDecorator;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;

public class ExpandFragment extends Fragment {
  private static final String SAVED_STATE_EXPANDABLE_ITEM_MANAGER = "RecyclerViewExpandableItemManager";

  private RecyclerView mRecyclerView;
  private RecyclerView.LayoutManager mLayoutManager;
  private ExpandAdapter mAdapter;
  private RecyclerView.Adapter mWrappedAdapter;
  private RecyclerViewExpandableItemManager mRecyclerViewExpandableItemManager;

  public ExpandFragment() {
    super();
    setHasOptionsMenu(true);
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_expand, container, false);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    //noinspection ConstantConditions
    mRecyclerView = (RecyclerView) getView().findViewById(R.id.recycler_view);
    mLayoutManager = new LinearLayoutManager(getContext());

    final Parcelable eimSavedState = (savedInstanceState != null) ? savedInstanceState.getParcelable(SAVED_STATE_EXPANDABLE_ITEM_MANAGER) : null;
    mRecyclerViewExpandableItemManager = new RecyclerViewExpandableItemManager(eimSavedState);

    // Expand all group items by default. This method must be called before creating a wrapper adapter.
    //
    // FYI: AbstractExpandableItemAdapter.getInitialGroupExpandedState() can also be used if you
    // need fine control of initial group items' state.
    mRecyclerViewExpandableItemManager.setDefaultGroupsExpandedState(true);

    //adapter
    final ExpandAdapter myItemAdapter = new ExpandAdapter(mRecyclerViewExpandableItemManager, getDataProvider());

    mAdapter = myItemAdapter;

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

  private boolean supportsViewElevation() {
    return (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP);
  }
  public AbstractAddRemoveExpandableDataProvider getDataProvider() {
    return ((ExpandActivity) getActivity()).getDataProvider();
  }
}
