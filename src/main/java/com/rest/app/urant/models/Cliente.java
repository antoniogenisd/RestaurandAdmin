package com.rest.app.urant.models;
import jakarta.persistence.*;

@Table(name = "rest_cliente")
@Entity
public class Cliente {
	//atributos
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "RESTCLI_SEQ")
	@SequenceGenerator(sequenceName = "restcli_seq",allocationSize =1,name="RESTCLI_SEQ")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "telefono")
	private String telefono;

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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	

}
