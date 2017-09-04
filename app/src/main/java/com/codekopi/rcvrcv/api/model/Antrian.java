
package com.codekopi.rcvrcv.api.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Antrian {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("dataAntrianPkb")
    @Expose
    private List<DataAntrianPkb> dataAntrianPkb = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DataAntrianPkb> getDataAntrianPkb() {
        return dataAntrianPkb;
    }

    public void setDataAntrianPkb(List<DataAntrianPkb> dataAntrianPkb) {
        this.dataAntrianPkb = dataAntrianPkb;
    }

}
