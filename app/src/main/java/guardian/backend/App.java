package guardian.backend;

import guardian.backend.control.FirstResponder;
import guardian.backend.model.FirstResponderDAO;

public class App {
    public static void main(String[] args) {
        FirstResponder firstResponder = new FirstResponder();
        firstResponder.setDescription("this FirstResponder was just created!");
        FirstResponderDAO classUnderTest = new FirstResponderDAO();
        int beforeCreate = classUnderTest.read().size();
        classUnderTest.create(firstResponder);
        int afterCreate = classUnderTest.read().size();
    }
}