package guardian.backend;

import guardian.backend.model.Report;
import guardian.backend.model.DAO.ReportDAO;

public class App {
    public static void main(String[] args) {
        ReportDAO classUnderTest = new ReportDAO();
        Report Report = new Report();
        Report.setReportObservation("observation");
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(Report);
    }
}