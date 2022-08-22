package com.valmojr.guardian.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Incident {
    private int id;
    private ArrayList<String> reportedPosition = new ArrayList<String>();
    private ArrayList<LocalDateTime> reportedPositionTime = new ArrayList<LocalDateTime>();
    private int danger;
    private int state;
    private String description;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public ArrayList<String> getReportedPosition() {
        return reportedPosition;
    }
    public void setReportedPosition(ArrayList<String> reportedPosition) {
        this.reportedPosition = reportedPosition;
    }
    public ArrayList<LocalDateTime> getReportedPositionTime() {
        return reportedPositionTime;
    }
    public void setReportedPositionTime(ArrayList<LocalDateTime> reportedPositionTime) {
        this.reportedPositionTime = reportedPositionTime;
    }
    public int getDanger() {
        return danger;
    }
    public void setDanger(int danger) {
        this.danger = danger;
    }
    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public void updateReport(String reportedPosition) {
        this.getReportedPosition().add(reportedPosition);
        this.getReportedPositionTime().add(LocalDateTime.now());
    }
}
