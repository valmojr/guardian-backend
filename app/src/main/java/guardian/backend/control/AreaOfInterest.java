package guardian.backend.control;

import java.util.Date;
import java.util.ArrayList;

public class AreaOfInterest {
    int id;
    ArrayList<String> reportedPosition;
    ArrayList<Date> reportedPositionTime;
    int danger;
    boolean state;
    String description;
    int assignedUserId;
    
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
    public ArrayList<Date> getReportedPositionTime() {
        return reportedPositionTime;
    }
    public void setReportedPositionTime(ArrayList<Date> reportedPositionTime) {
        this.reportedPositionTime = reportedPositionTime;
    }
    public int getDanger() {
        return danger;
    }
    public void setDanger(int danger) {
        this.danger = danger;
    }
    public boolean isState() {
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
    public int getAssignedUserId() {
        return assignedUserId;
    }
    public void setAssignedUserId(int assignedUserId) {
        this.assignedUserId = assignedUserId;
    }
}
