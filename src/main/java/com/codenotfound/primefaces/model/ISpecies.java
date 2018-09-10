package com.codenotfound.primefaces.model;

public interface ISpecies extends ITaxonomy{
	
	public IGenus getGenus();
	public void addCharacteristics(Characteristics characteristics);
	
	public void setGenus(IGenus family);

}
