package menus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            menu();
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresa un valor valido.");
        } finally {
            sc.close();
        }
    }

    // Menu general
    public static void menu() {
        boolean continuar = true;

        while (continuar) {

            int tabla = getTabla();

            switch (tabla) {
                case 0:
                    continuar = false;
                    break;
                case 1:
                    (new MenuCliente()).mostrarSubMenu(sc);
                    break;
                case 2:
                    (new MenuProducto()).mostrarSubMenu(sc);
                    break;
                case 3:
                    (new MenuOficina()).mostrarSubMenu(sc);
                    break;
                case 4:
                    (new MenuPedido()).mostrarSubMenu(sc);
                    break;
            }
        }
    }

    private static int getTabla() {
        System.out.println("\n-----------MENU-----------");
        System.out.println("1.- Cliente");
        System.out.println("2.- Producto");
        System.out.println("3.- Oficina");
        System.out.println("4.- Pedido");
        System.out.println("0.- Salir");

        return sc.nextInt();
    }
}