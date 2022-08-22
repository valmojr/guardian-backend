package com.valmojr.guardian.model;

public class Report_Action {
    private int id;
    private int assignedReportId;
    private int assignedActionId;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAssignedReportId() {
        return assignedReportId;
    }
    public void setAssignedReportId(int assignedReportId) {
        this.assignedReportId = assignedReportId;
    }
    public int getAssignedActionId() {
        return assignedActionId;
    }
    public void setAssignedActionId(int assignedActionId) {
        this.assignedActionId = assignedActionId;
    }
}
