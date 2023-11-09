package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.DepartamentoDTO;
import util.Conexion;

public class DepartamentoDAO {

    private static final String SQL_INSERT = "INSERT INTO departamento(cod_departamento, nombre, descripcion) VALUES (?, ?, ?)";
    private static final String SQL_DELETE = "DELETE FROM departamento WHERE cod_departamento = ?";
    private static final String SQL_UPDATE = "UPDATE departamento SET nombre = ?, descripcion = ? WHERE cod_departamento = ?";
    private static final String SQL_SELECT = "SELECT cod_departamento, nombre, descripcion FROM departamento";

    public int insertar(DepartamentoDTO departamento) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_INSERT)) {

            pS.setString(1, departamento.getCod_departamento());
            pS.setString(2, departamento.getNombre());
            pS.setString(3, departamento.getDescripcion());

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

            pS.setString(1, departamento.getCod_departamento());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int actualizar(DepartamentoDTO departamento) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_UPDATE)) {

            pS.setString(1, departamento.getNombre());
            pS.setString(2, departamento.getDescripcion());
            pS.setString(3, departamento.getCod_departamento());

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
                String cod_departamento = rS.getString("cod_departamento");
                String nombre = rS.getString("nombre");
                String descripcion = rS.getString("descripcion");

                departamentos.add(new DepartamentoDTO(cod_departamento, nombre, descripcion));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return departamentos;
    }
}

