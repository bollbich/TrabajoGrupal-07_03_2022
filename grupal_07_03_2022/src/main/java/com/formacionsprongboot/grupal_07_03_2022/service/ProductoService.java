package com.formacionsprongboot.grupal_07_03_2022.service;



	import java.util.List;

import com.formacionsprongboot.grupal_07_03_2022.entity.Producto;


		

		public interface ProductoService {

			public List<Producto> findAll();
			
			public Producto findById(Long id);
			
			public Producto save(Producto producto);
			
			public void delete(Long id);
}
