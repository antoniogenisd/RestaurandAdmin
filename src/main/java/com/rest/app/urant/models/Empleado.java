package com.rest.app.urant.models;

import jakarta.persistence.*;

@Table(name = "rest_empleado")
@Entity
public class Empleado {
	
		//atributos
		@Column(name="id")
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "RESTEMP_SEQ")
		@SequenceGenerator(sequenceName = "restemp_seq",allocationSize =1,name="RESTEMP_SEQ")
		private Long id;
		
		@Column(name = "nombre")
		private String nombre;
		
		@Column(name = "direccion")
		private String direccion;
		
		@Column(name = "telefono")
		private String telefono;

		@Column(name = "puesto")
		private String puesto;
		
		@Column(name = "sueldo")
		private Double sueldo;

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

		public String getPuesto() {
			return puesto;
		}

		public void setPuesto(String puesto) {
			this.puesto = puesto;
		}

		public Double getSueldo() {
			return sueldo;
		}

		public void setSueldo(Double sueldo) {
			this.sueldo = sueldo;
		}

		
}
