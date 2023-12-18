package escritura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirInformacion {

    // Metodo para escribir en un archivo, sobreescribe lo que ya hay
    public static void escribirLine(File archivo, String texto) {
        PrintWriter salida;
        try {
            salida = new PrintWriter(archivo);
            salida.println(texto);
            salida.close();

            System.out.println("Se ha escrito correctamente en el archivo");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Metodo para escribir en un archivo, agrega lo que ya hay
    public static void anexarLine(File archivo, String texto) {
        PrintWriter salida;

        try {
            salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(texto);
            salida.close();

            System.out.println("Se ha escrito correctamente en el archivo");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
