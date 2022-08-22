package com.valmojr.guardian.model;

public class FirstResponder_Action {
    private int id;
    private int assignedFirstResponderId;
    private int assignedActionId;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAssignedFirstResponderId() {
        return assignedFirstResponderId;
    }
    public void setAssignedFirstResponderId(int assignedFirstResponderId) {
        this.assignedFirstResponderId = assignedFirstResponderId;
    }
    public int getAssignedActionId() {
        return assignedActionId;
    }
    public void setAssignedActionId(int assignedActionId) {
        this.assignedActionId = assignedActionId;
    }
}
