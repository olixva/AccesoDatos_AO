package creacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ManejarArchivo {

    // Metodo para crear un archivo vacio dada una ruta
    public static File crear(String ruta) {
        File archivo = new File(ruta);

        try {
            PrintWriter salida = new PrintWriter(new PrintWriter(archivo));
            salida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("El archivo se ha creado correctamente");
        return archivo;
    }
}
