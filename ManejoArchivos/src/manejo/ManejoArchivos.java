package manejo;

import java.io.File;

import escritura.EscribirInformacion;
import lectura.LecturaArchivos;
import creacion.ManejarArchivo;

public class ManejoArchivos {
    public static void main(String[] args) {
        File archivo = ManejarArchivo.crear("resources/prueba.txt");

        EscribirInformacion.escribirLine(archivo, "Calero el chapero");
        EscribirInformacion.anexarLine(archivo, "es muy chapero");

        LecturaArchivos.lectura(archivo);
    }
}
