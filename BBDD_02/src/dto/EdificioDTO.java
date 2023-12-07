package dto;

public class EdificioDTO {

    private String cod_edificio;
    private String nombre;

    public EdificioDTO() {
    }

    public EdificioDTO(String cod_edificio) {
        this.cod_edificio = cod_edificio;
    }

    public EdificioDTO(String cod_edificio, String nombre) {
        this.cod_edificio = cod_edificio;
        this.nombre = nombre;
    }

    public String getCod_edificio() {
        return cod_edificio;
    }

    public void setCod_edificio(String cod_edificio) {
        this.cod_edificio = cod_edificio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "EdificioDTO{" +
                "cod_edificio='" + cod_edificio + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
