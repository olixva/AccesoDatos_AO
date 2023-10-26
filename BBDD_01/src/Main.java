import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import datos.DepartamentoDAO;
import datos.EmpleadoDAO;
import domain.DepartamentoDTO;
import domain.EmpleadoDTO;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final String MENU = "----MENU----\n1.- Añadir empleado\n2.- Borrar empleado\n" +
                "3.- Actualizar datos de empleado. (implica buscar y pedir nuevos datos)\n4.- Mostrar todos los empleados\n"
                +
                "5.- Añadir Departamento\n6.- Borrar departamento\n7.- Actualizar departamento\n8.- Mostrar todos los departamentos\n"
                +
                "0.- Salir";

        EmpleadoDAO daoEmpleado = new EmpleadoDAO();
        DepartamentoDAO daoDepartamento = new DepartamentoDAO();

        int opcion = -1;

        while (opcion != 0) {

            System.out.println(MENU);
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                opcion = 0;
            }

            switch (opcion) {
                case 0:
                    break;

                case 1:
                    EmpleadoDTO nuevoEmpleado = pedirDatosEmpleado();

                    if (nuevoEmpleado != null) {
                        daoEmpleado.insertar(nuevoEmpleado);
                    }
                    break;
                case 2:
                    System.out.println("Introduce el ID del empleado a borrar: ");
                    EmpleadoDTO empleadoBorrar = new EmpleadoDTO(sc.next());

                    daoEmpleado.borrar(empleadoBorrar);
                    break;

                case 3:
                    EmpleadoDTO actualizarEmpleado = pedirDatosEmpleado();

                    daoEmpleado.actualizar(actualizarEmpleado);
                    break;

                case 4:
                    daoEmpleado.seleccionar().forEach(empleado -> System.out.println(empleado.toString()));

                    break;

                case 5:
                    DepartamentoDTO departamentoNuevo = pedirDatosDepartamentos();

                    daoDepartamento.insertar(departamentoNuevo);
                    break;

                case 6:
                    System.out.println("Introduce el codigo del departamento a borrar: ");
                    DepartamentoDTO departamentoBorrar = new DepartamentoDTO(sc.next());

                    daoDepartamento.borrar(departamentoBorrar);
                    break;

                case 7:
                    DepartamentoDTO departamentoActualizar = pedirDatosDepartamentos();

                    daoDepartamento.actualizar(departamentoActualizar);
                    break;

                case 8:
                    daoDepartamento.seleccionar().forEach(departamento -> {
                        System.out.println(departamento.toString());
                    });
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }

    private static EmpleadoDTO pedirDatosEmpleado() {

        EmpleadoDTO nuevoEmpleado = new EmpleadoDTO();

        System.out.println("Introduce ID del empleado: ");
        nuevoEmpleado.setIdEmpleado(sc.next());

        System.out.println("Introduce nombre del empleado: ");
        nuevoEmpleado.setNombre(sc.next());

        System.out.println("Introduce sexo del empleado: ");
        nuevoEmpleado.setSexo(sc.next().charAt(0));

        try {
            System.out.println("Introduce fecha de nacimiento del empleado (AAAA-MM-DD): ");
            nuevoEmpleado.setFechaNac(Date.valueOf(sc.next()));

            System.out.println("Introduce fecha de incorporacion del empleado (AAAA-MM-DD): ");
            nuevoEmpleado.setFechaIncorpora(Date.valueOf(sc.next()));
        } catch (IllegalArgumentException e) {
            System.out.println("Fecha en formato invalido, el formato debe ser AAAA-MM-DD");
            return null;
        }

        try {
            System.out.println("Introduce salario del empleado: ");
            nuevoEmpleado.setSalario(sc.nextFloat());

            System.out.println("Introduce comision del empleado: ");
            nuevoEmpleado.setComision(sc.nextFloat());
        } catch (InputMismatchException e) {
            System.out.println("Salario/Comision en formato invalido, debe ser un numero");
            return null;
        }

        System.out.println("Introduce cargo del empleado: ");
        nuevoEmpleado.setCargo(sc.next());

        System.out.println("Introduce el ID del Jefe del empleado: ");
        nuevoEmpleado.setIdJefe(sc.next());

        System.out.println("Introduce el codigo del departamento del empleado: ");
        nuevoEmpleado.setCodDepto(sc.next());

        return nuevoEmpleado;
    }

    private static DepartamentoDTO pedirDatosDepartamentos() {
        DepartamentoDTO nuevoDepartamento = new DepartamentoDTO();

        System.out.println("Introduce codigo del departamento: ");
        nuevoDepartamento.setCodDepto(sc.next());

        System.out.println("Introduce nombre del departamento: ");
        nuevoDepartamento.setNombreDpto(sc.next());

        System.out.println("Introduce ciudad del departamento: ");
        nuevoDepartamento.setCiudad(sc.next());

        System.out.println("Introduce codigo del director del departamento: ");
        nuevoDepartamento.setCodDirector(sc.next());

        return nuevoDepartamento;
    }
}
