package com.codenotfound.primefaces.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Equipment implements IEquipment{
	
	private String manufacturer;
	private String brand;
	private String model;
	private String sn;
	private Species species;
	private ArrayList<Characteristics> characteristics;

	@Override
	public String getManufacturer() {
		return this.manufacturer;
	}

	@Override
	public String getBrand() {
		return this.brand;
	}

	@Override
	public String getModel() {
		return this.model;
	}

	@Override
	public String getSerialNumber() {
		return this.sn;
	}
	
	public ISpecies getSpecies() {
		return this.species;
	}
	
	public List<Characteristics> getCharacteristics(){
		return this.characteristics;
	}
	public List<Characteristics> getAllCharacteristics(){
		List<Characteristics> newList = Stream.of(this.getSpecies().getGenus().getCharacteristics(), 
				this.getSpecies().getCharacteristics(), this.getCharacteristics())
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
		return newList;
	}

	@Override
	public void setManufacturer(String manufacture) {
		this.manufacturer = manufacture;
		
	}

	@Override
	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public void setSerialNumber(String sn) {
		this.sn = sn;
	}
	
	public void setSpecies(ISpecies species) {
		this.species = (Species) species;
	}
	
	public void setCharacteristics(List<Characteristics> characteristics) {
		this.characteristics = new ArrayList<>(characteristics);
	}
	
	public void addCharacteristics(Characteristics characteristics) {
		this.characteristics.add(characteristics);
	}

	@Override
	public String toString() {
		String str = super.toString();
		str += "fabricante: " + this.manufacturer+"\n";
		str += "marca: " + this.brand+"\n";
		str += "modelo: " + this.model +"\n";
		str += "série de fabricação: " + this.sn +"\n";
		str += "caracteristicas: ";
//		str += String.join("\n", Stream.of(this.getCharacteristics()).flatMap(x -> x.toString())); 
		return str; 
	}
	@Override
    public int hashCode() {
        int hash = this.toString().hashCode();
        return hash;
    }

	
	 @Override
    public boolean equals(Object obj) {
	 	if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        try {
        	final Equipment other = (Equipment) obj;
        	if (!Objects.equals(this.hashCode(), other.hashCode())) {
        		return false;
        	}	        	
        }catch(ClassCastException ex) {
        	return false;
        }
        return true;
    }
	

}
