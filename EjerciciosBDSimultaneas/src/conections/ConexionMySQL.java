package conections;

import java.sql.*;

public class ConexionMySQL implements Conexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/empleados";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
}
