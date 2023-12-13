package conections;

import java.sql.Connection;
import java.sql.SQLException;

public interface Conexion {

    public Connection getConnection() throws SQLException;
}
