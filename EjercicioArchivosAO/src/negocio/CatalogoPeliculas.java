package negocio;

import excepciones.ArchivoNoIniciado;
import excepciones.ArchivoYaIniciado;

public interface CatalogoPeliculas {

    public void agregarPelicula(String nombrePelicula, String nombreArchivo) throws ArchivoNoIniciado;

    public void listarPeliculas(String nombreArchivo) throws ArchivoNoIniciado;

    public void buscarPelicula(String nombreArchivo, String buscar) throws ArchivoNoIniciado;

    public void iniciarArchivo(String nombreArchivo) throws ArchivoYaIniciado;

    public void borrarArchivo(String nombreArchivo) throws ArchivoNoIniciado;
}
