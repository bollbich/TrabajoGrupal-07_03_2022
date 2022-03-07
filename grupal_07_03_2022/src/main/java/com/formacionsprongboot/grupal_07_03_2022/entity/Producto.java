package com.formacionsprongboot.grupal_07_03_2022.entity;



	import java.io.Serializable;
	

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

import javax.persistence.Table;


	@Entity
	@Table(name="productos")
	public class Producto implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id_producto;
		@Column(nullable=false)	
		private String nombre;
		@Column(nullable=false)	
		private String descripcion;
		@Column(nullable=false)	
		private double precio_unitario;
		@Column(nullable=false)	
		private int existencias;
		
		
		

		public Producto() {
			
		}

		public Producto(String nombre, String descripcion, double precio_unitario, int existencias) {
			
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.precio_unitario = precio_unitario;
			this.existencias = existencias;
		}

		public Long getId_producto() {
			return id_producto;
		}

		public void setId_producto(Long id_producto) {
			this.id_producto = id_producto;
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

		public double getPrecio_unitario() {
			return precio_unitario;
		}

		public void setPrecio_unitario(double precio_unitario) {
			this.precio_unitario = precio_unitario;
		}

		public int getExistencias() {
			return existencias;
		}

		public void setExistencias(int existencias) {
			this.existencias = existencias;
		}

		
		
		
		
		
		
		
}
