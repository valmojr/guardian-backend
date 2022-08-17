package guardian.backend.control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class AreaOfInterestTest {
    @Test
    public void canAllocateAndUpdateAllNecessaryInformation() {
        AreaOfInterest classUnderTest = new AreaOfInterest();
        ArrayList<String> testPositionReportRecord = new ArrayList<String>();
        ArrayList<LocalDateTime> testPositionReportTimeRecord = new ArrayList<LocalDateTime>();
        ArrayList<Integer> testActionId = new ArrayList<Integer>();
        classUnderTest.setId(0);
        classUnderTest.setReportedPosition(testPositionReportRecord);
        classUnderTest.setReportedPositionTime(testPositionReportTimeRecord);
        classUnderTest.setDanger(0);
        classUnderTest.setState(false);
        classUnderTest.setDescription("description");
        classUnderTest.setAssignedActionId(testActionId);
        assertEquals(classUnderTest.getId(), 0);
        assertEquals(classUnderTest.getReportedPosition(), testPositionReportRecord);
        assertEquals(classUnderTest.getReportedPositionTime(), testPositionReportTimeRecord);
        assertEquals(classUnderTest.getDanger(), 0);
        assertEquals(classUnderTest.getState(), false);
        assertEquals(classUnderTest.getDescription(), "description");
        assertEquals(classUnderTest.getAssignedActionId(), testActionId);

    }
}
