package com.codenotfound.primefaces.model;

import java.util.List;

public interface ITaxonomy {
	
	public String getName();
	public String getAcronyms();
	public String getDescription();
	public List<Characteristics> getCharacteristics();
	
	public void setName(String name);
	public void setAcronyms(String acronyms);
	public void setDescription(String description);
	public void setCharacteristics(List<Characteristics> characteristics);

}
