import java.sql.*;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/empleadoss_departamentoss?useSSL=false";
        String sql = "SELECT codDepto, nombreDpto, FROM departamentos";

        try (Connection conecction = DriverManager.getConnection(url, "root", "root");
                Statement intruccion = conecction.createStatement();
                ResultSet rS = intruccion.executeQuery(sql);) {

            while (rS.next()) {
                System.out.print("Departamento: " + rS.getInt("codDpto"));
                System.out.print(" Nombre: " + rS.getString("nombreDpto") + "\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
