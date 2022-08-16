package guardian.backend.control;

import java.util.Date;
import java.util.ArrayList;

public class Report {
    private int id;
    private String reportDescription;
    private ArrayList<Integer> assignedUserId;
    private int assignedRelatedEventId;
    private ArrayList<String> reportedLocation;
    private ArrayList<Date> reportedLocationTime;
    private String reportObservation;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getReportDescription() {
        return reportDescription;
    }
    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }
    public ArrayList<Integer> getAssignedUserId() {
        return assignedUserId;
    }
    public void setAssignedUserId(ArrayList<Integer> assignedUserId) {
        this.assignedUserId = assignedUserId;
    }
    public int getAssignedRelatedEventId() {
        return assignedRelatedEventId;
    }
    public void setAssignedRelatedEventId(int assignedRelatedEventId) {
        this.assignedRelatedEventId = assignedRelatedEventId;
    }
    public ArrayList<String> getReportedLocation() {
        return reportedLocation;
    }
    public void setReportedLocation(ArrayList<String> reportedLocation) {
        this.reportedLocation = reportedLocation;
    }
    public ArrayList<Date> getReportedLocationTime() {
        return reportedLocationTime;
    }
    public void setReportedLocationTime(ArrayList<Date> reportedLocationTime) {
        this.reportedLocationTime = reportedLocationTime;
    }
    public String getReportObservation() {
        return reportObservation;
    }
    public void setReportObservation(String reportObservation) {
        this.reportObservation = reportObservation;
    }
}
