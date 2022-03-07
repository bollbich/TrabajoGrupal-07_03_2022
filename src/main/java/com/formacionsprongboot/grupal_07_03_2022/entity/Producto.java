package com.formacionsprongboot.grupal_07_03_2022.entity;

<<<<<<< HEAD:grupal_07_03_2022/src/main/java/com/formacionsprongboot/grupal_07_03_2022/entity/Producto.java


	import java.io.Serializable;
	import java.util.Date;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
		
		@ManyToOne
		@JoinColumn(name = "id_folio")
		private Venta ventas;
		
		

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

		public Venta getVentas() {
			return ventas;
		}

		public void setVentas(Venta ventas) {
			this.ventas = ventas;
		}
		
		
		
		
		
		
=======
public class Producto {

>>>>>>> d66a6d7d35219d5425a5576966fa707a200fefce:src/main/java/com/formacionsprongboot/grupal_07_03_2022/entity/Producto.java
}
