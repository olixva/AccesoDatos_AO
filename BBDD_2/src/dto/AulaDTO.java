package dto;

public class AulaDTO {

    private String num_aula;
    private String cod_edificio;

    public AulaDTO() {
    }

    public AulaDTO(String num_aula) {
        this.num_aula = num_aula;
    }

    public AulaDTO(String num_aula, String cod_edificio) {
        this.num_aula = num_aula;
        this.cod_edificio = cod_edificio;
    }

    public String getNum_aula() {
        return num_aula;
    }

    public void setNum_aula(String num_aula) {
        this.num_aula = num_aula;
    }

    public String getCod_edificio() {
        return cod_edificio;
    }

    public void setCod_edificio(String cod_edificio) {
        this.cod_edificio = cod_edificio;
    }

    @Override
    public String toString() {
        return "AulaDTO{" +
                "num_aula='" + num_aula + '\'' +
                ", cod_edificio='" + cod_edificio + '\'' +
                '}';
    }

    public String toStringCorto() {
        return "Aula numero: " + num_aula + " Edicifio: " + cod_edificio;
    }
}
