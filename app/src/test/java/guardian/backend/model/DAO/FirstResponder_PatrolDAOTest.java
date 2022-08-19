package guardian.backend.model.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import guardian.backend.model.FirstResponder_Patrol;

public class FirstResponder_PatrolDAOTest {
    @Test
    public void canCreateAndReadInformation() {
        FirstResponder_PatrolDAO classUnderTest = new FirstResponder_PatrolDAO();
        FirstResponder_Patrol firstResponder_Patrol = new FirstResponder_Patrol();
        firstResponder_Patrol.setAssignedFirstResponderId(155);
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(firstResponder_Patrol);
        int afterCreate = classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
        assertEquals(155, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedFirstResponderId());
    }
    @Test
    public void canReadInformationById() {
        FirstResponder_PatrolDAO classUnderTest = new FirstResponder_PatrolDAO();
        assertEquals(155, classUnderTest.read(classUnderTest.read().get(classUnderTest.read().size()-1).getId()).getAssignedFirstResponderId());
    }
    @Test
    public void canUpdateInformation() {
        FirstResponder_PatrolDAO classUnderTest = new FirstResponder_PatrolDAO();
        FirstResponder_Patrol firstResponder_Patrol = new FirstResponder_Patrol();
        firstResponder_Patrol.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        firstResponder_Patrol.setAssignedFirstResponderId(121);
        classUnderTest.update(firstResponder_Patrol);
        assertEquals(121, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedFirstResponderId());
    }
    @Test
    public void canDeleteInformation() {
        FirstResponder_PatrolDAO classUnderTest = new FirstResponder_PatrolDAO();
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1));
        int afterCreate = classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate+1);
    }
}
