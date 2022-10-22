package util;

import java.sql.*;

public class JdbcUtil {

    private static final String Driver="com.mysql.cj.jdbc.Driver";
    private static final String username="root";
    private static final String password="201314";
    private static final String url="jdbc:mysql://localhost:3306/demo";

    static {
        try {
            Class. forName(Driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConn() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    public static void close (ResultSet rs,Statement stmt,Connection conn) throws SQLException {
        if (rs!=null)rs.close();
        if (stmt!=null)stmt.close();
        if (conn!=null)conn.close();
    }

}
