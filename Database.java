package library_management_system;

import java.sql.*;

import java.util.HashMap;
import javax.swing.JOptionPane;

public class Database {

    private final String URL = "jdbc:mysql://localhost:3306/db_library_management_system";
    private final String USER = "root";
    private final String PASSWORD = "";
    public static HashMap<Integer, String[]> userDb = new HashMap<Integer, String[]>();
    public static HashMap<Integer, String[]> bookDb = new HashMap<Integer, String[]>();

    public static void addAdmin() {
        String[] adminInfos = {"", "", "admin", "pogiako", "admin"};
        int adminId = 1000;

        userDb.put(adminId, adminInfos);
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public int executeUpdate(String sql, Object... params) {
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }

            return pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
            return 0;
        }
    }

    public boolean validateLogin(String sql, Object... params) {
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }

            return pstmt.executeQuery().next();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
            return false;
        }
    }

    public String getUserRole(String url, Object... params) {
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(url)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);

            }
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("role");
            } else {
                return null; // No matching record found
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
            return null;
        }
    }

    public int updateData(String sql, Object... params) {
        int rowsAffected = 0;
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rowsAffected = pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
            return 0;
        }
        return rowsAffected;
    }

    public int deleteData(String sql, int id) {
        int rowAffected = 0;
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            rowAffected = pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
            return 0;

        }
        return rowAffected;
    }
}
