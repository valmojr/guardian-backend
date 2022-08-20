package guardian.backend.model.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import guardian.backend.model.Report_Patrol;

public class Report_PatrolDAOTest {
    @Test
    public void canCreateAndReadInformation() {
        Report_PatrolDAO classUnderTest = new Report_PatrolDAO();
        Report_Patrol Report_Patrol = new Report_Patrol();
        Report_Patrol.setAssignedPatrolId(199);
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(Report_Patrol);
        int afterCreate= classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
    }
    @Test
    public void canReadInformationById() {
        Report_PatrolDAO classUnderTest = new Report_PatrolDAO();
        assertEquals(199, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedPatrolId());
    }
    @Test
    public void canUpdateInformation() {
        Report_PatrolDAO classUnderTest = new Report_PatrolDAO();
        Report_Patrol Report_Patrol = new Report_Patrol();
        Report_Patrol.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        Report_Patrol.setAssignedPatrolId(129);
        classUnderTest.update(Report_Patrol);
        assertEquals(129, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedPatrolId());
    }
    @Test
    public void canDeleteInformation() {
        Report_PatrolDAO classUnderTest = new Report_PatrolDAO();
        int beforeDelete = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterDelete = classUnderTest.read().size();
        assertEquals(beforeDelete, afterDelete+1);
    }
}
    
    
