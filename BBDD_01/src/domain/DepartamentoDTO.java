package domain;

public class DepartamentoDTO {
    
    private String codDepto;
    private String nombreDpto;
    private String ciudad;
    private String codDirector;
    
    
    public DepartamentoDTO(String codDepto) {
        this.codDepto = codDepto;
    }

    public DepartamentoDTO(String codDepto, String nombreDpto, String ciudad, String codDirector) {
        this.codDepto = codDepto;
        this.nombreDpto = nombreDpto;
        this.ciudad = ciudad;
        this.codDirector = codDirector;
    }

    public DepartamentoDTO() {
    }

    @Override
    public String toString() {
        return "DepartamentoDTO [codDepto=" + codDepto + ", nombreDpto=" + nombreDpto + ", ciudad=" + ciudad
                + ", codDirector=" + codDirector + "]";
    }

    public String getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(String codDepto) {
        this.codDepto = codDepto;
    }

    public String getNombreDpto() {
        return nombreDpto;
    }

    public void setNombreDpto(String nombreDpto) {
        this.nombreDpto = nombreDpto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodDirector() {
        return codDirector;
    }

    public void setCodDirector(String codDirector) {
        this.codDirector = codDirector;
    }

    
    
}
