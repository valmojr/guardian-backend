package guardian.backend;

import guardian.backend.model.DAO.Action_IncidentDAO;

public class App {
    public static void main(String[] args) {
        Action_IncidentDAO action_IncidentDAO = new Action_IncidentDAO();
        for (int i = 0; i < action_IncidentDAO.read().size(); i++) {
            System.out.println(new Action_IncidentDAO().read().get(i).getId());
        }
    }
}
