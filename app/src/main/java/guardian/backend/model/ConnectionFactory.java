package guardian.backend.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static final String url = "jdbc:mysql://localhost:3306/guardian";
    private static final String username = "root";
    private static final String password = "";

    public static Connection createConnectionToMySQLDatabase() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
}