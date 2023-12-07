package dto;

import java.sql.Date;

public class AlumnoDTO {
    
    private String nre;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String tipo_via;
    private String nombre_via;
    private String numero;
    private String escalera;
    private String piso;
    private String puerta;
    private String cp;
    private String pais;
    private String tlfn_fijo;
    private String tlfn_movil;
    private String email;
    private Date fecha_nac;
    private String tutor;
    
    public AlumnoDTO() {
    }

    public AlumnoDTO(String nre) {
        this.nre = nre;
    }

    public AlumnoDTO(String nre, String dni, String nombre, String apellido1, String apellido2, String tipo_via,
            String nombre_via, String numero, String escalera, String piso, String puerta, String cp, String pais,
            String tlfn_fijo, String tlfn_movil, String email, Date fecha_nac, String tutor) {
        this.nre = nre;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.tipo_via = tipo_via;
        this.nombre_via = nombre_via;
        this.numero = numero;
        this.escalera = escalera;
        this.piso = piso;
        this.puerta = puerta;
        this.cp = cp;
        this.pais = pais;
        this.tlfn_fijo = tlfn_fijo;
        this.tlfn_movil = tlfn_movil;
        this.email = email;
        this.fecha_nac = fecha_nac;
        this.tutor = tutor;
    }
    
    public String getNre() {
        return nre;
    }

    public void setNre(String nre) {
        this.nre = nre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTipo_via() {
        return tipo_via;
    }

    public void setTipo_via(String tipo_via) {
        this.tipo_via = tipo_via;
    }

    public String getNombre_via() {
        return nombre_via;
    }

    public void setNombre_via(String nombre_via) {
        this.nombre_via = nombre_via;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEscalera() {
        return escalera;
    }

    public void setEscalera(String escalera) {
        this.escalera = escalera;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTlfn_fijo() {
        return tlfn_fijo;
    }

    public void setTlfn_fijo(String tlfn_fijo) {
        this.tlfn_fijo = tlfn_fijo;
    }

    public String getTlfn_movil() {
        return tlfn_movil;
    }

    public void setTlfn_movil(String tlfn_movil) {
        this.tlfn_movil = tlfn_movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    @Override
    public String toString() {
        return "AlumnoDTO [nre=" + nre + ", dni=" + dni + ", nombre=" + nombre + ", apellido1=" + apellido1
                + ", apellido2=" + apellido2 + ", tipo_via=" + tipo_via + ", nombre_via=" + nombre_via + ", numero="
                + numero + ", escalera=" + escalera + ", piso=" + piso + ", puerta=" + puerta + ", cp=" + cp + ", pais="
                + pais + ", tlfn_fijo=" + tlfn_fijo + ", tlfn_movil=" + tlfn_movil + ", email=" + email + ", fecha_nac="
                + fecha_nac + ", tutor=" + tutor + "]";
    }

    public String toStringCorto() {
        return "Alumno Nre: " + nre + ", Dni: " + dni + ", Nombre: " + nombre + ", Apellidos: " + apellido1 + " " + apellido2;
    }
}
