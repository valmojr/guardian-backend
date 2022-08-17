package guardian.backend.control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class ActionTest {
    @Test
    public void canAllocateAndUpdateAllNecessaryInformation() {
        Action classUnderTest = new Action();
        ArrayList<Integer> testId = new ArrayList<Integer>();
        classUnderTest.setId(0);
        classUnderTest.setAssignedUserId(testId);
        classUnderTest.setAssignedIncidentId(testId);
        classUnderTest.setDescription("description");
        classUnderTest.setState(true);
        assertEquals(classUnderTest.getId(), 0);
        assertEquals(classUnderTest.getAssignedUserId(), testId);
        assertEquals(classUnderTest.getAssignedIncidentId(), testId);
        assertEquals(classUnderTest.getDescription(), "description");
        assertEquals(classUnderTest.getState(), true);
    }
    @Test
    public void canAddReportedPosition() {
        Action classUnderTest = new Action();
        classUnderTest.addReportedPositon("x,y");
        assertEquals(classUnderTest.getReportedPosition().get(0), "x,y");
    }
}
