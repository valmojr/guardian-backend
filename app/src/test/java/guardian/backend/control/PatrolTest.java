package guardian.backend.control;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class PatrolTest {
    @Test
    public void canAllocateAndUpdateAllNecessaryInformation() {
        Patrol classUnderTest = new Patrol();
        ArrayList<Integer> testIntegerArray = new ArrayList<Integer>();
        classUnderTest.setId(0);
        classUnderTest.setDescription("description");
        classUnderTest.setAssignedUserId(testIntegerArray);
        classUnderTest.setAssignedIncidentId(testIntegerArray);
        classUnderTest.setState(true);
        assertEquals(classUnderTest.getId(), 0);
        assertEquals(classUnderTest.getDescription(), "description");
        assertEquals(classUnderTest.getAssignedUserId(), testIntegerArray);
        assertEquals(classUnderTest.getAssignedIncidentId(), testIntegerArray);
        assertEquals(classUnderTest.getState(), true);
    }
}
