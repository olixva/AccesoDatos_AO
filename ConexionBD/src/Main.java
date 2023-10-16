import java.sql.*;

import datos.Conexion;

public class Main {
    public static void main(String[] args) {
        String sql = "SELECT nomEmp, fecNac, salEmp FROM empleados";

        try {

            Connection conecction = Conexion.getConnection();
            Statement intruccion = conecction.createStatement();
            ResultSet rS = intruccion.executeQuery(sql);

            while (rS.next()) {
                System.out.print("Nombre: " + rS.getString("nomEmp"));
                System.out.print(" Fecha Nacimientos: " + rS.getDate("fecNAc"));
                System.out.print(" Salario: " + rS.getFloat("salEmp") + "\n\n");
            }
            
            Conexion.close(rS);
            Conexion.close(intruccion);
            Conexion.close(conecction);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
