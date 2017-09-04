
package com.codekopi.rcvrcv.api.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pit {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("dataPitPkb")
    @Expose
    private List<DataPitPkb> dataPitPkb = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DataPitPkb> getDataPitPkb() {
        return dataPitPkb;
    }

    public void setDataPitPkb(List<DataPitPkb> dataPitPkb) {
        this.dataPitPkb = dataPitPkb;
    }

}
