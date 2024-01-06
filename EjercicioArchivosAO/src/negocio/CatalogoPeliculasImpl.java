package negocio;

import java.util.List;

import datos.AccesoDatos;
import domain.Pelicula;
import excepciones.ArchivoNoIniciado;
import excepciones.ArchivoYaIniciado;

public class CatalogoPeliculasImpl implements CatalogoPeliculas {

    AccesoDatos datos;

    public CatalogoPeliculasImpl(AccesoDatos datos) {
        this.datos = datos;
    }

    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) throws ArchivoNoIniciado {

        Pelicula pelicula = new Pelicula(nombrePelicula);

        if (datos.existe(nombreArchivo)) {
            datos.escribir(pelicula, nombreArchivo, true);
        } else {
            throw new ArchivoNoIniciado(nombreArchivo);
        }

    }

    @Override
    public void listarPeliculas(String nombreArchivo) throws ArchivoNoIniciado {

        if (datos.existe(nombreArchivo)) {
            List<Pelicula> peliculas = datos.listar(nombreArchivo);

            for (Pelicula pelicula : peliculas) {
                System.out.println(pelicula.toString());
            }
        } else {
            throw new ArchivoNoIniciado(nombreArchivo);
        }

    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) throws ArchivoNoIniciado {

        if (datos.existe(nombreArchivo)) {

            String resultadoBusqueda = (datos.buscar(nombreArchivo, buscar) != null)
                    ? "Pelicula encontrada: " + datos.buscar(nombreArchivo, buscar)
                    : "Pelicula no encontrada";

            System.out.println(resultadoBusqueda);

        } else {
            throw new ArchivoNoIniciado(nombreArchivo);
        }

    }

    @Override
    public void iniciarArchivo(String nombreArchivo) throws ArchivoYaIniciado {

        if (!datos.existe(nombreArchivo)) {
            datos.crear(nombreArchivo);
        } else {
            throw new ArchivoYaIniciado(nombreArchivo);
        }
    }

    @Override
    public void borrarArchivo(String nombreArchivo) throws ArchivoNoIniciado {
            
            if (datos.existe(nombreArchivo)) {
                datos.borrar(nombreArchivo);
            } else {
                throw new ArchivoNoIniciado(nombreArchivo);
            }
    }
}
