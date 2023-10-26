package domain;

import java.sql.Date;

public class EmpleadoDTO {
    
    private String idEmpleado;
    private String nombre;
    private char sexo;
    private Date fechaNac;
    private Date fechaIncorpora;
    private float salario;
    private float comision;
    private String cargo;
    private String idJefe;
    private String codDepto;

    public EmpleadoDTO() {
        
    }

    public EmpleadoDTO(String idEmpleado, String nombre, char sexo, Date fechaNac, Date fechaIncorpora, float salario,
            float comision, String cargo, String idJefe, String codDepto) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechaNac = fechaNac;
        this.fechaIncorpora = fechaIncorpora;
        this.salario = salario;
        this.comision = comision;
        this.cargo = cargo;
        this.idJefe = idJefe;
        this.codDepto = codDepto;
    }

    public EmpleadoDTO(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public String toString() {
        return "EmpleadoDTO [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", sexo=" + sexo + ", fechaNac="
                + fechaNac + ", fechaIncorpora=" + fechaIncorpora + ", salario=" + salario + ", comision=" + comision
                + ", cargo=" + cargo + ", idJefe=" + idJefe + ", codDepto=" + codDepto + "]";
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public String getSexoString() {
        return String.valueOf(sexo);
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Date getFechaIncorpora() {
        return fechaIncorpora;
    }

    public void setFechaIncorpora(Date fechaIncorpora) {
        this.fechaIncorpora = fechaIncorpora;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getIdJefe() {
        return idJefe;
    }

    public void setIdJefe(String idJefe) {
        this.idJefe = idJefe;
    }

    public String getCodDepto() {
        return codDepto;
    }

    public void setCodDepto(String codDepto) {
        this.codDepto = codDepto;
    }
}
