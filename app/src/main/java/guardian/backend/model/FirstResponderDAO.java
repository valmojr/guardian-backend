package guardian.backend.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import guardian.backend.control.FirstResponder;

public class FirstResponderDAO {
    public void create(FirstResponder firstResponder) {
        String sql = "INSERT INTO firstResponders(username,password,email,showedName,privilegeLevel,reportedPosition,reportedPositionTime,FirstResponderType,state,description,assignedAction) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstResponder.getUsername());
            preparedStatement.setString(2, firstResponder.getUsername());
            preparedStatement.setString(3, firstResponder.getUsername());
            preparedStatement.setString(4, firstResponder.getUsername());
            preparedStatement.setInt(5, firstResponder.getPrivilegeLevel());
            preparedStatement.setString(6, new ArrayConverterFactory().stringArrayToJSON(firstResponder.getReportedPosition()));
            preparedStatement.setString(7, new ArrayConverterFactory().LocalDateTimeArrayToJSON(firstResponder.getReportedPositionTime()));
            preparedStatement.setInt(8, firstResponder.getFirstResponderType());
            preparedStatement.setBoolean(9, firstResponder.getState());
            preparedStatement.setString(10, firstResponder.getDescription());
            preparedStatement.setString(11, new ArrayConverterFactory().intArrayToJSON(firstResponder.getAssignedAction()));
            
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while connecting: " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error while closing the connection: " + e.getMessage());
            }
        }
    }
    public ArrayList<FirstResponder> read() {
        String sql = "SELECT * FROM firstResponders";
        ArrayList<FirstResponder> firstResponders = new ArrayList<FirstResponder>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                FirstResponder firstResponder = new FirstResponder();
                firstResponder.setId(resultSet.getInt("id"));
                firstResponder.setUsername(resultSet.getString("username"));
                firstResponder.setPassword(resultSet.getString("password"));
                firstResponder.setEmail(resultSet.getString("email"));
                firstResponder.setShowedName(resultSet.getString("showedName"));
                firstResponder.setPrivilegeLevel(resultSet.getInt("privilegeLevel"));
                firstResponder.setReportedPosition(new ArrayConverterFactory().jsonToStringArray(resultSet.getString("reportedPosition")));
                firstResponder.setReportedPositionTime(new ArrayConverterFactory().jsonToLocalDateTimeArray(resultSet.getString("reportedPositionTime")));
                firstResponder.setFirstResponderType(resultSet.getInt("firstResponderType"));
                firstResponder.setState(resultSet.getBoolean("state"));
                firstResponder.setDescription(resultSet.getString("description"));
                firstResponder.setAssignedAction(new ArrayConverterFactory().jsonToIntArray(resultSet.getString("assignedAction")));
                firstResponders.add(firstResponder);
            }
        } catch (Exception e) {
            System.out.println("Error while connecting: " + e.getMessage());
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
                System.out.println("Error while closing the connection: " + e.getMessage());
            }
        }
        return firstResponders;
    }
    public void update(FirstResponder firstResponder) {
        String sql = "UPDATE firstResponders SET reportedPosition=?,reportedPositionTime=?,danger=?,state=?,description=?,assignedActionId=?" + "WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstResponder.getUsername());
            preparedStatement.setString(2, firstResponder.getUsername());
            preparedStatement.setString(3, firstResponder.getUsername());
            preparedStatement.setString(4, firstResponder.getUsername());
            preparedStatement.setInt(5, firstResponder.getPrivilegeLevel());
            preparedStatement.setString(6, new ArrayConverterFactory().stringArrayToJSON(firstResponder.getReportedPosition()));
            preparedStatement.setString(7, new ArrayConverterFactory().LocalDateTimeArrayToJSON(firstResponder.getReportedPositionTime()));
            preparedStatement.setInt(8, firstResponder.getFirstResponderType());
            preparedStatement.setBoolean(9, firstResponder.getState());
            preparedStatement.setString(10, firstResponder.getDescription());
            preparedStatement.setString(11, new ArrayConverterFactory().intArrayToJSON(firstResponder.getAssignedAction()));
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while connecting: " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error while closing the connection: " + e.getMessage());
            }
        }
    }
    public void delete(int id) {
        String sql = "DELETE FROM FirstResponders WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while connecting: " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error while closing the connection: " + e.getMessage());
            }
        }
    }    
}
