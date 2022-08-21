package guardian.backend;

import guardian.backend.control.Authenticator;

public class App {
    public static void main(String[] args) {
        if (new Authenticator().authenticate("valmojr", "123456")) {
            System.out.println("LOGADO");
        } else {
            System.out.println("DESLOGADO");
        }
    }
}