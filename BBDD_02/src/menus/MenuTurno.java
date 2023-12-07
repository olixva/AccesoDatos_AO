package menus;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import dao.TurnoDAO;
import dto.TurnoDTO;
import util.Validador;

public class MenuTurno {
    private static TurnoDAO turnoDAO = new TurnoDAO();

    // Submenu de turno
    public void mostrarSubMenu(Scanner sc) {

        boolean continuar = true;
        while (continuar) {

            switch (Menu.opciones("Turno")) {

                case 1:
                    List<TurnoDTO> turnos = turnoDAO.seleccionar();

                    turnos.forEach(turno -> {
                        System.out.println("\n" + turno.toString());
                    });
                    break;

                case 2:
                    TurnoDTO turnoNuevo = pedirDatosTurno(Optional.empty());

                    if (turnoNuevo != null) {
                        turnoDAO.insertar(turnoNuevo);
                    }
                    break;

                case 3:
                    System.out.println("Introduce el código del turno: ");
                    String codigo = Validador.pedirNumeroVarcharMax(2);

                    if (turnoDAO.exist(codigo)) {
                        TurnoDTO turnoActualizado = pedirDatosTurno(Optional.of(codigo));
                        turnoActualizado.setCod_turno(codigo);
                        turnoDAO.actualizar(turnoActualizado);
                    }
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

    private static TurnoDTO pedirDatosTurno(Optional<String> codigo) {

        TurnoDTO nuevoTurno = new TurnoDTO();

        if (codigo.isEmpty()) {
            System.out.println("Introduce el código del turno: ");
            nuevoTurno.setCod_turno(Validador.pedirNumeroVarcharMax(2));

            if (turnoDAO.exist(nuevoTurno.getCod_turno())) {
                System.out.println("\nERROR: Ya existe un turno con ese codigo.");
                return null;
            }
        }

        System.out.println("Introduce el horario del turno: ");
        nuevoTurno.setHorario(Validador.pedirVarchar());

        return nuevoTurno;
    }
}
