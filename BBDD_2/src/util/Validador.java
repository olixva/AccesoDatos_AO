package util;

import java.sql.Date;
import java.util.Scanner;

import dao.CodigopostalDAO;
import dao.DepartamentoDAO;

public class Validador {

    private static Scanner sc = new Scanner(System.in);

    public static String pedirNumeroRegional() {

        String numero;

        boolean terminado = false;
        while (!terminado) {

            numero = sc.next();

            if (numero.matches("^\\d{5,8}$")) {
                terminado = true;
                return numero;
            } else {
                System.out.println("El formato no es valido, pruebe de nuevo:");
            }
        }
        return null;
    }

    public static String pedirNumeroVarchar() {

        String numero;

        boolean terminado = false;
        while (!terminado) {

            numero = sc.next();

            if (numero.matches("\\d+")) {
                terminado = true;
                return numero;
            } else {
                System.out.println("El formato no es valido, pruebe de nuevo:");
            }
        }
        return null;
    }

    public static String pedirNumeroVarchar(int longitud) {
        String numero;
        boolean terminado = false;

        while (!terminado) {

            numero = sc.next();

            if (numero.matches("\\d{" + longitud + "}")) {
                terminado = true;
                return numero;
            } else {
                System.out.println("La longitud del número no es válida, pruebe de nuevo:");
            }
        }
        return null;
    }

    public static String pedirNumeroVarcharMax(int longitudMaxima) {
        String numero;
        boolean terminado = false;

        while (!terminado) {
            numero = sc.next();

            if (numero.matches("\\d{1," + longitudMaxima + "}")) {
                terminado = true;
                return numero;
            } else {
                System.out.println("La longitud del número no es válida, pruebe de nuevo:");
            }
        }
        return null;
    }

    public static String pedirVarchar() {

        String cadena;

        boolean terminado = false;
        while (!terminado) {

            cadena = sc.next();

            if (cadena.matches("^[A-Za-z]+$")) {
                terminado = true;
                return cadena;
            } else {
                System.out.println("El formato no es valido, pruebe de nuevo:");
            }
        }
        return null;
    }

    public static String pedirDni() {

        String dni;

        boolean terminado = false;
        while (!terminado) {

            dni = sc.next();

            if (dni.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
                int numero = Integer.parseInt(dni.substring(0, 8));
                char letraCalculada = calcularLetraDNI(numero);
                char letraIntroducida = dni.charAt(8);

                if (letraCalculada == letraIntroducida) {
                    return dni;
                } else {
                    System.out
                            .println("La letra que has introducido no corresponde a el DNI.\nLa que le corresponde es "
                                    + letraCalculada);
                }
            } else {
                System.out.println("El formato no es valido, pruebe de nuevo:");
            }
        }
        return null;
    }

    public static char calcularLetraDNI(int numero) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indice = numero % 23;
        return letras.charAt(indice);
    }

    public static String pedirCp() {

        CodigopostalDAO cpDao = new CodigopostalDAO(); 
        String cp;

        boolean terminado = false;
        while (!terminado) {

            cp = sc.next();

            if (cp.matches("\\b\\d{5}\\b") && cpDao.exist(cp)) {
                terminado = true;
                return cp;
            } else {
                System.out.println("El formato no es valido, pruebe de nuevo:");
            }
        }
        return null;
    }

    public static String pedirNumeroTelefono() {

        String tel;

        boolean terminado = false;
        while (!terminado) {

            tel = sc.next();

            if (tel.matches("\\d{9}")) {
                terminado = true;
                return tel;
            } else {
                System.out.println("El formato no es valido, pruebe de nuevo:");
            }
        }
        return null;
    }

    public static String pedirMail() {

        String mail;

        boolean terminado = false;
        while (!terminado) {

            mail = sc.next();

            if (mail.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$")) {
                terminado = true;
                return mail;
            } else {
                System.out.println("El formato no es valido, pruebe de nuevo:");
            }
        }
        return null;
    }

    public static Date pedirFecha() {

        String fecha;

        boolean terminado = false;
        while (!terminado) {

            fecha = sc.next();

            if (fecha.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$")) {
                terminado = true;
                return Date.valueOf(fecha);
            } else {
                System.out.println("Fecha en formato invalido, el formato debe ser AAAA-MM-DD\nPruebe de nuevo:");
            }
        }
        return null;
    }

    public static String pedirCodigoDepartamento() {

        DepartamentoDAO dpDao = new DepartamentoDAO(); 
        String codigo;

        boolean terminado = false;
        while (!terminado) {

            codigo = sc.next();

            if (dpDao.exist(codigo)) {
                terminado = true;
                return codigo;
            } else {
                System.out.println("El departamento no existe, pruebe de nuevo");
            }
        }
        return null;
    }

}
