package com.formacionsprongboot.grupal_07_03_2022.service;



	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;

import com.formacionsprongboot.grupal_07_03_2022.dao.ProductoDao;
import com.formacionsprongboot.grupal_07_03_2022.entity.Producto;


	
	@Service
	public class ProductoServiceImpl implements ProductoService{

		@Autowired
		private ProductoDao productoDao;
		
		@Transactional(readOnly=true)
		@Override
		public List<Producto> findAll() {
			
			return (List<Producto>) productoDao.findAll();
		}

		@Override
		@Transactional(readOnly=true)
		public Producto findById(Long id) {
			return productoDao.findById(id).orElse(null);
			
		}

		@Override
		public Producto save(Producto producto) {
			return productoDao.save(producto);
			
		}

		@Override
		public void delete(Long id) {
			productoDao.deleteById(id);
			
		}
}
