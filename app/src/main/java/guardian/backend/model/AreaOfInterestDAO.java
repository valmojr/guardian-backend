package guardian.backend.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import guardian.backend.control.AreaOfInterest;

public class AreaOfInterestDAO {
    public void create(AreaOfInterest areaOfInterest) {
        String sql = "INSERT INTO areaOfInterests(reportedPosition,reportedPositionTime,danger,state,description,assignedActionId) VALUES(?,?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, new ArrayConverterFactory().stringArrayToJSON(areaOfInterest.getReportedPosition()));
            preparedStatement.setString(2, new ArrayConverterFactory().LocalDateTimeArrayToJSON(areaOfInterest.getReportedPositionTime()));
            preparedStatement.setInt(3, areaOfInterest.getDanger());
            preparedStatement.setBoolean(4, areaOfInterest.getState());
            preparedStatement.setString(5, areaOfInterest.getDescription());
            preparedStatement.setString(6, new ArrayConverterFactory().intArrayToJSON(areaOfInterest.getAssignedActionId()));
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
    public ArrayList<AreaOfInterest> read() {
        String sql = "SELECT * FROM areaOfInterests";
        ArrayList<AreaOfInterest> areaOfInterests = new ArrayList<AreaOfInterest>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                AreaOfInterest areaOfInterest = new AreaOfInterest();
                areaOfInterest.setId(resultSet.getInt("id"));
                areaOfInterest.setReportedPosition(new ArrayConverterFactory().jsonToStringArray(resultSet.getString("reportedPosition")));
                areaOfInterest.setReportedPositionTime(new ArrayConverterFactory().jsonToLocalDateTimeArray(resultSet.getString("reportedPositionTime")));
                areaOfInterest.setDanger(resultSet.getInt("danger"));
                areaOfInterest.setState(resultSet.getBoolean("state"));
                areaOfInterest.setDescription(resultSet.getString("description"));
                areaOfInterest.setAssignedActionId(new ArrayConverterFactory().jsonToIntArray(resultSet.getString("assignedActionId")));
                areaOfInterests.add(areaOfInterest);
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
        return areaOfInterests;
    }
    public void update(AreaOfInterest areaOfInterest) {
        String sql = "UPDATE areaOfInterests SET reportedPosition=?,reportedPositionTime=?,danger=?,state=?,description=?,assignedActionId=?" + "WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, new ArrayConverterFactory().stringArrayToJSON(areaOfInterest.getReportedPosition()));
            preparedStatement.setString(2, new ArrayConverterFactory().LocalDateTimeArrayToJSON(areaOfInterest.getReportedPositionTime()));
            preparedStatement.setInt(3, areaOfInterest.getDanger());
            preparedStatement.setBoolean(4, areaOfInterest.getState());
            preparedStatement.setString(5, areaOfInterest.getDescription());
            preparedStatement.setString(6, new ArrayConverterFactory().intArrayToJSON(areaOfInterest.getAssignedActionId()));
            preparedStatement.setInt(7, areaOfInterest.getId());
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
        String sql = "DELETE FROM areaOfInterests WHERE id = ?";
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
