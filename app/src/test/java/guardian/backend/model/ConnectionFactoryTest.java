package guardian.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

public class ConnectionFactoryTest {
    @Test
    void canConnectToDataBase() {
        Exception error = null;
        try {
            Connection connection = ConnectionFactory.createConnectionToMySQLDatabase();
        } catch (Exception e) {
            error = e;
        }
        assertEquals(error, null);
    }
}
