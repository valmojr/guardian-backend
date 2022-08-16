package guardian.backend.control;

import java.util.Date;
import java.util.ArrayList;

public class Action {
    int id;
    ArrayList<String> reportedPosition;
    ArrayList<Date> reportedPositionTime;
    String description;
    ArrayList<Integer> assignedUserId;
    ArrayList<Integer> assignedIncidentId;
    
    boolean state;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
