package dto;

//Esta clase deberia tener todos los campos de la base de datos, pero solo tiene los necesarios para el ejercicio
// del examen, por cuestiones obvias de tiempo
public class OficinaDTO {
    private String codigoOficina;
    private String telefono;

    public OficinaDTO() {
    }

    public OficinaDTO(String codigoOficina, String telefono) {
        this.codigoOficina = codigoOficina;
        this.telefono = telefono;
    }

    public String getCodigoOficina() {
        return codigoOficina;
    }

    public void setCodigoOficina(String codigoOficina) {
        this.codigoOficina = codigoOficina;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
}
