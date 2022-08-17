package guardian.backend;

import guardian.backend.control.Report;
import guardian.backend.model.ReportDAO;

public class App {
    public static void main(String[] args) {
        String description = "this Report was just updated!";
        Report report = new Report();
        ReportDAO classUnderTest = new ReportDAO();
        report.setReportDescription(description);
        report.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        System.out.println(report.getId());
        classUnderTest.update(report);
    }
}