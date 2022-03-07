package com.formacionsprongboot.grupal_07_03_2022;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.formacionsprongboot.grupal_07_03_2022.dao.ClienteRepository;
import com.formacionsprongboot.grupal_07_03_2022.dao.ProductoDao;
import com.formacionsprongboot.grupal_07_03_2022.dao.VentaDao;
import com.formacionsprongboot.grupal_07_03_2022.entity.Cliente;
import com.formacionsprongboot.grupal_07_03_2022.entity.Producto;
import com.formacionsprongboot.grupal_07_03_2022.entity.Venta;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class VentaTest {

	@Autowired
	private VentaDao ventaDao;
	
	@Autowired
	private ProductoDao productoDao;
	
	@Autowired
	private ClienteRepository clienteDao;
	
	
	@Test
	@Rollback(true)
	public void testGuardarVenta() {
		
		long id = 20;
		
		Producto producto=new Producto("Pizza","Pizza casa tarradellas 4 quesos",2.50, 10);
		
		Cliente cliente=new Cliente("Jose","Fernández Suárez","Hombre",678555444);
		
		clienteDao.save(cliente);
		
		productoDao.save(producto);
		
		Venta venta=new Venta(id,4,10.40,21,15.60,cliente,producto);
		
		Venta ventaGuardado=ventaDao.save(venta);
		
		assertNotNull(ventaGuardado);
	}
	
	
	
	@Test
	@Rollback(true)
	public void testActualizarVenta() {
		
		int cantidad = 39;
		
		long id = 20;
		
		Producto producto=new Producto("Pizza","Pizza casa tarradellas 4 quesos",2.50, 10);
		
		Cliente cliente=new Cliente("Jose","Fernández Suárez","Hombre",678555444);
		
		Venta venta = new Venta(id,4,123,21,160,cliente,producto);
		
		System.err.println(venta.getCantidad());
		
		ventaDao.save(venta);
		
		Venta ventaActualizado= ventaDao.findById(venta.getFolio()).orElse(null);
		
		ventaActualizado.setCantidad(cantidad);
		
		ventaDao.save(ventaActualizado);
		
		ventaActualizado= ventaDao.findById(venta.getFolio()).orElse(null);		
		
		assertThat(ventaActualizado.getCantidad()).isEqualTo(cantidad);
	}
	
	@Test
	public void testListarVentas() {
		
		List<Venta> ventas=(List<Venta>) ventaDao.findAll();
		
		assertThat(ventas).size().isGreaterThan(0);
	}
	
	@Test
	@Rollback(true)
	public void TestBorrarVenta() {
		Long id=(long)1;
		boolean existe=ventaDao.findById(id).isPresent();
		
		ventaDao.deleteById(id);
		
		boolean existe2=ventaDao.findById(id).isPresent();
		
		assertTrue(existe);
		assertFalse(existe2);
	}
	
}