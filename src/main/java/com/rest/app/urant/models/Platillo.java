package com.rest.app.urant.models;
import jakarta.persistence.*;

@Entity
@Table(name = "rest_platillos")

public class Platillo {

	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "RESTPLA_SEQ")
	@SequenceGenerator(sequenceName = "restpla_seq",allocationSize =1,name="RESTPLA_SEQ")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "precio")
	private Float precio;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	
	

}
