package guardian.backend.control;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import guardian.backend.model.AreaOfInterest;
import guardian.backend.model.FirstResponder;
import guardian.backend.model.FirstResponder_Action;
import guardian.backend.model.FirstResponder_Patrol;
import guardian.backend.model.Incident;
import guardian.backend.model.DAO.AreaOfInterestDAO;
import guardian.backend.model.DAO.FirstResponderDAO;
import guardian.backend.model.DAO.FirstResponder_ActionDAO;
import guardian.backend.model.DAO.FirstResponder_PatrolDAO;
import guardian.backend.model.DAO.IncidentDAO;

public class Registrator {
    public void registerTrooper(String username, String password, String email, String showedName, String description, int firstResponderType) {
        FirstResponder firstResponder = new FirstResponder();
        firstResponder.setUsername(username);
        firstResponder.setPassword(new Authenticator().encryptate(password));
        firstResponder.setEmail(email);
        firstResponder.setShowedName(showedName);
        firstResponder.setDescription(description);
        firstResponder.setPrivilegeLevel(1);
        firstResponder.setFirstResponderType(firstResponderType);
        new FirstResponderDAO().create(firstResponder);
    }
    public void registerCommsOperator(String username, String password, String email, String showedName, String description, int firstResponderType) {
        FirstResponder firstResponder = new FirstResponder();
        firstResponder.setUsername(username);
        firstResponder.setPassword(new Authenticator().encryptate(password));
        firstResponder.setEmail(email);
        firstResponder.setShowedName(showedName);
        firstResponder.setDescription(description);
        firstResponder.setPrivilegeLevel(2);
        firstResponder.setFirstResponderType(firstResponderType);
        new FirstResponderDAO().create(firstResponder);
    }
    public void registerAdministrator(String username, String password, String email, String showedName, String description, int firstResponderType) {
        FirstResponder firstResponder = new FirstResponder();
        firstResponder.setUsername(username);
        firstResponder.setPassword(new Authenticator().encryptate(password));
        firstResponder.setEmail(email);
        firstResponder.setShowedName(showedName);
        firstResponder.setDescription(description);
        firstResponder.setPrivilegeLevel(3);
        firstResponder.setFirstResponderType(firstResponderType);
        new FirstResponderDAO().create(firstResponder);
    }
    
    public void createIncident(String firstReportedPosition, String reportTime, int danger, String description) {
        Incident incident = new Incident();
        ArrayList<String> reportedPosition = new ArrayList<String>();
        reportedPosition.add(firstReportedPosition);
        incident.setReportedPosition(reportedPosition);
        ArrayList<LocalDateTime> reportedPositionTime = new ArrayList<LocalDateTime>();
        reportedPositionTime.add(LocalDateTime.now());
        incident.setReportedPositionTime(reportedPositionTime);
        incident.setDanger(danger);
        incident.setDescription(description);
        new IncidentDAO().create(incident);
    }
    public void assignAction(int assignedFirstResponderId, int assignedActionId) {
        FirstResponder_Action firstResponder_Action = new FirstResponder_Action();
        firstResponder_Action.setAssignedFirstResponderId(assignedFirstResponderId);
        firstResponder_Action.setAssignedActionId(assignedActionId);
        new FirstResponder_ActionDAO().create(firstResponder_Action);
    }
    public void createAreaOfInterest(String designatedArea, int danger, String observation) {
        AreaOfInterest areaOfInterest = new AreaOfInterest();
        areaOfInterest.setDesignatedArea(designatedArea);
        areaOfInterest.setDanger(danger);
        areaOfInterest.setObservation(observation);
        new AreaOfInterestDAO().create(areaOfInterest);
    }
    public void assignPatrol(int assignedFirstResponderId, int assignedPatrolId) {
        FirstResponder_Patrol firstResponder_Patrol = new FirstResponder_Patrol();
        firstResponder_Patrol.setAssignedFirstResponderId(assignedFirstResponderId);
        firstResponder_Patrol.setAssignedPatrolId(assignedPatrolId);
        new FirstResponder_PatrolDAO().create(firstResponder_Patrol);
    }
}
