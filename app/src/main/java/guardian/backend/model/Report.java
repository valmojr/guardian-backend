package guardian.backend.model;

public class Report {
    private int id;
    private String reportDescription;
    private String reportObservation;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getReportDescription() {
        return reportDescription;
    }
    public void setReportDescription(String reportDescription) {
        this.reportDescription = reportDescription;
    }
    public String getReportObservation() {
        return reportObservation;
    }
    public void setReportObservation(String reportObservation) {
        this.reportObservation = reportObservation;
    }
}
