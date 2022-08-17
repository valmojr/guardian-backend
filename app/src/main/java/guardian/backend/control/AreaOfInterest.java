package guardian.backend.control;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class AreaOfInterest {
    private int id;
    private ArrayList<String> reportedPosition;
    private ArrayList<LocalDateTime> reportedPositionTime;
    private int danger;
    private boolean state;
    private String description;
    private ArrayList<Integer> assignedActionId;
    
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
    public boolean getState() {
        return state;
    }
    public void setState(boolean state) {
        this.state = state;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public ArrayList<Integer> getAssignedActionId() {
        return assignedActionId;
    }
    public void setAssignedActionId(ArrayList<Integer> assignedActionId) {
        this.assignedActionId = assignedActionId;
    }
}
