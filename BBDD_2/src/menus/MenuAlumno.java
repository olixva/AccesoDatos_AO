package menus;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import dao.AlumnoDAO;
import dto.AlumnoDTO;
import util.Validador;

public class MenuAlumno {
    private static AlumnoDAO alumnoDAO = new AlumnoDAO();

    // Submenu de alumno
    public void mostrarSubMenu(Scanner sc) {

        boolean continuar = true;
        while (continuar) {

            switch (Menu.opciones("Alumno")) {

                case 1:
                    List<AlumnoDTO> alumnos = alumnoDAO.seleccionar();

                    alumnos.forEach(empleado -> {

                        System.out.println("\n" + empleado.toString());

                    });
                    break;

                case 2:
                    AlumnoDTO alumnoNuevo = pedirDatosAlumno(Optional.empty());
                    if (alumnoNuevo != null) {
                        alumnoDAO.insertar(alumnoNuevo);
                    }
                    break;
                case 3:
                    System.out.println("Introduce el nre del alumno: ");
                    String nre = Validador.pedirNumeroRegional();

                    if (alumnoDAO.exist(nre)) {
                        AlumnoDTO alumnoActualizado = pedirDatosAlumno(Optional.of(nre));
                        alumnoActualizado.setNre(nre);
                        alumnoDAO.actualizar(alumnoActualizado);
                    } else {
                        System.out.println("\nERROR: No existe ningun alumno con ese NRE. Pruebe de nuevo");
                    }

                    break;

                case 4:
                    System.out.println("Introduce el NRE del alumno a borrar: ");
                    String nreBorrar = sc.next();

                    AlumnoDTO alumnoBorrar = new AlumnoDTO(nreBorrar);

                    if (alumnoDAO.borrar(alumnoBorrar) == 0) {
                        System.out.println("\nERROR: No existe ningun Alumno con ese NRE, intentelo de nuevo.");
                    }
                    break;

                case 5:
                    continuar = false;
                    break;

                default:
                    break;
            }
        }
    }

    private static AlumnoDTO pedirDatosAlumno(Optional<String> nre) {

        AlumnoDTO nuevoAlumno = new AlumnoDTO();

        if (nre.isEmpty()) {
            System.out.println("Introduce el nre del alumno: ");
            nuevoAlumno.setNre(Validador.pedirNumeroRegional());

            if (alumnoDAO.exist(nuevoAlumno.getNre())) {
                System.out.println("\nERROR: Ya existe un alumno con ese NRE.");
                return null;
            }
        }

        System.out.println("Introduce el dni del alumno: ");
        nuevoAlumno.setDni(Validador.pedirDni());

        System.out.println("Introduce el nombre del alumno: ");
        nuevoAlumno.setNombre(Validador.pedirVarchar());

        System.out.println("Introduce el apellido1 del alumno: ");
        nuevoAlumno.setApellido1(Validador.pedirVarchar());

        System.out.println("Introduce el apellido2 del alumno: ");
        nuevoAlumno.setApellido2(Validador.pedirVarchar());

        System.out.println("Introduce el tipo de via del alumno: ");
        nuevoAlumno.setTipo_via(Validador.pedirVarchar());

        System.out.println("Introduce el nombre de la via del alumno: ");
        nuevoAlumno.setNombre_via(Validador.pedirVarchar());

        System.out.println("Introduce el numero del alumno: ");
        nuevoAlumno.setNumero(Validador.pedirNumeroVarchar());

        System.out.println("Introduce la escalera del alumno: ");
        nuevoAlumno.setEscalera(Validador.pedirNumeroVarchar());

        System.out.println("Introduce el piso del alumno: ");
        nuevoAlumno.setPiso(Validador.pedirNumeroVarchar());

        System.out.println("Introduce la puerta del alumno: ");
        nuevoAlumno.setPuerta(Validador.pedirVarchar());

        System.out.println("Introduce el CP del alumno: ");
        nuevoAlumno.setCp(Validador.pedirCp());

        System.out.println("Introduce el pais del alumno: ");
        nuevoAlumno.setPais(Validador.pedirVarchar());

        System.out.println("Introduce el telefono fijo del alumno: ");
        nuevoAlumno.setTlfn_fijo(Validador.pedirNumeroTelefono());

        System.out.println("Introduce el telefono movil del alumno: ");
        nuevoAlumno.setTlfn_movil(Validador.pedirNumeroTelefono());

        System.out.println("Introduce el email del alumno: ");
        nuevoAlumno.setEmail(Validador.pedirMail());

        System.out.println("Introduce fecha de nacimiento del alumno (AAAA-MM-DD): ");
        nuevoAlumno.setFecha_nac(Validador.pedirFecha());

        System.out.println("Introduce el tutor del alumno: ");
        nuevoAlumno.setTipo_via(Validador.pedirVarchar());

        return nuevoAlumno;
    }
}
