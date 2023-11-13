package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import dto.CursoDTO;
import util.Conexion;

public class CursoDAO {

    private static final String SQL_INSERT = "INSERT INTO curso(cod_curso, nombre, descripcion) VALUES(?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM curso WHERE cod_curso = ?";
    private static final String SQL_UPDATE = "UPDATE curso SET nombre = ?, descripcion = ? WHERE cod_curso = ?";
    private static final String SQL_SELECT = "SELECT cod_curso, nombre, descripcion FROM curso";
    private static final String SQL_SELECTBY = "SELECT * FROM curso WHERE cod_curso = ?";

    public int insertar(CursoDTO curso) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
             PreparedStatement pS = cn.prepareStatement(SQL_INSERT)) {

            pS.setString(1, curso.getCod_curso());
            pS.setString(2, curso.getNombre());
            pS.setString(3, curso.getDescripcion());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int borrar(CursoDTO curso) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
             PreparedStatement pS = cn.prepareStatement(SQL_DELETE)) {

            pS.setString(1, curso.getCod_curso());

            registros = pS.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println(
                    "\nNo ha sido posible borrar el curso debido a que se usa en otra tabla, elimine el registro de la otra tabla y vuelva a intentarlo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int actualizar(CursoDTO curso) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
             PreparedStatement pS = cn.prepareStatement(SQL_UPDATE)) {

            pS.setString(1, curso.getNombre());
            pS.setString(2, curso.getDescripcion());
            pS.setString(3, curso.getCod_curso());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public List<CursoDTO> seleccionar() {

        List<CursoDTO> cursos = new ArrayList<>();

        try (Connection cn = Conexion.getConnection();
             PreparedStatement pS = cn.prepareStatement(SQL_SELECT);
             ResultSet rS = pS.executeQuery()) {

            while (rS.next()) {
                String cod_curso = rS.getString("cod_curso");
                String nombre = rS.getString("nombre");
                String descripcion = rS.getString("descripcion");

                cursos.add(new CursoDTO(cod_curso, nombre, descripcion));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cursos;
    }

    public boolean exist(String codigo) {

        boolean existe = false;

        try (Connection conexion = Conexion.getConnection();
                PreparedStatement statement = conexion.prepareStatement(SQL_SELECTBY)) {

            statement.setString(1, codigo);

            try (ResultSet resultSet = statement.executeQuery()) {
                existe = resultSet.next(); // Devuelve true si hay al menos un resultado
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return existe;
    }
}

