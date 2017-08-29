package com.codekopi.rcvrcv.expand;

/**
 * Created by GeekGarden on 29/08/2017.
 */

public abstract class AbstractExpandableDataProvider {
  public static abstract class BaseData {

    public abstract String getText();

    public abstract void setPinned(boolean pinned);

    public abstract boolean isPinned();
  }

  public static abstract class Items extends BaseData {
    public abstract boolean isSectionHeader();
    public abstract long getGroupId();
  }

  public static abstract class Item extends BaseData {
    public abstract long getChildId();
  }

  public abstract int getGroupCount();
  public abstract int getChildCount(int groupPosition);

  public abstract Items getGroupItem(int groupPosition);
  public abstract Item getChildItem(int groupPosition, int childPosition);

  public abstract void moveGroupItem(int fromGroupPosition, int toGroupPosition);
  public abstract void moveChildItem(int fromGroupPosition, int fromChildPosition, int toGroupPosition, int toChildPosition);

  public abstract void removeGroupItem(int groupPosition);
  public abstract void removeChildItem(int groupPosition, int childPosition);

  public abstract long undoLastRemoval();
}
