package dto;

public class TurnoDTO {

    private String cod_turno;
    private String horario;

    public TurnoDTO() {
    }

    public TurnoDTO(String cod_turno) {
        this.cod_turno = cod_turno;
    }

    public TurnoDTO(String cod_turno, String horario) {
        this.cod_turno = cod_turno;
        this.horario = horario;
    }

    public String getCod_turno() {
        return cod_turno;
    }

    public void setCod_turno(String cod_turno) {
        this.cod_turno = cod_turno;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    @Override
    public String toString() {
        return "TurnoDTO{" +
                "cod_turno='" + cod_turno + '\'' +
                ", horario='" + horario + '\'' +
                '}';
    }
}
