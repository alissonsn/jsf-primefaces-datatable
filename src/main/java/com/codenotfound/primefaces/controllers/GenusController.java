package com.codenotfound.primefaces.controllers;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codenotfound.primefaces.model.Car;
import com.codenotfound.primefaces.model.Characteristics;
import com.codenotfound.primefaces.model.Genus;
import com.codenotfound.primefaces.repository.GenusRepository;

@Controller
@ViewScoped
public class GenusController {
	
	@Autowired
	private GenusRepository gr;
	
	private Genus genus;
	
	 @PostConstruct
	  public void init() {
		genus = new Genus();
	  }
	
	@RequestMapping("/cadastrar-categoria")
	public String form() {
		return "formCategory";
	}
	
	@RequestMapping("/caracteristicas")
	public ModelAndView listaCaracter(){
		ModelAndView mv = new ModelAndView("formCategory");
		Iterable<Characteristics> caracteristicas = genus.getCharacteristics();
		mv.addObject("caracteristicas", caracteristicas);
		return mv;
}
	

}
