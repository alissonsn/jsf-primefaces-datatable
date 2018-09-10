package com.codenotfound.primefaces.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.codenotfound.primefaces.model.Characteristics;
import com.codenotfound.primefaces.model.Genus;
import com.codenotfound.primefaces.repository.GenusRepository;

import lombok.Data;

//@Controller
@Named
@ViewScoped
@Data
public class GenusController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6093466141903573318L;

	@Autowired
	private GenusRepository gr;
	
	private Genus genus;
	
	 @PostConstruct
	  public void init() {
		genus = new Genus();
	  }
	
	@RequestMapping(value="/cadastrar-categoria", method=RequestMethod.GET)
	public String form() {
		return "./cadastrar/add-categoria";
	}
	
	@RequestMapping(value="/cadastrar-categoria", method=RequestMethod.POST)
	public String form(Genus genus) {
		gr.save(genus);
		return "redirect:cadastrar-categoria";
	}
	
	@RequestMapping("/caracteristicas")
	public ModelAndView listaCaracter(){
		ModelAndView mv = new ModelAndView("formCategory");
		Iterable<Characteristics> caracteristicas = genus.getCharacteristics();
		mv.addObject("caracteristicas", caracteristicas);
		return mv;
	}
	

}
