package com.sistemi.informativi.service;

import java.util.List;
import java.util.Map;

import com.sistemi.informativi.entity.City;

public interface CityService {
	
	public City saveOrUpdateCity(City city) throws Exception;

	public Map<String, Boolean> removeCity(int id);

	public City findCityById(int id) throws Exception;

	public List<City> findAllCity() throws Exception;
	
	public List<City> findAllCitiesByInhabitantsBetween(float limit1, float limit2) throws Exception;
	
	public List<City> findAllCitiesByCountry(int countryId) throws Exception;

}
