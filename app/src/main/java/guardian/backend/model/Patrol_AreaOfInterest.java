package guardian.backend.model;

public class Patrol_AreaOfInterest {
    private int id;
    private int assignedPatrolId;
    private int assignedAreaOfInterestId;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAssignedPatrolId() {
        return assignedPatrolId;
    }
    public void setAssignedPatrolId(int assignedPatrolId) {
        this.assignedPatrolId = assignedPatrolId;
    }
    public int getAssignedAreaOfInterestId() {
        return assignedAreaOfInterestId;
    }
    public void setAssignedAreaOfInterestId(int assignedAreaOfInterestId) {
        this.assignedAreaOfInterestId = assignedAreaOfInterestId;
    }
}
