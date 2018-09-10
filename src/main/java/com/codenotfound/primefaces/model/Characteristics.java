package com.codenotfound.primefaces.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Characteristics")
@Table(name="characteristics")
public class Characteristics implements Serializable{

	private static final long serialVersionUID = -5611004461559518373L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="characteristics_id")
	private long id;
	@Column(unique=true, nullable=false) 
	private String name;
	@ManyToMany(fetch=FetchType.LAZY) 
	@JoinTable(name="genus_characteristics", 
	joinColumns=@JoinColumn(name="characteristics_id"), inverseJoinColumns=@JoinColumn(name="genus_id"))
	private List<Genus> genus;
	@ManyToMany(fetch=FetchType.LAZY) 
	@JoinTable(name="species_characteristics", 
	joinColumns=@JoinColumn(name="characteristics_id"), inverseJoinColumns=@JoinColumn(name="species_id"))
	private List<Species> species;
	
	public Characteristics() {
		this.name = "";
		this.id = -1;
	}
	
	public Characteristics(String characteristics) {
		this.name = characteristics;
		this.id = -1;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		if(this.id < 0) {			
			this.id = id;
		}
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	
	public List<Genus> getGenus() {
		return genus;
	}

	public void setGenus(List<Genus> genus) {
		this.genus = genus;
	}

	public List<Species> getSpecies() {
		return species;
	}

	public void setSpecies(List<Species> species) {
		this.species = species;
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
	        	final Characteristics other = (Characteristics) obj;
	        	if (!Objects.equals(this.hashCode(), other.hashCode())) {
	        		return false;
	        	}	        	
	        }catch(ClassCastException ex) {
	        	return false;
	        }
	        return true;
	    }
	

}
