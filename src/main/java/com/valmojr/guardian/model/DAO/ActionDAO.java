package com.valmojr.guardian.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.valmojr.guardian.model.Action;
import com.valmojr.guardian.model.ConnectionFactory;

public class ActionDAO {
    public void create(Action action) {
        String sql = "INSERT INTO action(description,state,designatedPosition) VALUES (?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, action.getDescription());
            preparedStatement.setBoolean(2, action.isActive());
            preparedStatement.setString(3, action.getDesignatedPosition());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while registering action: " + e.getMessage());
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
    public ArrayList<Action> read() {
        String sql = "SELECT * FROM action";
        ArrayList<Action> actions = new ArrayList<Action>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Action action = new Action();
                action.setId(resultSet.getInt("id"));
                action.setDescription(resultSet.getString("description"));
                action.setState(resultSet.getBoolean("state"));
                action.setDesignatedPosition(resultSet.getString("designatedPosition"));
                actions.add(action);
            }
        } catch(Exception e) {
            System.out.println("Error while retrieving actions: " + e.getMessage());
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
        return actions;
    };
    public Action read(int id) {
        String sql = "SELECT * FROM action WHERE id = ?";
        ArrayList<Action> actions = new ArrayList<Action>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Action action = new Action();
                action.setId(resultSet.getInt("id"));
                action.setDescription(resultSet.getString("description"));
                action.setState(resultSet.getBoolean("state"));
                action.setDesignatedPosition(resultSet.getString("designatedPosition"));
                actions.add(action);
            }
        } catch(Exception e) {
            System.out.println("Error while retrieving actions: " + e.getMessage());
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
        return actions.get(0);
    };
    public void update(Action action) {
        String sql = "UPDATE action SET description = ?, state = ?, designatedPosition = ? WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, action.getDescription());
            preparedStatement.setBoolean(2, action.isActive());
            preparedStatement.setString(3, action.getDesignatedPosition());
            preparedStatement.setInt(4, action.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erorr while updating action: " + e.getMessage());
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
        String sql = "DELETE FROM action WHERE id = ?";
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
    public void delete(Action action) {
        String sql = "DELETE FROM action WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, action.getId());
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
