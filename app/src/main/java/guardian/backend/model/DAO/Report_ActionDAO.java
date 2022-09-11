package guardian.backend.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import guardian.backend.model.ConnectionFactory;
import guardian.backend.model.Report_Action;

public class Report_ActionDAO {
    public void create(Report_Action report_Action) {
        String sql = "INSERT INTO Report_Action(assignedReportId,assignedActionId) VALUES (?,?)";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, report_Action.getAssignedReportId());
            preparedStatement.setInt(2, report_Action.getAssignedActionId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while registering reports and actions of interest association: " + e.getMessage());
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
    public ArrayList<Report_Action> read() {
        String sql = "SELECT * FROM Report_Action";
        ArrayList<Report_Action> report_Actions = new ArrayList<Report_Action>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Report_Action report_Action = new Report_Action();
                report_Action.setId(resultSet.getInt("id"));
                report_Action.setAssignedReportId(resultSet.getInt("assignedReportId"));
                report_Action.setAssignedActionId(resultSet.getInt("assignedActionId"));
                report_Actions.add(report_Action);
            }
        } catch(Exception e) {
            System.out.println("Error while retrieving reports and actions of interest associations: " + e.getMessage());
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
        return report_Actions;
    };
    public Report_Action read(int id) {
        String sql = "SELECT * FROM Report_Action WHERE id = ?";
        ArrayList<Report_Action> report_Actions = new ArrayList<Report_Action>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Report_Action report_Action = new Report_Action();
                report_Action.setId(resultSet.getInt("id"));
                report_Action.setAssignedActionId(resultSet.getInt("assignedActionId"));
                report_Action.setAssignedReportId(resultSet.getInt("assignedReportId"));
                report_Actions.add(report_Action);
            }
        } catch(Exception e) {
            System.out.println("Error while retrieving reports and actions of interest associations: " + e.getMessage());
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
        return report_Actions.get(0);
    };
    public ArrayList<Report_Action> readByReportId(int reportId) {
        String sql = "SELECT * FROM Report_Action WHERE assignedReportId = ?";
        ArrayList<Report_Action> report_Actions = new ArrayList<Report_Action>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, reportId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Report_Action report_Action = new Report_Action();
                report_Action.setId(resultSet.getInt("id"));
                report_Action.setAssignedActionId(resultSet.getInt("assignedActionId"));
                report_Action.setAssignedReportId(resultSet.getInt("assignedReportId"));
                report_Actions.add(report_Action);
            }
        } catch(Exception e) {
            System.out.println("Error while retrieving reports and actions of interest associations by Report id: " + e.getMessage());
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
        return report_Actions;
    };
    public ArrayList<Report_Action> readByActionId(int actionId) {
        String sql = "SELECT * FROM Report_Action WHERE assignedActionId = ?";
        ArrayList<Report_Action> report_Actions = new ArrayList<Report_Action>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, actionId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Report_Action report_Action = new Report_Action();
                report_Action.setId(resultSet.getInt("id"));
                report_Action.setAssignedActionId(resultSet.getInt("assignedActionId"));
                report_Action.setAssignedReportId(resultSet.getInt("assignedReportId"));
                report_Actions.add(report_Action);
            }
        } catch(Exception e) {
            System.out.println("Error while retrieving reports and actions of interest associations by Action Id: " + e.getMessage());
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
        return report_Actions;
    };
    public void update(Report_Action report_Action) {
        String sql = "UPDATE Report_Action SET assignedReportId = ?,assignedActionId = ? WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, report_Action.getAssignedReportId());
            preparedStatement.setInt(2, report_Action.getAssignedActionId());
            preparedStatement.setInt(3, report_Action.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Erorr while updating reports and actions of interest association: " + e.getMessage());
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
        String sql = "DELETE FROM Report_Action WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while deleting reports and actions of interest association: " + e.getMessage());
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
    public void delete(Report_Action report_Action) {
        String sql = "DELETE FROM Report_Action WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionFactory.createConnectionToMySQLDatabase();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, report_Action.getId());
            preparedStatement.execute();
        } catch (Exception e) {
            System.out.println("Error while deleting reports and actions of interest association: " + e.getMessage());
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