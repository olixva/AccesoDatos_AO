package menus;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import dao.AulaDAO;
import dao.ProfesorDAO;
import dto.AulaDTO;
import dto.ProfesorDTO;
import util.Validador;

public class MenuProfesor {
    private static ProfesorDAO profesorDAO = new ProfesorDAO();
    private static AulaDAO aulaDAO = new AulaDAO();

    // Submenu de profesor
    public void mostrarSubMenu(Scanner sc) {

        boolean continuar = true;
        while (continuar) {

            switch (opcionesProfesor(sc)) {

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
                        profesorActualizado.setNrp(nrp);
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
                    buscarPorAula();
                    break;

                case 6:
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
            System.out.println("Introduce el nrp del profesor: ");
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

    public int opcionesProfesor(Scanner sc) {
        System.out.println("\n---------Profesor---------");

        System.out.println("1.- Listar Profesores");
        System.out.println("2.- Crear Profesor");
        System.out.println("3.- Actualizar Profesor");
        System.out.println("4.- Eliminar Profesor");
        System.out.println("5.- Buscar Profesores por Codigo de Aula");
        System.out.println("6.- Volver");

        System.out.print("Elige una opcion: ");
        return sc.nextInt();
    }

    private void buscarPorAula() {

        List<AulaDTO> aulas = aulaDAO.seleccionar();

        aulas.forEach(aula -> {
            System.out.println("\n" + aula.toStringCorto());
        });

        System.out.println("\nIntroduce el numero del Aula: ");
        String numero = Validador.pedirNumeroVarcharMax(2);

        if (aulaDAO.exist(numero)) {
            System.out.println("\nLos profesores que dan clase en el aula : " + numero + " son: \n");
            List<ProfesorDTO> profesoresAula = profesorDAO.seleccionarPorAula(numero);

            for (ProfesorDTO profesor : profesoresAula) {
                System.out.println(profesor.toStringCorto());
            }

        } else {
            System.out.println("\nERROR: No existe ninguna aula con ese codigo. Pruebe de nuevo");
        }
    }
}
