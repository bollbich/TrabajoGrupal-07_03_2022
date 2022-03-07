package com.formacionsprongboot.grupal_07_03_2022.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.formacionsprongboot.grupal_07_03_2022.entity.Producto;
import com.formacionsprongboot.grupal_07_03_2022.entity.Venta;
import com.formacionsprongboot.grupal_07_03_2022.service.VentaService;


@RestController
@RequestMapping("/api")
public class VentaController {

	@Autowired
	private VentaService ventaService;
	
	@GetMapping({"/ventas", "/todos"})
	public List<Venta> index(){
		return ventaService.finAll();
	}
	
	
	@GetMapping("venta/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		
		Venta venta = null;
		Map<String, Object> response = new HashMap<>();
		
		try {		
			venta = ventaService.findById(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al reallizar consulta a base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		if(venta == null) {
			response.put("mensaje", "La venta con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Venta>(venta, HttpStatus.OK);
		
	}
	
	
	@PostMapping("/venta")
	public ResponseEntity<?> saveVenta(@RequestBody Venta venta){
		
		Venta ventaNuevo = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			ventaNuevo = ventaService.save(venta);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		response.put("mensaje", "La venta ha sido creada con éxito");
		response.put("venta", ventaNuevo);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/venta/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> updateVenta(@RequestBody Venta venta, @PathVariable Long id) {
		
		Venta ventaActual = ventaService.findById(id);
		Map<String, Object> response = new HashMap<>();
		
		if (ventaActual == null) {
			response.put("mensaje", "La venta con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			ventaActual.setCantidad(venta.getCantidad());
			ventaActual.setClaveProducto(venta.getClaveProducto());
			ventaActual.setFolio(venta.getFolio());
			ventaActual.setIva(venta.getIva());
			ventaActual.setNumeroCliente(venta.getNumeroCliente());
			ventaActual.setSubtotal(venta.getSubtotal());
			ventaActual.setTotal(venta.getTotal());
			
			ventaService.save(ventaActual);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar update");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "La venta ha sido actualizada con éxito");
		response.put("venta", ventaActual);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);	
	}
	
	
	@DeleteMapping("/venta/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> deleteVenta(@PathVariable Long id){
		
		Venta ventaEliminada = ventaService.findById(id);
		Map<String, Object> response = new HashMap<>();
		
		if (ventaEliminada == null) {
			response.put("mensaje", "La venta con ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		try {
			ventaService.delete(id);
			
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar la venta");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		response.put("mensaje", "La venta ha sido eliminada con éxito");
		response.put("venta", ventaEliminada);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/productos")
	public List<Producto> listarProductos(){
		return ventaService.findAllProductos();
	}
}
