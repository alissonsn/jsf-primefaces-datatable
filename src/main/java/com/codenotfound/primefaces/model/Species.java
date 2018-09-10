package com.codenotfound.primefaces.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name = "Species")
@Table(name="species")
public class Species implements ISpecies, Serializable{
	
	private static final long serialVersionUID = -4776590794115456322L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="species_id") 
	private long id;
	@Column(unique=true, nullable=false)
	private String name;
	@Column(unique=true)
	private String acronyms;
	private String descriptions;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="genus_id", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Genus genus;
	
	@ManyToMany(fetch=FetchType.LAZY) 
	@JoinTable(name="species_characteristics", 
	joinColumns=@JoinColumn(name="species_id"), inverseJoinColumns=@JoinColumn(name="characteristics_id"))
	private List<Characteristics> characteristics; 
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public void setGenus(Genus genus) {
		this.genus = genus;
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

	@Override
	public IGenus getGenus() {
		return (IGenus)this.genus;
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
	public void setGenus(IGenus genus) {
		this.genus = (Genus) genus;
		
	}

	@Override
	public List<Characteristics> getCharacteristics() {
		return this.characteristics;
	}

	@Override
	public void setCharacteristics(List<Characteristics> characteristics) {
		this.characteristics = new ArrayList<>(characteristics);
		
	}

	@Override
	public void addCharacteristics(Characteristics characteristics) {
		if(!this.characteristics.contains(characteristics) && 
				!this.genus.getCharacteristics().contains(characteristics)) {			
			this.characteristics.add(characteristics);
		}		
	}

}
