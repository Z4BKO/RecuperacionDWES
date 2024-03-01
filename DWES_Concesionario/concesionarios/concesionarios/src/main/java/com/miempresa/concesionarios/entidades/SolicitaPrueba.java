package com.miempresa.concesionarios.entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "solicita_prueba")
public class SolicitaPrueba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculo;

    @Column(name = "fecha_hora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;

    @Column(nullable = false)
    private Boolean realizada;

    // Constructor por defecto
    public SolicitaPrueba() {}
    
    public boolean isRealizada() {
        return realizada;
    }


    // Constructor con parámetros
    public SolicitaPrueba(Cliente cliente, Vehiculo vehiculo, Date fechaHora, Boolean realizada) {
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaHora = fechaHora;
        this.realizada = realizada;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Boolean getRealizada() {
        return realizada;
    }

    public void setRealizada(Boolean realizada) {
        this.realizada = realizada;
    }

    @Override
    public String toString() {
        return "SolicitaPrueba{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", vehiculo=" + vehiculo +
                ", fechaHora=" + fechaHora +
                ", realizada=" + realizada +
                '}';
    }
}
