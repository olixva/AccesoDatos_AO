package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import conections.Conexion;
import conections.ConexionMySQL;
import dto.EmpleadoDTO;

public class EmpleadoDAOMySQL {

    Conexion connMySQL = new ConexionMySQL();

    private static String SQL_SELECT = "SELECT * FROM empleados";

    public List<EmpleadoDTO> seleccionarEmpleados() {
        List<EmpleadoDTO> empleados = new ArrayList<>();

        try (Connection conn = connMySQL.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL_SELECT);) {

            while (rs.next()) {

                int numEmpleado = rs.getInt("numEmpleado");
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
}
