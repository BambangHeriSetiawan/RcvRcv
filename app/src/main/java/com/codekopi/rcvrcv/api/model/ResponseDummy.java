
package com.codekopi.rcvrcv.api.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseDummy {

    @SerializedName("antrian")
    @Expose
    private List<Antrian> antrian = null;
    @SerializedName("pit")
    @Expose
    private List<Pit> pit = null;

    public List<Antrian> getAntrian() {
        return antrian;
    }

    public void setAntrian(List<Antrian> antrian) {
        this.antrian = antrian;
    }

    public List<Pit> getPit() {
        return pit;
    }

    public void setPit(List<Pit> pit) {
        this.pit = pit;
    }

}
