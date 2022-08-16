package guardian.backend.control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class ReportTest {
    @Test
    public void canAllocateAndUpdateInformation() {
        Report classUnderTest = new Report();
        ArrayList<Integer> testIntegerArray = new ArrayList<Integer>();
        ArrayList<String> testStringArray = new ArrayList<String>();
        ArrayList<Date> testDateArray = new ArrayList<Date>();
        classUnderTest.setId(0);
        classUnderTest.setReportDescription("reportDescription");
        classUnderTest.setAssignedUserId(testIntegerArray);
        classUnderTest.setAssignedRelatedEventId(0);
        classUnderTest.setReportedLocation(testStringArray);
        classUnderTest.setReportedLocationTime(testDateArray);
        classUnderTest.setReportObservation("reportObservation");

        assertEquals(classUnderTest.getId(), 0);
        assertEquals(classUnderTest.getReportDescription(), "reportDescription");
        assertEquals(classUnderTest.getAssignedRelatedEventId(), 0);
        assertEquals(classUnderTest.getReportedLocation(), testStringArray);
        assertEquals(classUnderTest.getReportedLocationTime(), testDateArray);
        assertEquals(classUnderTest.getReportObservation(), "reportObservation");
    }
}
