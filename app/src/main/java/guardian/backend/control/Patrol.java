package guardian.backend.control;

import java.util.ArrayList;

public class Patrol {
    private int id;
    private String description;
    private int designatedAreaOfInterestId;
    private ArrayList<Integer> assignedUserId;
    private ArrayList<Integer> assignedIncidentId;
    private boolean state;
    
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
    public int getDesignatedAreaOfInterestId() {
        return designatedAreaOfInterestId;
    }
    public void setDesignatedAreaOfInterestId(int designatedAreaOfInterest) {
        this.designatedAreaOfInterestId = designatedAreaOfInterest;
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
