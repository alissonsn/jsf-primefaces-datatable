package com.codenotfound.primefaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codenotfound.primefaces.model.Genus;

public interface GenusRepository extends JpaRepository<Genus, Long>{
	
//	public default <S extends Genus> S save(Genus arg0) {
//	
//		return null;
//	}

}
