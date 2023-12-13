import java.util.Scanner;

import dao.EmpleadoDAOMySQL;

public class Menu {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean fin = false;
        while (!fin) {
            System.out.println("\n----------MENU----------\n");
            System.out.println("1. Mostrar todos los empleados (MySQL)");
            System.out.println("2. Copiar tabla empleados a SQLite");
            System.out.println("3. Mostrar todos los empleados (SQLite)");
            System.out.println("4. Eliminar empleado (MySQL)");
            System.out.println("5. Sincronizar datos de SQLite a MySQL");
            System.out.println("6. Salir");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    mostrarEmpleadosMySQL();
                    break;

                case 2:
                    //copiarTablaEmpleados();
                    break;

                case 3:
                    //mostrarEmpleadosSQLite();
                    break;

                case 4:
                    //eliminarEmpleadoMySQL();
                    break;

                case 5:
                    //sincronizarDatos();
                    break;

                case 6:
                    fin = true;
            }
        }
    }

    private static void mostrarEmpleadosMySQL() {
        EmpleadoDAOMySQL empleadoDAOMySQL = new EmpleadoDAOMySQL();
        empleadoDAOMySQL.seleccionarEmpleados().forEach(System.out::println);
    }
}
