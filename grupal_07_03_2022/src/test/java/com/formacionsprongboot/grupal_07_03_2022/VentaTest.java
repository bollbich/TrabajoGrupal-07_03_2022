package com.formacionsprongboot.grupal_07_03_2022;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.formacionsprongboot.grupal_07_03_2022.dao.VentaDao;
import com.formacionsprongboot.grupal_07_03_2022.entity.Venta;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class VentaTest {

	@Autowired
	private VentaDao ventaDao;
	
	
	@Test
	@Rollback(false)
	public void testGuardarVenta() {
		Venta venta=new Venta(4,10.40,21,15.60,1,2);
		Venta ventaGuardado=ventaDao.save(venta);
		assertNotNull(ventaGuardado);
	}
	
	
	
	@Test
	@Rollback(false)
	public void testActualizarVenta() {
		Venta venta=new Venta("María","González Suárez","Mujer",699555000);
		venta.setId_venta((long) 1);
		ventaDao.save(venta);
		
		Venta ventaActualizado=ventaDao.findById(id);
		assertThat(ventaActualizado.getId_venta()).isEqualTo(id);
	}
	
	@Test
	public void testListarVentas() {
		List<Venta> ventas=(List<Venta>) ventaDao.findAll();
		
		assertThat(ventas).size().isGreaterThan(0);
	}
	
	@Test
	@Rollback(false)
	public void TestBorrarVenta() {
		Long id=(long)1;
		boolean existe=ventaDao.findById(id).isPresent();
		
		ventaDao.deleteById(id);
		
		boolean existe2=ventaDao.findById(id).isPresent();
		
		assertTrue(existe);
		assertFalse(existe2);
	}
	
}