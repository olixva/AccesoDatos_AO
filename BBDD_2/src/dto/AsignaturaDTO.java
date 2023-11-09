package dto;

public class AsignaturaDTO {

    private String cod_asignatura;
    private String cod_interno;
    private String descripcion;
    private int nHoras;
    private String cod_curso;

    public AsignaturaDTO() {
    }

    public AsignaturaDTO(String cod_asignatura) {
        this.cod_asignatura = cod_asignatura;
    }

    public AsignaturaDTO(String cod_asignatura, String cod_interno, String descripcion, int nHoras, String cod_curso) {
        this.cod_asignatura = cod_asignatura;
        this.cod_interno = cod_interno;
        this.descripcion = descripcion;
        this.nHoras = nHoras;
        this.cod_curso = cod_curso;
    }

    public String getCod_asignatura() {
        return cod_asignatura;
    }

    public void setCod_asignatura(String cod_asignatura) {
        this.cod_asignatura = cod_asignatura;
    }

    public String getCod_interno() {
        return cod_interno;
    }

    public void setCod_interno(String cod_interno) {
        this.cod_interno = cod_interno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getnHoras() {
        return nHoras;
    }

    public void setnHoras(int nHoras) {
        this.nHoras = nHoras;
    }

    public String getCod_curso() {
        return cod_curso;
    }

    public void setCod_curso(String cod_curso) {
        this.cod_curso = cod_curso;
    }

    @Override
    public String toString() {
        return "AsignaturaDTO{" +
                "cod_asignatura='" + cod_asignatura + '\'' +
                ", cod_interno='" + cod_interno + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", nHoras=" + nHoras +
                ", cod_curso='" + cod_curso + '\'' +
                '}';
    }
}

