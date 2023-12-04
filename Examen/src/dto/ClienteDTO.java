package dto;

public class ClienteDTO {

    private int codigoCliente;
    private String nombreCliente;
    private String nombreContacto;
    private String apellidoContacto;
    private String telefono;
    private String fax;
    private String lineaDireccion1;
    private String lineaDireccion2;
    private String ciudad;
    private String region;
    private String pais;
    private String codigoPostal;
    private int codigoEmpleadoRepVentas;
    private double limiteCredito;

    public ClienteDTO() {
    }

    public ClienteDTO(int codigoCliente, String nombreCliente, String nombreContacto, String apellidoContacto,
            String telefono, String fax, String lineaDireccion1, String lineaDireccion2, String ciudad, String region,
            String pais, String codigoPostal, int codigoEmpleadoRepVentas, double limiteCredito) {
        this.codigoCliente = codigoCliente;
        this.nombreCliente = nombreCliente;
        this.nombreContacto = nombreContacto;
        this.apellidoContacto = apellidoContacto;
        this.telefono = telefono;
        this.fax = fax;
        this.lineaDireccion1 = lineaDireccion1;
        this.lineaDireccion2 = lineaDireccion2;
        this.ciudad = ciudad;
        this.region = region;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
        this.codigoEmpleadoRepVentas = codigoEmpleadoRepVentas;
        this.limiteCredito = limiteCredito;
    }

    @Override
    public String toString() {
        return this.codigoCliente + " - " + this.nombreCliente + ", " + this.nombreContacto + " "
                + this.apellidoContacto + ", "
                + this.telefono + ", " + this.lineaDireccion1 + ", " + this.ciudad + ", "
                + this.pais;
    }
}