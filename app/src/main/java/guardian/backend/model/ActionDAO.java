package guardian.backend.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import guardian.backend.control.Action;

public class ActionDAO {
    public void create(Action action) {
        String sql = "";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
                        
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
