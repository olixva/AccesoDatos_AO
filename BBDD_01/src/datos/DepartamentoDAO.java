package datos;

import domain.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {
    // Sentencia SELECT
    private static final String SQL_SELECT = "SELECT codDepto, nombreDpto, ciudad, codDirector FROM departamentos";
    // Sentencia INSERT
    private static final String SQL_INSERT = "INSERT INTO departamentos (codDepto, nombreDpto, ciudad, codDirector) VALUES (?, ?, ?, ?)";
    // Sentencia UPDATE
    private static final String SQL_UPDATE = "UPDATE departamentos SET nombreDpto = ?, ciudad = ?, codDirector = ? WHERE codDepto = ?";
    // Sentencia DELETE
    private static final String SQL_DELETE = "DELETE FROM departamentos WHERE codDepto = ?";

    public int actualizar(DepartamentoDTO departamento) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
             PreparedStatement pS = cn.prepareStatement(SQL_UPDATE)) {

            pS.setString(1, departamento.getNombreDpto());
            pS.setString(2, departamento.getCiudad());
            pS.setString(3, departamento.getCodDirector());
            pS.setString(4, departamento.getCodDepto());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public List<DepartamentoDTO> seleccionar() {
        List<DepartamentoDTO> departamentos = new ArrayList<>();

        try (Connection cn = Conexion.getConnection();
             PreparedStatement pS = cn.prepareStatement(SQL_SELECT);
             ResultSet rS = pS.executeQuery()) {

            while (rS.next()) {
                DepartamentoDTO departamento = new DepartamentoDTO(
                        rS.getString("codDepto"),
                        rS.getString("nombreDpto"),
                        rS.getString("ciudad"),
                        rS.getString("codDirector")
                );

                departamentos.add(departamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departamentos;
    }

    public int insertar(DepartamentoDTO departamento) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
             PreparedStatement pS = cn.prepareStatement(SQL_INSERT)) {

            pS.setString(1, departamento.getCodDepto());
            pS.setString(2, departamento.getNombreDpto());
            pS.setString(3, departamento.getCiudad());
            pS.setString(4, departamento.getCodDirector());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int borrar(DepartamentoDTO departamento) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
             PreparedStatement pS = cn.prepareStatement(SQL_DELETE)) {

            pS.setString(1, departamento.getCodDepto());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }
}

