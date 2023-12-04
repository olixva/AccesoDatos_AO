package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.OficinaDTO;
import util.Conexion;

public class OficinaDAO {

    // Sentencia MODIFICAR telefono
    private static final String SQL_UPDATE = "UPDATE oficina SET telefono = ? WHERE codigo_oficina = ?";
    // Sentencia EXIST de la oficina
    private static final String SQL_EXIST = "SELECT codigo_oficina FROM oficina WHERE codigo_oficina = ?";

    // Metodo para modificar el telefono de una oficina
    public int actualizarTelefono(OficinaDTO oficina) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_UPDATE)) {

            pS.setString(1, oficina.getTelefono());
            pS.setString(2, oficina.getCodigoOficina());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    // Metodo para comprobar si existe una oficina
    public boolean existeOficina(String codigoOficina) {
        boolean existe = false;

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_EXIST)) {

            pS.setString(1, codigoOficina);

            existe = pS.executeQuery().next();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return existe;
    }

}
