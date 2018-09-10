package com.codenotfound.primefaces.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.codenotfound.primefaces.model.Genus;
import com.codenotfound.primefaces.repository.GenusRepository;

@Named
@ViewScoped
public class GenusView implements Serializable{

	private static final long serialVersionUID = 8307901783667261663L;
	
	@Inject
	private GenusRepository gr;
	
	private Genus genus;
	
	@PostConstruct
	public void init() {
		this.genus = new Genus();
	}
	
	public Genus getGenus() {
		return this.genus;
	}

}
