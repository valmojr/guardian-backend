package guardian.backend.control;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Action {
    private int id;
    private ArrayList<String> reportedPosition;
    private ArrayList<LocalDateTime> reportedPositionTime;
    private String description;
    private ArrayList<Integer> assignedUserId;
    private ArrayList<Integer> assignedIncidentId;
    boolean state;
    
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
}
