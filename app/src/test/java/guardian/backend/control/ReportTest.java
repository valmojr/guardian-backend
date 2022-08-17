package guardian.backend.control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class ReportTest {
    @Test
    public void canAllocateAndUpdateInformation() {
        Report classUnderTest = new Report();
        ArrayList<Integer> testIntegerArray = new ArrayList<Integer>();
        ArrayList<String> testStringArray = new ArrayList<String>();
        ArrayList<LocalDateTime> testDateArray = new ArrayList<LocalDateTime>();
        classUnderTest.setId(0);
        classUnderTest.setReportDescription("reportDescription");
        classUnderTest.setAssignedUserId(testIntegerArray);
        classUnderTest.setAssignedRelatedEventId(0);
        classUnderTest.setReportedPosition(testStringArray);
        classUnderTest.setReportedPositionTime(testDateArray);
        classUnderTest.setReportObservation("reportObservation");

        assertEquals(classUnderTest.getId(), 0);
        assertEquals(classUnderTest.getReportDescription(), "reportDescription");
        assertEquals(classUnderTest.getAssignedRelatedEventId(), 0);
        assertEquals(classUnderTest.getReportedPosition(), testStringArray);
        assertEquals(classUnderTest.getReportedPositionTime(), testDateArray);
        assertEquals(classUnderTest.getReportObservation(), "reportObservation");
    }
}
