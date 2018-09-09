package com.codenotfound.primefaces.model;

import java.util.ArrayList;
import java.util.List;

public class Genus implements IGenus{
	
	private String name;
	private String acronyms;
	private String descriptions;
	private ArrayList<String> characteristics;

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getAcronyms() {
		return this.acronyms;
	}

	@Override
	public String getDescription() {
		return this.descriptions;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setAcronyms(String acronyms) {
		this.acronyms = acronyms;
		
	}

	@Override
	public void setDescription(String description) {
		this.descriptions = description;
		
	}
	@Override
	public void addCharacteristics(String characteristics) {
		this.characteristics.add(characteristics);
		
	}

	@Override
	public List<String> getCharacteristics() {
		return this.characteristics;
	}

	@Override
	public void setCharacteristics(List<String> characteristics) {
		this.characteristics = new ArrayList<>(characteristics);
	}


}
