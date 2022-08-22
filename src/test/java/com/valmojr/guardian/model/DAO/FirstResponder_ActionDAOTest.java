package com.valmojr.guardian.model.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.valmojr.guardian.model.FirstResponder_Action;

public class FirstResponder_ActionDAOTest {
    @Test
    public void canCreateAndReadInformation() {
        FirstResponder_ActionDAO classUnderTest = new FirstResponder_ActionDAO();
        FirstResponder_Action firstResponder_Action = new FirstResponder_Action();
        firstResponder_Action.setAssignedFirstResponderId(155);
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(firstResponder_Action);
        int afterCreate = classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
        assertEquals(155, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedFirstResponderId());
    }
    @Test
    public void canReadInformationById() {
        FirstResponder_ActionDAO classUnderTest = new FirstResponder_ActionDAO();
        assertEquals(155, classUnderTest.read(classUnderTest.read().get(classUnderTest.read().size()-1).getId()).getAssignedFirstResponderId());
    }
    @Test
    public void canUpdateInformation() {
        FirstResponder_ActionDAO classUnderTest = new FirstResponder_ActionDAO();
        FirstResponder_Action firstResponder_Action = new FirstResponder_Action();
        firstResponder_Action.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        firstResponder_Action.setAssignedFirstResponderId(121);
        classUnderTest.update(firstResponder_Action);
        assertEquals(121, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedFirstResponderId());
    }
    @Test
    public void canDeleteInformation() {
        FirstResponder_ActionDAO classUnderTest = new FirstResponder_ActionDAO();
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1));
        int afterCreate = classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate+1);
    }
}
