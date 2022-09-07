package guardian.backend.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RESTController {
    @GetMapping("/registry/operator")
    public String registerOperator() {
        try {
            
            return "Class 1 First Respoder Registred\n";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @GetMapping("/registry/commsOperator")
    public String registerCommsOperator() {
        try {
            
            return "Class 2 First Respoder Registred\n";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @GetMapping("/registry/administrator")
    public String registerAdministrator() {
        try {
            
            return "Class 3 First Respoder Registred\n";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
