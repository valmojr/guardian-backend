package guardian.backend.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import guardian.backend.model.ConnectionFactory;
import guardian.backend.model.Position_Incident;

public class Position_IncidentDAO {
    public void create(Position_Incident position_Incident) {
        String sql = "INSERT INTO position_Incident(assignedIncidentId, reportedPosition,reportedTime) VALUES (?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, position_Incident.getAssignedIncidentId());
            preparedStatement.setString(2, position_Incident.getReportedPosition());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(position_Incident.getReportedTime()));
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
    public ArrayList<Position_Incident> read() {
        ArrayList<Position_Incident> position_Incidents = new ArrayList<Position_Incident>();
        String sql = "SELECT * FROM position_Incident";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Position_Incident position_Incident = new Position_Incident();
                position_Incident.setId(resultSet.getInt("id"));
                position_Incident.setAssignedIncidentId(resultSet.getInt("assignedIncidentId"));
                position_Incident.setReportedPosition(resultSet.getString("reportedPosition"));
                position_Incident.setReportedTime(resultSet.getTimestamp("reportedTime").toLocalDateTime());
                position_Incidents.add(position_Incident);
            }
        } catch (Exception e) {
            System.out.println("Error while getting position and incident relations: " + e.getMessage());
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
        return position_Incidents;
    };
    public Position_Incident read(int id) {
        ArrayList<Position_Incident> position_Incidents = new ArrayList<Position_Incident>();
        String sql = "SELECT * FROM position_Incidents WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Position_Incident position_Incident = new Position_Incident();
                position_Incident.setId(resultSet.getInt("id"));
                position_Incident.setAssignedIncidentId(resultSet.getInt("assignedIncidentId"));
                position_Incident.setReportedPosition(resultSet.getString("reportedPosition"));
                position_Incident.setReportedTime(resultSet.getTimestamp("reportedTime").toLocalDateTime());
                position_Incidents.add(position_Incident);
            }
        } catch (Exception e) {
            System.out.println("Error while getting position and incident relation by id: " + e.getMessage());
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
        return position_Incidents.get(0);
    };
    public ArrayList<Position_Incident> readByIncidentId(int incidentId) {
        ArrayList<Position_Incident> position_Incidents = new ArrayList<Position_Incident>();
        String sql = "SELECT * FROM position_Incidents WHERE assignedIncidentId = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, incidentId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Position_Incident position_Incident = new Position_Incident();
                position_Incident.setId(resultSet.getInt("id"));
                position_Incident.setAssignedIncidentId(resultSet.getInt("assignedIncidentId"));
                position_Incident.setReportedPosition(resultSet.getString("reportedPosition"));
                position_Incident.setReportedTime(resultSet.getTimestamp("reportedTime").toLocalDateTime());
                position_Incidents.add(position_Incident);
            }
        } catch (Exception e) {
            System.out.println("Error while getting position and incident relation by id: " + e.getMessage());
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
        return position_Incidents;
    };
    public void update(Position_Incident position_Incident) {
        String sql = "UPDATE position_Incident SET assignedIncidentId = ?, reportedPosition = ?, reportedTime = ? WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, position_Incident.getAssignedIncidentId());
            preparedStatement.setString(2, position_Incident.getReportedPosition());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(position_Incident.getReportedTime()));
            preparedStatement.setInt(4, position_Incident.getId());
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
            } catch(Exception e) {
                System.out.println("Error while closing the connection: " + e.getMessage());
            }
        }
    };
    public void delete(int id) {
        String sql = "DELETE FROM position_Incident WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while deleting incident: " + e.getMessage());
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
    public void delete(Position_Incident position_Incident) {
        String sql = "DELETE FROM position_Incident WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, position_Incident.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while deleting position and incident relation: " + e.getMessage());
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
