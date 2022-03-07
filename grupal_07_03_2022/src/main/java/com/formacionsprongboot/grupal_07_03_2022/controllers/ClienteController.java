package com.formacionsprongboot.grupal_07_03_2022.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.formacionsprongboot.grupal_07_03_2022.entity.Cliente;
import com.formacionsprongboot.grupal_07_03_2022.service.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService servicio;
	
	@GetMapping("/clientes")
	public String clientes(Model modelo) {
		
		modelo.addAttribute("Clientes",servicio.findAll());
		return "vistaClientes";
	}

	@GetMapping("clientes/nuevo")
	public String crearClientes(Model modelo) {
		Cliente cliente = new Cliente();
		
		modelo.addAttribute("id_cliente",cliente);
		return "NuevoClienteView";
	}

	@PostMapping("/cliente")
	public String guardarCliente(@ModelAttribute("id_cliente") Cliente cliente) {
		
		servicio.save(cliente);
		return "redirect:/clientes";
	}

	@GetMapping("/clientes/editar/{id}")
	public String editarCliente(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("id_cliente", servicio.findById(id));
		
		return "EditarClientesView";
	}

	@PostMapping("/clientes/{id}")
	public String actualizarCliente(@PathVariable Long id,@ModelAttribute("id_cliente") Cliente cliente) {
		Cliente clienteExistente=servicio.findById(id);
		
		clienteExistente.setId_cliente(clienteExistente.getId_cliente());
		clienteExistente.setNombre(clienteExistente.getNombre());
		clienteExistente.setApellidos(clienteExistente.getApellidos());
		clienteExistente.setSexo(clienteExistente.getSexo());
		clienteExistente.setTelefono(clienteExistente.getTelefono());
		
		servicio.save(clienteExistente);
		
		return "redirect:/clientes";
	}

	@GetMapping("/clientes/eliminar/{id}")
	public String eliminarCliente(@PathVariable Long id) {
		
		
		servicio.delete(id);
		
		
		
		return "redirect:/clientes";
	}

	}
