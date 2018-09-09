package com.codenotfound.primefaces.model;

import java.util.List;

public interface IEquipment {
	
	public String getName();
	public String getDescription();
	public ISpecies getSpecies();	
	public String getManufacturer();
	public String getBrand();
	public String getModel();
	public String getSerialNumber();
	public List<String> getCharacteristics();
	public List<String> getAllCharacteristics();
//	public String getCategory();
//	public String getSubCategory();
	
	public void setName(String name);
	public void setDescription(String description);
	public void setSpecies(ISpecies species);
	public void setManufacturer(String manufacture);
	public void setBrand(String brand);
	public void setModel(String model);
	public void setSerialNumber(String sn);
	public void setCharacteristics(List<String> characteristics);
	public void addCharacteristics(String characteristics);
//	public void setCategory(String category);
//	public void setSubCategory(String subCategory);

}
