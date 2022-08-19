package guardian.backend.model.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import guardian.backend.model.Patrol;

public class PatrolDAOTest {
    @Test
    public void canCreateAndReadInformation() {
        PatrolDAO classUnderTest = new PatrolDAO();
        Patrol patrol = new Patrol();
        patrol.setObservation("observation");
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(patrol);
        int afterCreate= classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
    }
    @Test
    public void canReadInformationById() {
        PatrolDAO classUnderTest = new PatrolDAO();
        assertEquals("observation", classUnderTest.read().get(classUnderTest.read().size()-1).getObservation());
    }
    @Test
    public void canUpdateInformation() {
        PatrolDAO classUnderTest = new PatrolDAO();
        Patrol patrol = new Patrol();
        patrol.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        patrol.setObservation("new observation");
        classUnderTest.update(patrol);
        assertEquals("new observation", classUnderTest.read().get(classUnderTest.read().size()-1).getObservation());
    }
    @Test
    public void canDeleteInformation() {
        PatrolDAO classUnderTest = new PatrolDAO();
        int beforeDelete = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterDelete = classUnderTest.read().size();
        assertEquals(beforeDelete, afterDelete+1);
    }
}
