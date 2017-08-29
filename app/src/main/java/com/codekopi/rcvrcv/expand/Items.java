package com.codekopi.rcvrcv.expand;

import java.util.List;

/**
 * Created by GeekGarden on 29/08/2017.
 */

public class Items {
  private long id;
  private List<Item> itemList;

  public Items(long id, List<Item> itemList) {
    this.id = id;
    this.itemList = itemList;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public List<Item> getItemList() {
    return itemList;
  }

  public void setItemList(List<Item> itemList) {
    this.itemList = itemList;
  }
}
