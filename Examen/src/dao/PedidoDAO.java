package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.PedidoDTO;
import util.Conexion;

public class PedidoDAO {

    // Sentencia SELECT de pedidos entre fechas con todos los campos
    private static final String SQL_SELECT = "SELECT codigo_pedido, fecha_pedido, fecha_esperada, fecha_entrega, estado, comentarios, codigo_cliente FROM pedido WHERE fecha_pedido BETWEEN ? AND ?";
    // Sentencia SELECT de detalles de pedido dado un codigo de pedido
    private static final String SQL_SELECT_DETALLES = "SELECT * FROM detalle_pedido WHERE codigo_pedido = ?";
    // Sentencia DELETE de deatalles de pedido dado un codigo de pedido
    private static final String SQL_DELETE_DETALLES = "DELETE FROM detalle_pedido WHERE codigo_pedido = ?";
    // Sentencia DELETE de pedido dado un codigo de pedido
    private static final String SQL_DELETE_PEDIDO = "DELETE FROM pedido WHERE codigo_pedido = ?";

    // Metodo para buscar pedidos entre dos fechas
    public List<PedidoDTO> buscarPedidosPorFecha(Date fechaInicio, Date fechaFin) {

        List<PedidoDTO> pedidos = new ArrayList<>();

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_SELECT)) {

            pS.setDate(1, fechaInicio);
            pS.setDate(2, fechaFin);

            ResultSet rS = pS.executeQuery();

            while (rS.next()) {
                int codigoPedido = rS.getInt("codigo_pedido");
                Date fechaPedido = rS.getDate("fecha_pedido");
                Date fechaEsperada = rS.getDate("fecha_esperada");
                Date fechaEntrega = rS.getDate("fecha_entrega");
                String estado = rS.getString("estado");
                String comentarios = rS.getString("comentarios");
                int codigoCliente = rS.getInt("codigo_cliente");

                PedidoDTO pedido = new PedidoDTO(codigoPedido, fechaPedido, fechaEsperada, fechaEntrega, estado,
                        comentarios, codigoCliente);

                pedidos.add(pedido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    // Metodo para borrar un pedido y sus detalles
    public void borrarPedido(int codigoPedido, Scanner sc) {
        try (Connection cn = Conexion.getConnection()) {

            PreparedStatement pS = cn.prepareStatement(SQL_SELECT_DETALLES);

            pS.setInt(1, codigoPedido);
            ResultSet rs = pS.executeQuery();

            if (rs.next()) {
                System.out.println(
                        "Este pedido tiene detalles relacionados. ¿Desea borrar también estos detalles? (s/n)");
                String respuesta = sc.next();

                if (respuesta.equalsIgnoreCase("s")) {
                    pS = cn.prepareStatement(SQL_DELETE_DETALLES);
                    pS.setInt(1, codigoPedido);
                    pS.executeUpdate();
                    pS = cn.prepareStatement(SQL_DELETE_PEDIDO);
                    pS.setInt(1, codigoPedido);

                    pS.executeUpdate();
                    System.out.println("El pedido y sus detalles han sido borrados.");
                } else {
                    System.out.println("No se ha borrado nada.");
                }

            } else {
                pS = cn.prepareStatement(SQL_DELETE_PEDIDO);
                pS.setInt(1, codigoPedido);
                int registros = pS.executeUpdate();

                if (registros == 0) {
                    System.out.println("No se ha encontrado el pedido.");
                } else {
                    System.out.println("El pedido ha sido borrado.");
                }
            }
            pS.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
