package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import dto.AlumnoDTO;
import dto.AsignaturaDTO;
import dto.ProfesorDTO;
import util.Conexion;

public class AsignaturaDAO {

    private static final String SQL_INSERT = "INSERT INTO asignatura(cod_asignatura, cod_interno, descripcion, nHoras, cod_curso) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM asignatura WHERE cod_asignatura = ?";
    private static final String SQL_UPDATE = "UPDATE asignatura SET cod_interno = ?, descripcion = ?, nHoras = ?, cod_curso = ? WHERE cod_asignatura = ?";
    private static final String SQL_SELECT = "SELECT cod_asignatura, cod_interno, descripcion, nHoras, cod_curso FROM asignatura";
    private static final String SQL_SELECTBY = "SELECT * FROM asignatura WHERE cod_asignatura = ?";
    private static final String SQL_SELECTBY_DPTO = "SELECT DISTINCT cod_asignatura, cod_interno, descripcion, nHoras, cod_curso FROM asignatura INNER JOIN imparte ON cod_asignatura = cod_asig inner join profesor on nrp_profesor = nrp WHERE cod_departamento = ?";
    private static final String SQL_SELECTBY_NREYANIO = "SELECT distinct asignatura.descripcion from asignatura inner join matricula on cod_asig = cod_asignatura INNER JOIN alumno ON alumno.nre = matricula.nre WHERE anyo = ? AND alumno.nre = ?";
    private static final String SQL_SELECTBY_DEPTO_NRP = "SELECT descripcion FROM profesor INNER JOIN imparte ON nrp = nrp_profesor INNER JOIN asignatura ON cod_asignatura = cod_asig WHERE anyo = ? AND nrp = ? AND cod_departamento = ?";

    public int insertar(AsignaturaDTO asignatura) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_INSERT)) {

            pS.setString(1, asignatura.getCod_asignatura());
            pS.setString(2, asignatura.getCod_interno());
            pS.setString(3, asignatura.getDescripcion());
            pS.setInt(4, asignatura.getnHoras());
            pS.setString(5, asignatura.getCod_curso());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int borrar(AsignaturaDTO asignatura) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_DELETE)) {

            pS.setString(1, asignatura.getCod_asignatura());

            registros = pS.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println(
                    "\nNo ha sido posible borrar la asignatura debido a que se usa en otra tabla, elimine el registro de la otra tabla y vuelva a intentarlo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int actualizar(AsignaturaDTO asignatura) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_UPDATE)) {

            pS.setString(1, asignatura.getCod_interno());
            pS.setString(2, asignatura.getDescripcion());
            pS.setInt(3, asignatura.getnHoras());
            pS.setString(4, asignatura.getCod_curso());
            pS.setString(5, asignatura.getCod_asignatura());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public List<AsignaturaDTO> seleccionar() {

        List<AsignaturaDTO> asignaturas = new ArrayList<>();

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_SELECT);
                ResultSet rS = pS.executeQuery()) {

            while (rS.next()) {
                String cod_asignatura = rS.getString("cod_asignatura");
                String cod_interno = rS.getString("cod_interno");
                String descripcion = rS.getString("descripcion");
                int nHoras = rS.getInt("nHoras");
                String cod_curso = rS.getString("cod_curso");

                asignaturas.add(new AsignaturaDTO(cod_asignatura, cod_interno, descripcion, nHoras, cod_curso));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return asignaturas;
    }

    public List<AsignaturaDTO> seleccionarPorDepartamento(String codigoDpto) {

        List<AsignaturaDTO> asignaturas = new ArrayList<>();

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_SELECTBY_DPTO)) {

            pS.setString(1, codigoDpto);
            ResultSet rS = pS.executeQuery();

            while (rS.next()) {

                String cod_asignatura = rS.getString("cod_asignatura");
                String cod_interno = rS.getString("cod_interno");
                String descripcion = rS.getString("descripcion");
                int nHoras = rS.getInt("nHoras");
                String cod_curso = rS.getString("cod_curso");

                asignaturas.add(new AsignaturaDTO(cod_asignatura, cod_interno, descripcion, nHoras, cod_curso));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return asignaturas;
    }

    public boolean exist(String cod_asignatura) {
        boolean existe = false;

        try (Connection conexion = Conexion.getConnection();
                PreparedStatement statement = conexion.prepareStatement(SQL_SELECTBY)) {

            statement.setString(1, cod_asignatura);

            try (ResultSet resultSet = statement.executeQuery()) {
                existe = resultSet.next(); // Devuelve true si hay al menos un resultado
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return existe;
    }

    public List<String> selectAsignaturas(AlumnoDTO alumno, String anyo) {

        List<String> asignaturas = new ArrayList<>();

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_SELECTBY_NREYANIO)) {

            pS.setString(1, anyo);
            pS.setString(2, alumno.getNre());
            ResultSet rS = pS.executeQuery();

            while (rS.next()) {

                asignaturas.add(rS.getString("descripcion"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return asignaturas;
    }

    public List<String> selectAsignaturas(ProfesorDTO alumno, String anyo, String cod_departamento) {

        List<String> asignaturas = new ArrayList<>();

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_SELECTBY_DEPTO_NRP)) {

            pS.setString(1, anyo);
            pS.setString(2, alumno.getNrp());
            pS.setString(3, cod_departamento);
            ResultSet rS = pS.executeQuery();

            while (rS.next()) {

                asignaturas.add(rS.getString("descripcion"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return asignaturas;
    }
}
