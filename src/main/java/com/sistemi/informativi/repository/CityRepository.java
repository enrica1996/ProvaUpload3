package com.sistemi.informativi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemi.informativi.entity.City;

public interface CityRepository extends JpaRepository<City, Integer>{
	
	public List<City> findByInhabitantsBetween(float limit1, float limit2);

}
