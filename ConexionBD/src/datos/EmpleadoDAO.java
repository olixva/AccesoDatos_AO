package datos;

import domain.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    private static final String SQL_SELECT = "SELECT nDIEmp, nomEmp, sexEmp, fecNac, fecIncorporacion, salEmp, comisionE, cargoE, jefeID, codDepto FROM empleados";

    public List<EmpleadoDTO> seleccionar() {
        
        List<EmpleadoDTO> empleados = new ArrayList<>();

        try 
            (Connection conexion = Conexion.getConnection();
            PreparedStatement pS = conexion.prepareStatement(SQL_SELECT);
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
}
