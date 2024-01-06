package excepciones;

public class ArchivoYaIniciado extends Exception {

    public ArchivoYaIniciado(String nombreArchivo) {
        super("El archivo " + nombreArchivo + " ya ha sido iniciado.");
    }

}
