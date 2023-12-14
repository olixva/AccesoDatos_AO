package dto;

import java.sql.Date;

public class EmpleadoDTO {

    private int numEmpleado;
    private String nombre;
    private int edad;
    private int departamento;
    private int categoria;
    private Date contrato;

    public EmpleadoDTO(int numEmpleado, String nombre, int edad, int departamento, int categoria, Date contrato) {
        this.numEmpleado = numEmpleado;
        this.nombre = nombre;
        this.edad = edad;
        this.departamento = departamento;
        this.categoria = categoria;
        this.contrato = contrato;
    }

    @Override
    public String toString() {
        return numEmpleado + ", " + nombre + " Edad: " + edad + ", Departamento: "
                + departamento + ", Categoria: " + categoria + " Contrato: " + contrato;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public Date getContrato() {
        return contrato;
    }

    public void setContrato(Date contrato) {
        this.contrato = contrato;
    }

}
