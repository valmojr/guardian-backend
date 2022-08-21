package guardian.backend.control;

import guardian.backend.model.FirstResponder;
import guardian.backend.model.DAO.FirstResponderDAO;

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
}
