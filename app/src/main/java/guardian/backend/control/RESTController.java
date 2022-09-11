package guardian.backend.control;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import guardian.backend.model.FirstResponder;
import guardian.backend.model.DAO.FirstResponderDAO;
@RestController
public class RESTController {
    @GetMapping("/error")
    public String error() {
        return "Error!";
    }
    @GetMapping("/getTroopers")
    public String getTroopers() {
        ArrayList<FirstResponder> Troopers = new FirstResponderDAO().read();
        String res = "";
        for (int i = 0; i < Troopers.size(); i++) {
            res += Troopers.get(i).getId();
            res += " - ";
            res += Troopers.get(i).getShowedName();
            res += "\n";
        }
        return res;
    }
    @GetMapping("/registry/operator")
    public String registerOperator() {
        try {
            return "Class 1 First Responder Registred\n";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @GetMapping("/registry/commsOperator")
    public String registerCommsOperator() {
        try {
            
            return "Class 2 First Responder Registred\n";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @GetMapping("/registry/administrator")
    public String registerAdministrator() {
        try {
            
            return "Class 3 First Responder Registred\n";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
