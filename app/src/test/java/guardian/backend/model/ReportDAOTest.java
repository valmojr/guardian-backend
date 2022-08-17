package guardian.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import guardian.backend.control.Report;

public class ReportDAOTest {
    @Test
    public void canCreateAndReadReports() {
        Report report = new Report();
        report.setReportDescription("this Report was just created!");
        report.addAssignedUserId(0);
        ReportDAO classUnderTest = new ReportDAO();
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(report);
        int afterCreate = classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
    };
    @Test
    public void canUpdateReports() {
        String description = "this Report was just updated!";
        Report report = new Report();
        ReportDAO classUnderTest = new ReportDAO();
        report.setReportDescription(description);
        report.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        classUnderTest.update(report);
        assertEquals(classUnderTest.read().get(classUnderTest.read().size()-1).getReportDescription(), description);
    };
    @Test
    public void canDeleteReports() {
        ReportDAO classUnderTest = new ReportDAO();
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterCreate = classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate+1);
    };
}
