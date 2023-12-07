package util;
import java.sql.*;

public class Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/instituto";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public static void close(ResultSet rS) throws SQLException {
        rS.close();
    }

    public static void close(Statement stmt) throws SQLException {
        stmt.close();
    }

    public static void close(Connection cn) throws SQLException {
        cn.close();
    }
}
