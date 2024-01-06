package App;

import java.util.Scanner;

import datos.AccesoDatosImpl;
import excepciones.ArchivoNoIniciado;
import excepciones.ArchivoYaIniciado;
import negocio.CatalogoPeliculas;
import negocio.CatalogoPeliculasImpl;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int opcion;
    static String nombreArchivo = "resources/peliculas.txt";
    static CatalogoPeliculas catalogo = new CatalogoPeliculasImpl(new AccesoDatosImpl());

    public static void main(String[] args) {

        System.out.println("Bienvenido a la aplicación de catálogo de películas");
        System.out.println("--------------------------------------------------");

        ejecutarMenu();

    }

    public static void ejecutarMenu() {

        do {
            try {
                mostrarMenu();
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        catalogo.iniciarArchivo(nombreArchivo);
                        System.out.println("\nArchivo iniciado correctamente en: " + nombreArchivo);
                        break;
                    case 2:
                        System.out.println("\nIntroduce el nombre de la película a agregar:");
                        String nombrePelicula = sc.nextLine();
                        catalogo.agregarPelicula(nombrePelicula, nombreArchivo);
                        break;
                    case 3:
                        System.out.println("\nListado de películas:");
                        catalogo.listarPeliculas(nombreArchivo);
                        break;
                    case 4:
                        System.out.println("\nIntroduce el nombre de la película a buscar:");
                        String buscar = sc.nextLine();
                        catalogo.buscarPelicula(nombreArchivo, buscar);
                        break;
                    case 5:
                        catalogo.borrarArchivo(nombreArchivo);
                        System.out.println("\nArchivo borrado correctamente");
                        break;
                    case 0:
                        System.out.println("\nHasta pronto!");
                        break;
                    default:
                        System.out.println("\nOpción no reconocida");
                        break;
                }
            } catch (ArchivoNoIniciado | ArchivoYaIniciado e) {
                System.out.println(e.getMessage());
            }
        } while (opcion != 0);

    }

    public static void mostrarMenu() {
        System.out.println("\nElige una opción:\n");
        System.out.println("1.- Iniciar catálogo de películas");
        System.out.println("2.- Agregar película");
        System.out.println("3.- Listar películas");
        System.out.println("4.- Buscar película");
        System.out.println("5.- Borrar catálogo de películas");
        System.out.println("0.- Salir");
    }

}
