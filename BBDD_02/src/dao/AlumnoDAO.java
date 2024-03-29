package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import dto.AlumnoDTO;
import util.Conexion;

public class AlumnoDAO {
    // Sentencia INSERT
    private static final String SQL_INSERT = "INSERT INTO ALUMNO(nre, dni, nombre, apellido1, apellido2, tipo_via, nombre_via, numero, escalera, piso, puerta, cp, pais, tlfn_fijo, tlfn_movil, email, fecha_nac, tutor) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    // Sentencia DELETE
    private static final String SQL_DELETE = "DELETE FROM alumno WHERE nre = ?";
    // Sentencia UPDATE
    private static final String SQL_UPDATE = "UPDATE alumno SET dni = ?, nombre = ?, apellido1 = ?, apellido2 = ?, tipo_via = ?, nombre_via = ?, numero = ?, escalera = ?, piso = ?, puerta = ?, cp = ?, pais = ?, tlfn_fijo = ?, tlfn_movil = ?, email = ?, fecha_nac = ?, tutor = ? WHERE nre = ?";
    // Sentencia SELECT
    private static final String SQL_SELECT = "SELECT nre, dni, nombre, apellido1, apellido2, tipo_via, nombre_via, numero, escalera, piso, puerta, cp, pais, tlfn_fijo, tlfn_movil, email, fecha_nac, tutor FROM alumno";
    // Sentencia SELECT BY NRE
    private static final String SQL_SELECTBY_NRE = "SELECT * FROM alumno WHERE nre = ?";
    // Sentencia SELECT BY CODIGO CURSO
    private static final String SQL_SELECTBY_CURSO = "SELECT DISTINCT alumno.nre, dni, nombre, apellido1, apellido2, tipo_via, nombre_via, numero, escalera, piso, puerta, cp, pais, tlfn_fijo, tlfn_movil, email, fecha_nac, tutor FROM alumno INNER JOIN matricula ON alumno.nre = matricula.nre WHERE cod_curso = ?";
    // Sentencia SELECT BY CODIGO ASIGNATURA
    private static final String SQL_SELECTBY_ASIGNATURA = "SELECT DISTINCT alumno.nre, dni, nombre, apellido1, apellido2, tipo_via, nombre_via, numero, escalera, piso, puerta, cp, pais, tlfn_fijo, tlfn_movil, email, fecha_nac, tutor FROM alumno INNER JOIN matricula ON alumno.nre = matricula.nre WHERE cod_asig = ?";
    // Sentencia SELECT BY NOMBRE
    private static final String SQL_SELECTBY_NOMBRE = "SELECT DISTINCT alumno.nre, dni, nombre, apellido1, apellido2, tipo_via, nombre_via, numero, escalera, piso, puerta, cp, pais, tlfn_fijo, tlfn_movil, email, fecha_nac, tutor FROM alumno WHERE CONCAT(nombre, ' ', apellido1, ' ', apellido2) like ?;";
    // Sentencia SELECT BY GRUPO Y AÑO
    private static final String SQL_SELECTBY_ANIO_GRUPO = "SELECT DISTINCT CONCAT(a.nombre , ' ' , a.apellido1 , ' ' , a.apellido2) as nombre FROM alumno a INNER JOIN matricula m ON a.nre = m.nre INNER JOIN curso c ON m.cod_curso = c.cod_curso INNER JOIN grupo g ON c.cod_curso = g.cod_curso WHERE m.anyo = ? AND g.cod_grupo = ?";

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

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println(
                    "\nNo ha sido posible borrar el alumno debido a que se usa en otra tabla, elimine el registro de la otra tabla y vuelva a intentarlo.");
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

    public List<AlumnoDTO> seleccionarPorCurso(String codigoCurso) {

        List<AlumnoDTO> alumnos = new ArrayList<>();

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_SELECTBY_CURSO)) {

            pS.setString(1, codigoCurso);
            ResultSet rS = pS.executeQuery();

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

    public List<AlumnoDTO> seleccionarPorAsignatura(String codigoAsignatura) {

        List<AlumnoDTO> alumnos = new ArrayList<>();

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_SELECTBY_ASIGNATURA)) {

            pS.setString(1, codigoAsignatura);
            ResultSet rS = pS.executeQuery();

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

    public List<AlumnoDTO> seleccionarPorNombre(String nombreBuscar) {

        List<AlumnoDTO> alumnos = new ArrayList<>();

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_SELECTBY_NOMBRE)) {

            pS.setString(1, "%" + nombreBuscar + "%");
            ResultSet rS = pS.executeQuery();

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

    public List<String> seleccionarPorGrupo(String anyo, String codGrupo) {

        List<String> alumnos = new ArrayList<>();

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_SELECTBY_ANIO_GRUPO)) {

            pS.setString(1, anyo);
            pS.setString(2, codGrupo);
            ResultSet rS = pS.executeQuery();

            while (rS.next()) {

                String nombre = rS.getString("nombre");
                
                alumnos.add(nombre);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return alumnos;
    }
        
    
    public boolean exist(String nre) {

        boolean existe = false;

        try (Connection conexion = Conexion.getConnection();
                PreparedStatement statement = conexion.prepareStatement(SQL_SELECTBY_NRE)) {

            statement.setString(1, nre);

            try (ResultSet resultSet = statement.executeQuery()) {
                existe = resultSet.next(); // Devuelve true si hay al menos un resultado
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return existe;
    }

}
