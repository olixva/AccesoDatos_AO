package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.ProductoDTO;
import util.Conexion;

public class ProductoDAO {
    // Sentencia INSERT
    private static final String SQL_INSERT = "INSERT INTO producto(codigo_producto, nombre, gama, dimensiones, proveedor, descripcion, cantidad_en_stock, precio_venta, precio_proveedor) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public int insertar(ProductoDTO alumno) {
        int registros = 0;

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_INSERT)) {

            pS.setString(1, alumno.getCodigoProducto());
            pS.setString(2, alumno.getNombre());
            pS.setString(3, alumno.getGama());
            pS.setString(4, alumno.getDimensiones());
            pS.setString(5, alumno.getProveedor());
            pS.setString(6, alumno.getDescripcion());
            pS.setInt(7, alumno.getCantidadEnStock());
            pS.setDouble(8, alumno.getPrecioVenta());
            pS.setDouble(9, alumno.getPrecioProveedor());

            registros = pS.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }
}
