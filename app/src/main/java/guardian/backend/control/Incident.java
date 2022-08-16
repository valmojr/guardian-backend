package guardian.backend.control;

import java.util.ArrayList;
import java.util.Date;

public class Incident {
    private int id;
    private ArrayList<String> reportedPosition;
    private ArrayList<Date> reportedPositionTime;
    private int danger;
    private int state;
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
    public ArrayList<Integer> getAssignedActionId() {
        return assignedActionId;
    }
    public void setAssignedActionId(ArrayList<Integer> assignedActionId) {
        this.assignedActionId = assignedActionId;
    }
    public void updateReport(String newPosition, Date newReportTime) {
        this.reportedPosition.add(newPosition);
        this.reportedPositionTime.add(newReportTime);
    }
}
