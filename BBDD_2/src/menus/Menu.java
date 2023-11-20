package menus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        try {
            menu();
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingresa un valor entero valido.");
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
                    (new MenuAlumno()).mostrarSubMenu(sc);
                    break;

                case 2:
                    (new MenuDepartamento()).mostrarSubMenu(sc);
                    break;

                case 3:
                    (new MenuProfesor()).mostrarSubMenu(sc);
                    break;

                case 4:
                    (new MenuEdificio()).mostrarSubMenu(sc);
                    break;

                case 5:
                    (new MenuAula()).mostrarSubMenu(sc);
                    break;

                case 6:
                    (new MenuCurso()).mostrarSubMenu(sc);
                    break;

                case 7:
                    (new MenuTurno()).mostrarSubMenu(sc);
                    break;

                case 8:
                    (new MenuGrupo()).mostrarSubMenu(sc);
                    break;

                case 9:
                    (new MenuAsignatura()).mostrarSubMenu(sc);
                    break;
                default:
                    break;
            }
        }
    }

    private static int getTabla() {
        System.out.println("\n-----------MENU-----------");
        System.out.println("1.- Alumno");
        System.out.println("2.- Departamento");
        System.out.println("3.- Profesor");
        System.out.println("4.- Edificio");
        System.out.println("5.- Aula");
        System.out.println("6.- Curso");
        System.out.println("7.- Turno");
        System.out.println("8.- Grupo");
        System.out.println("9.- Asignatura");
        System.out.println("0.- Salir");

        return sc.nextInt();
    }

    // Opciones generales para algunos submenus
    public static int opciones(String tabla) {
        System.out.println("\n---------" + tabla + "---------");

        System.out.println("1.- Listar " + tabla);
        System.out.println("2.- Crear " + tabla);
        System.out.println("3.- Actualizar " + tabla);
        System.out.println("4.- Eliminar " + tabla);
        System.out.println("5.- Volver");

        System.out.print("Elige una opcion: ");
        return sc.nextInt();
    }
}