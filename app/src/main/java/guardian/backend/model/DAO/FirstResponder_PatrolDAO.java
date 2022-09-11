package guardian.backend.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import guardian.backend.model.ConnectionFactory;
import guardian.backend.model.FirstResponder_Patrol;

public class FirstResponder_PatrolDAO {
    public void create(FirstResponder_Patrol firstResponder_Patrol) {
        String sql = "INSERT INTO firstResponder_Patrol(assignedFirstResponderId,assignedPatrolId) VALUES (?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,firstResponder_Patrol.getAssignedFirstResponderId());
            preparedStatement.setInt(2,firstResponder_Patrol.getAssignedPatrolId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while registering first responders and patrols association: " + e.getMessage());
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
    public ArrayList<FirstResponder_Patrol> read() {
        String sql = "SELECT * FROM FirstResponder_Patrol";
        ArrayList<FirstResponder_Patrol> firstResponder_Patrols = new ArrayList<FirstResponder_Patrol>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                FirstResponder_Patrol firstResponder_Patrol = new FirstResponder_Patrol();
                firstResponder_Patrol.setId(resultSet.getInt("id"));
                firstResponder_Patrol.setAssignedFirstResponderId(resultSet.getInt("assignedFirstResponderId"));
                firstResponder_Patrol.setAssignedPatrolId(resultSet.getInt("assignedPatrolId"));
                firstResponder_Patrols.add(firstResponder_Patrol);
            }
        } catch (Exception e) {
            System.out.println("Error while registering first responders and patrol association: " + e.getMessage());
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
        return firstResponder_Patrols;
    };
    public FirstResponder_Patrol read(int id) {
        String sql = "SELECT * FROM FirstResponder_Patrol WHERE id = ?";
        ArrayList<FirstResponder_Patrol> firstResponder_Patrols = new ArrayList<FirstResponder_Patrol>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                FirstResponder_Patrol firstResponder_Patrol = new FirstResponder_Patrol();
                firstResponder_Patrol.setId(resultSet.getInt("id"));
                firstResponder_Patrol.setAssignedFirstResponderId(resultSet.getInt("assignedFirstResponderId"));
                firstResponder_Patrol.setAssignedPatrolId(resultSet.getInt("assignedPatrolId"));
                firstResponder_Patrols.add(firstResponder_Patrol);
            }
        } catch (Exception e) {
            System.out.println("Error while registering first responders and patrol association: " + e.getMessage());
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
        return firstResponder_Patrols.get(0);
    };
    public ArrayList<FirstResponder_Patrol> readByFirstResponderId(int firstResponderId) {
        String sql = "SELECT * FROM FirstResponder_Patrol WHERE assignedFirstResponderId = ?";
        ArrayList<FirstResponder_Patrol> firstResponder_Patrols = new ArrayList<FirstResponder_Patrol>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, firstResponderId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                FirstResponder_Patrol firstResponder_Patrol = new FirstResponder_Patrol();
                firstResponder_Patrol.setId(resultSet.getInt("id"));
                firstResponder_Patrol.setAssignedFirstResponderId(resultSet.getInt("assignedFirstResponderId"));
                firstResponder_Patrol.setAssignedPatrolId(resultSet.getInt("assignedPatrolId"));
                firstResponder_Patrols.add(firstResponder_Patrol);
            }
        } catch (Exception e) {
            System.out.println("Error while registering first responders and patrol association: " + e.getMessage());
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
        return firstResponder_Patrols;
    };
    public ArrayList<FirstResponder_Patrol> readByPatrolId(int patrolId) {
        String sql = "SELECT * FROM FirstResponder_Patrol WHERE assignedPatrolId = ?";
        ArrayList<FirstResponder_Patrol> firstResponder_Patrols = new ArrayList<FirstResponder_Patrol>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, patrolId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                FirstResponder_Patrol firstResponder_Patrol = new FirstResponder_Patrol();
                firstResponder_Patrol.setId(resultSet.getInt("id"));
                firstResponder_Patrol.setAssignedFirstResponderId(resultSet.getInt("assignedFirstResponderId"));
                firstResponder_Patrol.setAssignedPatrolId(resultSet.getInt("assignedPatrolId"));
                firstResponder_Patrols.add(firstResponder_Patrol);
            }
        } catch (Exception e) {
            System.out.println("Error while registering first responders and patrol association: " + e.getMessage());
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
        return firstResponder_Patrols;
    };
    public void update(FirstResponder_Patrol firstResponder_Patrol) {
        String sql = "UPDATE FirstResponder_Patrol SET assignedFirstResponderId = ?, assignedPatrolId = ? WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, firstResponder_Patrol.getAssignedFirstResponderId());
            preparedStatement.setInt(2, firstResponder_Patrol.getAssignedPatrolId());
            preparedStatement.setInt(3, firstResponder_Patrol.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while updating first responders and Patrol association: " + e.getMessage());
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
        String sql = "DELETE FROM FirstResponder_Patrol WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while deleting first responders and Patrol association: " + e.getMessage());
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
    public void delete(FirstResponder_Patrol firstResponder_Patrol) {
        String sql = "DELETE FROM FirstResponder_Patrol WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, firstResponder_Patrol.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while deleting first responders and Patrol association: " + e.getMessage());
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