package com.codekopi.rcvrcv;

import android.support.v7.widget.RecyclerView;
import android.view.DragEvent;
import android.view.View;
import java.util.List;

/**
 * Created by GeekGarden on 25/08/2017.
 */

public class DragListener implements View.OnDragListener {
  private boolean isDropped =  false;
  private Listener listener;

  public DragListener(Listener listener) {
    this.listener = listener;
  }

  @Override
  public boolean onDrag(View v, DragEvent dragEvent) {
    switch (dragEvent.getAction()) {
      case DragEvent.ACTION_DROP:
        isDropped = true;
        int positionTarget = -1;

        View viewSource = (View) dragEvent.getLocalState();
        int viewId = v.getId();
        final int framCA = R.id.cv_ca;
        final int tvEmpetyListTop = R.id.tvEmptyListTop;
        final int tvEmpetyListBottom = R.id.tvEmptyListBottom;
        final int rcvCA = R.id.rcv_ca;
        final int rcvMA = R.id.rcv_ma;
        switch (viewId) {
          case framCA:
          case tvEmpetyListTop:
          case tvEmpetyListBottom:
          case rcvCA:
          case rcvMA:
            RecyclerView target;
            switch (viewId) {
              case tvEmpetyListTop:
              case rcvCA:
                target = v.getRootView().findViewById(R.id.rcv_ca);
                break;
              case tvEmpetyListBottom:
              case rcvMA:
                target = v.getRootView().findViewById(R.id.rcv_ma);
                break;
                default:
                  target = (RecyclerView) v.getParent();
                  positionTarget = (int) v.getTag();
            }
            if (viewSource != null) {
              RecyclerView source = (RecyclerView) viewSource.getParent();

              ListAdapter adapterSource = (ListAdapter) source.getAdapter();
              int positionSource = (int) viewSource.getTag();
              int sourceId = source.getId();

              String list = adapterSource.getList().get(positionSource);
              List<String> listSource = adapterSource.getList();

              listSource.remove(positionSource);
              adapterSource.UpdateList(listSource);
              adapterSource.notifyDataSetChanged();

              ListAdapter adapterTarget = (ListAdapter) target.getAdapter();
              List<String> customListTarget = adapterTarget.getList();
              if (positionTarget >= 0) {
                customListTarget.add(positionTarget, list);
              } else {
                customListTarget.add(list);
              }
              adapterTarget.UpdateList(customListTarget);
              adapterTarget.notifyDataSetChanged();

              if (sourceId == rcvMA && adapterSource.getItemCount() < 1) {
                listener.setEmptyListBottom(true);
              }
              if (viewId == tvEmpetyListBottom) {
                listener.setEmptyListBottom(false);
              }
              if (sourceId == rcvCA && adapterSource.getItemCount() < 1) {
                listener.setEmptyListTop(true);
              }
              if (viewId == tvEmpetyListTop) {
                listener.setEmptyListTop(false);
              }
            }
            break;
        }
        break;
    }
    if (!isDropped && dragEvent.getLocalState() != null) {
      ((View) dragEvent.getLocalState()).setVisibility(View.VISIBLE);
    }
    return true;
  }

}
