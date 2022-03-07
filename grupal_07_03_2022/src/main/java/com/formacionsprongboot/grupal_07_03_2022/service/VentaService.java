package com.formacionsprongboot.grupal_07_03_2022.service;

import java.util.List;

import com.formacionsprongboot.grupal_07_03_2022.entity.Producto;
import com.formacionsprongboot.grupal_07_03_2022.entity.Venta;

public interface VentaService {

	public List<Venta> finAll();
	
	public Venta findById(Long id);
	
	public Venta save(Venta venta);
	
	public void delete(Long id);
	
	public List<Producto> findAllProductos();
}
