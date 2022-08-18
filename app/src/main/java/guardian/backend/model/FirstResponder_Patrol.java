package guardian.backend.model;

public class FirstResponder_Patrol {
    private int id;
    private int assignedFirstResponderId;
    private int assignedPatrolId;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAssignedFirstResponderId() {
        return assignedFirstResponderId;
    }
    public void setAssignedFirstResponderId(int assignedFirstResponderId) {
        this.assignedFirstResponderId = assignedFirstResponderId;
    }
    public int getAssignedPatrolId() {
        return assignedPatrolId;
    }
    public void setAssignedPatrolId(int assignedPatrolId) {
        this.assignedPatrolId = assignedPatrolId;
    }
}
