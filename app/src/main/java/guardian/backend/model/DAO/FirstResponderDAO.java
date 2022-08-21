package guardian.backend.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import guardian.backend.model.ArrayConverterFactory;
import guardian.backend.model.ConnectionFactory;
import guardian.backend.model.FirstResponder;

public class FirstResponderDAO {
    public void create(FirstResponder firstResponder) {
        String sql = "INSERT INTO firstResponder(username,password,email,showedName,description,privilegeLevel,reportedPosition,reportedPositionTime,firstResponderType,state) VALUES (?,?,?,?,?,?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstResponder.getUsername());
            preparedStatement.setString(2, firstResponder.getPassword());
            preparedStatement.setString(3, firstResponder.getEmail());
            preparedStatement.setString(4, firstResponder.getShowedName());
            preparedStatement.setString(5, firstResponder.getDescription());
            preparedStatement.setInt(6, firstResponder.getPrivilegeLevel());
            preparedStatement.setString(7, new ArrayConverterFactory().stringArrayToJSON(firstResponder.getReportedPosition()));
            preparedStatement.setString(8, new ArrayConverterFactory().LocalDateTimeArrayToJSON(firstResponder.getReportedPositionTime()));
            preparedStatement.setInt(9, firstResponder.getFirstResponderType());
            preparedStatement.setBoolean(10, firstResponder.isReady());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while registering first responder: " + e.getMessage());
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
        ArrayList<FirstResponder> firstResponders = new ArrayList<FirstResponder>();
        String sql = "SELECT * FROM FirstResponder";
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
                firstResponder.setDescription(resultSet.getString("description"));
                firstResponder.setPrivilegeLevel(resultSet.getInt("privilegeLevel"));
                firstResponder.setReportedPosition(new ArrayConverterFactory().jsonToStringArray(resultSet.getString("reportedPosition")));
                firstResponder.setReportedPositionTime(new ArrayConverterFactory().jsonToLocalDateTimeArray(resultSet.getString("reportedPositionTime")));
                firstResponder.setFirstResponderType(resultSet.getInt("firstResponderType"));
                firstResponder.setState(resultSet.getBoolean("state"));
                firstResponders.add(firstResponder);
            }
        } catch (Exception e) {
            System.out.println("Error while registering first responder: " + e.getMessage());
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
    };
    public FirstResponder read(int id) {
        ArrayList<FirstResponder> firstResponders = new ArrayList<FirstResponder>();
        String sql = "SELECT * FROM FirstResponder WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                FirstResponder firstResponder = new FirstResponder();
                firstResponder.setId(resultSet.getInt("id"));
                firstResponder.setUsername(resultSet.getString("username"));
                firstResponder.setPassword(resultSet.getString("password"));
                firstResponder.setEmail(resultSet.getString("email"));
                firstResponder.setShowedName(resultSet.getString("showedName"));
                firstResponder.setDescription(resultSet.getString("description"));
                firstResponder.setPrivilegeLevel(resultSet.getInt("privilegeLevel"));
                firstResponder.setReportedPosition(new ArrayConverterFactory().jsonToStringArray(resultSet.getString("reportedPosition")));
                firstResponder.setReportedPositionTime(new ArrayConverterFactory().jsonToLocalDateTimeArray(resultSet.getString("reportedPositionTime")));
                firstResponder.setFirstResponderType(resultSet.getInt("firstResponderType"));
                firstResponder.setState(resultSet.getBoolean("state"));
                firstResponders.add(firstResponder);
            }
        } catch (Exception e) {
            System.out.println("Error while registering first responder: " + e.getMessage());
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
        return firstResponders.get(0);
    };
    public void update(FirstResponder firstResponder) {
        String sql = "UPDATE FirstResponder SET username = ?,password = ?,email = ?,showedName = ?,description = ?,privilegeLevel = ?,reportedPosition = ?,reportedPositionTime = ?,firstResponderType = ?,state = ? WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, firstResponder.getUsername());
            preparedStatement.setString(2, firstResponder.getPassword());
            preparedStatement.setString(3, firstResponder.getEmail());
            preparedStatement.setString(4, firstResponder.getShowedName());
            preparedStatement.setString(5, firstResponder.getDescription());
            preparedStatement.setInt(6, firstResponder.getPrivilegeLevel());
            preparedStatement.setString(7, new ArrayConverterFactory().stringArrayToJSON(firstResponder.getReportedPosition()));
            preparedStatement.setString(8, new ArrayConverterFactory().LocalDateTimeArrayToJSON(firstResponder.getReportedPositionTime()));
            preparedStatement.setInt(9, firstResponder.getFirstResponderType());
            preparedStatement.setBoolean(10, firstResponder.isReady());
            preparedStatement.setInt(11, firstResponder.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while updating first responder: " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch(Exception e) {
                System.out.println("Error while closing the connection: " + e.getMessage());
            }
        }
    };
    public void delete(int id) {
        String sql = "DELETE FROM FirstResponder WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while deleting first responder: " + e.getMessage());
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
    };
    public void delete(FirstResponder firstResponder) {
        String sql = "DELETE FROM FirstResponder WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, firstResponder.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while deleting first responder: " + e.getMessage());
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
    };
    public FirstResponder getFirstResponderByUsername(String username) {
        FirstResponder firstResponder = new FirstResponder();
        for (int i = 0; i < this.read().size(); i++) {
            if (username.equals(this.read().get(i).getUsername())) {
                firstResponder = this.read().get(i);
            }
        }
        return firstResponder;
    };
}
