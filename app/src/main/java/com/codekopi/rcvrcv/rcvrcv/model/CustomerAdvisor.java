package com.codekopi.rcvrcv.rcvrcv.model;

import com.bignerdranch.expandablerecyclerview.model.Parent;
import java.util.List;

/**
 * Created by GeekGarden on 28/08/2017.
 */

public class CustomerAdvisor implements Parent<AntrianService> {
  private String name;
  private List<AntrianService>  antrianServices ;

  public CustomerAdvisor(String name,
      List<AntrianService> antrianServices) {
    this.name = name;
    this.antrianServices = antrianServices;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<AntrianService> getAntrianServices() {
    return antrianServices;
  }

  public void setAntrianServices(
      List<AntrianService> antrianServices) {
    this.antrianServices = antrianServices;
  }

  @Override
  public List<AntrianService> getChildList() {
    return antrianServices;
  }

  @Override
  public boolean isInitiallyExpanded() {
    return true;
  }
}
