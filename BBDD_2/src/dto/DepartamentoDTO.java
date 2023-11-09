package dto;

public class DepartamentoDTO {

    private String cod_departamento;
    private String nombre;
    private String descripcion;

    public DepartamentoDTO() {
    }

    public DepartamentoDTO(String cod_departamento) {
        this.cod_departamento = cod_departamento;
    }

    public DepartamentoDTO(String cod_departamento, String nombre, String descripcion) {
        this.cod_departamento = cod_departamento;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getCod_departamento() {
        return cod_departamento;
    }

    public void setCod_departamento(String cod_departamento) {
        this.cod_departamento = cod_departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "DepartamentoDTO [cod_departamento=" + cod_departamento + ", nombre=" + nombre + ", descripcion="
                + descripcion + "]";
    }
}
