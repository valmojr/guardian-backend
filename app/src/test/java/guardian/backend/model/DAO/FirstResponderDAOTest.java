package guardian.backend.model.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import guardian.backend.model.FirstResponder;

public class FirstResponderDAOTest {
    @Test
    public void canCreateAndReadInformation() {
        FirstResponderDAO classUnderTest = new FirstResponderDAO();
        FirstResponder firstResponder = new FirstResponder();
        firstResponder.setDescription("description");
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(firstResponder);
        int afterCreate = classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
        assertEquals("description", classUnderTest.read().get(classUnderTest.read().size()-1).getDescription());
    }
    @Test
    public void canReadInformationById() {
        FirstResponderDAO classUnderTest = new FirstResponderDAO();
        assertEquals("description", classUnderTest.read(classUnderTest.read().get(classUnderTest.read().size()-1).getId()).getDescription());
    }
    @Test
    public void canUpdateInformation() {
        FirstResponderDAO classUnderTest = new FirstResponderDAO();
        FirstResponder firstResponder = new FirstResponder();
        firstResponder.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        firstResponder.setDescription("new description");
        classUnderTest.update(firstResponder);
        assertEquals("new description", classUnderTest.read().get(classUnderTest.read().size()-1).getDescription());
    }
    @Test
    public void canDeleteInformation() {
        FirstResponderDAO classUnderTest = new FirstResponderDAO();
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1));
        int afterCreate = classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate+1);
    }
}
