package com.valmojr.guardian.model.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.valmojr.guardian.model.Report;

public class ReportDAOTest {
    @Test
    public void canCreateAndReadInformation() {
        ReportDAO classUnderTest = new ReportDAO();
        Report Report = new Report();
        Report.setReportObservation("observation");
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(Report);
        int afterCreate= classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
    }
    @Test
    public void canReadInformationById() {
        ReportDAO classUnderTest = new ReportDAO();
        assertEquals("observation", classUnderTest.read().get(classUnderTest.read().size()-1).getReportObservation());
    }
    @Test
    public void canUpdateInformation() {
        ReportDAO classUnderTest = new ReportDAO();
        Report Report = new Report();
        Report.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        Report.setReportObservation("new observation");
        classUnderTest.update(Report);
        assertEquals("new observation", classUnderTest.read().get(classUnderTest.read().size()-1).getReportObservation());
    }
    @Test
    public void canDeleteInformation() {
        ReportDAO classUnderTest = new ReportDAO();
        int beforeDelete = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterDelete = classUnderTest.read().size();
        assertEquals(beforeDelete, afterDelete+1);
    }
}
