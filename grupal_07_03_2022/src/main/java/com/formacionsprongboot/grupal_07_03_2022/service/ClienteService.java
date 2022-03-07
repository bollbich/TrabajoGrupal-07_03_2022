package com.formacionsprongboot.grupal_07_03_2022.service;

import java.util.List;

import com.formacionsprongboot.grupal_07_03_2022.entity.Cliente;


public interface ClienteService {
	
	public List<Cliente> findAll();
	public Cliente findById(Long id_cliente);
	public Cliente save(Cliente cliente);
	public void delete(Long id_cliente);

}
