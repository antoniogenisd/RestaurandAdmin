package com.rest.app.urant.models;

import jakarta.persistence.*;


@Table(name = "rest_ticket")
@Entity
public class Ticket {
	
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "RESTICK_SEQ")
	@SequenceGenerator(sequenceName = "restick_seq",allocationSize =1,name="RESTICK_SEQ")
	private Long id;
	
	@JoinColumn(name = "orden_id")
	@ManyToOne
	private Ordenes orden;
	
	@JoinColumn(name = "platillo_id")
	@ManyToOne
	private Platillo platillo;
	
	
	@Column(name = "total")
	private Float total;
	
	@Column(name = "cantidad")
	private Float cantidad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ordenes getOrden() {
		return orden;
	}

	public void setOrden(Ordenes orden) {
		this.orden = orden;
	}

	public Platillo getPlatillo() {
		return platillo;
	}

	public void setPlatillo(Platillo platillo) {
		this.platillo = platillo;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Float getCantidad() {
		return cantidad;
	}

	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
