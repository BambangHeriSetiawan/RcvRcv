
package com.codekopi.rcvrcv.api.model.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("additional_information")
    @Expose
    private String additionalInformation;
    @SerializedName("maintenance_queue_type_id")
    @Expose
    private Integer maintenanceQueueTypeId;
    @SerializedName("branch_id")
    @Expose
    private Integer branchId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;
    @SerializedName("repair_orders")
    @Expose
    private List<RepairOrder> repairOrders = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public Integer getMaintenanceQueueTypeId() {
        return maintenanceQueueTypeId;
    }

    public void setMaintenanceQueueTypeId(Integer maintenanceQueueTypeId) {
        this.maintenanceQueueTypeId = maintenanceQueueTypeId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public List<RepairOrder> getRepairOrders() {
        return repairOrders;
    }

    public void setRepairOrders(List<RepairOrder> repairOrders) {
        this.repairOrders = repairOrders;
    }

}
