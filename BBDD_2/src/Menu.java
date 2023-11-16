import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import dao.*;
import dto.*;
import util.Validador;

public class Menu {

    private static Scanner sc = new Scanner(System.in);
    static AlumnoDAO alumnoDAO = new AlumnoDAO();
    static DepartamentoDAO departamentoDAO = new DepartamentoDAO();
    static ProfesorDAO profesorDAO = new ProfesorDAO();
    static AulaDAO aulaDAO = new AulaDAO();
    static CursoDAO cursoDAO = new CursoDAO();
    static TurnoDAO turnoDAO = new TurnoDAO();
    static GrupoDAO grupoDAO = new GrupoDAO();
    static AsignaturaDAO asignaturaDAO = new AsignaturaDAO();

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

    // Submenu de departamento
    private static void subMenuDepartamento() {

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
                    DepartamentoDTO departamentoNuevo = pedirDatosDepartamento(Optional.empty());
                    if (departamentoNuevo != null) {
                        departamentoDAO.insertar(departamentoNuevo);
                    }
                    break;

                case 3:
                    System.out.println("Introduce el codigo del departamento: ");
                    String codigo = Validador.pedirNumeroVarchar(3);

                    if (departamentoDAO.exist(codigo)) {
                        DepartamentoDTO departamentoActualizado = pedirDatosDepartamento(Optional.of(codigo));
                        departamentoDAO.actualizar(departamentoActualizado);
                    } else {
                        System.out.println("\nERROR: No existe ningun alumno con ese NRE. Pruebe de nuevo");
                    }

                    break;

                case 4:
                    System.out.println("Introduce el código del departamento a borrar: ");
                    String codBorrar = sc.next();

                    DepartamentoDTO departamentoBorrar = new DepartamentoDTO(codBorrar);

                    if (departamentoDAO.borrar(departamentoBorrar) == 0) {
                        System.out.println("\nNo existe ningun Departamento con ese codigo, intentelo de nuevo.");
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

    private static DepartamentoDTO pedirDatosDepartamento(Optional<String> codigo) {

        DepartamentoDTO nuevoDepartamento = new DepartamentoDTO();

        if (codigo.isEmpty()) {
            System.out.println("Introduce el código del departamento: ");
            nuevoDepartamento.setCod_departamento(Validador.pedirNumeroVarchar(3));

            if (departamentoDAO.exist(nuevoDepartamento.getCod_departamento())) {
                System.out.println("\nERROR: Ya existe un departamento con ese codigo.");
                return null;
            }
        }

        System.out.println("Introduce el nombre del departamento: ");
        nuevoDepartamento.setNombre(Validador.pedirVarchar());

        System.out.println("Introduce la descripción del departamento: ");
        nuevoDepartamento.setDescripcion(Validador.pedirVarchar());

        return nuevoDepartamento;
    }

    // Submenu de profesor
    private static void subMenuProfesor() {

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
                    ProfesorDTO profesorNuevo = pedirDatosProfesor(Optional.empty());
                    if (profesorNuevo != null) {
                        profesorDAO.insertar(profesorNuevo);
                    }
                    break;

                case 3:
                    System.out.println("Introduce el nrp del profesor: ");
                    String nrp = Validador.pedirNumeroRegional();

                    if (profesorDAO.exist(nrp)) {
                        ProfesorDTO profesorActualizado = pedirDatosProfesor(Optional.of(nrp));
                        profesorDAO.actualizar(profesorActualizado);
                    } else {
                        System.out.println("\nERROR: No existe ningun profesor con ese NRP. Pruebe de nuevo");
                    }

                    break;

                case 4:
                    System.out.println("Introduce el NRP del profesor a borrar: ");
                    String nrpBorrar = sc.next();

                    ProfesorDTO profesorBorrar = new ProfesorDTO(nrpBorrar);

                    if (profesorDAO.borrar(profesorBorrar) == 0) {
                        System.out.println("\nNo existe ningun Profesor con ese NRP, intentelo de nuevo.");
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

    private static ProfesorDTO pedirDatosProfesor(Optional<String> nrp) {

        ProfesorDTO nuevoProfesor = new ProfesorDTO();

        if (nrp.isEmpty()) {
            System.out.println("Introduce el nre del alumno: ");
            nuevoProfesor.setNrp(Validador.pedirNumeroRegional());

            if (profesorDAO.exist(nuevoProfesor.getNrp())) {
                System.out.println("\nERROR: Ya existe un profesor con ese NRP.");
                return null;
            }
        }

        System.out.println("Introduce el DNI del profesor: ");
        nuevoProfesor.setDni(Validador.pedirDni());

        System.out.println("Introduce el nombre del profesor: ");
        nuevoProfesor.setNombre(Validador.pedirVarchar());

        System.out.println("Introduce el apellido1 del profesor: ");
        nuevoProfesor.setApellido1(Validador.pedirVarchar());

        System.out.println("Introduce el apellido2 del profesor: ");
        nuevoProfesor.setApellido2(Validador.pedirVarchar());

        System.out.println("Introduce el tipo de via del profesor: ");
        nuevoProfesor.setTipo_via(Validador.pedirVarchar());

        System.out.println("Introduce el nombre de la via del profesor: ");
        nuevoProfesor.setNombre_via(Validador.pedirVarchar());

        System.out.println("Introduce el numero del profesor: ");
        nuevoProfesor.setNumero(Validador.pedirNumeroVarchar());

        System.out.println("Introduce la escalera del profesor: ");
        nuevoProfesor.setEscalera(Validador.pedirNumeroVarchar());

        System.out.println("Introduce el piso del profesor: ");
        nuevoProfesor.setPiso(Validador.pedirNumeroVarchar());

        System.out.println("Introduce la puerta del profesor: ");
        nuevoProfesor.setPuerta(Validador.pedirVarchar());

        System.out.println("Introduce el CP del profesor: ");
        nuevoProfesor.setCp(Validador.pedirCp());

        System.out.println("Introduce el pais del profesor: ");
        nuevoProfesor.setPais(Validador.pedirVarchar());

        System.out.println("Introduce el telefono fijo del profesor: ");
        nuevoProfesor.setTlfn_fijo(Validador.pedirNumeroTelefono());

        System.out.println("Introduce el telefono movil del profesor: ");
        nuevoProfesor.setTlfn_movil(Validador.pedirNumeroTelefono());

        System.out.println("Introduce el email del profesor: ");
        nuevoProfesor.setEmail(Validador.pedirMail());

        System.out.println("Introduce fecha de nacimiento del profesor (AAAA-MM-DD): ");
        nuevoProfesor.setFecha_nac(Validador.pedirFecha());

        System.out.println("Introduce el código del departamento del profesor: ");
        nuevoProfesor.setCod_departamento(Validador.pedirCodigoDepartamento());

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

                    if (edificioDAO.borrar(edificioBorrar) == 0) {
                        System.out.println("El codigo del edificio no existe, intentelo de nuevo.");
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

    private static EdificioDTO pedirDatosEdificio() {

        EdificioDTO nuevoEdificio = new EdificioDTO();

        System.out.println("Introduce el código del edificio: ");
        nuevoEdificio.setCod_edificio(Validador.pedirNumeroVarcharMax(2));

        System.out.println("Introduce el nombre del edificio: ");
        nuevoEdificio.setNombre(Validador.pedirVarchar());

        return nuevoEdificio;
    }

    // Submenu de aula
    private static void subMenuAula() {

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

                    if (aulaDAO.borrar(aulaBorrar) == 0) {
                        System.out.println("El numero de aula no existe, intentelo de nuevo.");
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

    private static AulaDTO pedirDatosAula() {

        AulaDTO nuevaAula = new AulaDTO();

        System.out.println("Introduce el número de aula: ");
        nuevaAula.setNum_aula(Validador.pedirNumeroVarcharMax(2));

        System.out.println("Introduce el código del edificio: ");
        nuevaAula.setCod_edificio(Validador.pedirCodigoEdificio());

        return nuevaAula;
    }

    // Submenu de curso
    private static void subMenuCurso() {

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

                    if (cursoDAO.borrar(cursoBorrar) == 0) {
                        System.out.println("El codigo del curso no existe, intentelo de nuevo.");
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

    private static CursoDTO pedirDatosCurso() {

        CursoDTO nuevoCurso = new CursoDTO();

        System.out.println("Introduce el código del curso: ");
        nuevoCurso.setCod_curso(Validador.pedirNumeroVarcharMax(3));

        System.out.println("Introduce el nombre del curso: ");
        nuevoCurso.setNombre(Validador.pedirVarchar());

        System.out.println("Introduce la descripción del curso: ");
        nuevoCurso.setDescripcion(Validador.pedirVarchar());

        return nuevoCurso;
    }

    // Submenu de turno
    private static void subMenuTurno() {

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

                    if (turnoDAO.borrar(turnoBorrar) > 1) {
                        System.out.println("El codigo del turno no existe, intentelo de nuevo.");
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

    private static TurnoDTO pedirDatosTurno() {

        TurnoDTO nuevoTurno = new TurnoDTO();

        System.out.println("Introduce el código del turno: ");
        nuevoTurno.setCod_turno(Validador.pedirNumeroVarcharMax(2));

        System.out.println("Introduce el horario del turno: ");
        nuevoTurno.setHorario(Validador.pedirNumeroVarcharMax(6));

        return nuevoTurno;
    }

    // Submenu de grupo
    private static void subMenuGrupo() {

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

                    if (grupoDAO.borrar(grupoBorrar) == 0) {
                        System.out.println("El codigo del grupo no existe, intentelo de nuevo.");
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

    private static GrupoDTO pedirDatosGrupo() {

        GrupoDTO nuevoGrupo = new GrupoDTO();

        System.out.println("Introduce el código del grupo: ");
        nuevoGrupo.setCod_grupo(Validador.pedirNumeroVarcharMax(2));

        System.out.println("Introduce el código del curso: ");
        nuevoGrupo.setCod_curso(Validador.pedirCodigoCurso());

        System.out.println("Introduce el nombre del grupo: ");
        nuevoGrupo.setNombre(Validador.pedirVarchar());

        System.out.println("Introduce el código del turno: ");
        nuevoGrupo.setCod_turno(Validador.pedirCodigoTurno());

        System.out.println("Introduce el número máximo de alumnos: ");
        nuevoGrupo.setnMaxAlumnos(Validador.pedirNumeroInt());

        return nuevoGrupo;
    }

    // Submenu de asignatura
    private static void subMenuAsignatura() {

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

                    if (asignaturaDAO.borrar(asignaturaBorrar) == 0) {
                        System.out.println("El codigo de la asignatura no existe, intentelo de nuevo.");
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

    private static AsignaturaDTO pedirDatosAsignatura() {

        AsignaturaDTO nuevaAsignatura = new AsignaturaDTO();

        System.out.println("Introduce el código de la asignatura: ");
        nuevaAsignatura.setCod_asignatura(Validador.pedirNumeroVarchar(4));

        System.out.println("Introduce el código interno de la asignatura: ");
        nuevaAsignatura.setCod_interno(Validador.pedirNumeroVarchar(4));

        System.out.println("Introduce la descripción de la asignatura: ");
        nuevaAsignatura.setDescripcion(Validador.pedirVarchar());

        System.out.println("Introduce el número de horas de la asignatura: ");
        nuevaAsignatura.setnHoras(Validador.pedirNumeroInt());

        System.out.println("Introduce el código del curso de la asignatura: ");
        nuevaAsignatura.setCod_curso(Validador.pedirCodigoCurso());

        return nuevaAsignatura;
    }
}