package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;

public class GamaDAO {
    // Sentencia SELECT
    private static final String SQL_SELECT = "SELECT gama FROM gama_producto";

    // Metodo para buscar y devolver las gamas
    public List<String> seleccionarGamas() {
        List<String> gamas = new ArrayList<>();

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_SELECT);
                ResultSet rS = pS.executeQuery()) {

            while (rS.next()) {

                String gama = rS.getString("gama");

                gamas.add(gama);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gamas;
    }
}
