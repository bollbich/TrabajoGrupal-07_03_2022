package com.formacionsprongboot.grupal_07_03_2022.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ventas")
public class Venta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long folio;
	private Cliente numeroCliente;
	private Producto claveProducto;
	private int cantidad;
	private double subtotal;
	private int iva;
	private double total;
	
	public Long getFolio() {
		return folio;
	}
	
	public void setFolio(Long folio) {
		this.folio = folio;
	}
	
	public Cliente getNumeroCliente() {
		return numeroCliente;
	}
	
	public void setNumeroCliente(Cliente numeroCliente) {
		this.numeroCliente = numeroCliente;
	}
	
	public Producto getClaveProducto() {
		return claveProducto;
	}
	
	public void setClaveProducto(Producto claveProducto) {
		this.claveProducto = claveProducto;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	public int getIva() {
		return iva;
	}
	
	public void setIva(int iva) {
		this.iva = iva;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}	
	
}
