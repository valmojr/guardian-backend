package guardian.backend.control;

import guardian.backend.model.FirstResponder;
import guardian.backend.model.DAO.FirstResponderDAO;

public class Registrator {
    public void registerPoliceTrooper(String username, String password, String email, String showedName, String description) {
        FirstResponder firstResponder = new FirstResponder();
        firstResponder.setUsername(username);
        firstResponder.setPassword(new Authenticator().encryptate(password));
        firstResponder.setEmail(email);
        firstResponder.setShowedName(showedName);
        firstResponder.setDescription(description);
        firstResponder.setPrivilegeLevel(1);
        firstResponder.setFirstResponderType(1);
        new FirstResponderDAO().create(firstResponder);
    }
    public void registerCommsOperator(String username, String password, String email, String showedName, String description) {
        FirstResponder firstResponder = new FirstResponder();
        firstResponder.setUsername(username);
        firstResponder.setPassword(new Authenticator().encryptate(password));
        firstResponder.setEmail(email);
        firstResponder.setShowedName(showedName);
        firstResponder.setDescription(description);
        firstResponder.setPrivilegeLevel(2);
        firstResponder.setFirstResponderType(1);
        new FirstResponderDAO().create(firstResponder);
    }
}
