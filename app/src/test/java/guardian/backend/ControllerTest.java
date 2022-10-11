package guardian.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import guardian.backend.model.Action;
import guardian.backend.model.Action_Incident;
import guardian.backend.model.AreaOfInterest;
import guardian.backend.model.FirstResponder;
import guardian.backend.model.FirstResponder_Action;
import guardian.backend.model.FirstResponder_Patrol;
import guardian.backend.model.Incident;
import guardian.backend.model.Patrol;
import guardian.backend.model.Patrol_AreaOfInterest;
import guardian.backend.model.Position_FirstResponder;
import guardian.backend.model.Position_Incident;
import guardian.backend.model.Report;
import guardian.backend.model.Report_Action;
import guardian.backend.model.Report_Patrol;
import guardian.backend.model.DAO.ActionDAO;
import guardian.backend.model.DAO.Action_IncidentDAO;
import guardian.backend.model.DAO.AreaOfInterestDAO;
import guardian.backend.model.DAO.FirstResponderDAO;
import guardian.backend.model.DAO.FirstResponder_ActionDAO;
import guardian.backend.model.DAO.FirstResponder_PatrolDAO;
import guardian.backend.model.DAO.IncidentDAO;
import guardian.backend.model.DAO.PatrolDAO;
import guardian.backend.model.DAO.Patrol_AreaOfInterestDAO;
import guardian.backend.model.DAO.Position_FirstResponderDAO;
import guardian.backend.model.DAO.Position_IncidentDAO;
import guardian.backend.model.DAO.ReportDAO;
import guardian.backend.model.DAO.Report_ActionDAO;
import guardian.backend.model.DAO.Report_PatrolDAO;

public class ControllerTest {
    @Test
    public void Action_IncidentCRUDTest() {
        Action_IncidentDAO classUnderTest = new Action_IncidentDAO();
        Action_Incident action_Incident = new Action_Incident();
        action_Incident.setAssignedActionId(199);
        action_Incident.setAssignedIncidentId(100);
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(action_Incident);
        int afterCreate= classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
        assertEquals(199, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedActionId());
        //readByActionId test
        //readByIncidentId test
        action_Incident.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        action_Incident.setAssignedActionId(129);
        classUnderTest.update(action_Incident);
        assertEquals(129, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedActionId());
        int beforeDelete = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterDelete = classUnderTest.read().size();
        assertEquals(beforeDelete, afterDelete+1);
    }
    @Test
    public void ActionCRUDTest() {
        ActionDAO classUnderTest = new ActionDAO();
        Action action = new Action();
        action.setDescription("description");
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(action);
        int afterCreate= classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
        assertEquals("description", classUnderTest.read().get(classUnderTest.read().size()-1).getDescription());
        action.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        action.setDescription("new description");
        classUnderTest.update(action);
        assertEquals("new description", classUnderTest.read().get(classUnderTest.read().size()-1).getDescription());
        int beforeDelete = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterDelete = classUnderTest.read().size();
        assertEquals(beforeDelete, afterDelete+1);
    };
    @Test
    public void AreaOfInterestCRUDTest() {
        AreaOfInterestDAO classUnderTest = new AreaOfInterestDAO();
        AreaOfInterest areaOfInterest = new AreaOfInterest();
        areaOfInterest.setObservation("description");
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(areaOfInterest);
        int afterCreate= classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
        assertEquals("description", classUnderTest.read().get(classUnderTest.read().size()-1).getObservation());
        areaOfInterest.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        areaOfInterest.setObservation("new description");
        classUnderTest.update(areaOfInterest);
        assertEquals("new description", classUnderTest.read().get(classUnderTest.read().size()-1).getObservation());
        int beforeDelete = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterDelete = classUnderTest.read().size();
        assertEquals(beforeDelete, afterDelete+1);
    };
    @Test
    public void FirstResponder_ActionCRUDTest() {
        FirstResponder_ActionDAO classUnderTest = new FirstResponder_ActionDAO();
        FirstResponder_Action firstResponder_Action = new FirstResponder_Action();
        firstResponder_Action.setAssignedFirstResponderId(155);
        firstResponder_Action.setAssignedActionId(100);
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(firstResponder_Action);
        int afterCreate = classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
        assertEquals(155, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedFirstResponderId());
        //readByFirstResponderId Test
        //readByActionId Test
        firstResponder_Action.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        firstResponder_Action.setAssignedFirstResponderId(121);
        classUnderTest.update(firstResponder_Action);
        assertEquals(121, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedFirstResponderId());
        beforeCreate = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1));
        afterCreate = classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate+1);
    };
    @Test
    public void FirstResponder_PatrolCRUDTest() {
        FirstResponder_PatrolDAO classUnderTest = new FirstResponder_PatrolDAO();
        FirstResponder_Patrol firstResponder_Patrol = new FirstResponder_Patrol();
        firstResponder_Patrol.setAssignedFirstResponderId(155);
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(firstResponder_Patrol);
        int afterCreate = classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
        assertEquals(155, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedFirstResponderId());
        firstResponder_Patrol.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        firstResponder_Patrol.setAssignedFirstResponderId(121);
        classUnderTest.update(firstResponder_Patrol);
        assertEquals(121, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedFirstResponderId());
        beforeCreate = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1));
        afterCreate = classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate+1);
    };
    @Test
    public void FirstResponderCRUDTest() {
        FirstResponderDAO classUnderTest = new FirstResponderDAO();
        FirstResponder firstResponder = new FirstResponder();
        firstResponder.setDescription("description");
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(firstResponder);
        int afterCreate = classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
        assertEquals("description", classUnderTest.read().get(classUnderTest.read().size()-1).getDescription());
        firstResponder.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        firstResponder.setDescription("new description");
        classUnderTest.update(firstResponder);
        assertEquals("new description", classUnderTest.read().get(classUnderTest.read().size()-1).getDescription());
        beforeCreate = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1));
        afterCreate = classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate+1);
    };
    @Test
    public void IncidentCRUDTest() {
        IncidentDAO classUnderTest = new IncidentDAO();
        Incident incident = new Incident();
        incident.setDescription("description");
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(incident);
        int afterCreate= classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
        assertEquals("description", classUnderTest.read().get(classUnderTest.read().size()-1).getDescription());
        incident.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        incident.setDescription("new description");
        classUnderTest.update(incident);
        assertEquals("new description", classUnderTest.read().get(classUnderTest.read().size()-1).getDescription());
        int beforeDelete = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterDelete = classUnderTest.read().size();
        assertEquals(beforeDelete, afterDelete+1);
    };
    @Test
    public void Patrol_AreaOfInterestCRUDTest() {
        Patrol_AreaOfInterestDAO classUnderTest = new Patrol_AreaOfInterestDAO();
        Patrol_AreaOfInterest patrol_AreaOfInterest = new Patrol_AreaOfInterest();
        patrol_AreaOfInterest.setAssignedPatrolId(199);
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(patrol_AreaOfInterest);
        int afterCreate= classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
        assertEquals(199, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedPatrolId());
        patrol_AreaOfInterest.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        patrol_AreaOfInterest.setAssignedPatrolId(129);
        classUnderTest.update(patrol_AreaOfInterest);
        assertEquals(129, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedPatrolId());
        int beforeDelete = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterDelete = classUnderTest.read().size();
        assertEquals(beforeDelete, afterDelete+1);
    };
    @Test
    public void PatrolCRUDTest() {
        PatrolDAO classUnderTest = new PatrolDAO();
        Patrol patrol = new Patrol();
        patrol.setObservation("observation");
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(patrol);
        int afterCreate= classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
        assertEquals("observation", classUnderTest.read().get(classUnderTest.read().size()-1).getObservation());
        patrol.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        patrol.setObservation("new observation");
        classUnderTest.update(patrol);
        assertEquals("new observation", classUnderTest.read().get(classUnderTest.read().size()-1).getObservation());
        int beforeDelete = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterDelete = classUnderTest.read().size();
        assertEquals(beforeDelete, afterDelete+1);
    };
    @Test
    public void Position_FirstResponderCRUDTest() {
        Position_FirstResponderDAO classUnderTest = new Position_FirstResponderDAO();
        Position_FirstResponder position_FirstResponder = new Position_FirstResponder();
        position_FirstResponder.setAssignedFirstResponderId(199);
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(position_FirstResponder);
        int afterCreate= classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
        assertEquals(199, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedFirstResponderId());
        position_FirstResponder.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        position_FirstResponder.setAssignedFirstResponderId(129);
        classUnderTest.update(position_FirstResponder);
        assertEquals(129, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedFirstResponderId());
        int beforeDelete = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterDelete = classUnderTest.read().size();
        assertEquals(beforeDelete, afterDelete+1);
    }
    @Test
    public void Position_IncidentCRUDTest() {
        Position_IncidentDAO classUnderTest = new Position_IncidentDAO();
        Position_Incident position_Incident = new Position_Incident();
        position_Incident.setAssignedIncidentId(199);
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(position_Incident);
        int afterCreate= classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
        assertEquals(199, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedIncidentId());
        position_Incident.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        position_Incident.setAssignedIncidentId(129);
        classUnderTest.update(position_Incident);
        assertEquals(129, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedIncidentId());
        int beforeDelete = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterDelete = classUnderTest.read().size();
        assertEquals(beforeDelete, afterDelete+1);
    }
    @Test
    public void Report_ActionCRUDTest() {
        Report_ActionDAO classUnderTest = new Report_ActionDAO();
        Report_Action Report_Action = new Report_Action();
        Report_Action.setAssignedActionId(199);
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(Report_Action);
        int afterCreate= classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
        assertEquals(199, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedActionId());
        Report_Action.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        Report_Action.setAssignedActionId(129);
        classUnderTest.update(Report_Action);
        assertEquals(129, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedActionId());
        int beforeDelete = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterDelete = classUnderTest.read().size();
        assertEquals(beforeDelete, afterDelete+1);
    };
    @Test
    public void Report_PatrolCRUDTest() {
        Report_PatrolDAO classUnderTest = new Report_PatrolDAO();
        Report_Patrol Report_Patrol = new Report_Patrol();
        Report_Patrol.setAssignedPatrolId(199);
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(Report_Patrol);
        int afterCreate= classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
        assertEquals(199, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedPatrolId());
        Report_Patrol.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        Report_Patrol.setAssignedPatrolId(129);
        classUnderTest.update(Report_Patrol);
        assertEquals(129, classUnderTest.read().get(classUnderTest.read().size()-1).getAssignedPatrolId());
        int beforeDelete = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterDelete = classUnderTest.read().size();
        assertEquals(beforeDelete, afterDelete+1);
    };
    @Test
    public void ReportCRUDTest() {
        ReportDAO classUnderTest = new ReportDAO();
        Report Report = new Report();
        Report.setReportObservation("observation");
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(Report);
        int afterCreate= classUnderTest.read().size();
        assertEquals(beforeCreate, afterCreate-1);
        assertEquals("observation", classUnderTest.read().get(classUnderTest.read().size()-1).getReportObservation());
        Report.setId(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        Report.setReportObservation("new observation");
        classUnderTest.update(Report);
        assertEquals("new observation", classUnderTest.read().get(classUnderTest.read().size()-1).getReportObservation());
        int beforeDelete = classUnderTest.read().size();
        classUnderTest.delete(classUnderTest.read().get(classUnderTest.read().size()-1).getId());
        int afterDelete = classUnderTest.read().size();
        assertEquals(beforeDelete, afterDelete+1);
    };
}
