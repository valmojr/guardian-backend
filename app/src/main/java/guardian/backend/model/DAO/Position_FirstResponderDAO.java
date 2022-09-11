package guardian.backend.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import guardian.backend.model.ConnectionFactory;
import guardian.backend.model.Position_FirstResponder;

public class Position_FirstResponderDAO {
    public void create(Position_FirstResponder position_FirstResponder) {
        String sql = "INSERT INTO position_FirstResponder(assignedFirstResponderId, reportedPosition,reportedTime) VALUES (?,?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, position_FirstResponder.getAssignedFirstResponderId());
            preparedStatement.setString(2, position_FirstResponder.getReportedPosition());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(position_FirstResponder.getReportedTime()));
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while registering first responder: " + e.getMessage());
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
    public ArrayList<Position_FirstResponder> read() {
        ArrayList<Position_FirstResponder> position_FirstResponders = new ArrayList<Position_FirstResponder>();
        String sql = "SELECT * FROM position_FirstResponder";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Position_FirstResponder position_FirstResponder = new Position_FirstResponder();
                position_FirstResponder.setId(resultSet.getInt("id"));
                position_FirstResponder.setAssignedFirstResponderId(resultSet.getInt("assignedFirstResponderId"));
                position_FirstResponder.setReportedPosition(resultSet.getString("reportedPosition"));
                position_FirstResponder.setReportedTime(resultSet.getTimestamp("reportedTime").toLocalDateTime());
                position_FirstResponders.add(position_FirstResponder);
            }
        } catch (Exception e) {
            System.out.println("Error while getting position and first responder relations: " + e.getMessage());
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
        return position_FirstResponders;
    };
    public Position_FirstResponder read(int id) {
        ArrayList<Position_FirstResponder> position_FirstResponders = new ArrayList<Position_FirstResponder>();
        String sql = "SELECT * FROM position_FirstResponders WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Position_FirstResponder position_FirstResponder = new Position_FirstResponder();
                position_FirstResponder.setId(resultSet.getInt("id"));
                position_FirstResponder.setAssignedFirstResponderId(resultSet.getInt("assignedFirstResponderId"));
                position_FirstResponder.setReportedPosition(resultSet.getString("reportedPosition"));
                position_FirstResponder.setReportedTime(resultSet.getTimestamp("reportedPosition").toLocalDateTime());
                position_FirstResponders.add(position_FirstResponder);
            }
        } catch (Exception e) {
            System.out.println("Error while getting position and first responder relation by id: " + e.getMessage());
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
        return position_FirstResponders.get(0);
    };
    public void update(Position_FirstResponder position_FirstResponder) {
        String sql = "UPDATE position_FirstResponder SET assignedFirstResponderId = ?, reportedPosition = ?, reportedTime = ? WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, position_FirstResponder.getAssignedFirstResponderId());
            preparedStatement.setString(2, position_FirstResponder.getReportedPosition());
            preparedStatement.setTimestamp(3, Timestamp.valueOf(position_FirstResponder.getReportedTime()));
            preparedStatement.setInt(4, position_FirstResponder.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while updating first responder: " + e.getMessage());
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
        String sql = "DELETE FROM position_FirstResponder WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while deleting first responder: " + e.getMessage());
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
    public void delete(Position_FirstResponder position_FirstResponder) {
        String sql = "DELETE FROM position_FirstResponder WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, position_FirstResponder.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while deleting position and first responder relation: " + e.getMessage());
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
