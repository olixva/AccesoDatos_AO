import java.util.List;
import java.util.Scanner;

import dao.*;
import dto.*;

public class Menu {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    // Menu general
    public static void menu() {

        System.out.println("1.- Alumno");
        System.out.println("2.- Asignatura");
        System.out.println("3.- Aula");
        System.out.println("4.- Codigo Postal");
        System.out.println("5.- Curso");
        System.out.println("6.- Departamento");
        System.out.println("7.- Edificio");
        System.out.println("8.- Grupo");
        System.out.println("9.- Imparte");
        System.out.println("10.- Matricula");
        System.out.println("11.- Profesor");
        System.out.println("12.- Turno");
        System.out.println("13.- Usuarios");
        System.out.println("0.- Salir");
        System.out.print("Elige una opcion: ");

        int opcion = sc.nextInt();

        boolean continuar = true;
        while (continuar) {

            switch (opcion) {
                case 0:
                    continuar = false;
                    break;
                case 1:
                    subMenuAlumno();
                    break;
                default:
                    break;
            }
        }

    }

    // Opciones generales para todos los submenu
    private static int opciones(String tabla) {
        System.out.println("---------" + tabla + "---------");

        System.out.println("1.- Listar " + tabla);
        System.out.println("2.- Insertar " + tabla);
        System.out.println("3.- Modificar " + tabla);
        System.out.println("4.- Eliminar " + tabla);
        System.out.println("5.- Volver");

        System.out.print("Elige una opcion: ");
        return sc.nextInt();
    }

    // Submenu de alumno
    private static void subMenuAlumno() {
        AlumnoDAO alumnoDAO = new AlumnoDAO();

        boolean continuar = true;
        while (continuar) {

            switch (opciones("Alumno")) {

                case 1:
                    List<AlumnoDTO> alumnos = alumnoDAO.seleccionar();

                    alumnos.forEach(empleado -> {

                        System.out.println(empleado);

                    });
                    break;

                case 2:
                    break;

                case 3:
                    break;

                case 4:
                    System.out.println("introduce el NRE del alumno a borrar: ");
                    String nreBorrar = sc.next();

                    AlumnoDTO alumnoBorrar = new AlumnoDTO(nreBorrar);
                    alumnoDAO.borrar(alumnoBorrar);
                    break;

                case 5:
                    continuar = false;
                    break;

                default:
                    break;
            }
        }
    }

    private static AlumnoDTO pedirDatosAlumno() {

        AlumnoDTO nuevoAlumno = new Alumno();

        System.out.println("Introduce el nre del alumno: ");
        nuevoAlumno.setNre(lectura.next());

        System.out.println("Introduce el dni del alumno: ");
        nuevoAlumno.setDni(lectura.next());

        System.out.println("Introduce el nombre del alumno: ");
        nuevoAlumno.setNombre(lectura.next());

        System.out.println("Introduce el apellido1 del alumno: ");
        nuevoAlumno.setApellido1(lectura.next());

        System.out.println("Introduce el apellido2 del alumno: ");
        nuevoAlumno.setApellido2(lectura.next());

        System.out.println("Introduce el tipo de via del alumno: ");
        nuevoAlumno.setTipo_via(lectura.next());

        System.out.println("Introduce el nombre de la via del alumno: ");
        nuevoAlumno.setNombre_via(lectura.next());

        System.out.println("Introduce el numero del alumno: ");
        nuevoAlumno.setNumero(lectura.next());

        System.out.println("Introduce la escalera del alumno: ");
        nuevoAlumno.setEscalera(lectura.next());

        System.out.println("Introduce el piso del alumno: ");
        nuevoAlumno.setPiso(lectura.next());

        System.out.println("Introduce la puerta del alumno: ");
        nuevoAlumno.setPuerta(lectura.next());

        System.out.println("Introduce el cp del alumno: ");
        nuevoAlumno.setCp(lectura.next());

        System.out.println("Introduce el pais del alumno: ");
        nuevoAlumno.setPais(lectura.next());

        System.out.println("Introduce el telefono fijo del alumno: ");
        nuevoAlumno.setTlfn_fijo(lectura.next());

        System.out.println("Introduce el telefono movil del alumno: ");
        nuevoAlumno.setTlfn_movil(lectura.next());

        System.out.println("Introduce el email del alumno: ");
        nuevoAlumno.setEmail(lectura.next());

        try {
            System.out.println("Introduce fecha de nacimiento del alumno (AAAA-MM-DD): ");
            nuevoAlumno.setFecha_nac(Date.valueOf(lectura.next()));

        } catch (IllegalArgumentException e) {
            System.out.println("Fecha en formato invalido, el formato debe ser AAAA-MM-DD");
            return null;
        }

        System.out.println("Introduce el tutor del alumno: ");
        nuevoAlumno.setTipo_via(lectura.next());

        return nuevoAlumno;
    }

}