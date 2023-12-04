package menus;

import java.util.List;
import java.util.Scanner;

import dao.ClienteDAO;
import dto.ClienteDTO;


public class MenuCliente {
    private static ClienteDAO clienteDAO = new ClienteDAO();

    // Submenu de Cliente
    public void mostrarSubMenu(Scanner sc) {

        boolean continuar = true;
        while (continuar) {

            switch (this.opcionesCliente(sc)) {

                case 1:
                    this.listarClientes();
                    break;
                case 0:
                    continuar = false;
                    break;

                default:
                    break;
            }
        }
    }

    public int opcionesCliente(Scanner sc) {
        System.out.println("\n---------CLIENTE---------");

        System.out.println("1.- Listar Clientes");
        System.out.println("0.- Volver");

        System.out.print("Elige una opcion: ");
        return sc.nextInt();
    }

    // Funciones de Cliente
    private void listarClientes() {

        List<ClienteDTO> clientes = clienteDAO.seleccionar();

        clientes.forEach(empleado -> {

            System.out.println("\n" + empleado.toString());

        });
    }
}
