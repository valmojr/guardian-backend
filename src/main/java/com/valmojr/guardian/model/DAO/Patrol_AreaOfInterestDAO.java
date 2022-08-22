package com.valmojr.guardian.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.valmojr.guardian.model.ConnectionFactory;
import com.valmojr.guardian.model.Patrol_AreaOfInterest;

public class Patrol_AreaOfInterestDAO {
    public void create(Patrol_AreaOfInterest patrol_AreaOfInterest) {
        String sql = "INSERT INTO Patrol_AreaOfInterest(assignedPatrolId,assignedAreaOfInterestId) VALUES (?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, patrol_AreaOfInterest.getAssignedPatrolId());
            preparedStatement.setInt(2, patrol_AreaOfInterest.getAssignedAreaOfInterestId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while registering patrols and areas of interest association: " + e.getMessage());
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
    public ArrayList<Patrol_AreaOfInterest> read() {
        String sql = "SELECT * FROM Patrol_AreaOfInterest";
        ArrayList<Patrol_AreaOfInterest> patrol_AreaOfInterests = new ArrayList<Patrol_AreaOfInterest>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Patrol_AreaOfInterest patrol_AreaOfInterest = new Patrol_AreaOfInterest();
                patrol_AreaOfInterest.setId(resultSet.getInt("id"));
                patrol_AreaOfInterest.setAssignedPatrolId(resultSet.getInt("assignedPatrolId"));
                patrol_AreaOfInterest.setAssignedAreaOfInterestId(resultSet.getInt("assignedAreaOfInterestId"));
                patrol_AreaOfInterests.add(patrol_AreaOfInterest);
            }
        } catch(Exception e) {
            System.out.println("Error while retrieving patrols and areas of interest associations: " + e.getMessage());
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
        return patrol_AreaOfInterests;
    };
    public Patrol_AreaOfInterest read(int id) {
        String sql = "SELECT * FROM Patrol_AreaOfInterest WHERE id = ?";
        ArrayList<Patrol_AreaOfInterest> patrol_AreaOfInterests = new ArrayList<Patrol_AreaOfInterest>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Patrol_AreaOfInterest patrol_AreaOfInterest = new Patrol_AreaOfInterest();
                patrol_AreaOfInterest.setId(resultSet.getInt("id"));
                patrol_AreaOfInterest.setAssignedPatrolId(resultSet.getInt("assignedPatrolId"));
                patrol_AreaOfInterest.setAssignedAreaOfInterestId(resultSet.getInt("assignedAreaOfInterestId"));
                patrol_AreaOfInterests.add(patrol_AreaOfInterest);
            }
        } catch(Exception e) {
            System.out.println("Error while retrieving patrols and areas of interest associations: " + e.getMessage());
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
        return patrol_AreaOfInterests.get(0);
    };
    public void update(Patrol_AreaOfInterest patrol_AreaOfInterest) {
        String sql = "UPDATE Patrol_AreaOfInterest SET assignedPatrolId = ?,assignedAreaOfInterestId = ? WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, patrol_AreaOfInterest.getAssignedPatrolId());
            preparedStatement.setInt(2, patrol_AreaOfInterest.getAssignedAreaOfInterestId());
            preparedStatement.setInt(3, patrol_AreaOfInterest.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erorr while updating patrols and areas of interest association: " + e.getMessage());
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
        String sql = "DELETE FROM Patrol_AreaOfInterest WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while deleting patrols and areas of interest association: " + e.getMessage());
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
    public void delete(Patrol_AreaOfInterest patrol_AreaOfInterest) {
        String sql = "DELETE FROM Patrol_AreaOfInterest WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, patrol_AreaOfInterest.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while deleting patrols and areas of interest association: " + e.getMessage());
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