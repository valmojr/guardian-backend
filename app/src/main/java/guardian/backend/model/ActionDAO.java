package guardian.backend.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import guardian.backend.control.Action;

public class ActionDAO {
    public void create(Action action) {
        String sql = "INSERT INTO actions(reportedPosition,reportedPositionTime,description,assignedUserId,assignedIncidentId) VALUES(?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, new ArrayConverterFactory().stringArrayToJSON(action.getReportedPosition()));
            preparedStatement.setString(2, new ArrayConverterFactory().LocalDateTimeArrayToJSON(action.getReportedPositionTime()));
            preparedStatement.setString(3, action.getDescription());
            preparedStatement.setString(4, new ArrayConverterFactory().intArrayToJSON(action.getAssignedUserId()));
            preparedStatement.setString(5, new ArrayConverterFactory().intArrayToJSON(action.getAssignedIncidentId()));
        } catch (Exception e) {
            System.out.println("Error while connecting" + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error while closing the connection" + e.getMessage());
            }
        }
    }
    public ArrayList<Action> read() {
        String sql = "SELECT * FROM actions";
        ArrayList<Action> actions = new ArrayList<Action>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Action action = new Action();
                action.setId(resultSet.getInt("id"));
                action.setReportedPosition(new ArrayConverterFactory().jsonToStringArray(resultSet.getString("reportedPosition")));
                action.setReportedPositionTime(new ArrayConverterFactory().jsonToLocalDateTimeArray(resultSet.getString("reportedPositionTime")));
                action.setDescription(resultSet.getString("description"));
                action.setAssignedUserId(new ArrayConverterFactory().jsonToIntArray(resultSet.getString("assignedUserId")));
                action.setAssignedIncidentId(new ArrayConverterFactory().jsonToIntArray(resultSet.getString("assignedIncidentId")));
                actions.add(action);
            }
        } catch (Exception e) {
            System.out.println("Error while connecting" + e.getMessage());
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error while closing the connection" + e.getMessage());
            }
        }
        return new ArrayList<Action>();
    }
    public void update(Action action) {
        String sql = "UPDATE actions SET reportedPosition = ?, reportedPositionTime = ?, description = ?, assignedUserId = ?, assignedIncidentId = ?" + "WHERE = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, new ArrayConverterFactory().stringArrayToJSON(action.getReportedPosition()));
            preparedStatement.setString(2, new ArrayConverterFactory().LocalDateTimeArrayToJSON(action.getReportedPositionTime()));
            preparedStatement.setString(3, action.getDescription());
            preparedStatement.setString(4, new ArrayConverterFactory().intArrayToJSON(action.getAssignedUserId()));
            preparedStatement.setString(5, new ArrayConverterFactory().intArrayToJSON(action.getAssignedIncidentId()));
            preparedStatement.setInt(6, action.getId());

            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while connecting" + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error while closing the connection" + e.getMessage());
            }
        }
    }
}
