package com.valmojr.guardian.model.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.valmojr.guardian.model.Incident;

public class IncidentDAOTest {
    @Test
    public void canCreateAndReadInformation() {
        IncidentDAO classUnderTest = new IncidentDAO();
        Incident incident = new Incident();
        incident.setDescription("description");
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(incident);
        int afterCreate= classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
    }
    @Test
    public void canReadInformationById() {
        IncidentDAO classUnderTest = new IncidentDAO();
        assertEquals("description", classUnderTest.read().get(classUnderTest.read().size()-1).getDescription());
    }
    @Test
    public void canUpdateInformation() {
        IncidentDAO classUnderTest = new IncidentDAO();
        Incident incident = new Incident();
        incident.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        incident.setDescription("new description");
        classUnderTest.update(incident);
        assertEquals("new description", classUnderTest.read().get(classUnderTest.read().size()-1).getDescription());
    }
    @Test
    public void canDeleteInformation() {
        IncidentDAO classUnderTest = new IncidentDAO();
        int beforeDelete = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterDelete = classUnderTest.read().size();
        assertEquals(beforeDelete, afterDelete+1);
    }
}
