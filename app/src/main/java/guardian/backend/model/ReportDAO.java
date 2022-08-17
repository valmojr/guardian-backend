package guardian.backend.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import guardian.backend.control.Report;

public class ReportDAO {
    public void create(Report report) {
        String sql = "INSERT INTO reports(reportDescription,assignedUserId,assignedRelatedEventId,reportedPosition,reportedPositionTime,reportObservation) VALUES(?,?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, report.getReportDescription());
            preparedStatement.setString(2, new ArrayConverterFactory().intArrayToJSON(report.getAssignedUserId()));
            preparedStatement.setInt(3, report.getAssignedRelatedEventId());
            preparedStatement.setString(4, new ArrayConverterFactory().stringArrayToJSON(report.getReportedPosition()));
            preparedStatement.setString(5, new ArrayConverterFactory().LocalDateTimeArrayToJSON(report.getReportedPositionTime()));
            preparedStatement.setString(6, report.getReportObservation());
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
    public ArrayList<Report> read() {
        String sql = "SELECT * FROM reports";
        ArrayList<Report> reports = new ArrayList<Report>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Report report = new Report();
                report.setId(resultSet.getInt("id"));
                report.setReportDescription(resultSet.getString("reportDescription"));
                report.setAssignedUserId(new ArrayConverterFactory().jsonToIntArray(resultSet.getString("assignedUserId")));
                report.setReportedPosition(new ArrayConverterFactory().jsonToStringArray(resultSet.getString("reportedPosition")));
                report.setReportedPositionTime(new ArrayConverterFactory().jsonToLocalDateTimeArray(resultSet.getString("reportedPositionTime")));
                report.setReportObservation(resultSet.getString("reportObservation"));
                reports.add(report);
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
        return reports;
    }
    public void update(Report report) {
        String sql = "UPDATE reports SET reportDescription = ?, assignedUserId = ?, assignedRelatedEventId = ?, reportedPosition = ?, reportedPositionTime = ?, reportObservation = ?" + "WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, report.getReportDescription());
            preparedStatement.setString(2, new ArrayConverterFactory().intArrayToJSON(report.getAssignedUserId()));
            preparedStatement.setInt(3, report.getAssignedRelatedEventId());
            preparedStatement.setString(4, new ArrayConverterFactory().stringArrayToJSON(report.getReportedPosition()));
            preparedStatement.setString(5, new ArrayConverterFactory().LocalDateTimeArrayToJSON(report.getReportedPositionTime()));
            preparedStatement.setString(6, report.getReportObservation());
            preparedStatement.setInt(7, report.getId());
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
        String sql = "DELETE FROM reports WHERE id = ?";
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