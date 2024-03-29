package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AulaDTO;
import util.Conexion;

public class AulaDAO {

    private static final String SQL_INSERT = "INSERT INTO aula(num_aula, cod_edificio) VALUES(?, ?)";
    private static final String SQL_DELETE = "DELETE FROM aula WHERE num_aula = ?";
    private static final String SQL_UPDATE = "UPDATE aula SET cod_edificio = ? WHERE num_aula = ?";
    private static final String SQL_SELECT = "SELECT num_aula, cod_edificio FROM aula";
    private static final String SQL_SELECTBY = "SELECT * FROM aula WHERE num_aula = ?";

    public int insertar(AulaDTO aula) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
             PreparedStatement pS = cn.prepareStatement(SQL_INSERT)) {

            pS.setString(1, aula.getNum_aula());
            pS.setString(2, aula.getCod_edificio());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int borrar(AulaDTO aula) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
             PreparedStatement pS = cn.prepareStatement(SQL_DELETE)) {

            pS.setString(1, aula.getNum_aula());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int actualizar(AulaDTO aula) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
             PreparedStatement pS = cn.prepareStatement(SQL_UPDATE)) {

            pS.setString(1, aula.getCod_edificio());
            pS.setString(2, aula.getNum_aula());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public List<AulaDTO> seleccionar() {

        List<AulaDTO> aulas = new ArrayList<>();

        try (Connection cn = Conexion.getConnection();
             PreparedStatement pS = cn.prepareStatement(SQL_SELECT);
             ResultSet rS = pS.executeQuery()) {

            while (rS.next()) {
                String num_aula = rS.getString("num_aula");
                String cod_edificio = rS.getString("cod_edificio");

                aulas.add(new AulaDTO(num_aula, cod_edificio));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aulas;
    }

    public boolean exist(String num_aula) {
        boolean existe = false;

        try (Connection conexion = Conexion.getConnection();
             PreparedStatement statement = conexion.prepareStatement(SQL_SELECTBY)) {

            statement.setString(1, num_aula);

            try (ResultSet resultSet = statement.executeQuery()) {
                existe = resultSet.next(); // Devuelve true si hay al menos un resultado
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return existe;
    }
}
