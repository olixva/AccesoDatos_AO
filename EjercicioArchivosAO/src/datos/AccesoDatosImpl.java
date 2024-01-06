package datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import domain.Pelicula;

public class AccesoDatosImpl implements AccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) {
        List<Pelicula> peliculas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {

            // Recorrer el archivo y crear las peliculas
            String linea = null;
            while ((linea = br.readLine()) != null) {
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) {

        try (PrintWriter salida = new PrintWriter(new FileWriter(nombreArchivo, anexar))) {
            salida.println(pelicula.toString());
            System.out.println("Se ha escrito información al archivo: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {
        String resultado = null;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {

            // Recorrer el archivo y comprobar si alguna linea coincide con el nombre
            String linea = null;
            int i = 1;
            while ((linea = br.readLine()) != null) {
                if (linea.toLowerCase().contains(buscar.toLowerCase())) {
                    resultado = "Pelicula " + linea + " encontrada en la linea " + i;
                    break;
                }
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) {
        try {
            File archivo = new File(nombreArchivo);
            archivo.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        archivo.delete();
    }

}
