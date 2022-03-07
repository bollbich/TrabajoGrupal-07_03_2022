package com.formacionsprongboot.grupal_07_03_2022.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacionsprongboot.grupal_07_03_2022.dao.ClienteRepository;
import com.formacionsprongboot.grupal_07_03_2022.entity.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repositorio;
	
	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) repositorio.findAll();
	}

	@Override
	public Cliente findById(Long id_cliente) {
		return repositorio.findById(id_cliente).orElse(null);
	}

	@Override
	public Cliente save(Cliente cliente) {
		return repositorio.save(cliente);
	}

	@Override
	public void delete(Long id_cliente) {
		repositorio.deleteById(id_cliente);
		
	}
	
	

}
