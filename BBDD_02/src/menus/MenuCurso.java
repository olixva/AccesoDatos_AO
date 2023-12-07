package menus;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import dao.CursoDAO;
import dto.CursoDTO;
import util.Validador;

public class MenuCurso {
    private static CursoDAO cursoDAO = new CursoDAO();

    // Submenu de curso
    public void mostrarSubMenu(Scanner sc) {

        boolean continuar = true;
        while (continuar) {

            switch (Menu.opciones("Curso")) {

                case 1:
                    List<CursoDTO> cursos = cursoDAO.seleccionar();

                    cursos.forEach(curso -> {
                        System.out.println("\n" + curso.toString());
                    });
                    break;

                case 2:

                    CursoDTO cursoNuevo = pedirDatosCurso(Optional.empty());
                    if (cursoNuevo != null) {
                        cursoDAO.insertar(cursoNuevo);
                    }
                    break;

                case 3:
                    System.out.println("Introduce el código del curso: ");
                    String codigo = Validador.pedirNumeroVarcharMax(3);

                    if (cursoDAO.exist(codigo)) {
                        CursoDTO cursoActualizado = pedirDatosCurso(Optional.of(codigo));
                        cursoActualizado.setCod_curso(codigo);
                        cursoDAO.actualizar(cursoActualizado);
                    } else {
                        System.out.println("\nERROR: No existe ningun curso con ese codigo. Pruebe de nuevo");
                    }

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

    private static CursoDTO pedirDatosCurso(Optional<String> codigo) {

        CursoDTO nuevoCurso = new CursoDTO();

        if (codigo.isEmpty()) {
            System.out.println("Introduce el código del curso: ");
            nuevoCurso.setCod_curso(Validador.pedirNumeroVarcharMax(3));

            if (cursoDAO.exist(nuevoCurso.getCod_curso())) {
                System.out.println("\nERROR: Ya existe un curso con ese codigo.");
                return null;
            }
        }

        System.out.println("Introduce el nombre del curso: ");
        nuevoCurso.setNombre(Validador.pedirVarchar());

        System.out.println("Introduce la descripción del curso: ");
        nuevoCurso.setDescripcion(Validador.pedirVarchar());

        return nuevoCurso;
    }
}
