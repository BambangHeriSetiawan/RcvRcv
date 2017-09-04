
package com.codekopi.rcvrcv.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataPitPkb {

    @SerializedName("pkb")
    @Expose
    private String pkb;

    public String getPkb() {
        return pkb;
    }

    public void setPkb(String pkb) {
        this.pkb = pkb;
    }

}
