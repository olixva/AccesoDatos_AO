package manejo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ManejoArchivos {
    public static void main(String[] args) {

        try {
            File archivo = new File("resources/archivo.txt");
            PrintWriter salida = new PrintWriter(new PrintWriter(archivo));
            salida.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("El archivo se ha creado correctamente");
    }
}
