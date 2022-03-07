package com.formacionsprongboot.grupal_07_03_2022.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionsprongboot.grupal_07_03_2022.dao.VentaDao;
import com.formacionsprongboot.grupal_07_03_2022.entity.Producto;
import com.formacionsprongboot.grupal_07_03_2022.entity.Venta;

@Service
public class VentaServiceImpl implements VentaService{

	@Autowired
	private VentaDao ventaDao;
	
	@Override
	public List<Venta> finAll() {
		return (List<Venta>) ventaDao.findAll();
	}

	@Override
	public Venta findById(Long id) {
		return ventaDao.findById(id).orElse(null);
	}

	@Override
	public Venta save(Venta venta) {
		return ventaDao.save(venta);
	}

	@Override
	public void delete(Long id) {
		ventaDao.deleteById(id);
	}

	@Override
	public List<Producto> findAllProductos() {
		return ventaDao.findAllProductos();
	}

}
