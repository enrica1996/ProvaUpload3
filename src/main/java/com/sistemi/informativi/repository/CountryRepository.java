package com.sistemi.informativi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemi.informativi.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{
	
	public List<Country> findByInhabitantsBetween(float limit1, float limit2);
	
	

}
