package menus;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import dao.PedidoDAO;
import dto.PedidoDTO;
import util.Validador;

public class MenuPedido {

    private static PedidoDAO pedidoDAO = new PedidoDAO();

    // Submenu de Pedido
    public void mostrarSubMenu(Scanner sc) {

        boolean continuar = true;
        while (continuar) {

            switch (this.opcionesPedido(sc)) {

                case 1:
                    this.buscarPedidosPorFecha(sc);
                    break;
                case 2:
                    this.eliminarPedido(sc);
                    break;
                case 0:
                    continuar = false;
                    break;

                default:
                    break;
            }
        }
    }

    public int opcionesPedido(Scanner sc) {
        System.out.println("\n---------Pedido---------");

        System.out.println("1.- Buscar pedidos entre fechas");
        System.out.println("2.- Eliminar pedido");
        System.out.println("0.- Volver");

        System.out.print("Elige una opcion: ");
        return sc.nextInt();
    }

    // Funciones de Pedido

    private void buscarPedidosPorFecha(Scanner sc) {

        System.out.print("Introduce la fecha de inicio AAAA-MM-DD: ");
        String fechaInicio = Validador.pedirFecha();

        System.out.print("Introduce la fecha de fin AAAA-MM-DD: ");
        String fechaFin = Validador.pedirFecha();

        List<PedidoDTO> pedidos = pedidoDAO.buscarPedidosPorFecha(Date.valueOf(fechaInicio), Date.valueOf(fechaFin));

        for (PedidoDTO pedidoDTO : pedidos) {
            System.out.println(pedidoDTO.toString());
        }
    }

    private void eliminarPedido(Scanner sc) {

        System.out.print("Introduce el codigo del pedido: ");
        int codigoPedido = sc.nextInt();

        pedidoDAO.borrarPedido(codigoPedido, sc);
    }
}
