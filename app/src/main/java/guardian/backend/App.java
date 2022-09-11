package guardian.backend;

import guardian.backend.model.FirstResponder;
import guardian.backend.model.DAO.FirstResponderDAO;

public class App {
    public static void main(String[] args) {
		FirstResponder firstResponder = new FirstResponder();
        firstResponder.setUsername("username");
        firstResponder.setPassword("password");
        firstResponder.setShowedName("showedName");
        firstResponder.setEmail("email@algo.com");
        firstResponder.setPrivilegeLevel(3);
        firstResponder.setFirstResponderType(1);
        firstResponder.setDescription("description");
        new FirstResponderDAO().create(firstResponder);
    }
}
