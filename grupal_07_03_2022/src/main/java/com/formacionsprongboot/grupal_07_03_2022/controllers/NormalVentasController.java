package com.formacionsprongboot.grupal_07_03_2022.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.formacionsprongboot.grupal_07_03_2022.service.VentaService;


@Controller
public class NormalVentasController {

	
	@Autowired
	private VentaService ventaService;
	
	@GetMapping({"/ventas"})
	public String index(Model modelo){
		
		modelo.addAttribute("Ventas",ventaService.finAll());
		
		return "vistaVentas";
	}
}
