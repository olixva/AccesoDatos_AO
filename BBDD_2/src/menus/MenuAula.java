package menus;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import dao.AulaDAO;
import dto.AulaDTO;
import util.Validador;

public class MenuAula {
    private static AulaDAO aulaDAO = new AulaDAO();

    // Submenu de aula
    public void mostrarSubMenu(Scanner sc) {

        boolean continuar = true;
        while (continuar) {

            switch (Menu.opciones("Aula")) {

                case 1:
                    List<AulaDTO> aulas = aulaDAO.seleccionar();

                    aulas.forEach(aula -> {
                        System.out.println("\n" + aula.toString());
                    });
                    break;

                case 2:
                    AulaDTO aulaNueva = pedirDatosAula(Optional.empty());

                    if (aulaNueva != null) {
                        aulaDAO.insertar(aulaNueva);
                    }
                    break;

                case 3:
                    System.out.println("Introduce el número de aula: ");
                    String numero = Validador.pedirNumeroVarcharMax(2);

                    if (aulaDAO.exist(numero)) {
                        AulaDTO aulaActualizada = pedirDatosAula(Optional.of(numero));
                        aulaActualizada.setNum_aula(numero);
                        aulaDAO.actualizar(aulaActualizada);
                    } else {
                        System.out.println("\nERROR: No existe ningun aula con ese codigo. Pruebe de nuevo");
                    }
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

    private static AulaDTO pedirDatosAula(Optional<String> codigo) {

        AulaDTO nuevaAula = new AulaDTO();
        if (codigo.isEmpty()) {
            System.out.println("Introduce el número de aula: ");
            nuevaAula.setNum_aula(Validador.pedirNumeroVarcharMax(2));

            if (aulaDAO.exist(nuevaAula.getNum_aula())) {
                System.out.println("\nERROR: Ya existe un aula con ese codigo.");
                return null;
            }
        }

        System.out.println("Introduce el código del edificio: ");
        nuevaAula.setCod_edificio(Validador.pedirCodigoEdificio());

        return nuevaAula;
    }
}
