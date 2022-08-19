package guardian.backend.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import guardian.backend.model.ConnectionFactory;
import guardian.backend.model.Patrol;

public class PatrolDAO {
    public void create(Patrol patrol) {
        String sql = "INSERT INTO patrol(specificArea,state,observation) VALUES (?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, patrol.getSpecificArea());
            preparedStatement.setInt(2, patrol.getState());
            preparedStatement.setString(3, patrol.getObservation());
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
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
    public ArrayList<Patrol> read() {
        String sql = "SELECT * FROM Patrol";
        ArrayList<Patrol> patrols = new ArrayList<Patrol>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Patrol patrol = new Patrol();
                patrol.setId(resultSet.getInt("id"));
                patrol.setSpecificArea(resultSet.getString("specificArea"));
                patrol.setState(resultSet.getInt("state"));
                patrol.setObservation(resultSet.getString("observation"));
                patrols.add(patrol);
            }
        } catch(Exception e) {
            System.out.println("Error while retrieving patrols: " + e.getMessage());
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
        return patrols;
    };
    public Patrol read(int id) {
        String sql = "SELECT * FROM Patrol WHERE id = ?";
        ArrayList<Patrol> patrols = new ArrayList<Patrol>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Patrol patrol = new Patrol();
                patrol.setId(resultSet.getInt("id"));
                patrol.setSpecificArea(resultSet.getString("specificArea"));
                patrol.setObservation(resultSet.getString("observation"));
                patrols.add(patrol);
            }
        } catch(Exception e) {
            System.out.println("Error while retrieving patrol: " + e.getMessage());
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
        return patrols.get(0);
    };
    public void update(Patrol patrol) {
        String sql = "UPDATE Patrol SET specificArea = ?,state = ?,observation = ? WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, patrol.getSpecificArea());
            preparedStatement.setInt(2, patrol.getState());
            preparedStatement.setString(3, patrol.getObservation());
            preparedStatement.setInt(4, patrol.getId());
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
        String sql = "DELETE FROM Patrol WHERE id = ?";
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
    public void delete(Patrol patrol) {
        String sql = "DELETE FROM Patrol WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, patrol.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while deleting patrols: " + e.getMessage());
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
