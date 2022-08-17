package guardian.backend.control;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Action {
    private int id;
    private ArrayList<String> reportedPosition = new ArrayList<String>();
    private ArrayList<LocalDateTime> reportedPositionTime = new ArrayList<LocalDateTime>();
    private String description;
    private ArrayList<Integer> assignedUserId = new ArrayList<Integer>();
    private ArrayList<Integer> assignedIncidentId = new ArrayList<Integer>();
    boolean state;
    
    public Action() {
        this.setState(false);
    }
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public ArrayList<Integer> getAssignedUserId() {
        return assignedUserId;
    }
    public void setAssignedUserId(ArrayList<Integer> assignedUserId) {
        this.assignedUserId = assignedUserId;
    }
    public ArrayList<Integer> getAssignedIncidentId() {
        return assignedIncidentId;
    }
    public void setAssignedIncidentId(ArrayList<Integer> assignedIncidentId) {
        this.assignedIncidentId = assignedIncidentId;
    }
    public boolean getState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
    public void addReportedPositon(String reportedPosition) {
        this.getReportedPosition().add(reportedPosition);
        this.getReportedPositionTime().add(LocalDateTime.now());
        this.state = true;
    }
    public void addAssignedUserId(int id) {
        this.assignedUserId.add(id);
    }
    public void addAssignedIncidentId(int id) {
        this.assignedIncidentId.add(id);
    }
}
