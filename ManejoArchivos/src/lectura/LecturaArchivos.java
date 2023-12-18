package lectura;

import java.io.*;

public class LecturaArchivos {
    public static void lectura() {
        
        try {
            
            File archivo = new File("resources/archivo.txt");
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
