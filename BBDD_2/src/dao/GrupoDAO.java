package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.GrupoDTO;
import util.Conexion;

public class GrupoDAO {

    private static final String SQL_INSERT = "INSERT INTO grupo(cod_grupo, cod_curso, nombre, cod_turno, nMaxAlumnos) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM grupo WHERE cod_grupo = ?";
    private static final String SQL_UPDATE = "UPDATE grupo SET cod_curso = ?, nombre = ?, cod_turno = ?, nMaxAlumnos = ? WHERE cod_grupo = ?";
    private static final String SQL_SELECT = "SELECT cod_grupo, cod_curso, nombre, cod_turno, nMaxAlumnos FROM grupo";

    public int insertar(GrupoDTO grupo) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_INSERT)) {

            pS.setString(1, grupo.getCod_grupo());
            pS.setString(2, grupo.getCod_curso());
            pS.setString(3, grupo.getNombre());
            pS.setString(4, grupo.getCod_turno());
            pS.setInt(5, grupo.getnMaxAlumnos());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int borrar(GrupoDTO grupo) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_DELETE)) {

            pS.setString(1, grupo.getCod_grupo());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int actualizar(GrupoDTO grupo) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_UPDATE)) {

            pS.setString(1, grupo.getCod_curso());
            pS.setString(2, grupo.getNombre());
            pS.setString(3, grupo.getCod_turno());
            pS.setInt(4, grupo.getnMaxAlumnos());
            pS.setString(5, grupo.getCod_grupo());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public List<GrupoDTO> seleccionar() {

        List<GrupoDTO> grupos = new ArrayList<>();

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_SELECT);
                ResultSet rS = pS.executeQuery()) {

            while (rS.next()) {
                String cod_grupo = rS.getString("cod_grupo");
                String cod_curso = rS.getString("cod_curso");
                String nombre = rS.getString("nombre");
                String cod_turno = rS.getString("cod_turno");
                int nMaxAlumnos = rS.getInt("nMaxAlumnos");

                grupos.add(new GrupoDTO(cod_grupo, cod_curso, nombre, cod_turno, nMaxAlumnos));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return grupos;
    }
}
