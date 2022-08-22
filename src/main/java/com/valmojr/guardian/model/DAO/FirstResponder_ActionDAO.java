package com.valmojr.guardian.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.valmojr.guardian.model.ConnectionFactory;
import com.valmojr.guardian.model.FirstResponder_Action;

public class FirstResponder_ActionDAO {
    public void create(FirstResponder_Action firstResponder_Action) {
        String sql = "INSERT INTO firstResponder_action(assignedFirstResponderId,assignedActionId) VALUES (?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,firstResponder_Action.getAssignedFirstResponderId());
            preparedStatement.setInt(2,firstResponder_Action.getAssignedActionId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while registering first responders and actions association: " + e.getMessage());
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
    public ArrayList<FirstResponder_Action> read() {
        String sql = "SELECT * FROM FirstResponder_Action";
        ArrayList<FirstResponder_Action> firstResponder_Actions = new ArrayList<FirstResponder_Action>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                FirstResponder_Action firstResponder_Action = new FirstResponder_Action();
                firstResponder_Action.setId(resultSet.getInt("id"));
                firstResponder_Action.setAssignedFirstResponderId(resultSet.getInt("assignedFirstResponderId"));
                firstResponder_Action.setAssignedActionId(resultSet.getInt("assignedActionId"));
                firstResponder_Actions.add(firstResponder_Action);
            }
        } catch (Exception e) {
            System.out.println("Error while registering first responders and action association: " + e.getMessage());
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
        return firstResponder_Actions;
    };
    public FirstResponder_Action read(int id) {
        String sql = "SELECT * FROM FirstResponder_Action WHERE id = ?";
        ArrayList<FirstResponder_Action> firstResponder_Actions = new ArrayList<FirstResponder_Action>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                FirstResponder_Action firstResponder_Action = new FirstResponder_Action();
                firstResponder_Action.setId(resultSet.getInt("id"));
                firstResponder_Action.setAssignedFirstResponderId(resultSet.getInt("assignedFirstResponderId"));
                firstResponder_Action.setAssignedActionId(resultSet.getInt("assignedActionId"));
                firstResponder_Actions.add(firstResponder_Action);
            }
        } catch (Exception e) {
            System.out.println("Error while registering first responders and action association: " + e.getMessage());
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
        return firstResponder_Actions.get(0);
    }
    public void update(FirstResponder_Action firstResponder_Action) {
        String sql = "UPDATE FirstResponder_Action SET assignedFirstResponderId = ?, assignedActionId = ? WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, firstResponder_Action.getAssignedFirstResponderId());
            preparedStatement.setInt(2, firstResponder_Action.getAssignedActionId());
            preparedStatement.setInt(3, firstResponder_Action.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while updating first responders and action association: " + e.getMessage());
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
        String sql = "DELETE FROM FirstResponder_Action WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while deleting first responders and action association: " + e.getMessage());
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
    public void delete(FirstResponder_Action firstResponder_Action) {
        String sql = "DELETE FROM FirstResponder_Action WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, firstResponder_Action.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while deleting first responders and action association: " + e.getMessage());
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