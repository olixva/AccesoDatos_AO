import java.sql.Date;
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
        boolean continuar = true;

        while (continuar) {
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

            int opcion = sc.nextInt();

            switch (opcion) {
                case 0:
                    continuar = false;
                    break;
                case 1:
                    subMenuAlumno();
                    break;

                case 2:
                    subMenuDepartamento();
                    break;

                case 3:
                    subMenuProfesor();
                    break;

                case 4:
                    subMenuEdificio();
                    break;

                case 5:
                    subMenuAula();
                    break;

                case 6:
                    subMenuCurso();
                    break;

                case 7:
                    subMenuTurno();
                    break;

                case 8:
                    subMenuGrupo();
                    break;

                case 9:
                    subMenuAsignatura();
                    break;
                default:
                    break;
            }
        }

    }

    // Opciones generales para todos los submenu
    private static int opciones(String tabla) {
        System.out.println("\n---------" + tabla + "---------");

        System.out.println("1.- Listar " + tabla);
        System.out.println("2.- Crear " + tabla);
        System.out.println("3.- Actualizar " + tabla);
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

                        System.out.println("\n" + empleado.toString());

                    });
                    break;

                case 2:
                    AlumnoDTO alumnoNuevo = pedirDatosAlumno();
                    alumnoDAO.insertar(alumnoNuevo);
                    break;
                case 3:
                    AlumnoDTO alumnoActualizado = pedirDatosAlumno();
                    alumnoDAO.actualizar(alumnoActualizado);
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

        AlumnoDTO nuevoAlumno = new AlumnoDTO();

        System.out.println("Introduce el nre del alumno: ");
        nuevoAlumno.setNre(sc.next());

        System.out.println("Introduce el dni del alumno: ");
        nuevoAlumno.setDni(sc.next());

        System.out.println("Introduce el nombre del alumno: ");
        nuevoAlumno.setNombre(sc.next());

        System.out.println("Introduce el apellido1 del alumno: ");
        nuevoAlumno.setApellido1(sc.next());

        System.out.println("Introduce el apellido2 del alumno: ");
        nuevoAlumno.setApellido2(sc.next());

        System.out.println("Introduce el tipo de via del alumno: ");
        nuevoAlumno.setTipo_via(sc.next());

        System.out.println("Introduce el nombre de la via del alumno: ");
        nuevoAlumno.setNombre_via(sc.next());

        System.out.println("Introduce el numero del alumno: ");
        nuevoAlumno.setNumero(sc.next());

        System.out.println("Introduce la escalera del alumno: ");
        nuevoAlumno.setEscalera(sc.next());

        System.out.println("Introduce el piso del alumno: ");
        nuevoAlumno.setPiso(sc.next());

        System.out.println("Introduce la puerta del alumno: ");
        nuevoAlumno.setPuerta(sc.next());

        System.out.println("Introduce el CP del alumno: ");
        nuevoAlumno.setCp(sc.next());

        System.out.println("Introduce el pais del alumno: ");
        nuevoAlumno.setPais(sc.next());

        System.out.println("Introduce el telefono fijo del alumno: ");
        nuevoAlumno.setTlfn_fijo(sc.next());

        System.out.println("Introduce el telefono movil del alumno: ");
        nuevoAlumno.setTlfn_movil(sc.next());

        System.out.println("Introduce el email del alumno: ");
        nuevoAlumno.setEmail(sc.next());

        try {
            System.out.println("Introduce fecha de nacimiento del alumno (AAAA-MM-DD): ");
            nuevoAlumno.setFecha_nac(Date.valueOf(sc.next()));

        } catch (IllegalArgumentException e) {
            System.out.println("Fecha en formato invalido, el formato debe ser AAAA-MM-DD");
            return null;
        }

        System.out.println("Introduce el tutor del alumno: ");
        nuevoAlumno.setTipo_via(sc.next());

        return nuevoAlumno;
    }

    // Submenu de departamento
    private static void subMenuDepartamento() {
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();

        boolean continuar = true;
        while (continuar) {

            switch (opciones("Departamento")) {

                case 1:
                    List<DepartamentoDTO> departamentos = departamentoDAO.seleccionar();

                    departamentos.forEach(departamento -> {
                        System.out.println("\n" + departamento.toString());
                    });
                    break;

                case 2:
                    DepartamentoDTO departamentoNuevo = pedirDatosDepartamento();
                    departamentoDAO.insertar(departamentoNuevo);
                    break;

                case 3:
                    DepartamentoDTO departamentoActualizado = pedirDatosDepartamento();
                    departamentoDAO.actualizar(departamentoActualizado);
                    break;

                case 4:
                    System.out.println("Introduce el código del departamento a borrar: ");
                    String codBorrar = sc.next();

                    DepartamentoDTO departamentoBorrar = new DepartamentoDTO(codBorrar);
                    departamentoDAO.borrar(departamentoBorrar);
                    break;

                case 5:
                    continuar = false;
                    break;

                default:
                    break;
            }
        }
    }

    private static DepartamentoDTO pedirDatosDepartamento() {

        DepartamentoDTO nuevoDepartamento = new DepartamentoDTO();

        System.out.println("Introduce el código del departamento: ");
        nuevoDepartamento.setCod_departamento(sc.next());

        System.out.println("Introduce el nombre del departamento: ");
        nuevoDepartamento.setNombre(sc.next());

        System.out.println("Introduce la descripción del departamento: ");
        nuevoDepartamento.setDescripcion(sc.next());

        return nuevoDepartamento;
    }

    // Submenu de profesor
    private static void subMenuProfesor() {
        ProfesorDAO profesorDAO = new ProfesorDAO();

        boolean continuar = true;
        while (continuar) {

            switch (opciones("Profesor")) {

                case 1:
                    List<ProfesorDTO> profesores = profesorDAO.seleccionar();

                    profesores.forEach(profesor -> {
                        System.out.println("\n" + profesor.toString());
                    });
                    break;

                case 2:
                    ProfesorDTO profesorNuevo = pedirDatosProfesor();
                    profesorDAO.insertar(profesorNuevo);
                    break;

                case 3:
                    ProfesorDTO profesorActualizado = pedirDatosProfesor();
                    profesorDAO.actualizar(profesorActualizado);
                    break;

                case 4:
                    System.out.println("Introduce el NRP del profesor a borrar: ");
                    String nrpBorrar = sc.next();

                    ProfesorDTO profesorBorrar = new ProfesorDTO(nrpBorrar);
                    profesorDAO.borrar(profesorBorrar);
                    break;

                case 5:
                    continuar = false;
                    break;

                default:
                    break;
            }
        }
    }

    private static ProfesorDTO pedirDatosProfesor() {

        ProfesorDTO nuevoProfesor = new ProfesorDTO();

        System.out.println("Introduce el NRP del profesor: ");
        nuevoProfesor.setNrp(sc.next());

        System.out.println("Introduce el DNI del profesor: ");
        nuevoProfesor.setDni(sc.next());

        System.out.println("Introduce el nombre del profesor: ");
        nuevoProfesor.setNombre(sc.next());

        System.out.println("Introduce el apellido1 del profesor: ");
        nuevoProfesor.setApellido1(sc.next());

        System.out.println("Introduce el apellido2 del profesor: ");
        nuevoProfesor.setApellido2(sc.next());

        System.out.println("Introduce el tipo de via del profesor: ");
        nuevoProfesor.setTipo_via(sc.next());

        System.out.println("Introduce el nombre de la via del profesor: ");
        nuevoProfesor.setNombre_via(sc.next());

        System.out.println("Introduce el numero del profesor: ");
        nuevoProfesor.setNumero(sc.next());

        System.out.println("Introduce la escalera del profesor: ");
        nuevoProfesor.setEscalera(sc.next());

        System.out.println("Introduce el piso del profesor: ");
        nuevoProfesor.setPiso(sc.next());

        System.out.println("Introduce la puerta del profesor: ");
        nuevoProfesor.setPuerta(sc.next());

        System.out.println("Introduce el CP del profesor: ");
        nuevoProfesor.setCp(sc.next());

        System.out.println("Introduce el pais del profesor: ");
        nuevoProfesor.setPais(sc.next());

        System.out.println("Introduce el telefono fijo del profesor: ");
        nuevoProfesor.setTlfn_fijo(sc.next());

        System.out.println("Introduce el telefono movil del profesor: ");
        nuevoProfesor.setTlfn_movil(sc.next());

        System.out.println("Introduce el email del profesor: ");
        nuevoProfesor.setEmail(sc.next());

        try {
            System.out.println("Introduce fecha de nacimiento del profesor (AAAA-MM-DD): ");
            nuevoProfesor.setFecha_nac(Date.valueOf(sc.next()));

        } catch (IllegalArgumentException e) {
            System.out.println("Fecha en formato invalido, el formato debe ser AAAA-MM-DD");
            return null;
        }

        System.out.println("Introduce el código del departamento del profesor: ");
        nuevoProfesor.setCod_departamento(sc.next());

        return nuevoProfesor;
    }

    // Submenu de edificio
    private static void subMenuEdificio() {
        EdificioDAO edificioDAO = new EdificioDAO();

        boolean continuar = true;
        while (continuar) {

            switch (opciones("Edificio")) {

                case 1:
                    List<EdificioDTO> edificios = edificioDAO.seleccionar();

                    edificios.forEach(edificio -> {
                        System.out.println("\n" + edificio.toString());
                    });
                    break;

                case 2:
                    EdificioDTO edificioNuevo = pedirDatosEdificio();
                    edificioDAO.insertar(edificioNuevo);
                    break;

                case 3:
                    EdificioDTO edificioActualizado = pedirDatosEdificio();
                    edificioDAO.actualizar(edificioActualizado);
                    break;

                case 4:
                    System.out.println("Introduce el código del edificio a borrar: ");
                    String codEdificioBorrar = sc.next();

                    EdificioDTO edificioBorrar = new EdificioDTO(codEdificioBorrar);
                    edificioDAO.borrar(edificioBorrar);
                    break;

                case 5:
                    continuar = false;
                    break;

                default:
                    break;
            }
        }
    }

    private static EdificioDTO pedirDatosEdificio() {

        EdificioDTO nuevoEdificio = new EdificioDTO();

        System.out.println("Introduce el código del edificio: ");
        nuevoEdificio.setCod_edificio(sc.next());

        System.out.println("Introduce el nombre del edificio: ");
        nuevoEdificio.setNombre(sc.next());

        return nuevoEdificio;
    }

    // Submenu de aula
    private static void subMenuAula() {
        AulaDAO aulaDAO = new AulaDAO();

        boolean continuar = true;
        while (continuar) {

            switch (opciones("Aula")) {

                case 1:
                    List<AulaDTO> aulas = aulaDAO.seleccionar();

                    aulas.forEach(aula -> {
                        System.out.println("\n" + aula.toString());
                    });
                    break;

                case 2:
                    AulaDTO aulaNueva = pedirDatosAula();
                    aulaDAO.insertar(aulaNueva);
                    break;

                case 3:
                    AulaDTO aulaActualizada = pedirDatosAula();
                    aulaDAO.actualizar(aulaActualizada);
                    break;

                case 4:
                    System.out.println("Introduce el número de aula a borrar: ");
                    String numAulaBorrar = sc.next();

                    AulaDTO aulaBorrar = new AulaDTO(numAulaBorrar);
                    aulaDAO.borrar(aulaBorrar);
                    break;

                case 5:
                    continuar = false;
                    break;

                default:
                    break;
            }
        }
    }

    private static AulaDTO pedirDatosAula() {

        AulaDTO nuevaAula = new AulaDTO();

        System.out.println("Introduce el número de aula: ");
        nuevaAula.setNum_aula(sc.next());

        System.out.println("Introduce el código del edificio: ");
        nuevaAula.setCod_edificio(sc.next());

        return nuevaAula;
    }

    // Submenu de curso
    private static void subMenuCurso() {
        CursoDAO cursoDAO = new CursoDAO();

        boolean continuar = true;
        while (continuar) {

            switch (opciones("Curso")) {

                case 1:
                    List<CursoDTO> cursos = cursoDAO.seleccionar();

                    cursos.forEach(curso -> {
                        System.out.println("\n" + curso.toString());
                    });
                    break;

                case 2:
                    CursoDTO cursoNuevo = pedirDatosCurso();
                    cursoDAO.insertar(cursoNuevo);
                    break;

                case 3:
                    CursoDTO cursoActualizado = pedirDatosCurso();
                    cursoDAO.actualizar(cursoActualizado);
                    break;

                case 4:
                    System.out.println("Introduce el código del curso a borrar: ");
                    String codCursoBorrar = sc.next();

                    CursoDTO cursoBorrar = new CursoDTO(codCursoBorrar);
                    cursoDAO.borrar(cursoBorrar);
                    break;

                case 5:
                    continuar = false;
                    break;

                default:
                    break;
            }
        }
    }

    private static CursoDTO pedirDatosCurso() {

        CursoDTO nuevoCurso = new CursoDTO();

        System.out.println("Introduce el código del curso: ");
        nuevoCurso.setCod_curso(sc.next());

        System.out.println("Introduce el nombre del curso: ");
        nuevoCurso.setNombre(sc.next());

        System.out.println("Introduce la descripción del curso: ");
        nuevoCurso.setDescripcion(sc.next());

        return nuevoCurso;
    }

    // Submenu de turno
    private static void subMenuTurno() {
        TurnoDAO turnoDAO = new TurnoDAO();

        boolean continuar = true;
        while (continuar) {

            switch (opciones("Turno")) {

                case 1:
                    List<TurnoDTO> turnos = turnoDAO.seleccionar();

                    turnos.forEach(turno -> {
                        System.out.println("\n" + turno.toString());
                    });
                    break;

                case 2:
                    TurnoDTO turnoNuevo = pedirDatosTurno();
                    turnoDAO.insertar(turnoNuevo);
                    break;

                case 3:
                    TurnoDTO turnoActualizado = pedirDatosTurno();
                    turnoDAO.actualizar(turnoActualizado);
                    break;

                case 4:
                    System.out.println("Introduce el código del turno a borrar: ");
                    String codTurnoBorrar = sc.next();

                    TurnoDTO turnoBorrar = new TurnoDTO(codTurnoBorrar);
                    turnoDAO.borrar(turnoBorrar);
                    break;

                case 5:
                    continuar = false;
                    break;

                default:
                    break;
            }
        }
    }

    private static TurnoDTO pedirDatosTurno() {

        TurnoDTO nuevoTurno = new TurnoDTO();

        System.out.println("Introduce el código del turno: ");
        nuevoTurno.setCod_turno(sc.next());

        System.out.println("Introduce el horario del turno: ");
        nuevoTurno.setHorario(sc.next());

        return nuevoTurno;
    }

    // Submenu de grupo
    private static void subMenuGrupo() {
        GrupoDAO grupoDAO = new GrupoDAO();

        boolean continuar = true;
        while (continuar) {

            switch (opciones("Grupo")) {

                case 1:
                    List<GrupoDTO> grupos = grupoDAO.seleccionar();

                    grupos.forEach(grupo -> {
                        System.out.println("\n" + grupo.toString());
                    });
                    break;

                case 2:
                    GrupoDTO grupoNuevo = pedirDatosGrupo();
                    grupoDAO.insertar(grupoNuevo);
                    break;

                case 3:
                    GrupoDTO grupoActualizado = pedirDatosGrupo();
                    grupoDAO.actualizar(grupoActualizado);
                    break;

                case 4:
                    System.out.println("Introduce el código del grupo a borrar: ");
                    String codGrupoBorrar = sc.next();

                    GrupoDTO grupoBorrar = new GrupoDTO(codGrupoBorrar);
                    grupoDAO.borrar(grupoBorrar);
                    break;

                case 5:
                    continuar = false;
                    break;

                default:
                    break;
            }
        }
    }

    private static GrupoDTO pedirDatosGrupo() {

        GrupoDTO nuevoGrupo = new GrupoDTO();

        System.out.println("Introduce el código del grupo: ");
        nuevoGrupo.setCod_grupo(sc.next());

        System.out.println("Introduce el código del curso: ");
        nuevoGrupo.setCod_curso(sc.next());

        System.out.println("Introduce el nombre del grupo: ");
        nuevoGrupo.setNombre(sc.next());

        System.out.println("Introduce el código del turno: ");
        nuevoGrupo.setCod_turno(sc.next());

        System.out.println("Introduce el número máximo de alumnos: ");
        nuevoGrupo.setnMaxAlumnos(sc.nextInt());

        return nuevoGrupo;
    }

    // Submenu de asignatura
    private static void subMenuAsignatura() {
        AsignaturaDAO asignaturaDAO = new AsignaturaDAO();

        boolean continuar = true;
        while (continuar) {

            switch (opciones("Asignatura")) {

                case 1:
                    List<AsignaturaDTO> asignaturas = asignaturaDAO.seleccionar();

                    asignaturas.forEach(asignatura -> {
                        System.out.println("\n" + asignatura.toString());
                    });
                    break;

                case 2:
                    AsignaturaDTO asignaturaNueva = pedirDatosAsignatura();
                    asignaturaDAO.insertar(asignaturaNueva);
                    break;

                case 3:
                    AsignaturaDTO asignaturaActualizada = pedirDatosAsignatura();
                    asignaturaDAO.actualizar(asignaturaActualizada);
                    break;

                case 4:
                    System.out.println("Introduce el código de la asignatura a borrar: ");
                    String codAsignaturaBorrar = sc.next();

                    AsignaturaDTO asignaturaBorrar = new AsignaturaDTO(codAsignaturaBorrar);
                    asignaturaDAO.borrar(asignaturaBorrar);
                    break;

                case 5:
                    continuar = false;
                    break;

                default:
                    break;
            }
        }
    }

    private static AsignaturaDTO pedirDatosAsignatura() {

        AsignaturaDTO nuevaAsignatura = new AsignaturaDTO();

        System.out.println("Introduce el código de la asignatura: ");
        nuevaAsignatura.setCod_asignatura(sc.next());

        System.out.println("Introduce el código interno de la asignatura: ");
        nuevaAsignatura.setCod_interno(sc.next());

        System.out.println("Introduce la descripción de la asignatura: ");
        nuevaAsignatura.setDescripcion(sc.next());

        System.out.println("Introduce el número de horas de la asignatura: ");
        nuevaAsignatura.setnHoras(sc.nextInt());

        System.out.println("Introduce el código del curso de la asignatura: ");
        nuevaAsignatura.setCod_curso(sc.next());

        return nuevaAsignatura;
    }
}