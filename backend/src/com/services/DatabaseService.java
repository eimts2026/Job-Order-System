package com.services;
import java.sql.*;

import com.classes.Admin;
import com.classes.JobOrder;
import com.tokens.Token;

public class DatabaseService {
    private final static String url = "jdbc:mysql://mysql-bbe58e-emeraldisle-3e00.b.aivencloud.com:11707/my_first_db?sslmode=verify-ca&enabledTLSProtocols=TLSv1.2,TLSv1.3";
    private final static String user = "avnadmin";
    private final static String password = "AVNS_hc8P7RDvEk5hxt0bk32";

    public static int checkAdminDatabase() {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {

            }

            String checkSQL = "SELECT * FROM admins;";
            try (PreparedStatement pstmt = conn.prepareStatement(checkSQL)) {

                ResultSet rs = pstmt.executeQuery();
                if (!rs.isBeforeFirst()) {
                    System.out.println("\nThere is no data in database!");
                }

            } catch (SQLException e) {
                return 0;
            }

        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
        }
        return 1;
    }

    public static void loadAdminDatabase() {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {

            }

            String checkSQL = "SELECT id, first_name, last_name, email FROM admins;";
            try (PreparedStatement pstmt = conn.prepareStatement(checkSQL)) {

                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    String empID = rs.getString("id");
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    String email = rs.getString("email");

                    Admin newAdmin = new Admin(firstName, lastName, email, empID);
                    AdminService.allAdmins.put(newAdmin.getEmpID(), newAdmin);
                }
            }

        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
        }
    }

    public static void loadJobOrderDatabase() {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {

            }

            String checkSQL = "SELECT jobOrderID, jobOrderName, jobOrderDes FROM job_orders;";
            try (PreparedStatement pstmt = conn.prepareStatement(checkSQL)) {

                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    String jobOrderID = rs.getString("jobOrderID");
                    String jobOrderName = rs.getString("jobOrderName");
                    String jobOrderDes = rs.getString("jobOrderDes");

                    JobOrder newJobOrder = new JobOrder(jobOrderName, jobOrderDes, jobOrderID);
                    JobOrderService.allJobOrders.put(newJobOrder.getJobOrderID(), newJobOrder);
                }
            }

        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
        }
    }

    public static int checkJobOrderDatabase() {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {

            }

            String checkSQL = "SELECT * FROM job_orders;";
            try (PreparedStatement pstmt = conn.prepareStatement(checkSQL)) {

                ResultSet rs = pstmt.executeQuery();
                if (!rs.isBeforeFirst()) {
                    System.out.println("\nThere is no data in database!");
                }

            } catch (SQLException e) {
                return 0;
            }

        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
        }
        return 1;
    }

    public static void insertAdmin(Admin newAdmin) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {

            }

            String insertSQL = "INSERT INTO admins (id, first_name, last_name, email) VALUES (?, ?, ?, ?) ";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                pstmt.setString(1, newAdmin.getEmpID());
                pstmt.setString(2, newAdmin.getFirstName());
                pstmt.setString(3, newAdmin.getLastName());
                pstmt.setString(4, newAdmin.getEmail());

                pstmt.executeUpdate();
            }


        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
        }
    }

    public static void updateAdmin(Admin newAdmin, String oldID) {
        if (checkAdminDatabase() == 1) {
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                if (conn != null) {

                }

                String updateSQL = "UPDATE admins SET id = ?, first_name = ?, last_name = ?, email = ? WHERE id = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
                    pstmt.setString(1, newAdmin.getEmpID());
                    pstmt.setString(2, newAdmin.getFirstName());
                    pstmt.setString(3, newAdmin.getLastName());
                    pstmt.setString(4, newAdmin.getEmail());
                    pstmt.setString(5, oldID);

                    pstmt.executeUpdate();
                }

            } catch (SQLException e) {
                System.out.println("Failed to connect to database");
                e.printStackTrace();
            }
        }

    }

    public static void deleteAdmin(Admin admin) {
        if (checkAdminDatabase() == 1) {
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                if (conn != null) {

                }

                String deleteSQL = "DELETE FROM admins WHERE id = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
                    pstmt.setString(1, admin.getEmpID());

                    pstmt.executeUpdate();
                }

            } catch (SQLException e) {
                System.out.println("Failed to connect to database");
                e.printStackTrace();
            }
        }
    }

    public static void insertJobOrder(JobOrder jobOrder) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {

            }

            String insertSQL = "INSERT INTO job_orders (jobOrderName, JobOrderDes, JobOrderID, jobOrderAssigneeID, jobOrderStartTime) VALUES (?, ?, ?, ?, ?) ";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                pstmt.setString(1, jobOrder.getJobName());
                pstmt.setString(2, jobOrder.getJobDescription());
                pstmt.setString(3,Token.getToken());
                pstmt.setString(4, Admin.getEmpID()); // Can't execute this has to be unique and cannot be empty
                pstmt.setString(5, jobOrder.getStartTime());

                pstmt.executeUpdate();
            }


        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
        }
    }

    public static void updateJobOrder(JobOrder newJobOrder, String jobOrderID) {
        if (checkAdminDatabase() == 1) {
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                if (conn != null) {

                }

                String updateSQL = "UPDATE job_orders SET jobOrderID = ?, jobOrderName = ?, jobOrderDes = ? WHERE jobOrderID = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
                    pstmt.setString(1, newJobOrder.getJobOrderID());
                    pstmt.setString(2, newJobOrder.getJobName());
                    pstmt.setString(3, newJobOrder.getJobDescription());
                    pstmt.setString(4, jobOrderID);

                    pstmt.executeUpdate();
                }

            } catch (SQLException e) {
                System.out.println("Failed to connect to database");
                e.printStackTrace();
            }
        }
    }

}

