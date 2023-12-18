package lectura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LecturaArchivos {

    // Metodo para leer un archivo linea por linea y mostrarlo por consola
    public static void lectura(File archivo) {

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));

            String lectura = entrada.readLine();
            while (lectura != null) {
                System.out.println("Lectura: " + lectura);
                lectura = entrada.readLine();
            }

            entrada.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
