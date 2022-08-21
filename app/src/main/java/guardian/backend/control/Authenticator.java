package guardian.backend.control;

import java.nio.charset.StandardCharsets;
import com.google.common.hash.Hashing;
import guardian.backend.model.DAO.FirstResponderDAO;

public class Authenticator{
    public boolean authenticate(String username, String password) {
        String encryptedPassword = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        if (encryptedPassword.equals(new FirstResponderDAO().getFirstResponderByUsername(username).getPassword())) {
            return true;
        } else {
            return false;
        }
    }
    public String encryptate(String password) {
        String encryptedPassword = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        return encryptedPassword;
    }
}