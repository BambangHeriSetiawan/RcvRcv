package com.codekopi.rcvrcv.firebase;

/**
 * Created by GeekGarden on 28/08/2017.
 */

public class ListTiket {
  public ListTiket(){}
  private String date;

  private String descripsiton;

  private Integer id;

  private String namaCustomer;

  private String snAlat;

  private String status;

  private String typeAlat;

  private String urgencyLevel;

  public ListTiket(String date, String descripsiton, Integer id, String namaCustomer,
      String snAlat, String status, String typeAlat, String urgencyLevel) {
    this.date = date;
    this.descripsiton = descripsiton;
    this.id = id;
    this.namaCustomer = namaCustomer;
    this.snAlat = snAlat;
    this.status = status;
    this.typeAlat = typeAlat;
    this.urgencyLevel = urgencyLevel;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getDescripsiton() {
    return descripsiton;
  }

  public void setDescripsiton(String descripsiton) {
    this.descripsiton = descripsiton;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNamaCustomer() {
    return namaCustomer;
  }

  public void setNamaCustomer(String namaCustomer) {
    this.namaCustomer = namaCustomer;
  }

  public String getSnAlat() {
    return snAlat;
  }

  public void setSnAlat(String snAlat) {
    this.snAlat = snAlat;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getTypeAlat() {
    return typeAlat;
  }

  public void setTypeAlat(String typeAlat) {
    this.typeAlat = typeAlat;
  }

  public String getUrgencyLevel() {
    return urgencyLevel;
  }

  public void setUrgencyLevel(String urgencyLevel) {
    this.urgencyLevel = urgencyLevel;
  }
}
