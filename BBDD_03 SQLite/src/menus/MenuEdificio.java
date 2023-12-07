package menus;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import dao.EdificioDAO;
import dto.EdificioDTO;
import util.Validador;

public class MenuEdificio {
    private static EdificioDAO edificioDAO = new EdificioDAO();

    // Submenu de edificio
    public void mostrarSubMenu(Scanner sc) {

        boolean continuar = true;
        while (continuar) {

            switch (Menu.opciones("Edificio")) {

                case 1:
                    List<EdificioDTO> edificios = edificioDAO.seleccionar();

                    edificios.forEach(edificio -> {
                        System.out.println("\n" + edificio.toString());
                    });
                    break;

                case 2:
                    EdificioDTO edificioNuevo = pedirDatosEdificio(Optional.empty());
                    if (edificioNuevo != null) {
                        edificioDAO.insertar(edificioNuevo);
                    }
                    break;

                case 3:

                    System.out.println("Introduce el código del edificio: ");
                    String codigo = Validador.pedirNumeroVarcharMax(2);

                    if (edificioDAO.exist(codigo)) {
                        EdificioDTO edificioActualizado = pedirDatosEdificio(Optional.of(codigo));
                        edificioActualizado.setCod_edificio(codigo);
                        edificioDAO.actualizar(edificioActualizado);
                    } else {
                        System.out.println("\nERROR: No existe ningun departamento con ese codigo. Pruebe de nuevo");
                    }

                    break;

                case 4:
                    System.out.println("Introduce el codigo del edificio a borrar: ");
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

    private static EdificioDTO pedirDatosEdificio(Optional<String> codigo) {

        EdificioDTO nuevoEdificio = new EdificioDTO();

        if (codigo.isEmpty()) {
            System.out.println("Introduce el código del edificio: ");
            nuevoEdificio.setCod_edificio(Validador.pedirNumeroVarcharMax(2));

            if (edificioDAO.exist(nuevoEdificio.getCod_edificio())) {
                System.out.println("\nERROR: Ya existe un alumno con ese NRE.");
                return null;
            }
        }

        System.out.println("Introduce el nombre del edificio: ");
        nuevoEdificio.setNombre(Validador.pedirVarchar());

        return nuevoEdificio;
    }
}
