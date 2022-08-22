package com.valmojr.guardian.model.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.valmojr.guardian.model.Report_Action;

public class Report_ActionDAOTest {
    @Test
    public void canCreateAndReadInformation() {
        Report_ActionDAO classUnderTest = new Report_ActionDAO();
        Report_Action Report_Action = new Report_Action();
        Report_Action.setAssignedActionId(199);
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(Report_Action);
        int afterCreate= classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
    }
    @Test
    public void canReadInformationById() {
        Report_ActionDAO classUnderTest = new Report_ActionDAO();
        assertEquals(199, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedActionId());
    }
    @Test
    public void canUpdateInformation() {
        Report_ActionDAO classUnderTest = new Report_ActionDAO();
        Report_Action Report_Action = new Report_Action();
        Report_Action.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        Report_Action.setAssignedActionId(129);
        classUnderTest.update(Report_Action);
        assertEquals(129, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedActionId());
    }
    @Test
    public void canDeleteInformation() {
        Report_ActionDAO classUnderTest = new Report_ActionDAO();
        int beforeDelete = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterDelete = classUnderTest.read().size();
        assertEquals(beforeDelete, afterDelete+1);
    }
}
    
    
