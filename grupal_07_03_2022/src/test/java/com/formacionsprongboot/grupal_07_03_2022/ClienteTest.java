package com.formacionsprongboot.grupal_07_03_2022;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;


import com.formacionsprongboot.grupal_07_03_2022.dao.ClienteRepository;
import com.formacionsprongboot.grupal_07_03_2022.entity.Cliente;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class ClienteTest {

	@Autowired
	private ClienteRepository clienteDao;
	
	
	@Test
	@Rollback(false)
	public void testGuardarCliente() {
		Cliente cliente=new Cliente("Jose","Fernández Suárez","Hombre",678555444);
		Cliente clienteGuardado=clienteDao.save(cliente);
		assertNotNull(clienteGuardado);
	}
	
	
	/*
	@Test
	@Rollback(false)
	public void testActualizarCliente() {
		Cliente cliente=new Cliente("María","González Suárez","Mujer",699555000);
		cliente.setId_cliente((long) 1);
		clienteDao.save(cliente);
		
		Cliente clienteActualizado=clienteDao.findById(id);
		assertThat(clienteActualizado.getId_cliente()).isEqualTo(id);
	}
	*/
	@Test
	public void testListarClientes() {
		List<Cliente> clientes=(List<Cliente>) clienteDao.findAll();
		
		assertThat(clientes).size().isGreaterThan(0);
	}
	
	@Test
	@Rollback(true)
	public void TestBorrarCliente() {
		Long id=(long)1;
		boolean existe=clienteDao.findById(id).isPresent();
		
		clienteDao.deleteById(id);
		
		boolean existe2=clienteDao.findById(id).isPresent();
		
		assertTrue(existe);
		assertFalse(existe2);
	}
}
