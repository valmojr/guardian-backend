package guardian.backend.control;
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
import guardian.backend.model.DAO.ActionDAO;
import guardian.backend.model.DAO.Action_IncidentDAO;
import guardian.backend.model.DAO.AreaOfInterestDAO;
import guardian.backend.model.DAO.FirstResponderDAO;
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
    //FirstResponder_Action C R U D

    //FirstResponder_Patrol C R U D
    
    
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
    
    //Incident C R U D
    
    //Patrol_AreaOfInterest C R U D
    
    //Patrol CRUD
    
    //PositionFirst
    
    //PositionIncident
    
    //ReportAction
    
    //ReportPatrol
    
    //Report

}