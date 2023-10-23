import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import datos.DepartamentoDAO;
import datos.EmpleadoDAO;
import domain.DepartamentoDTO;
import domain.EmpleadoDTO;

public class Main {
    public static void main(String[] args) {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();

        EmpleadoDTO empleadoNuevo = new EmpleadoDTO("11.000.111", "Marcos Chapero", 'V',
                Date.valueOf("2001-02-04"), Date.valueOf("2001-02-04"), 2000f, 100f, "Pringado", "11.111.111", "4300");

        //empleadoDAO.insertar(empleadoNuevo);

        
        //empleadoNuevo.setNombre("Calero MUY Chapero");
        //empleadoDAO.actualizar(empleadoNuevo);

        List<EmpleadoDTO> empleados = empleadoDAO.seleccionar();

        empleados.forEach(empleado -> {
            System.out.println(empleado.toString()); // Listando todos los empleados
        });

        empleadoDAO.borrar(empleadoNuevo);
        empleados = empleadoDAO.seleccionar();
        
        empleados.forEach(empleado -> {
            System.out.println(empleado.toString()); // Listando todos los empleados
        });


        /*DepartamentoDAO departamentoDAO = new DepartamentoDAO();

        List<DepartamentoDTO> departamentos = departamentoDAO.seleccionar();

        departamentos.forEach(departamento -> {
            System.out.println(departamento.toString()); // Listando todos los departamentos
        });*/

    }
}
