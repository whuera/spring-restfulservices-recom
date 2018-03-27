package ec.com.core.springrestfulservices.model;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@DynamicUpdate
@Table(name="STG_CONTACT")
@Inheritance (strategy = InheritanceType.JOINED)
public class Person {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "CODIGO_PERSONA")
    private int codigoPersona;
    @Column(name = "NUMERO_IDENTIFICACION", length = 50, nullable = false)
    private String numeroIdentificacion;
    @Column(name = "TIPO_IDENTIFICACION", length = 5)
    private String tipoIdentificacion;

    @Column(name = "PRIMER_NOMBRE", length = 50)
    private String primerNombre;

    @Column(name = "SEGUNDO_NOMBRE", length = 50)
    private String segundoNombre;

    @Column(name = "PRIMER_APELLIDO", length = 50)
    private String primerApellido;

    @Column(name = "SEGUNDO_APELLIDO", length = 50)
    private String segundoApellido;

    @Column(name = "FECHA_NACIMIENTO", length = 20)
    private String fechaNacimiento;

    @Column(name = "ESTADO_CIVIL", length = 15)
    private String estadoCivil;

    @Column(name = "GENERO", length = 15)
    private String genero;

    @Column(name = "CODIGO_PROFESION", length = 20)
    private String codigoProfesion;

    @Column(name = "NOMBRE_PROFESION", length = 50)
    private String nombreProfesion;

    @Column(name = "EMAIL_SECUNDARIO", length = 80)
    private String emailSecundario;

    @Column(name = "CELULAR", length = 20)
    private String celular;

    @Column(name = "TELEFONO_OFICINA", length = 20)
    private String telefonoOficina;

    @Column(name = "TELEFONO_DOMICILIO", length = 20)
    private String telefonoDomicilio;

    @Column(name = "EMAIL_PRIMARIO", length = 80)
    private String emailPrimario;


    public int getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(int codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCodigoProfesion() {
        return codigoProfesion;
    }

    public void setCodigoProfesion(String codigoProfesion) {
        this.codigoProfesion = codigoProfesion;
    }

    public String getNombreProfesion() {
        return nombreProfesion;
    }

    public void setNombreProfesion(String nombreProfesion) {
        this.nombreProfesion = nombreProfesion;
    }

    public String getEmailSecundario() {
        return emailSecundario;
    }

    public void setEmailSecundario(String emailSecundario) {
        this.emailSecundario = emailSecundario;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefonoOficina() {
        return telefonoOficina;
    }

    public void setTelefonoOficina(String telefonoOficina) {
        this.telefonoOficina = telefonoOficina;
    }

    public String getTelefonoDomicilio() {
        return telefonoDomicilio;
    }

    public void setTelefonoDomicilio(String telefonoDomicilio) {
        this.telefonoDomicilio = telefonoDomicilio;
    }

    public String getEmailPrimario() {
        return emailPrimario;
    }

    public void setEmailPrimario(String emailPrimario) {
        this.emailPrimario = emailPrimario;
    }
}
