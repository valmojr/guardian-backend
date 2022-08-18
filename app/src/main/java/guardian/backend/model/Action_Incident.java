package guardian.backend.model;

public class Action_Incident {
    private int id;
    private int assignedActionId;
    private int assignedIncidentId;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAssignedActionId() {
        return assignedActionId;
    }
    public void setAssignedActionId(int assignedActionId) {
        this.assignedActionId = assignedActionId;
    }
    public int getAssignedIncidentId() {
        return assignedIncidentId;
    }
    public void setAssignedIncidentId(int assignedIncidentId) {
        this.assignedIncidentId = assignedIncidentId;
    }
}
