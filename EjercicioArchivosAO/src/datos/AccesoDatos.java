package datos;

import java.util.List;

import domain.Pelicula;

public interface AccesoDatos {

    //Metodos para leer y escribir archivos
    public boolean existe(String nombreArchivo);

    public List<Pelicula> listar(String nombreArchivo);

    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar);

    public String buscar(String nombreArchivo, String buscar);

    //Metodos para crear y borrar archivos
    public void crear(String nombreArchivo);

    public void borrar(String nombreArchivo);
}
