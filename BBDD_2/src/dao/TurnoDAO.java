package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.TurnoDTO;
import util.Conexion;

public class TurnoDAO {

    private static final String SQL_INSERT = "INSERT INTO turno(cod_turno, horario) VALUES(?, ?)";
    private static final String SQL_DELETE = "DELETE FROM turno WHERE cod_turno = ?";
    private static final String SQL_UPDATE = "UPDATE turno SET horario = ? WHERE cod_turno = ?";
    private static final String SQL_SELECT = "SELECT cod_turno, horario FROM turno";

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
}
