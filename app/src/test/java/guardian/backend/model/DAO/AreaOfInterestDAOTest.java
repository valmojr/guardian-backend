package guardian.backend.model.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import guardian.backend.model.AreaOfInterest;

public class AreaOfInterestDAOTest {
    @Test
    public void canCreateAndReadInformation() {
        AreaOfInterestDAO classUnderTest = new AreaOfInterestDAO();
        AreaOfInterest areaOfInterest = new AreaOfInterest();
        areaOfInterest.setObservation("description");
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(areaOfInterest);
        int afterCreate= classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
    }
    @Test
    public void canReadInformationById() {
        AreaOfInterestDAO classUnderTest = new AreaOfInterestDAO();
        assertEquals("description", classUnderTest.read().get(classUnderTest.read().size()-1).getObservation());
    }
    @Test
    public void canUpdateInformation() {
        AreaOfInterestDAO classUnderTest = new AreaOfInterestDAO();
        AreaOfInterest areaOfInterest = new AreaOfInterest();
        areaOfInterest.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        areaOfInterest.setObservation("new description");
        classUnderTest.update(areaOfInterest);
        assertEquals("new description", classUnderTest.read().get(classUnderTest.read().size()-1).getObservation());
    }
    @Test
    public void canDeleteInformation() {
        AreaOfInterestDAO classUnderTest = new AreaOfInterestDAO();
        int beforeDelete = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterDelete = classUnderTest.read().size();
        assertEquals(beforeDelete, afterDelete+1);
    }
}
