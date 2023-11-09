package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.EdificioDTO;
import util.Conexion;

public class EdificioDAO {

    private static final String SQL_INSERT = "INSERT INTO edificio(cod_edificio, nombre) VALUES(?, ?)";
    private static final String SQL_DELETE = "DELETE FROM edificio WHERE cod_edificio = ?";
    private static final String SQL_UPDATE = "UPDATE edificio SET nombre = ? WHERE cod_edificio = ?";
    private static final String SQL_SELECT = "SELECT cod_edificio, nombre FROM edificio";

    public int insertar(EdificioDTO edificio) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
             PreparedStatement pS = cn.prepareStatement(SQL_INSERT)) {

            pS.setString(1, edificio.getCod_edificio());
            pS.setString(2, edificio.getNombre());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int borrar(EdificioDTO edificio) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
             PreparedStatement pS = cn.prepareStatement(SQL_DELETE)) {

            pS.setString(1, edificio.getCod_edificio());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int actualizar(EdificioDTO edificio) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
             PreparedStatement pS = cn.prepareStatement(SQL_UPDATE)) {

            pS.setString(1, edificio.getNombre());
            pS.setString(2, edificio.getCod_edificio());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public List<EdificioDTO> seleccionar() {

        List<EdificioDTO> edificios = new ArrayList<>();

        try (Connection cn = Conexion.getConnection();
             PreparedStatement pS = cn.prepareStatement(SQL_SELECT);
             ResultSet rS = pS.executeQuery()) {

            while (rS.next()) {
                String cod_edificio = rS.getString("cod_edificio");
                String nombre = rS.getString("nombre");

                edificios.add(new EdificioDTO(cod_edificio, nombre));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return edificios;
    }
}
