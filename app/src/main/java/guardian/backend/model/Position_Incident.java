package guardian.backend.model;

import java.time.LocalDateTime;

public class Position_Incident {
    private int id;
    private int assignedIncidentId;
    private String reportedPosition = "";
    private LocalDateTime reportedTime = LocalDateTime.now();

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAssignedIncidentId() {
        return assignedIncidentId;
    }
    public void setAssignedIncidentId(int assignedIncidentId) {
        this.assignedIncidentId = assignedIncidentId;
    }
    public String getReportedPosition() {
        return reportedPosition;
    }
    public void setReportedPosition(String reportedPosition) {
        this.reportedPosition = reportedPosition;
    }
    public LocalDateTime getReportedTime() {
        return reportedTime;
    }
    public void setReportedTime(LocalDateTime reportedTime) {
        this.reportedTime = reportedTime;
    }
}
