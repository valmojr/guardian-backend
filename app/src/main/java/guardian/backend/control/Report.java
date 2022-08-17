package guardian.backend.control;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Report {
    private int id;
    private String reportDescription = "";
    private ArrayList<Integer> assignedUserId = new ArrayList<Integer>();
    private int assignedRelatedEventId;
    private ArrayList<String> reportedPosition = new ArrayList<String>();
    private ArrayList<LocalDateTime> reportedPositionTime = new ArrayList<LocalDateTime>();
    private String reportObservation = "";
    
    public Report() {};
    public Report(Patrol patrol) {};
    public Report(Action action) {};
    
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
    public ArrayList<String> getReportedPosition() {
        return reportedPosition;
    }
    public void setReportedPosition(ArrayList<String> reportedLocation) {
        this.reportedPosition = reportedLocation;
    }
    public ArrayList<LocalDateTime> getReportedPositionTime() {
        return reportedPositionTime;
    }
    public void setReportedPositionTime(ArrayList<LocalDateTime> reportedPositionTime) {
        this.reportedPositionTime = reportedPositionTime;
    }
    public String getReportObservation() {
        return reportObservation;
    }
    public void setReportObservation(String reportObservation) {
        this.reportObservation = reportObservation;
    }
    public void addReportedPositon(String reportedPosition) {
        this.getReportedPosition().add(reportedPosition);
        this.getReportedPositionTime().add(LocalDateTime.now());
    }
    public void addAssignedUserId(int id) {
        this.getAssignedUserId().add(id);
    }
}
