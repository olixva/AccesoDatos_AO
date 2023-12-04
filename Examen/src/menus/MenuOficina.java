package menus;

import java.util.Scanner;

import dao.OficinaDAO;
import dto.OficinaDTO;

public class MenuOficina {
    private static OficinaDAO oficinaDAO = new OficinaDAO();

    // Submenu de Oficina
    public void mostrarSubMenu(Scanner sc) {

        boolean continuar = true;
        while (continuar) {

            switch (this.opcionesOficina(sc)) {

                case 1:
                    this.modificarTelefono(sc);
                    break;
                case 0:
                    continuar = false;
                    break;

                default:
                    break;
            }
        }
    }

    public int opcionesOficina(Scanner sc) {
        System.out.println("\n---------Oficina---------");

        System.out.println("1.- Modificar Telefono");
        System.out.println("0.- Volver");

        System.out.print("Elige una opcion: ");
        return sc.nextInt();
    }

    // Funciones de Oficina
    private void modificarTelefono(Scanner sc) {

        OficinaDTO oficina = pedirDatosOficina(sc);

        if (oficina != null) {
            int registros = oficinaDAO.actualizarTelefono(oficina);
            System.out.println("\nREGISTROS MODIFICADOS: " + registros);
        }
    }

    private OficinaDTO pedirDatosOficina(Scanner sc) {

        OficinaDTO oficina = new OficinaDTO();

        System.out.print("Introduce el codigo de la oficina: ");
        String codigoOficina = sc.next();

        while (!oficinaDAO.existeOficina(codigoOficina)) {
            System.out.println(
                    "No existe ninguna oficina con ese codigo. Introduce otro codigo de oficina o teclee 0 para volver al menu: ");
            codigoOficina = sc.next();
            if (codigoOficina.equals("0")) {
                return null;
            }
        }
        oficina.setCodigoOficina(codigoOficina);

        System.out.print("Introduce el nuevo telefono: ");
        oficina.setTelefono(sc.next());

        return oficina;
    }

}