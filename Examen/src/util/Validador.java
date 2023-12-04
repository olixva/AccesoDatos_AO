package util;

import java.util.Scanner;


public class Validador {

    private static Scanner sc = new Scanner(System.in);

    
    /**
     * La función "pedir" toma una expresión regular y un mensaje como entrada, solicita la entrada al
     * usuario hasta que la entrada coincida con la expresión regular y devuelve la entrada válida.
     * 
     * @param regex El patrón de expresión regular con el que debe coincidir la entrada.
     * @param mensaje El parámetro "mensaje" es una cadena que representa el mensaje que se mostrará
     * cuando el usuario ingresa una entrada no válida.
     * @return El método devuelve un valor de cadena.
     */
    private static String pedir(String regex, String mensaje) {

        String entrada;

        boolean terminado = false;
        while (!terminado) {

            entrada = sc.next();

            if (entrada.matches(regex)) {
                terminado = true;
                return entrada;
            } else {
                System.out.println(mensaje);
            }
        }
        return null;
    }
    

    //Funcion que pide un codigo de producto con al minimo 4 caracteres y al maximo 6
    
    public static String pedirCodigoProducto() {
        String regex = "[a-zA-Z0-9]{4,6}";
        String mensaje = "Error: El codigo del producto debe tener entre 4 y 6 caracteres alfanumericos.";
        return pedir(regex, mensaje);
    }

    //Funcion que pide una fecha en formato AAAA-MM-DD

    public static String pedirFecha() {
        String regex = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
        String mensaje = "Error: La fecha debe tener el formato AAAA-MM-DD.";
        return pedir(regex, mensaje);
    }
}
