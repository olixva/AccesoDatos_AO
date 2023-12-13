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
}
