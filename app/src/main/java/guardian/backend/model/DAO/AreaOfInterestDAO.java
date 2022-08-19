package guardian.backend.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import guardian.backend.model.AreaOfInterest;
import guardian.backend.model.ConnectionFactory;

public class AreaOfInterestDAO {
    //private int id;
    //private String designatedArea;
    //private int danger;
    //private String observation;
    public void create(AreaOfInterest areaOfInterest) {
        String sql = "INSERT INTO AreaOfInterest(designatedArea,danger,observation) VALUES (?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, areaOfInterest.getDesignatedArea());
            preparedStatement.setInt(2, areaOfInterest.getId());
            preparedStatement.setString(3, areaOfInterest.getObservation());
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
    };
    public ArrayList<AreaOfInterest> read() {
        String sql = "SELECT * FROM AreaOfInterest";
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
                areaOfInterest.setDesignatedArea(resultSet.getString("designatedArea"));
                areaOfInterest.setDanger(resultSet.getInt("danger"));
                areaOfInterest.setObservation(resultSet.getString("observation"));
                areaOfInterests.add(areaOfInterest);
            }
        } catch (Exception e) {
            System.out.println("Error while registering area of interest: " + e.getMessage());
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
        return areaOfInterests;
    };
    public AreaOfInterest read(int id) {
        String sql = "SELECT * FROM AreaOfInterest WHERE id = ?";
        ArrayList<AreaOfInterest> areaOfInterests = new ArrayList<AreaOfInterest>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                AreaOfInterest areaOfInterest = new AreaOfInterest();
                areaOfInterest.setId(resultSet.getInt("id"));
                areaOfInterest.setDesignatedArea(resultSet.getString("designatedArea"));
                areaOfInterest.setDanger(resultSet.getInt("danger"));
                areaOfInterest.setObservation(resultSet.getString("observation"));
                areaOfInterests.add(areaOfInterest);
            }
        } catch (Exception e) {
            System.out.println("Error while registering area of interest: " + e.getMessage());
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
        return areaOfInterests.get(0);
    }
    public void update(AreaOfInterest areaOfInterest) {
        String sql = "UPDATE AreaOfInterest SET designatedArea = ?, danger = ?, observation = ? WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, areaOfInterest.getDesignatedArea());
            preparedStatement.setInt(2, areaOfInterest.getDanger());
            preparedStatement.setString(3, areaOfInterest.getObservation());
            preparedStatement.setInt(4, areaOfInterest.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erorr while updating area of interest: " + e.getMessage());
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
        String sql = "DELETE FROM AreaOfInterest WHERE id = ?";
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
    public void delete(AreaOfInterest areaOfInterest) {
        String sql = "DELETE FROM AreaOfInterest WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, areaOfInterest.getId());
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
