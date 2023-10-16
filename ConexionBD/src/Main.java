import java.util.ArrayList;
import java.util.List;

import datos.EmpleadoDAO;
import domain.EmpleadoDTO;

public class Main {
    public static void main(String[] args) {
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        
        List<EmpleadoDTO> empleados = new ArrayList<>();
        
        // for (EmpleadoDTO empleado : empleadoDAO.seleccionar()) {
        //     System.out.println(empleado.toString() + "\n");
        // }

        empleados.forEach(empleado -> {
            System.out.println(empleado);
        });
    }
}
