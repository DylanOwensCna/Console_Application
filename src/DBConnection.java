import java.sql.*;
public class DBConnection {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        String url = "jdbc:mysql://localhost/mydb";
        String user = "username";
        String password = "password";
        String sql = "INSERT INTO mytable (name, age) VALUES (?, ?)";
        try {
            // Create a connection object
            conn = DriverManager.getConnection(url, user, password);

            // Prepare the SQL statement
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "John");
            pstmt.setInt(2, 25);

            // Execute the SQL statement
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " row(s) inserted.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the PreparedStatement and Connection objects
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
