package com.codenotfound.primefaces.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Genus")
@Table(name="genus")
public class Genus implements IGenus, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4872381131858696778L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="genus_id") 
	private long id;
	@Column(unique=true, nullable=false) 
	private String name;
	@Column(unique=true)
	private String acronyms;
	private String descriptions;
	
	@OneToMany(mappedBy="genus", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Species> species;
	
	@ManyToMany(fetch=FetchType.LAZY) 
	@JoinTable(name="genus_characteristics", 
	joinColumns=@JoinColumn(name="genus_id"), inverseJoinColumns=@JoinColumn(name="characteristics_id"))
	private List<Characteristics> characteristics;
	
	public Genus() {
		this.id = -1;
		this.name = "";
		this.acronyms = "";
		this.descriptions = "";
//		this.characteristics = new ArrayList<>();
	}
	
	public long getId() {
		return this.id;
	}

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
	
	public void setId(long id) {
		if(this.id < 0) {
			this.id = id;
		}
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
	public void addCharacteristics(Characteristics characteristics) {
		if(!this.characteristics.contains(characteristics)) {			
			this.characteristics.add(characteristics);
		}
		
	}

	@Override
	public List<Characteristics> getCharacteristics() {
		return this.characteristics;
	}

	@Override
	public void setCharacteristics(List<Characteristics> characteristics) {
		this.characteristics = new ArrayList<>(characteristics);
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public List<Species> getSpecies() {
		return species;
	}

	public void setSpecies(List<Species> species) {
		this.species = species;
	}
	
	


}
