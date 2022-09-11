package guardian.backend.controller;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

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

@RestController
public class RESTController {
    @PostMapping("/action_Incident")
    public void registerAction_Incident(@RequestBody Action_Incident action_Incident) {
        new Action_IncidentDAO().create(action_Incident);
    }
    @GetMapping("/action_Incident")
    public String readAction_Incident() {
        ArrayList<Action_Incident> action_Incidents = new Action_IncidentDAO().read();
        return new Gson().toJson(action_Incidents);
    }
    @GetMapping("/action_Incident/{id}")
    public String readAction_IncidentById() {
        ArrayList<Action_Incident> action_Incidents = new Action_IncidentDAO().read();
        return new Gson().toJson(action_Incidents);
    }
    @GetMapping("/action_Incident/action={action}")
    public String readAction_IncidentByActionId(@PathVariable(value = "action")int id) {
        ArrayList<Action_Incident> action_Incidents = new Action_IncidentDAO().readByActionId(id);
        return new Gson().toJson(action_Incidents);
    }
    @PatchMapping("/action_Incident")
    public void updateAction_Incident(@RequestBody Action_Incident action_Incident) {
        new Action_IncidentDAO().update(action_Incident);
    }
    @DeleteMapping("/action_Incident")
    public void deleteAction_Incident(@RequestBody Action_Incident action_Incident) {
        new Action_IncidentDAO().delete(action_Incident);
    }
    @DeleteMapping("/action_Incident/{id}")
    public void deleteAction_Incident(@PathVariable(value = "id")int id) {
        new Action_IncidentDAO().delete(id);
    }

    @PostMapping("/action")
    public void createAction(@RequestBody Action action) {
        new ActionDAO().create(action);
    }
    @GetMapping("/action")
    public String readActions() {
        ArrayList<Action> actions = new ActionDAO().read();
        return new Gson().toJson(actions);
    }
    @PatchMapping("/action")
    public void updateAction(@RequestBody Action action) {
        new ActionDAO().update(action);
    }
    @DeleteMapping("/action")
    public void deleteAction(@RequestBody Action action) {
        new ActionDAO().delete(action);
    }
    @DeleteMapping("/action/{id}")
    public void deleteActionById(@PathVariable(value = "id")int id) {
        new ActionDAO().delete(id);
    }

    @PostMapping("/areaOfInterest")
    public void createAreaOfInterest(@RequestBody AreaOfInterest areaOfInterest) {
        new AreaOfInterestDAO().create(areaOfInterest);
    }
    @GetMapping("/areaOfInterest")
    public String readAreaOfInterest() {
        ArrayList<AreaOfInterest> areaOfInterests = new AreaOfInterestDAO().read();
        return new Gson().toJson(areaOfInterests);
    }
    @GetMapping("/areaOfInterest/{id}")
    public String readAreaOfInterestById(@PathVariable(value = "id")int id) {
        AreaOfInterest areaOfInterest = new AreaOfInterestDAO().read(id);
        return new Gson().toJson(areaOfInterest);
    }
    @PatchMapping("/areaOfInterest")
    public void updateAreaOfInterest(@RequestBody AreaOfInterest areaOfInterest) {
        new AreaOfInterestDAO().update(areaOfInterest);
    }
    @DeleteMapping("/areaOfInterest")
    public void deleteAreaOfInterest(@RequestBody AreaOfInterest areaOfInterest) {
        new AreaOfInterestDAO().delete(areaOfInterest);
    }
    @DeleteMapping("/areaOfInterest/{id}")
    public void deleteAreaOfInterestById(@PathVariable(value = "id")int id) {
        new AreaOfInterestDAO().delete(id);
    }
    
    @PostMapping("/firstResponder_Action")
    public void createFirstResponder_Action(@RequestBody FirstResponder_Action firstResponder_Action) {
        new FirstResponder_ActionDAO().create(firstResponder_Action);
    }
    @GetMapping("/firstResponder_Action")
    public String getFirstResponder_Action() {
        ArrayList<FirstResponder_Action> firstResponder_Actions = new FirstResponder_ActionDAO().read();
        return new Gson().toJson(firstResponder_Actions);
    }
    @GetMapping("/firstResponder_Action/{id}")
    public String getFirstResponder_ActionById(@PathVariable(value = "id")int id) {
        FirstResponder_Action firstResponder_Action = new FirstResponder_ActionDAO().read(id);
        return new Gson().toJson(firstResponder_Action);
    }
    @GetMapping("/firstResponder_Action/action={actionId}")
    public String getFirstResponder_ActionByActionId(@PathVariable(value = "actionId")int actionId) {
        ArrayList<FirstResponder_Action> firstResponder_Actions = new FirstResponder_ActionDAO().readByActionId(actionId);
        return new Gson().toJson(firstResponder_Actions);
    }
    @GetMapping("/firstResponder_Action/firstResponder={firstResponderId}")
    public String getFirstResponder_ActionByFirstResponderId(@PathVariable(value = "firstResponderId")int firstResponderId) {
        ArrayList<FirstResponder_Action> firstResponder_Actions = new FirstResponder_ActionDAO().readByFirstResponderId(firstResponderId);
        return new Gson().toJson(firstResponder_Actions);
    }
    @PatchMapping("/firstResponder_Action")
    public void updateFirstResponder_Action(@RequestBody FirstResponder_Action firstResponder_Action) {
        new FirstResponder_ActionDAO().update(firstResponder_Action);
    }
    @DeleteMapping("/firstResponder_Action")
    public void deleteFirstResponder_Action(@RequestBody FirstResponder_Action firstResponder_Action) {
        new FirstResponder_ActionDAO().delete(firstResponder_Action);
    }
    @DeleteMapping("/firstResponder_Action/{id}")
    public void deleteFirstResponder_ActionById(@PathVariable(value = "id")int id) {
        new FirstResponder_ActionDAO().delete(id);
    }
    //FirstResponder_Patrol C R U D
    @PostMapping("/firstResponder_Patrol")
    public void createFirstResponder_Patrol(@RequestBody FirstResponder_Patrol firstResponder_Patrol) {
        new FirstResponder_PatrolDAO().create(firstResponder_Patrol);
    }
    @GetMapping("/firstResponder_Patrol")
    public String getFirstResponder_Patrol() {
        ArrayList<FirstResponder_Patrol> firstResponder_Patrols = new FirstResponder_PatrolDAO().read();
        return new Gson().toJson(firstResponder_Patrols);
    }
    @GetMapping("/firstResponder_Patrol/{id}")
    public String getFirstResponder_PatrolById(@PathVariable(value = "id")int id) {
        FirstResponder_Patrol firstResponder_Patrol = new FirstResponder_PatrolDAO().read(id);
        return new Gson().toJson(firstResponder_Patrol);
    }
    @GetMapping("/firstResponder_Patrol/patrol={patrolId}")
    public String getFirstResponder_PatrolByActionId(@PathVariable(value = "patrolId")int patrolId) {
        ArrayList<FirstResponder_Patrol> firstResponder_Patrols = new FirstResponder_PatrolDAO().readByPatrolId(patrolId);
        return new Gson().toJson(firstResponder_Patrols);
    }
    @GetMapping("/firstResponder_Patrol/firstResponder={firstResponderId}")
    public String getFirstResponder_PatrolByFirstResponderId(@PathVariable(value = "firstResponderId")int firstResponderId) {
        ArrayList<FirstResponder_Patrol> firstResponder_Patrols = new FirstResponder_PatrolDAO().readByFirstResponderId(firstResponderId);
        return new Gson().toJson(firstResponder_Patrols);
    }
    @PatchMapping("/firstResponder_Patrol")
    public void updateFirstResponder_Patrol(@RequestBody FirstResponder_Patrol firstResponder_Patrol) {
        new FirstResponder_PatrolDAO().update(firstResponder_Patrol);
    }
    @DeleteMapping("/firstResponder_Patrol")
    public void deleteFirstResponder_Patrol(@RequestBody FirstResponder_Patrol firstResponder_Patrol) {
        new FirstResponder_PatrolDAO().delete(firstResponder_Patrol);
    }
    @DeleteMapping("/firstResponder_Patrol/{id}")
    public void deleteFirstResponder_PatrolById(@PathVariable(value = "id")int id) {
        new FirstResponder_PatrolDAO().delete(id);
    }
    
    @PostMapping("/firstResponder")
    public void registerFirstResponder(@RequestBody FirstResponder firstResponder) {
        new FirstResponderDAO().create(firstResponder);
    }
    @GetMapping("/firstResponder")
    public String getFirstResponders() {
        ArrayList<FirstResponder> firstResponders = new FirstResponderDAO().read();
        return new Gson().toJson(firstResponders);
    }
    @GetMapping("/firstResponder/{id}")
    public String getFirstResponderById(@PathVariable(value = "id") int id) {
        FirstResponder firstResponder = new FirstResponderDAO().read(id);
        return new Gson().toJson(firstResponder);
    }
    @PatchMapping("/firstResponder")
    public void updateFirstResponder(@RequestBody FirstResponder firstResponder) {
        new FirstResponderDAO().update(firstResponder);
    }
    @DeleteMapping("/firstResponder")
    public void deleteFirstResponder(@RequestBody FirstResponder firstResponder) {
        new FirstResponderDAO().delete(firstResponder);
    }
    @DeleteMapping("/firstResponder/{id}")
    public void deleteFirstResponderById(@PathVariable(value = "id")int id) {
        new FirstResponderDAO().delete(id);
    }
    
    @PostMapping("/incident")
    public void createIncident(@RequestBody Incident incident) {
        new IncidentDAO().create(incident);
    }
    @GetMapping("/incident")
    public String getIncidents() {
        ArrayList<Incident> incidents = new IncidentDAO().read();
        return new Gson().toJson(incidents);
    }
    @GetMapping("/incident/{id}")
    public String getIncidentById(@PathVariable(value = "id")int id) {
        Incident incident = new IncidentDAO().read(id);
        return new Gson().toJson(incident);
    }
    @PatchMapping("/incident")
    public void updateIncident(@RequestBody Incident incident) {
        new IncidentDAO().update(incident);
    }
    @DeleteMapping("/incident")
    public void deleteIncident(@RequestBody Incident incident) {
        new IncidentDAO().delete(incident);
    }
    @DeleteMapping("/incident/{id}")
    public void deleteIncidentById(@PathVariable(value = "id")int id) {
        new IncidentDAO().delete(id);
    }
    
    @PostMapping("/patrol_AreaOfInterest")
    public void createPatrol_AreaOfInterest(@RequestBody Patrol_AreaOfInterest patrol_AreaOfInterest) {
        new Patrol_AreaOfInterestDAO().create(patrol_AreaOfInterest);
    }
    @GetMapping("/patrol_AreaOfInterest")
    public String getPatrol_AreaOfInterests() {
        ArrayList<Patrol_AreaOfInterest> patrol_AreaOfInterests = new Patrol_AreaOfInterestDAO().read();
        return new Gson().toJson(patrol_AreaOfInterests);
    }
    @GetMapping("/patrol_AreaOfInterest/{id}")
    public String getPatrol_AreaOfInterestById(@PathVariable(value = "id")int id) {
        Patrol_AreaOfInterest patrol_AreaOfInterest = new Patrol_AreaOfInterestDAO().read(id);
        return new Gson().toJson(patrol_AreaOfInterest);
    }
    @GetMapping("/patrol_AreaOfInterest/patrol={patrolId}")
    public String getPatrol_AreaOfInterestByPatrolId(@PathVariable(value = "patrolId")int patrolId) {
        ArrayList<Patrol_AreaOfInterest> patrol_AreaOfInterests = new Patrol_AreaOfInterestDAO().readByPatrolId(patrolId);
        return new Gson().toJson(patrol_AreaOfInterests);
    }
    @GetMapping("/patrol_AreaOfInterest/areaOfInterest={areaOfInterestId}")
    public String getPatrol_AreaOfInterestByAreaOfInterestId(@PathVariable(value = "areaOfInterestId")int areaOfInterestId) {
        ArrayList<Patrol_AreaOfInterest> patrol_AreaOfInterests = new Patrol_AreaOfInterestDAO().readByAreaOfInterestId(areaOfInterestId);
        return new Gson().toJson(patrol_AreaOfInterests);
    }
    @PatchMapping("/patrol_AreaOfInterest")
    public void updatePatrol_AreaOfInterest(@RequestBody Patrol_AreaOfInterest patrol_AreaOfInterest) {
        new Patrol_AreaOfInterestDAO().update(patrol_AreaOfInterest);
    }
    @DeleteMapping("/patrol_AreaOfInterest")
    public void deletePatrol_AreaOfInterest(@RequestBody Patrol_AreaOfInterest patrol_AreaOfInterest) {
        new Patrol_AreaOfInterestDAO().delete(patrol_AreaOfInterest);
    }
    @DeleteMapping("/patrol_AreaOfInterest/{id}")
    public void deletePatrol_AreaOfInterest(@PathVariable(value = "id")int id) {
        new Patrol_AreaOfInterestDAO().delete(id);
    }
    
    @PostMapping("/patrol")
    public void createPatrol(@RequestBody Patrol patrol) {
        new PatrolDAO().create(patrol);
    }
    @GetMapping("/patrol")
    public String getPatrols() {
        ArrayList<Patrol> patrols = new PatrolDAO().read();
        return new Gson().toJson(patrols);
    }
    @GetMapping("/patrol/{id}")
    public String getPatrolById(@PathVariable(value = "id")int id) {
        Patrol patrol = new PatrolDAO().read(id);
        return new Gson().toJson(patrol);
    }
    @PatchMapping("/patrol")
    public void updatePatrol(@RequestBody Patrol patrol) {
        new PatrolDAO().update(patrol);
    }
    @DeleteMapping("/patrol")
    public void deletePatrol(@RequestBody Patrol patrol) {
        new PatrolDAO().delete(patrol);
    }
    @DeleteMapping("/patrol/{id}")
    public void deletePatrolById(@PathVariable(value = "id")int id) {
        new PatrolDAO().delete(id);
    }
    
    @PostMapping("/position_FirstResponder")
    public void createPosition_FirstResponder(@RequestBody Position_FirstResponder position_FirstResponder) {
        new Position_FirstResponderDAO().create(position_FirstResponder);
    }
    @GetMapping("/position_FirstResponder")
    public String getposition_FirstResponders() {
        ArrayList<Position_FirstResponder> position_FirstResponders = new Position_FirstResponderDAO().read();
        return new Gson().toJson(position_FirstResponders);
    }
    @GetMapping("/position_FirstResponder/{id}")
    public String getPosition_FirstResponderById(@PathVariable(value = "id")int id) {
        Position_FirstResponder position_FirstResponder = new Position_FirstResponderDAO().read(id);
        return new Gson().toJson(position_FirstResponder);
    }
    @GetMapping("/position_FirstResponder/firstResponder={firstResponderId}")
    public String getPosition_FirstResponderByPatrolId(@PathVariable(value = "firstResponderId")int firstResponderId) {
        ArrayList<Position_FirstResponder> position_FirstResponders = new Position_FirstResponderDAO().readByFirstResponderId(firstResponderId);
        return new Gson().toJson(position_FirstResponders);
    }
    @PatchMapping("/position_FirstResponder")
    public void updatePosition_FirstResponder(@RequestBody Position_FirstResponder position_FirstResponder) {
        new Position_FirstResponderDAO().update(position_FirstResponder);
    }
    @DeleteMapping("/position_FirstResponder")
    public void deletePosition_FirstResponder(@RequestBody Position_FirstResponder position_FirstResponder) {
        new Position_FirstResponderDAO().delete(position_FirstResponder);
    }
    @DeleteMapping("/position_FirstResponder/{id}")
    public void deleteposition_FirstResponder(@PathVariable(value = "id")int id) {
        new Position_FirstResponderDAO().delete(id);
    }
    
    @PostMapping("/position_Incident")
    public void createPosition_Incident(@RequestBody Position_Incident position_Incident) {
        new Position_IncidentDAO().create(position_Incident);
    }
    @GetMapping("/position_Incident")
    public String getposition_Incidents() {
        ArrayList<Position_Incident> position_Incidents = new Position_IncidentDAO().read();
        return new Gson().toJson(position_Incidents);
    }
    @GetMapping("/position_Incident/{id}")
    public String getPosition_IncidentById(@PathVariable(value = "id")int id) {
        Position_Incident position_Incident = new Position_IncidentDAO().read(id);
        return new Gson().toJson(position_Incident);
    }
    @GetMapping("/position_Incident/Incident={IncidentId}")
    public String getPosition_IncidentByPatrolId(@PathVariable(value = "IncidentId")int IncidentId) {
        ArrayList<Position_Incident> position_Incidents = new Position_IncidentDAO().readByIncidentId(IncidentId);
        return new Gson().toJson(position_Incidents);
    }
    @PatchMapping("/position_Incident")
    public void updatePosition_Incident(@RequestBody Position_Incident position_Incident) {
        new Position_IncidentDAO().update(position_Incident);
    }
    @DeleteMapping("/position_Incident")
    public void deletePosition_Incident(@RequestBody Position_Incident position_Incident) {
        new Position_IncidentDAO().delete(position_Incident);
    }
    @DeleteMapping("/position_Incident/{id}")
    public void deleteposition_Incident(@PathVariable(value = "id")int id) {
        new Position_IncidentDAO().delete(id);
    }
    
    @PostMapping("/report_Action")
    public void createReport_Action(@RequestBody Report_Action report_Action) {
        new Report_ActionDAO().create(report_Action);
    }
    @GetMapping("/report_Action")
    public String getReport_Actions() {
        ArrayList<Report_Action> report_Actions = new Report_ActionDAO().read();
        return new Gson().toJson(report_Actions);
    }
    @GetMapping("/report_Action/{id}")
    public String getReport_ActionById(@PathVariable(value = "id")int id) {
        Report_Action Report_Action = new Report_ActionDAO().read(id);
        return new Gson().toJson(Report_Action);
    }
    @GetMapping("/report_Action/report={reportId}")
    public String getReport_ActionByReportId(@PathVariable(value = "reportId")int reportId) {
        ArrayList<Report_Action> report_Actions = new Report_ActionDAO().readByReportId(reportId);
        return new Gson().toJson(report_Actions);
    }
    @GetMapping("/report_Action/action={actionId}")
    public String getReport_ActionByActionId(@PathVariable(value = "actionId")int actionId) {
        ArrayList<Report_Action> report_Actions = new Report_ActionDAO().readByActionId(actionId);
        return new Gson().toJson(report_Actions);
    }
    @PatchMapping("/report_Action")
    public void updateReport_Action(@RequestBody Report_Action report_Action) {
        new Report_ActionDAO().update(report_Action);
    }
    @DeleteMapping("/report_Action")
    public void deleteReport_Action(@RequestBody Report_Action report_Action) {
        new Report_ActionDAO().delete(report_Action);
    }
    @DeleteMapping("/report_Action/{id}")
    public void deleteReport_Action(@PathVariable(value = "id")int id) {
        new Report_ActionDAO().delete(id);
    }
    
    @PostMapping("/report_Patrol")
    public void createReport_Patrol(@RequestBody Report_Patrol report_Patrol) {
        new Report_PatrolDAO().create(report_Patrol);
    }
    @GetMapping("/report_Patrol")
    public String getReport_Patrols() {
        ArrayList<Report_Patrol> report_Patrols = new Report_PatrolDAO().read();
        return new Gson().toJson(report_Patrols);
    }
    @GetMapping("/report_Patrol/{id}")
    public String getReport_PatrolById(@PathVariable(value = "id")int id) {
        Report_Patrol Report_Patrol = new Report_PatrolDAO().read(id);
        return new Gson().toJson(Report_Patrol);
    }
    @GetMapping("/report_Patrol/report={reportId}")
    public String getReport_PatrolByReportId(@PathVariable(value = "reportId")int reportId) {
        ArrayList<Report_Patrol> report_Patrols = new Report_PatrolDAO().readByReportId(reportId);
        return new Gson().toJson(report_Patrols);
    }
    @GetMapping("/report_Patrol/Patrol={patrolId}")
    public String getReport_PatrolByPatrolId(@PathVariable(value = "patrolId")int patrolId) {
        ArrayList<Report_Patrol> report_Patrols = new Report_PatrolDAO().readByPatrolId(patrolId);
        return new Gson().toJson(report_Patrols);
    }
    @PatchMapping("/report_Patrol")
    public void updateReport_Patrol(@RequestBody Report_Patrol report_Patrol) {
        new Report_PatrolDAO().update(report_Patrol);
    }
    @DeleteMapping("/report_Patrol")
    public void deleteReport_Patrol(@RequestBody Report_Patrol report_Patrol) {
        new Report_PatrolDAO().delete(report_Patrol);
    }
    @DeleteMapping("/report_Patrol/{id}")
    public void deleteReport_Patrol(@PathVariable(value = "id")int id) {
        new Report_PatrolDAO().delete(id);
    }
    
    @PostMapping("/report")
    public void createreport(@RequestBody Report report) {
        new ReportDAO().create(report);
    }
    @GetMapping("/report")
    public String getreports() {
        ArrayList<Report> reports = new ReportDAO().read();
        return new Gson().toJson(reports);
    }
    @GetMapping("/report/{id}")
    public String getreportById(@PathVariable(value = "id")int id) {
        Report report = new ReportDAO().read(id);
        return new Gson().toJson(report);
    }
    @PatchMapping("/report")
    public void updatereport(@RequestBody Report report) {
        new ReportDAO().update(report);
    }
    @DeleteMapping("/report")
    public void deletereport(@RequestBody Report report) {
        new ReportDAO().delete(report);
    }
    @DeleteMapping("/report/{id}")
    public void deletereportById(@PathVariable(value = "id")int id) {
        new ReportDAO().delete(id);
    }
}