package com.codenotfound.primefaces.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GenusController {
	
	@RequestMapping("/cadastrar-categoria")
	public String form() {
		return "formCategory";
	}

}
