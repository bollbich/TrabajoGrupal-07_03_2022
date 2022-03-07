package com.formacionsprongboot.grupal_07_03_2022;



	import org.junit.jupiter.api.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
	import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
	import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
	import org.springframework.test.annotation.Rollback;

import com.formacionsprongboot.grupal_07_03_2022.dao.ProductoDao;
import com.formacionsprongboot.grupal_07_03_2022.entity.Producto;

import static org.assertj.core.api.Assertions.assertThat;
	import static org.junit.jupiter.api.Assertions.assertNotNull;
	//import static org.junit.jupiter.api.Assertions.assertNull;
	import static org.junit.jupiter.api.Assertions.assertFalse;
	import static org.junit.jupiter.api.Assertions.assertTrue;

	import java.util.List;

	@DataJpaTest
	@AutoConfigureTestDatabase(replace=Replace.NONE)
	public class ProductoTest {

		@Autowired
		private ProductoDao productoDao;
		
		
		@Test
		@Rollback(false)
		public void testGuardarProducto() {
			Producto producto=new Producto("Pizza","Pizza casa tarradellas 4 quesos",2.50, 10);
			Producto productoGuardado=productoDao.save(producto);
			assertNotNull(productoGuardado);
		}
		
		
		/*
		@Test
		@Rollback(false)
		public void testActualizarProducto() {
			Producto producto=new Producto("Pasta","Spaghetti marca Mercadona",1.50, 20);
			producto.setId_producto((long) 1);
			productoDao.save(producto);
			
			Producto productoActualizado=productoDao.findById(id);
			assertThat(productoActualizado.getId_producto()).isEqualTo(id);
		}
		*/
		
		@Test
		public void testListarProductos() {
			List<Producto> productos=(List<Producto>) productoDao.findAll();
			
			assertThat(productos).size().isGreaterThan(0);
		}
		
		@Test
		@Rollback(false)
		public void TestBorrarProducto() {
			Long id=(long)1;
			boolean existe=productoDao.findById(id).isPresent();
			
			productoDao.deleteById(id);
			
			boolean existe2=productoDao.findById(id).isPresent();
			
			assertTrue(existe);
			assertFalse(existe2);
		}
}
