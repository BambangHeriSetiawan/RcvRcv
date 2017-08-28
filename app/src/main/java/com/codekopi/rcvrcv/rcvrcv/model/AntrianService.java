package com.codekopi.rcvrcv.rcvrcv.model;

/**
 * Created by GeekGarden on 28/08/2017.
 */

public class AntrianService {
  private String name;
  private String type;

  public AntrianService(String name, String type) {
    this.name = name;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
