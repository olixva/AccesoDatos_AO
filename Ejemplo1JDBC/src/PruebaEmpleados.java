import java.sql.*;

public class PruebaEmpleados {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/empleadoss_departamentoss?useSSL=false";
        String sql = "SELECT nomEmp, fecNac, salEmp FROM empleados";

        try (Connection conecction = DriverManager.getConnection(url, "root", "root");
                Statement intruccion = conecction.createStatement();
                ResultSet rS = intruccion.executeQuery(sql);) {

            while (rS.next()) {
                System.out.print("Nombre: " + rS.getString("nomEmp"));
                System.out.print(" Fecha Nacimientos: " + rS.getDate("fecNAc") );
                System.out.print(" Salario: " + rS.getFloat("salEmp" ) + "\n\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
