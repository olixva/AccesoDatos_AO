package menus;

import java.util.List;
import java.util.Scanner;

import dao.GamaDAO;
import dao.ProductoDAO;
import dto.ProductoDTO;
import util.Validador;

public class MenuProducto {
    private static ProductoDAO productoDAO = new ProductoDAO();

    // Submenu de Producto
    public void mostrarSubMenu(Scanner sc) {

        boolean continuar = true;
        while (continuar) {

            switch (this.opcionesProducto(sc)) {

                case 1:
                    insertarProducto(sc);
                    break;
                case 0:
                    continuar = false;
                    break;

                default:
                    break;
            }
        }
    }

    public int opcionesProducto(Scanner sc) {
        System.out.println("\n---------Producto---------");

        System.out.println("1.- Insertar producto");
        System.out.println("0.- Volver");

        System.out.print("Elige una opcion: ");
        return sc.nextInt();
    }

    // Funciones de Producto

    private void insertarProducto(Scanner sc) {

        ProductoDTO producto = pedirDatosProducto(sc);

        int registros = productoDAO.insertar(producto);

        System.out.println("\nREGISTROS INSERTADOS: " + registros);
    }

    private ProductoDTO pedirDatosProducto(Scanner sc) {

        ProductoDTO producto = new ProductoDTO();

        System.out.print("Introduce el codigo del producto: ");
        producto.setCodigoProducto(Validador.pedirCodigoProducto());
        System.out.print("Introduce el nombre del producto: ");
        producto.setNombre(sc.next());
        pedirGama(sc, producto);
        System.out.print("Introduce las dimensiones del producto: ");
        producto.setDimensiones(sc.next());
        System.out.print("Introduce el proveedor del producto: ");
        producto.setProveedor(sc.next());
        System.out.print("Introduce la descripcion del producto: ");
        producto.setDescripcion(sc.next());
        System.out.print("Introduce la cantidad en stock del producto (Entero): ");
        producto.setCantidadEnStock(sc.nextInt());
        System.out.print("Introduce el precio de venta del producto (Decimal): ");
        double precioVenta = sc.nextDouble();
        producto.setPrecioVenta(precioVenta);

        System.out.print("Introduce el precio del proveedor del producto (Decimal): ");
        double precioProveedor = sc.nextDouble();

        while (precioVenta < precioProveedor) {
            System.out.println("El precio del proveedor no puede ser mayor que el precio de venta, introducelo de nuevo");
            precioProveedor = sc.nextDouble();
        }
        producto.setPrecioProveedor(precioProveedor);

        return producto;
    }

    private void pedirGama(Scanner sc, ProductoDTO producto) {
        System.out.println("Introduce la gama del producto (El numero NO el nombre): ");
        List<String> gamas = mostrarGamas();
        producto.setGama(gamas.get(sc.nextInt()));
    }

    private List<String> mostrarGamas() {
        GamaDAO gamaDAO = new GamaDAO();
        List<String> gamas = gamaDAO.seleccionarGamas();

        System.out.println("\nGamas disponibles: ");
        for (String string : gamas) {
            System.out.println(gamas.indexOf(string) + ".- " + string);
        }
        return gamas;
    }
}
