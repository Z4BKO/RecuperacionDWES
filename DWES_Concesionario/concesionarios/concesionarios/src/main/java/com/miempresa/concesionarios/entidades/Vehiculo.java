package com.miempresa.concesionarios.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_bastidor", nullable = false, unique = true)
    private String numeroBastidor;

    @Column(nullable = false, unique = true)
    private String matricula;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private Integer potencia;

    @Column(nullable = false)
    private Integer cilindrada;

    @Column(name = "precio_venta", nullable = false)
    private Double precioVenta;

    @Column(name = "anio_fabricacion", nullable = false)
    private Integer anioFabricacion;

    // Constructores
    public Vehiculo() {}

    public Vehiculo(String numeroBastidor, String matricula, String marca, String modelo, Integer potencia, Integer cilindrada, Double precioVenta, Integer anioFabricacion) {
        this.numeroBastidor = numeroBastidor;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.cilindrada = cilindrada;
        this.precioVenta = precioVenta;
        this.anioFabricacion = anioFabricacion;
    }

    

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroBastidor() {
		return numeroBastidor;
	}

	public void setNumeroBastidor(String numeroBastidor) {
		this.numeroBastidor = numeroBastidor;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getPotencia() {
		return potencia;
	}

	public void setPotencia(Integer potencia) {
		this.potencia = potencia;
	}

	public Integer getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(Integer cilindrada) {
		this.cilindrada = cilindrada;
	}

	public Double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Integer getAnioFabricacion() {
		return anioFabricacion;
	}

	public void setAnioFabricacion(Integer anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}

	// Sobreescribe toString()
    @Override
    public String toString() {
        return "Vehiculo{" +
                "id=" + id +
                ", numeroBastidor='" + numeroBastidor + '\'' +
                ", matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", potencia=" + potencia +
                ", cilindrada=" + cilindrada +
                ", precioVenta=" + precioVenta +
                ", anioFabricacion=" + anioFabricacion +
                '}';
    }
}

