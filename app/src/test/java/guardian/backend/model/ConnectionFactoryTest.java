package guardian.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

public class ConnectionFactoryTest {
    @Test
    public void canConnectToLocalDataBase() {
        Exception error = null;
        try {
            Connection connection = ConnectionFactory.createConnectionToMySQLDatabase();
            connection.createStatement();
        } catch (Exception e) {
            error = e;
        }
        assertEquals(error, null);
    }
    @Test
    public void canConnectToAnyDataBase() {
        Exception error = null;
        try {
            String url = "jdbc:mysql://localhost:3306/guardian";
            String username = "root";
            String password = "";
            Connection connection = ConnectionFactory.createConnection(url,username,password);
            connection.createStatement();
        } catch (Exception e) {
            error = e;
        }
        assertEquals(error, null);
    }
}
