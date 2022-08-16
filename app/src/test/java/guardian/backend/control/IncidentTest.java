package guardian.backend.control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class IncidentTest {
    @Test
    public void canAllocateAndUpdateAllNecessaryInformation() {
        Incident classUnderTest = new Incident();
        ArrayList<Integer> testIntegerArray = new ArrayList<Integer>();
        ArrayList<String> testStringArray = new ArrayList<String>();
        ArrayList<Date> testDateArray = new ArrayList<Date>();
        classUnderTest.setId(0);
        classUnderTest.setReportedPosition(testStringArray);
        classUnderTest.setReportedPositionTime(testDateArray);
        classUnderTest.setDanger(0);
        classUnderTest.setState(0);
        classUnderTest.setDescription("description");
        classUnderTest.setAssignedActionId(testIntegerArray);
        assertEquals(classUnderTest.getId(), 0);
        assertEquals(classUnderTest.getReportedPosition(), testStringArray);
        assertEquals(classUnderTest.getReportedPositionTime(), testDateArray);
        assertEquals(classUnderTest.getDanger(), 0);
        assertEquals(classUnderTest.getState(), 0);
        assertEquals(classUnderTest.getDescription(), "description");
        assertEquals(classUnderTest.getAssignedActionId(), testIntegerArray);
    }
}
