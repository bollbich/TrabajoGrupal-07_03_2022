package com.formacionsprongboot.grupal_07_03_2022.controllers;

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

import org.springframework.web.bind.annotation.RestController;

import com.formacionsprongboot.grupal_07_03_2022.entity.Producto;
import com.formacionsprongboot.grupal_07_03_2022.service.ProductoService;




@RestController
@RequestMapping("/api")
public class ProductosController {

	@Autowired
	private ProductoService servicio;
	
	@GetMapping("/productos")
	public List<Producto> index(){
		return servicio.findAll();
	}
	

	@GetMapping("/productos/{id}")
	public ResponseEntity<?> buscarProductoporId(@PathVariable Long id){
		
		Producto producto=null;
		
		Map<String,Object> response=new HashMap<>();
		
		try {
			producto=  servicio.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar consulta");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(producto==null) {
			response.put("mensaje", "El producto id:".concat(id.toString().concat(" no existe en la BD.")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Producto>(producto,HttpStatus.OK);
	}
	
	
	@PostMapping("/producto")
	public ResponseEntity<?> guardarProducto(@RequestBody Producto producto) {
		
        Producto productoNuevo=null;
		Map<String,Object> response=new HashMap<>();
		
		try {
			productoNuevo=servicio.save(producto);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar inserción.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "EL producto fue creado con éxito.");
		response.put("producto", productoNuevo);
		
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/producto/{id}")
	public ResponseEntity<?> actualizarProducto(@RequestBody Producto p,@PathVariable Long id) {
		
		Producto proActualizar=servicio.findById(id);
		
		Map<String,Object> response=new HashMap<>();
		
		if(proActualizar==null) {
			response.put("mensaje", "El producto id:".concat(id.toString().concat(" no existe en la BD.")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		
				
		try {
			proActualizar.setId_producto(id);
			proActualizar.setNombre(p.getNombre());
			proActualizar.setDescripcion(p.getDescripcion());
			proActualizar.setPrecio_unitario(p.getPrecio_unitario());
			proActualizar.setExistencias(p.getExistencias());
			
			servicio.save(proActualizar);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar actualización.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "EL producto fue actualizado con éxito.");
		response.put("producto", proActualizar);
		
		
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
		
		
	}
	
	
	
	@DeleteMapping("/producto/{id}")
	public ResponseEntity<?> eliminarProducto(@PathVariable Long id) {
				
		Producto proActualizar=servicio.findById(id);;
		Map<String,Object> response=new HashMap<>();
		
		try {
			servicio.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar.");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(proActualizar==null) {
			response.put("mensaje", "El producto id:".concat(id.toString().concat(" no existe en la BD.")));
			return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
		}
		response.put("mensaje", "Eliminado con éxito.");
		response.put("producto", proActualizar);
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
}
