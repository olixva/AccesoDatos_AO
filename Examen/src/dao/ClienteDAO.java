package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ClienteDTO;
import util.Conexion;

public class ClienteDAO {

    // Sentencia SELECT
    private static final String SQL_SELECT = "SELECT codigo_cliente, nombre_cliente, nombre_contacto, apellido_contacto, telefono, fax, linea_direccion1, linea_direccion2, ciudad, region, pais, codigo_postal, codigo_empleado_rep_ventas, limite_credito FROM cliente";

    public List<ClienteDTO> seleccionar() {

        List<ClienteDTO> clientes = new ArrayList<>();

        try (Connection cn = Conexion.getConnection();
                PreparedStatement pS = cn.prepareStatement(SQL_SELECT);
                ResultSet rS = pS.executeQuery()) {

            while (rS.next()) {

                int codigoCliente = rS.getInt("codigo_cliente");
                String nombreCliente = rS.getString("nombre_cliente");
                String nombreContacto = rS.getString("nombre_contacto");
                String apellidoContacto = rS.getString("apellido_contacto");
                String telefono = rS.getString("telefono");
                String fax = rS.getString("fax");
                String lineaDireccion1 = rS.getString("linea_direccion1");
                String lineaDireccion2 = rS.getString("linea_direccion2");
                String ciudad = rS.getString("ciudad");
                String region = rS.getString("region");
                String pais = rS.getString("pais");
                String codigoPostal = rS.getString("codigo_postal");
                int codigoEmpleadoRepVentas = rS.getInt("codigo_empleado_rep_ventas");
                double limiteCredito = rS.getDouble("limite_credito");

                ClienteDTO cliente = new ClienteDTO(codigoCliente, nombreCliente, nombreContacto, apellidoContacto,
                        telefono, fax, lineaDireccion1, lineaDireccion2, ciudad, region, pais, codigoPostal,
                        codigoEmpleadoRepVentas, limiteCredito);

                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }
}
