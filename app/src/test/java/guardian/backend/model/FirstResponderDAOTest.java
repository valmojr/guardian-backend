package guardian.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import guardian.backend.control.FirstResponder;

public class FirstResponderDAOTest {
    @Test
    public void canCreateAndReadFirstResponders() {
        FirstResponder firstResponder = new FirstResponder();
        firstResponder.setDescription("this FirstResponder was just created!");
        FirstResponderDAO classUnderTest = new FirstResponderDAO();
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(firstResponder);
        int afterCreate = classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
    };
    @Test
    public void canUpdateFirstResponders() {
        String description = "this FirstResponder was just updated!";
        FirstResponder firstResponder = new FirstResponder();
        FirstResponderDAO classUnderTest = new FirstResponderDAO();
        firstResponder.setDescription(description);
        firstResponder.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        classUnderTest.update(firstResponder);
        assertEquals(classUnderTest.read().get(classUnderTest.read().size()-1).getDescription(), description);
    };
    @Test
    public void canDeleteFirstResponders() {
        FirstResponderDAO classUnderTest = new FirstResponderDAO();
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterCreate = classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate+1);
    };
}
