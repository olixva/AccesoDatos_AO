package menus;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import dao.AsignaturaDAO;
import dto.AsignaturaDTO;
import util.Validador;

public class MenuAsignatura {
    private static AsignaturaDAO asignaturaDAO = new AsignaturaDAO();

    // Submenu de asignatura
    public void mostrarSubMenu(Scanner sc) {

        boolean continuar = true;
        while (continuar) {

            switch (Menu.opciones("Asignatura")) {

                case 1:
                    List<AsignaturaDTO> asignaturas = asignaturaDAO.seleccionar();

                    asignaturas.forEach(asignatura -> {
                        System.out.println("\n" + asignatura.toString());
                    });
                    break;

                case 2:
                    AsignaturaDTO asignaturaNueva = pedirDatosAsignatura(Optional.empty());

                    if (asignaturaNueva != null) {
                        asignaturaDAO.insertar(asignaturaNueva);
                    }
                    break;

                case 3:
                    System.out.println("Introduce el código de la asignatura: ");
                    String codigo = Validador.pedirNumeroVarchar(4);

                    if (asignaturaDAO.exist(codigo)) {
                        AsignaturaDTO asignaturaActualizada = pedirDatosAsignatura(Optional.of(codigo));
                        asignaturaActualizada.setCod_asignatura(codigo);
                        asignaturaDAO.actualizar(asignaturaActualizada);
                    } else {
                        System.out.println("\nERROR: No existe ninguna asignatura con ese codigo. Pruebe de nuevo");
                    }
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

    private static AsignaturaDTO pedirDatosAsignatura(Optional<String> codigo) {

        AsignaturaDTO nuevaAsignatura = new AsignaturaDTO();

        if (codigo.isEmpty()) {
            System.out.println("Introduce el código de la asignatura: ");
            nuevaAsignatura.setCod_asignatura(Validador.pedirNumeroVarchar(4));

            if (asignaturaDAO.exist(nuevaAsignatura.getCod_asignatura())) {
                System.out.println("\nERROR: Ya existe una asignatura con ese codigo.");
                return null;
            }
        }

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
