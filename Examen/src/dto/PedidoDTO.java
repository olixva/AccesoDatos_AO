package dto;

import java.sql.Date;

public class PedidoDTO {
    private int codigoPedido;
    private Date fechaPedido;
    private Date fechaEsperada;
    private Date fechaEntrega;
    private String estado;
    private String comentarios;
    private int codigoCliente;

    public PedidoDTO() {
    }

    public PedidoDTO(int codigoPedido, Date fechaPedido, Date fechaEsperada, Date fechaEntrega, String estado,
            String comentarios, int codigoCliente) {
        this.codigoPedido = codigoPedido;
        this.fechaPedido = fechaPedido;
        this.fechaEsperada = fechaEsperada;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
        this.comentarios = comentarios;
        this.codigoCliente = codigoCliente;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public Date getFechaEsperada() {
        return fechaEsperada;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public String getComentarios() {
        return comentarios;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    @Override
    public String toString() {
        return codigoPedido + " Fecha: " + fechaPedido + " Estado: " + estado + " Cliente:" + codigoCliente;
    }
}
