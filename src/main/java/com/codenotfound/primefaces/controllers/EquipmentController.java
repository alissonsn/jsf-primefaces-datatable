package com.codenotfound.primefaces.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EquipmentController {
	
	@RequestMapping("/cadastrar-equipment")
	public String form() {
		return "formEquipment";
	}

}
