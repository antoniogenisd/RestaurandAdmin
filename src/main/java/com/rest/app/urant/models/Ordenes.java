package com.rest.app.urant.models;

import java.util.Date;

import jakarta.persistence.*;

@Table(name = "rest_Ordenes")
@Entity
public class Ordenes {
	
	//atributos
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "RESTORD_SEQ")
	@SequenceGenerator(sequenceName = "restord_seq",allocationSize = 1,name="RESTORD_SEQ")
	private Long id;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "total")
	private Float total;
	
	@Column(name = "subtotal")
	private Float subtotal;
	
	@JoinColumn(name = "cliente_id")
	@ManyToOne
	private Cliente cliente;
	

	@JoinColumn(name = "empleado_id")
	@ManyToOne
	private Empleado empleado;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public Float getTotal() {
		return total;
	}


	public void setTotal(Float total) {
		this.total = total;
	}


	public Float getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
	
	
}
