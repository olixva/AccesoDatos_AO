package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import dto.TurnoDTO;
import util.Conexion;

public class TurnoDAO {

    private static final String SQL_INSERT = "INSERT INTO turno(cod_turno, horario) VALUES(?, ?)";
    private static final String SQL_DELETE = "DELETE FROM turno WHERE cod_turno = ?";
    private static final String SQL_UPDATE = "UPDATE turno SET horario = ? WHERE cod_turno = ?";
    private static final String SQL_SELECT = "SELECT cod_turno, horario FROM turno";
    private static final String SQL_SELECTBY = "SELECT * FROM turno WHERE cod_turno = ?";

    public int insertar(TurnoDTO turno) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_INSERT)) {

            pS.setString(1, turno.getCod_turno());
            pS.setString(2, turno.getHorario());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int borrar(TurnoDTO turno) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_DELETE)) {

            pS.setString(1, turno.getCod_turno());

            registros = pS.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println(
                    "\nNo ha sido posible borrar el turno debido a que se usa en otra tabla, elimine el registro de la otra tabla y vuelva a intentarlo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int actualizar(TurnoDTO turno) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_UPDATE)) {

            pS.setString(1, turno.getHorario());
            pS.setString(2, turno.getCod_turno());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public List<TurnoDTO> seleccionar() {

        List<TurnoDTO> turnos = new ArrayList<>();

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_SELECT);
                ResultSet rS = pS.executeQuery()) {

            while (rS.next()) {
                String cod_turno = rS.getString("cod_turno");
                String horario = rS.getString("horario");

                turnos.add(new TurnoDTO(cod_turno, horario));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return turnos;
    }

    public boolean exist(String codigo) {

        boolean existe = false;

        try (Connection conexion = Conexion.getConnection();
                PreparedStatement statement = conexion.prepareStatement(SQL_SELECTBY)) {

            statement.setString(1, codigo);

            try (ResultSet resultSet = statement.executeQuery()) {
                existe = resultSet.next(); // Devuelve true si hay al menos un resultado
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return existe;
    }
}
