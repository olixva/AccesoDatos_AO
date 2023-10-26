package datos;

import domain.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    // Sentencia SELECT
    private static final String SQL_SELECT = "SELECT nDIEmp, nomEmp, sexEmp, fecNac, fecIncorporacion, salEmp, comisionE, cargoE, jefeID, codDepto FROM empleados";
    // Sentencia INSERT
    private static final String SQL_INSERT = "INSERT INTO EMPLEADOS(nDIEmp, nomEmp, sexEmp, fecNac, fecIncorporacion, salEmp, comisionE, cargoE, jefeID, codDepto) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    // Sentencia UPDATE
    private static final String SQL_UPDATE = "UPDATE empleados SET nomEmp = ?, sexEmp = ?, fecNac = ?, fecIncorporacion = ?, salEmp = ?, comisionE = ?, cargoE = ?, jefeID = ?, codDepto = ? WHERE nDIEmp = ?";
    //Sentencia DELETE
    private static final String SQL_DELETE = "DELETE FROM empleados WHERE nDIEmp = ?";
    

    public int actualizar(EmpleadoDTO empleado) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_UPDATE);) {

            
            pS.setString(1, empleado.getNombre());
            System.out.println(empleado.getNombre());
            pS.setString(2, empleado.getSexoString());
            pS.setDate(3, empleado.getFechaNac());
            pS.setDate(4, empleado.getFechaIncorpora());
            pS.setFloat(5, empleado.getSalario());
            pS.setFloat(6, empleado.getComision());
            pS.setString(7, empleado.getCargo());
            pS.setString(8, empleado.getIdJefe());
            pS.setString(9, empleado.getCodDepto());
            pS.setString(10, empleado.getIdEmpleado());

            registros = pS.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            
        }

        return registros;
    }

    public List<EmpleadoDTO> seleccionar() {

        List<EmpleadoDTO> empleados = new ArrayList<>();

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_SELECT);
                ResultSet rS = pS.executeQuery()) {

            while (rS.next()) {
                EmpleadoDTO empleado = new EmpleadoDTO(rS.getString("nDIEmp"), rS.getString("nomEmp"),
                        rS.getString("sexEmp").charAt(0), rS.getDate("fecNac"),
                        rS.getDate("fecIncorporacion"), rS.getFloat("salEMp"), rS.getFloat("comisionE"),
                        rS.getString("cargoE"), rS.getString("jefeID"), rS.getString("codDepto"));

                empleados.add(empleado);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return empleados;
    }

    public int insertar(EmpleadoDTO empleado) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection(); PreparedStatement pS = cn.prepareStatement(SQL_INSERT)) {

            pS.setString(1, empleado.getIdEmpleado());
            pS.setString(2, empleado.getNombre());
            pS.setString(3, empleado.getSexoString());
            pS.setDate(4, empleado.getFechaNac());
            pS.setDate(5, empleado.getFechaIncorpora());
            pS.setFloat(6, empleado.getSalario());
            pS.setFloat(7, empleado.getComision());
            pS.setString(8, empleado.getCargo());
            pS.setString(9, empleado.getIdJefe());
            pS.setString(10, empleado.getCodDepto());

            registros = pS.executeUpdate();

        } catch (SQLException sqlE) {
            sqlE.printStackTrace(System.out);
        }
        return registros;
    }

    public int borrar(EmpleadoDTO empleado) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection(); PreparedStatement pS = cn.prepareStatement(SQL_DELETE)) {

            pS.setString(1, empleado.getIdEmpleado());
            
            registros = pS.executeUpdate();

        } catch (SQLException sqlE) {
            sqlE.printStackTrace(System.out);
        }
        return registros;
    }
}
