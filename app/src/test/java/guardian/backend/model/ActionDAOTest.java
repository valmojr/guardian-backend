package guardian.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import guardian.backend.control.Action;

public class ActionDAOTest {
    @Test
    public void canCreateAndReadActions() {
        Action action = new Action();
        action.addReportedPositon("x,y");
        action.setDescription("this action was just created!");
        action.addAssignedUserId(0);
        action.addAssignedIncidentId(0);
        ActionDAO classUnderTest = new ActionDAO();
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(action);
        int afterCreate = classUnderTest.read().size();
        assertEquals(beforeCreate+1, afterCreate);
    };
    @Test
    public void canUpdateActions() {
        String description = "this action was just updated!";
        Action action = new Action();
        ActionDAO classUnderTest = new ActionDAO();
        action.addReportedPositon("x,y");
        action.setDescription(description);
        action.addAssignedUserId(0);
        action.addAssignedIncidentId(0);
        action.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        classUnderTest.update(action);
        assertEquals(classUnderTest.read().get(classUnderTest.read().size()-1).getDescription(), description);
    };
    @Test
    public void canDeleteActions() {
        ActionDAO classUnderTest = new ActionDAO();
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().size()-1);
        int afterCreate = classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate+1);
    };
}
