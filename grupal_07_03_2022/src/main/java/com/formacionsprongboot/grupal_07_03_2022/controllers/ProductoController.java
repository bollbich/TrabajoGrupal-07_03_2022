package com.formacionsprongboot.grupal_07_03_2022.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formacionsprongboot.grupal_07_03_2022.entity.Producto;
import com.formacionsprongboot.grupal_07_03_2022.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;





@Controller
public class ProductoController {
	
	@Autowired
	private ProductoService servicio;

@GetMapping("/productos")
public String productos(Model modelo) {
	
	modelo.addAttribute("dato",servicio.findAll());
	return "VistaProductos";
}

@GetMapping("productos/nuevo")
public String crearProductos(Model modelo) {
	Producto p=new Producto();
	
	modelo.addAttribute("keyProducto",p);
	return "NuevoProductoView";
}

@PostMapping("/producto")
public String guardarProducto(@ModelAttribute("KeyProducto") Producto p) {
	
	servicio.save(p);
	return "redirect:/productos";
}

@GetMapping("/productos/editar/{id}")
public String editarProducto(@PathVariable Long id, Model modelo) {
	modelo.addAttribute("keyProducto", servicio.findById(id));
	
	return "EditarProductoView";
}

@PostMapping("/productos/{id}")
public String actualizarProducto(@PathVariable Long id,@ModelAttribute("keyProducto") Producto p) {
	Producto productoExistente=servicio.findById(id);
	
	productoExistente.setId_producto(id);
	productoExistente.setNombre(p.getNombre());
	productoExistente.setDescripcion(p.getDescripcion());
	productoExistente.setPrecio_unitario(p.getPrecio_unitario());
	productoExistente.setExistencias(p.getExistencias());
	productoExistente.setVentas(p.getVentas());
	
	
	servicio.save(productoExistente);
	
	
	
	return "redirect:/productos";
}

@GetMapping("/productos/eliminar/{id}")
public String eliminarProducto(@PathVariable Long id) {
	
	
	servicio.delete(id);
	
	
	
	return "redirect:/productos";
}
	
}
