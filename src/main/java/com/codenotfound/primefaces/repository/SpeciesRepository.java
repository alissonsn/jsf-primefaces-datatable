package com.codenotfound.primefaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codenotfound.primefaces.model.Species;


public interface SpeciesRepository extends JpaRepository<Species, Long>{

}
