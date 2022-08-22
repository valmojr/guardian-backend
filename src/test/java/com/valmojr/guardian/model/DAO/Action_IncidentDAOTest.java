package com.valmojr.guardian.model.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.valmojr.guardian.model.Action_Incident;

public class Action_IncidentDAOTest {
    @Test
    public void canCreateAndReadInformation() {
        Action_IncidentDAO classUnderTest = new Action_IncidentDAO();
        Action_Incident action_Incident = new Action_Incident();
        action_Incident.setAssignedActionId(199);
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(action_Incident);
        int afterCreate= classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
    }
    @Test
    public void canReadInformationById() {
        Action_IncidentDAO classUnderTest = new Action_IncidentDAO();
        assertEquals(199, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedActionId());
    }
    @Test
    public void canUpdateInformation() {
        Action_IncidentDAO classUnderTest = new Action_IncidentDAO();
        Action_Incident action_Incident = new Action_Incident();
        action_Incident.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        action_Incident.setAssignedActionId(129);
        classUnderTest.update(action_Incident);
        assertEquals(129, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedActionId());
    }
    @Test
    public void canDeleteInformation() {
        Action_IncidentDAO classUnderTest = new Action_IncidentDAO();
        int beforeDelete = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterDelete = classUnderTest.read().size();
        assertEquals(beforeDelete, afterDelete+1);
    }
}
