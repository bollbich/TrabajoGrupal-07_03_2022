package com.formacionsprongboot.grupal_07_03_2022.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.formacionsprongboot.grupal_07_03_2022.dao.VentaDao;
import com.formacionsprongboot.grupal_07_03_2022.entity.Producto;
import com.formacionsprongboot.grupal_07_03_2022.entity.Venta;

@Service
public class VentaServiceImpl implements VentaService{

	@Autowired
	private VentaDao ventaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Venta> finAll() {
		return (List<Venta>) ventaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Venta findById(Long id) {
		return ventaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Venta save(Venta venta) {
		return ventaDao.save(venta);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		ventaDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAllProductos() {
		return ventaDao.findAllProductos();
	}

}
