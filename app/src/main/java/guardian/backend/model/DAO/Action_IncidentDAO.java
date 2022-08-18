package guardian.backend.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import guardian.backend.model.Action_Incident;
import guardian.backend.model.ConnectionFactory;

public class Action_IncidentDAO {
    public void create(Action_Incident action_Incident) {
        String sql = "INSERT INTO action_incident(assignedActionId,assignedIncidentId) VALUES (?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, action_Incident.getAssignedActionId());
            preparedStatement.setInt(2, action_Incident.getAssignedIncidentId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while registering action and incident association: " + e.getMessage());
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
    public ArrayList<Action_Incident> read() {
        String sql = "SELECT * FROM action_incident";
        ArrayList<Action_Incident> action_Incidents = new ArrayList<Action_Incident>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Action_Incident action_Incident = new Action_Incident();
                action_Incident.setId(resultSet.getInt("id"));
                action_Incident.setAssignedActionId(resultSet.getInt("assignedActionId"));
                action_Incident.setAssignedIncidentId(resultSet.getInt("assignedIncidentId"));
                action_Incidents.add(action_Incident);
            }
        } catch(Exception e) {
            System.out.println("Error while retrieving actions and incidents associations: " + e.getMessage());
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
        return action_Incidents;
    }
    public Action_Incident read(int id) {
        String sql = "SELECT * FROM action_incident WHERE id = ?";
        ArrayList<Action_Incident> action_Incidents = new ArrayList<Action_Incident>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Action_Incident action_Incident = new Action_Incident();
                action_Incident.setId(resultSet.getInt("id"));
                action_Incident.setAssignedActionId(resultSet.getInt("assignedActionId"));
                action_Incident.setAssignedIncidentId(resultSet.getInt("assignedIncidentId"));
                action_Incidents.add(action_Incident);
            }
        } catch(Exception e) {
            System.out.println("Error while retrieving actions and incidents associations by id: " + e.getMessage());
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
        return action_Incidents.get(0);
    }
    public void update(Action_Incident action_Incident) {
        String sql = "UPDATE action_incident SET id = ?,assignedActionId = ?,assignedIncidentId = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, action_Incident.getId());
            preparedStatement.setInt(2, action_Incident.getAssignedActionId());
            preparedStatement.setInt(3, action_Incident.getAssignedIncidentId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erorr while updating action and incident association: " + e.getMessage());
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
    }
    public void delete(int id) {
        String sql = "DELETE FROM action_incident WHERE id = ?";
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
    }
    public void delete(Action_Incident action_Incident) {
        String sql = "DELETE FROM action_incident WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, action_Incident.getId());
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
    }
}
