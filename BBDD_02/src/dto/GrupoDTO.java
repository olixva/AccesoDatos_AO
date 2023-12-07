package dto;

public class GrupoDTO {

    private String cod_grupo;
    private String cod_curso;
    private String nombre;
    private String cod_turno;
    private int nMaxAlumnos;

    public GrupoDTO() {
    }

    public GrupoDTO(String cod_grupo) {
        this.cod_grupo = cod_grupo;
    }

    public GrupoDTO(String cod_grupo, String cod_curso, String nombre, String cod_turno, int nMaxAlumnos) {
        this.cod_grupo = cod_grupo;
        this.cod_curso = cod_curso;
        this.nombre = nombre;
        this.cod_turno = cod_turno;
        this.nMaxAlumnos = nMaxAlumnos;
    }

    public String getCod_grupo() {
        return cod_grupo;
    }

    public void setCod_grupo(String cod_grupo) {
        this.cod_grupo = cod_grupo;
    }

    public String getCod_curso() {
        return cod_curso;
    }

    public void setCod_curso(String cod_curso) {
        this.cod_curso = cod_curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCod_turno() {
        return cod_turno;
    }

    public void setCod_turno(String cod_turno) {
        this.cod_turno = cod_turno;
    }

    public int getnMaxAlumnos() {
        return nMaxAlumnos;
    }

    public void setnMaxAlumnos(int nMaxAlumnos) {
        this.nMaxAlumnos = nMaxAlumnos;
    }

    @Override
    public String toString() {
        return "GrupoDTO{" +
                "cod_grupo='" + cod_grupo + '\'' +
                ", cod_curso='" + cod_curso + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cod_turno='" + cod_turno + '\'' +
                ", nMaxAlumnos=" + nMaxAlumnos +
                '}';
    }
}

