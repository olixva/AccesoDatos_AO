package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conections.Conexion;
import conections.ConexionSQLite;
import dto.EmpleadoDTO;

public class EmpleadoDAOSQLite {

    Conexion connSQLite = new ConexionSQLite();

    private static String SQL_DELETE_ALL = "DELETE FROM empleados";
    private static String SQL_INSERT = "INSERT INTO empleados VALUES (?,?,?,?,?,?)";
    private static String SQL_SELECT = "SELECT * FROM empleados";

    // Funcion para seleccionar todos los empleados de la tabla empleados
    public List<EmpleadoDTO> seleccionarEmpleados() {
        List<EmpleadoDTO> empleados = new ArrayList<>();

        try (Connection conn = connSQLite.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL_SELECT);) {

            while (rs.next()) {

                int numEmpleado = rs.getInt("num");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                int departamento = rs.getInt("departamento");
                int categoria = rs.getInt("categoria");
                Date contrato = rs.getDate("contrato");

                empleados.add(new EmpleadoDTO(numEmpleado, nombre, edad, departamento, categoria, contrato));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleados;
    }

    // Funcion para borrar todos los empleados de la tabla empleados,
    // devuelve el numero de empleados borrados
    public int borrarEmpleados() {

        try (Connection conn = connSQLite.getConnection();
                Statement stmt = conn.createStatement()) {

            return stmt.executeUpdate(SQL_DELETE_ALL);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // Funcion para insertar un empleado en la tabla empleados
    public void insertarEmpleado(EmpleadoDTO empleado) {

        try (Connection conn = connSQLite.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SQL_INSERT)) {

            stmt.setInt(1, empleado.getNumEmpleado());
            stmt.setString(2, empleado.getNombre());
            stmt.setInt(3, empleado.getEdad());
            stmt.setInt(4, empleado.getDepartamento());
            stmt.setInt(5, empleado.getCategoria());
            stmt.setDate(6, empleado.getContrato());

            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
