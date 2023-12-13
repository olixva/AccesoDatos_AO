package conections;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSQLite implements Conexion {

    private static final String JDBC_URL = "jdbc:sqlite:empleados.db";

    public Connection getConnection() {
        try {
            // Establecer una conexión a la base de datos SQLite
            return DriverManager.getConnection(JDBC_URL);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}