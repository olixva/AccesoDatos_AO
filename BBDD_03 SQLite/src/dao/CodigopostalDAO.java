package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.Conexion;

public class CodigopostalDAO {
    private static final String SQL_SELECTBY = "SELECT * FROM codigopostal WHERE cp = ?";

    public boolean exist(String cp) {

        boolean existe = false;

        try (Connection conexion = Conexion.getConnection();
                PreparedStatement statement = conexion.prepareStatement(SQL_SELECTBY)) {

            statement.setString(1, cp);

            try (ResultSet resultSet = statement.executeQuery()) {
                existe = resultSet.next(); // Devuelve true si hay al menos un resultado
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return existe;
    }
}
