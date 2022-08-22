package com.valmojr.guardian.model;

public class Report_Patrol {
    private int id;
    private int assignedReportId;
    private int assignedPatrolId;
    
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
    public int getAssignedPatrolId() {
        return assignedPatrolId;
    }
    public void setAssignedPatrolId(int assignedPatrolId) {
        this.assignedPatrolId = assignedPatrolId;
    }
}
