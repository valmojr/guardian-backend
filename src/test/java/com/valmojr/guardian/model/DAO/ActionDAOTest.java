package com.valmojr.guardian.model.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.valmojr.guardian.model.Action;

public class ActionDAOTest {
    @Test
    public void canCreateAndReadInformation() {
        ActionDAO classUnderTest = new ActionDAO();
        Action action = new Action();
        action.setDescription("description");
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(action);
        int afterCreate= classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
    }
    @Test
    public void canReadInformationById() {
        ActionDAO classUnderTest = new ActionDAO();
        assertEquals("description", classUnderTest.read().get(classUnderTest.read().size()-1).getDescription());
    }
    @Test
    public void canUpdateInformation() {
        ActionDAO classUnderTest = new ActionDAO();
        Action action = new Action();
        action.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        action.setDescription("new description");
        classUnderTest.update(action);
        assertEquals("new description", classUnderTest.read().get(classUnderTest.read().size()-1).getDescription());
    }
    @Test
    public void canDeleteInformation() {
        ActionDAO classUnderTest = new ActionDAO();
        int beforeDelete = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterDelete = classUnderTest.read().size();
        assertEquals(beforeDelete, afterDelete+1);
    }
}
