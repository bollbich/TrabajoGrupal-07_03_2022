package com.formacionsprongboot.grupal_07_03_2022.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacionsprongboot.grupal_07_03_2022.entity.Cliente;
import com.formacionsprongboot.grupal_07_03_2022.entity.Producto;
import com.formacionsprongboot.grupal_07_03_2022.entity.Venta;

@Repository
public interface VentaDao extends CrudRepository<Venta, Long>{
	
	@Query("from Producto")
	public List<Producto> findAllProductos();
	
}
