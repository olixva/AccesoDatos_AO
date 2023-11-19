package menus;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import dao.GrupoDAO;
import dto.GrupoDTO;
import util.Validador;

public class MenuGrupo {
    private static GrupoDAO grupoDAO = new GrupoDAO();

        
     // Submenu de grupo
    public void mostrarSubMenu(Scanner sc) {

        boolean continuar = true;
        while (continuar) {

            switch (Menu.opciones("Grupo")) {

                case 1:
                    List<GrupoDTO> grupos = grupoDAO.seleccionar();

                    grupos.forEach(grupo -> {
                        System.out.println("\n" + grupo.toString());
                    });
                    break;

                case 2:
                    GrupoDTO grupoNuevo = pedirDatosGrupo(Optional.empty());

                    if (grupoNuevo != null) {
                        grupoDAO.insertar(grupoNuevo);
                    }
                    break;

                case 3:
                    System.out.println("Introduce el código del grupo: ");
                    String codigo = Validador.pedirNumeroVarcharMax(2);

                    if (grupoDAO.exist(codigo)) {
                        GrupoDTO grupoActualizado = pedirDatosGrupo(Optional.of(codigo));
                        grupoActualizado.setCod_curso(codigo);
                        grupoDAO.actualizar(grupoActualizado);
                    }else {
                        System.out.println("\nERROR: No existe ningun grupo con ese codigo. Pruebe de nuevo");
                    }
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

    private static GrupoDTO pedirDatosGrupo(Optional<String> codigo) {

        GrupoDTO nuevoGrupo = new GrupoDTO();

        if (codigo.isEmpty()) {
            System.out.println("Introduce el código del grupo: ");
            nuevoGrupo.setCod_grupo(Validador.pedirNumeroVarcharMax(2));

            if (grupoDAO.exist(nuevoGrupo.getCod_grupo())) {
                System.out.println("\nERROR: Ya existe un grupo con ese codigo.");
                return null;
            }
        }

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
}
