package menus;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import dao.AlumnoDAO;
import dao.AsignaturaDAO;
import dao.CursoDAO;
import dto.AlumnoDTO;
import dto.AsignaturaDTO;
import dto.CursoDTO;
import util.Validador;

public class MenuAlumno {
    private static AlumnoDAO alumnoDAO = new AlumnoDAO();
    private static CursoDAO cursoDAO = new CursoDAO();
    private static AsignaturaDAO asignaturaDAO = new AsignaturaDAO();

    // Submenu de alumno
    public void mostrarSubMenu(Scanner sc) {

        boolean continuar = true;
        while (continuar) {

            switch (this.opcionesAlumno(sc)) {

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
                    buscarPorCurso();
                    break;

                case 6:
                    buscarPorAsignatura();
                    break;

                    case 7:
                    buscarPorNombre();
                    break;
                case 8:
                    continuar = false;
                    break;

                default:
                    break;
            }
        }
    }

    private AlumnoDTO pedirDatosAlumno(Optional<String> nre) {

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

    public int opcionesAlumno(Scanner sc) {
        System.out.println("\n---------ALUMNO---------");

        System.out.println("1.- Listar Alumnos");
        System.out.println("2.- Crear Alumno");
        System.out.println("3.- Actualizar Alumno");
        System.out.println("4.- Eliminar Alumno");
        System.out.println("5.- Buscar Alumnos por Codigo de Curso");
        System.out.println("6.- Buscar Alumnos por Codigo de Asignatura");
        System.out.println("7.- Buscar Alumnos por Nombre");
        System.out.println("8.- Volver");

        System.out.print("Elige una opcion: ");
        return sc.nextInt();
    }

    /**
     * La función "buscarPorCurso" muestra una lista de cursos disponibles, solicita
     * al usuario que
     * ingrese un código de curso y luego muestra los estudiantes matriculados en
     * ese curso, si existe.
     */
    private void buscarPorCurso() {

        List<CursoDTO> cursos = cursoDAO.seleccionar();

        cursos.forEach(curso -> {
            System.out.println("\n" + curso.toStringCorto());
        });

        System.out.println("\nIntroduce el código del curso: ");
        String codigo = Validador.pedirNumeroVarcharMax(3);

        if (cursoDAO.exist(codigo)) {
            System.out.println("\nLos alumnos matriculados en el curso con codigo: " + codigo + " son: \n");
            List<AlumnoDTO> alumnosCurso = alumnoDAO.seleccionarPorCurso(codigo);

            for (AlumnoDTO alumno : alumnosCurso) {
                System.out.println(alumno.toStringCorto());
            }

        } else {
            System.out.println("\nERROR: No existe ningun curso con ese codigo. Pruebe de nuevo");
        }
    }

    /**
     * La función "buscarPorAsignatura" permite al usuario buscar estudiantes
     * matriculados en una
     * asignatura específica ingresando el código de la materia.
     */
    private void buscarPorAsignatura() {

        List<AsignaturaDTO> asignaturas = asignaturaDAO.seleccionar();

        asignaturas.forEach(curso -> {
            System.out.println("\n" + curso.toStringCorto());
        });

        System.out.println("\nIntroduce el código de la asignatura: ");
        String codigo = Validador.pedirNumeroVarcharMax(4);

        if (asignaturaDAO.exist(codigo)) {
            System.out.println("\nLos alumnos matriculados en la Asignatura con codigo: " + codigo + " son: \n");
            List<AlumnoDTO> alumnosAsignatura = alumnoDAO.seleccionarPorAsignatura(codigo);

            for (AlumnoDTO alumno : alumnosAsignatura) {
                System.out.println(alumno.toStringCorto());
            }

        } else {
            System.out.println("\nERROR: No existe ninguna asignatura con ese codigo. Pruebe de nuevo");
        }
    }

    /**
     * La función "buscarPorNombre" solicita al usuario que ingrese un nombre o apellido, busca
     * estudiantes con nombres coincidentes en la base de datos e imprime los resultados.
     */
    private void buscarPorNombre() {

        System.out.println("\nIntroduce el nombre o apellido: ");
        String nombre = Validador.pedirVarchar();

        System.out.println("\nLos alumnos que coinciden son: \n");
        List<AlumnoDTO> alumnosNombre = alumnoDAO.seleccionarPorNombre(nombre);

        for (AlumnoDTO alumno : alumnosNombre) {
            System.out.println(alumno.toStringCorto());
        }
    }
}
