package com.rest.app.urant.dtos;

import java.util.Date;

public class OrdenTDO {

	private Long id;
    private Date fecha;
    private String descripcion;
    private Float total;
    private Float subtotal;
    private Long cliente;
    private Long empleado;
    
    
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	public Long getCliente() {
		return cliente;
	}
	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}
	public Long getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Long empleado) {
		this.empleado = empleado;
	}
    
    
    
    
}
