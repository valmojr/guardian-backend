package guardian.backend.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import guardian.backend.model.ConnectionFactory;
import guardian.backend.model.Report_Patrol;

public class Report_PatrolDAO {
    public void create(Report_Patrol Report_Patrol) {
        String sql = "INSERT INTO Report_Patrol(assignedReportId,assignedPatrolId) VALUES (?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Report_Patrol.getAssignedReportId());
            preparedStatement.setInt(2, Report_Patrol.getAssignedPatrolId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while registering reports and patrols association: " + e.getMessage());
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
    public ArrayList<Report_Patrol> read() {
        String sql = "SELECT * FROM Report_Patrol";
        ArrayList<Report_Patrol> Report_Patrols = new ArrayList<Report_Patrol>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Report_Patrol Report_Patrol = new Report_Patrol();
                Report_Patrol.setId(resultSet.getInt("id"));
                Report_Patrol.setAssignedReportId(resultSet.getInt("assignedReportId"));
                Report_Patrol.setAssignedPatrolId(resultSet.getInt("assignedPatrolId"));
                Report_Patrols.add(Report_Patrol);
            }
        } catch(Exception e) {
            System.out.println("Error while retrieving reports and patrols associations: " + e.getMessage());
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
        return Report_Patrols;
    };
    public Report_Patrol read(int id) {
        String sql = "SELECT * FROM Report_Patrol WHERE id = ?";
        ArrayList<Report_Patrol> Report_Patrols = new ArrayList<Report_Patrol>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Report_Patrol Report_Patrol = new Report_Patrol();
                Report_Patrol.setId(resultSet.getInt("id"));
                Report_Patrol.setAssignedReportId(resultSet.getInt("assignedReportId"));
                Report_Patrol.setAssignedPatrolId(resultSet.getInt("assignedPatrolId"));
                Report_Patrols.add(Report_Patrol);
            }
        } catch(Exception e) {
            System.out.println("Error while retrieving reports and patrols associations: " + e.getMessage());
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
        return Report_Patrols.get(0);
    };
    public ArrayList<Report_Patrol> readByReportId(int reportId) {
        String sql = "SELECT * FROM Report_Patrol WHERE assignedReportId = ?";
        ArrayList<Report_Patrol> Report_Patrols = new ArrayList<Report_Patrol>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, reportId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Report_Patrol Report_Patrol = new Report_Patrol();
                Report_Patrol.setId(resultSet.getInt("id"));
                Report_Patrol.setAssignedReportId(resultSet.getInt("assignedReportId"));
                Report_Patrol.setAssignedPatrolId(resultSet.getInt("assignedPatrolId"));
                Report_Patrols.add(Report_Patrol);
            }
        } catch(Exception e) {
            System.out.println("Error while retrieving reports and patrols associations by report id: " + e.getMessage());
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
        return Report_Patrols;
    };
    public ArrayList<Report_Patrol> readByPatrolId(int patrolId) {
        String sql = "SELECT * FROM Report_Patrol WHERE assignedPatrolId = ?";
        ArrayList<Report_Patrol> Report_Patrols = new ArrayList<Report_Patrol>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, patrolId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Report_Patrol Report_Patrol = new Report_Patrol();
                Report_Patrol.setId(resultSet.getInt("id"));
                Report_Patrol.setAssignedReportId(resultSet.getInt("assignedReportId"));
                Report_Patrol.setAssignedPatrolId(resultSet.getInt("assignedPatrolId"));
                Report_Patrols.add(Report_Patrol);
            }
        } catch(Exception e) {
            System.out.println("Error while retrieving reports and patrols associations by patrol id: " + e.getMessage());
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
        return Report_Patrols;
    };
    public void update(Report_Patrol Report_Patrol) {
        String sql = "UPDATE Report_Patrol SET assignedReportId = ?,assignedPatrolId = ? WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Report_Patrol.getAssignedReportId());
            preparedStatement.setInt(2, Report_Patrol.getAssignedPatrolId());
            preparedStatement.setInt(3, Report_Patrol.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erorr while updating reports and patrols association: " + e.getMessage());
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
        String sql = "DELETE FROM Report_Patrol WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while deleting reports and patrols association: " + e.getMessage());
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
    public void delete(Report_Patrol Report_Patrol) {
        String sql = "DELETE FROM Report_Patrol WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Report_Patrol.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while deleting reports and patrols association: " + e.getMessage());
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