package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AlumnoDTO;
import util.Conexion;

public class AlumnoDAO {
    // Sentencia INSERT
    private static final String SQL_INSERT = "INSERT INTO ALUMNO(nre, dni, nombre, apellido1, apellido2, tipo_via, numero, escalera, piso, puerta, cp, pais, tlfn_fijo, tlfn_movil, email, fecha_nac, tutor) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    // Sentencia DELETE
    private static final String SQL_DELETE = "DELETE FROM alumno WHERE nre = ?";
    // Sentencia UPDATE
    private static final String SQL_UPDATE = "UPDATE alumno SET dni = ?, nombre = ?, apellido1 = ?, apellido2 = ?, tipo_via = ? numero = ?, escalera = ?, piso = ?, puerta = ?, cp =?, pais = ?, tlfn_fijo = ?, tlfn_movil = ?, email = ?, fecha_nac = ?, tutor = ? WHERE nre = ?";
    // Sentencia SELECT
    private static final String SQL_SELECT = "SELECT nre, dni, nombre, apellido1, apellido2, tipo_via, nombre_via, numero, escalera, piso, puerta, cp, pais, tlfn_fijo, tlfn_movil, email, fecha_nac, tutor FROM alumno";

    public int insertar(AlumnoDTO alumno) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_INSERT)) {

            pS.setString(1, alumno.getNre());
            pS.setString(2, alumno.getDni());
            pS.setString(3, alumno.getNombre());
            pS.setString(4, alumno.getApellido1());
            pS.setString(5, alumno.getApellido2());
            pS.setString(6, alumno.getTipo_via());
            pS.setString(7, alumno.getNombre_via());
            pS.setString(8, alumno.getNumero());
            pS.setString(9, alumno.getEscalera());
            pS.setString(10, alumno.getPiso());
            pS.setString(11, alumno.getPuerta());
            pS.setString(12, alumno.getCp());
            pS.setString(13, alumno.getPais());
            pS.setString(14, alumno.getTlfn_fijo());
            pS.setString(15, alumno.getTlfn_movil());
            pS.setString(16, alumno.getEmail());
            pS.setDate(17, alumno.getFecha_nac());
            pS.setString(18, alumno.getTutor());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int borrar(AlumnoDTO alumno) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_DELETE)) {

            pS.setString(1, alumno.getNre());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int actualizar(AlumnoDTO alumno) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_UPDATE)) {

            pS.setString(1, alumno.getDni());
            pS.setString(2, alumno.getNombre());
            pS.setString(3, alumno.getApellido1());
            pS.setString(4, alumno.getApellido2());
            pS.setString(5, alumno.getTipo_via());
            pS.setString(6, alumno.getNombre_via());
            pS.setString(7, alumno.getNumero());
            pS.setString(8, alumno.getEscalera());
            pS.setString(9, alumno.getPiso());
            pS.setString(10, alumno.getPuerta());
            pS.setString(11, alumno.getCp());
            pS.setString(12, alumno.getPais());
            pS.setString(13, alumno.getTlfn_fijo());
            pS.setString(14, alumno.getTlfn_movil());
            pS.setString(15, alumno.getEmail());
            pS.setDate(16, alumno.getFecha_nac());
            pS.setString(17, alumno.getTutor());
            pS.setString(18, alumno.getNre());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;

    }

    public List<AlumnoDTO> seleccionar() {

        List<AlumnoDTO> alumnos = new ArrayList<>();

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_SELECT);
                ResultSet rS = pS.executeQuery()) {

            while (rS.next()) {

                String nre = rS.getString("nre");
                String dni = rS.getString("dni");
                String nombre = rS.getString("nombre");
                String apellido1 = rS.getString("apellido1");
                String apellido2 = rS.getString("apellido2");
                String tipo_via = rS.getString("tipo_via");
                String nombre_via = rS.getString("nombre_via");
                String numero = rS.getString("numero");
                String escalera = rS.getString("escalera");
                String piso = rS.getString("piso");
                String puerta = rS.getString("puerta");
                String cp = rS.getString("cp");
                String pais = rS.getString("pais");
                String tlfn_fijo = rS.getString("tlfn_fijo");
                String tlfn_movil = rS.getString("tlfn_movil");
                String email = rS.getString("email");
                Date fecha_nac = rS.getDate("fecha_nac");
                String tutor = rS.getString("tutor");

                alumnos.add(new AlumnoDTO(nre, dni, nombre, apellido1, apellido2, tipo_via, nombre_via, numero,
                        escalera, piso, puerta, cp, pais, tlfn_fijo, tlfn_movil, email, fecha_nac, tutor));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alumnos;
    }
}
