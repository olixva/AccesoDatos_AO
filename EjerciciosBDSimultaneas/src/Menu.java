import java.util.List;
import java.util.Scanner;

import dao.EmpleadoDAOMySQL;
import dao.EmpleadoDAOSQLite;
import dto.EmpleadoDTO;

public class Menu {

    static Scanner sc = new Scanner(System.in);
    static EmpleadoDAOMySQL empleadoDAOMySQL = new EmpleadoDAOMySQL();
    static EmpleadoDAOSQLite empleadoDAOSQLite = new EmpleadoDAOSQLite();

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
                    copiarTablaEmpleados();
                    break;

                case 3:
                    mostrarEmpleadosSQLite();
                    break;

                case 4:
                    eliminarEmpleadoMySQL();
                    break;

                case 5:
                    sincronizarDatos();
                    break;

                case 6:
                    fin = true;
            }
        }
    }


    private static void mostrarEmpleadosMySQL() {
        System.out.println("\nEmpleados de MySQL:\n");
        empleadoDAOMySQL.seleccionarEmpleados().forEach(System.out::println);
    }

    private static void copiarTablaEmpleados() {

        // Primero booramos los posibles empleados que haya en la tabla empleados de
        // SQLite
        int borrados = empleadoDAOSQLite.borrarEmpleados();
        System.out.println("\nSe han borrado " + borrados + " empleados de la tabla empleados de SQLite");

        // Ahora recupero todos los empleados de MySQL y los inserto en SQLite
        empleadoDAOMySQL.seleccionarEmpleados().forEach(empleado -> empleadoDAOSQLite.insertarEmpleado(empleado));
        System.out.println("\nSe han copiado los empleados de MySQL a SQLite");
    }

    private static void mostrarEmpleadosSQLite() {
        System.out.println("\nEmpleados de SQLite:\n");
        empleadoDAOSQLite.seleccionarEmpleados().forEach(System.out::println);
    }

    private static void eliminarEmpleadoMySQL() {
        System.out.println("\nIntroduce el numero de empleado a eliminar:");
        int numEmpleado = sc.nextInt();

        int eliminado = empleadoDAOMySQL.eliminarEmpleado(numEmpleado);

        if (eliminado > 0) {
            System.out.println(
                    "\nSe ha eliminado el empleado con numero " + numEmpleado + " de la tabla empleados de MySQL");
        } else {
            System.out.println(
                    "\nNo se ha eliminado el empleado con numero " + numEmpleado + " de la tabla empleados de MySQL");
        }
    }

    private static void sincronizarDatos() {
        //Recuperamos los empleados de SQLite y de MySQL
        List<EmpleadoDTO> empleadosSQLite = empleadoDAOSQLite.seleccionarEmpleados();
        List<EmpleadoDTO> empleadosMySQL = empleadoDAOMySQL.seleccionarEmpleados();

        //Recorremos los empleados de SQLite y comprobamos si existen en MySQL
        empleadosSQLite.forEach(empleadoSQLite -> {
            
            boolean existe = false;
            for (EmpleadoDTO empleadoMySQL : empleadosMySQL) {
                if (empleadoSQLite.getNumEmpleado() == empleadoMySQL.getNumEmpleado()) {
                    existe = true;
                    break;
                }
            }

            //Si no existe, lo insertamos en MySQL
            if (!existe) {
                empleadoDAOMySQL.insertarEmpleado(empleadoSQLite);
                System.out.println("\nSe ha insertado el empleado con numero " + empleadoSQLite.getNumEmpleado()
                        + " en la tabla empleados de MySQL");
            }
            
        });
    }
}
