package guardian.backend;

import guardian.backend.control.Action;
import guardian.backend.model.ActionDAO;

public class App {
    public static void main(String[] args) {
        System.out.println(new ActionDAO().read().size());
    }
}