package menus;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import dao.DepartamentoDAO;
import dto.DepartamentoDTO;
import util.Validador;

public class MenuDepartamento {
    private static DepartamentoDAO departamentoDAO = new DepartamentoDAO();

    // Submenu de departamento
    public void mostrarSubMenu(Scanner sc) {

        boolean continuar = true;
        while (continuar) {

            switch (Menu.opciones("Departamento")) {

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
                        departamentoActualizado.setCod_departamento(codigo);
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
}
