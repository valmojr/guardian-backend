package guardian.backend.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import guardian.backend.model.ArrayConverterFactory;
import guardian.backend.model.ConnectionFactory;
import guardian.backend.model.Incident;

public class IncidentDAO {
    public void create(Incident incident) {
        String sql = "INSERT INTO incident(reportedPosition,reportedPositionTime,danger,state,description) VALUES (?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, new ArrayConverterFactory().stringArrayToJSON(incident.getReportedPosition()));
            preparedStatement.setString(2, new ArrayConverterFactory().LocalDateTimeArrayToJSON(incident.getReportedPositionTime()));
            preparedStatement.setInt(3, incident.getDanger());
            preparedStatement.setInt(4, incident.getState());
            preparedStatement.setString(5, incident.getDescription());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while registering incident: " + e.getMessage());
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
    public ArrayList<Incident> read() {
        ArrayList<Incident> incidents = new ArrayList<Incident>();
        String sql = "SELECT * FROM incident";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Incident incident = new Incident();
                incident.setId(resultSet.getInt("id"));
                incident.setReportedPosition(new ArrayConverterFactory().jsonToStringArray(resultSet.getString("reportedPosition")));
                incident.setReportedPositionTime(new ArrayConverterFactory().jsonToLocalDateTimeArray(resultSet.getString("reportedPositionTime")));
                incident.setDanger(resultSet.getInt("danger"));
                incident.setState(resultSet.getInt("state"));
                incident.setDescription(resultSet.getString("description"));
                incidents.add(incident);
            }
        } catch(Exception e) {
            System.out.println("Error while retrieving incidents: " + e.getMessage());
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
        return incidents;
    };
    public Incident read(int id) {
        ArrayList<Incident> incidents = new ArrayList<Incident>();
        String sql = "SELECT * FROM incident WHERE = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Incident incident = new Incident();
                incident.setId(resultSet.getInt("id"));
                incident.setReportedPosition(new ArrayConverterFactory().jsonToStringArray(resultSet.getString("reportedPosition")));
                incident.setReportedPositionTime(new ArrayConverterFactory().jsonToLocalDateTimeArray(resultSet.getString("reportedPositionTime")));
                incident.setDanger(resultSet.getInt("danger"));
                incident.setState(resultSet.getInt("state"));
                incident.setDescription(resultSet.getString("description"));
                incidents.add(incident);
            }
        } catch(Exception e) {
            System.out.println("Error while retrieving incidents: " + e.getMessage());
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
        return incidents.get(0);
    };
    public void update(Incident incident) {
        String sql = "UPDATE incident SET reportedPosition = ?, reportedPositionTime = ?,danger = ?,state = ?,description = ? WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, new ArrayConverterFactory().stringArrayToJSON(incident.getReportedPosition()));
            preparedStatement.setString(2, new ArrayConverterFactory().LocalDateTimeArrayToJSON(incident.getReportedPositionTime()));
            preparedStatement.setInt(3, incident.getDanger());
            preparedStatement.setInt(4, incident.getState());
            preparedStatement.setString(5, incident.getDescription());
            preparedStatement.setInt(6, incident.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while updating incident: " + e.getMessage());
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
    public void delete(int id) {
        String sql = "DELETE FROM incident WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while deleting action and incident association: " + e.getMessage());
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
    public void delete(Incident incident) {
        String sql = "DELETE FROM incident WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, incident.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while deleting action and incident association: " + e.getMessage());
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
}