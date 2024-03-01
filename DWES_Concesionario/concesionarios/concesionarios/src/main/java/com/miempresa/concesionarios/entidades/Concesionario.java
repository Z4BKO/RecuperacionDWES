package com.miempresa.concesionarios.entidades;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "concesionarios")
public class Concesionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String horario;

    @Column(nullable = false)
    private String telefono;

    @Column(name = "anio_apertura", nullable = false)
    private Integer anioApertura;

    // Constructor por defecto
    public Concesionario() {}

    // Constructor con parámetros
    public Concesionario(String nombre, String direccion, String email, String horario, String telefono, Integer anioApertura) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.horario = horario;
        this.telefono = telefono;
        this.anioApertura = anioApertura;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getAnioApertura() {
        return anioApertura;
    }

    public void setAnioApertura(Integer anioApertura) {
        this.anioApertura = anioApertura;
    }

    @Override
    public String toString() {
        return "Concesionario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", horario='" + horario + '\'' +
                ", telefono='" + telefono + '\'' +
                ", anioApertura=" + anioApertura +
                '}';
    }
}
