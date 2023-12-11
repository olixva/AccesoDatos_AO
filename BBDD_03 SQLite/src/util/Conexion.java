package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static final String JDBC_URL = "jdbc:sqlite:SQLite\\db.db";

    public static Connection getConnection() {
        try {
            // Establecer una conexión a la base de datos SQLite
            return DriverManager.getConnection(JDBC_URL);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}