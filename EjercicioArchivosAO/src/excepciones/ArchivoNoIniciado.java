package excepciones;

public class ArchivoNoIniciado extends Exception {

    public ArchivoNoIniciado(String nombreArchivo) {
        super("El archivo " + nombreArchivo + " no ha sido iniciado.");
    }
}
