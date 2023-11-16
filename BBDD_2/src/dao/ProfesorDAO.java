package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import dto.ProfesorDTO;
import util.Conexion;

public class ProfesorDAO {

    private static final String SQL_INSERT = "INSERT INTO profesor(nrp, dni, nombre, apellido1, apellido2, tipo_via, nombre_via, numero, escalera, piso, puerta, cp, pais, tlfn_fijo, tlfn_movil, email, fecha_nac, cod_departamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM profesor WHERE nrp = ?";
    private static final String SQL_UPDATE = "UPDATE profesor SET dni = ?, nombre = ?, apellido1 = ?, apellido2 = ?, tipo_via = ?, nombre_via = ?, numero = ?, escalera = ?, piso = ?, puerta = ?, cp = ?, pais = ?, tlfn_fijo = ?, tlfn_movil = ?, email = ?, fecha_nac = ?, cod_departamento = ? WHERE nrp = ?";
    private static final String SQL_SELECT = "SELECT nrp, dni, nombre, apellido1, apellido2, tipo_via, nombre_via, numero, escalera, piso, puerta, cp, pais, tlfn_fijo, tlfn_movil, email, fecha_nac, cod_departamento FROM profesor";
    private static final String SQL_SELECTBY = "SELECT * FROM profesor WHERE nrp = ?";

    public int insertar(ProfesorDTO profesor) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_INSERT)) {

            pS.setString(1, profesor.getNrp());
            pS.setString(2, profesor.getDni());
            pS.setString(3, profesor.getNombre());
            pS.setString(4, profesor.getApellido1());
            pS.setString(5, profesor.getApellido2());
            pS.setString(6, profesor.getTipo_via());
            pS.setString(7, profesor.getNombre_via());
            pS.setString(8, profesor.getNumero());
            pS.setString(9, profesor.getEscalera());
            pS.setString(10, profesor.getPiso());
            pS.setString(11, profesor.getPuerta());
            pS.setString(12, profesor.getCp());
            pS.setString(13, profesor.getPais());
            pS.setString(14, profesor.getTlfn_fijo());
            pS.setString(15, profesor.getTlfn_movil());
            pS.setString(16, profesor.getEmail());
            pS.setDate(17, profesor.getFecha_nac());
            pS.setString(18, profesor.getCod_departamento());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int borrar(ProfesorDTO profesor) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_DELETE)) {

            pS.setString(1, profesor.getNrp());

            registros = pS.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println(
                    "\nNo ha sido posible borrar el profesor debido a que se usa en otra tabla, elimine el registro de la otra tabla y vuelva a intentarlo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int actualizar(ProfesorDTO profesor) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_UPDATE)) {

            pS.setString(1, profesor.getDni());
            pS.setString(2, profesor.getNombre());
            pS.setString(3, profesor.getApellido1());
            pS.setString(4, profesor.getApellido2());
            pS.setString(5, profesor.getTipo_via());
            pS.setString(6, profesor.getNombre_via());
            pS.setString(7, profesor.getNumero());
            pS.setString(8, profesor.getEscalera());
            pS.setString(9, profesor.getPiso());
            pS.setString(10, profesor.getPuerta());
            pS.setString(11, profesor.getCp());
            pS.setString(12, profesor.getPais());
            pS.setString(13, profesor.getTlfn_fijo());
            pS.setString(14, profesor.getTlfn_movil());
            pS.setString(15, profesor.getEmail());
            pS.setDate(16, profesor.getFecha_nac());
            pS.setString(17, profesor.getCod_departamento());
            pS.setString(18, profesor.getNrp());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public List<ProfesorDTO> seleccionar() {

        List<ProfesorDTO> profesores = new ArrayList<>();

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_SELECT);
                ResultSet rS = pS.executeQuery()) {

            while (rS.next()) {
                String nrp = rS.getString("nrp");
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
                String cod_departamento = rS.getString("cod_departamento");

                profesores.add(new ProfesorDTO(nrp, dni, nombre, apellido1, apellido2, tipo_via, nombre_via, numero,
                        escalera, piso, puerta, cp, pais, tlfn_fijo, tlfn_movil, email, fecha_nac, cod_departamento));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return profesores;
    }

    public boolean exist(String nrp) {
        boolean existe = false;

        try (Connection conexion = Conexion.getConnection();
                PreparedStatement statement = conexion.prepareStatement(SQL_SELECTBY)) {

            statement.setString(1, nrp);

            try (ResultSet resultSet = statement.executeQuery()) {
                existe = resultSet.next(); // Devuelve true si hay al menos un resultado
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return existe;
    }
}
