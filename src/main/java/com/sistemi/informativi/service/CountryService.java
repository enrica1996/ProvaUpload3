package com.sistemi.informativi.service;

import java.util.List;
import java.util.Map;

import com.sistemi.informativi.entity.Country;

public interface CountryService {

	public Country saveOrUpdateCountry(Country country) throws Exception;

	public Map<String, Boolean> removeCountry(int id);

	public Country findCountryById(int id) throws Exception;

	public List<Country> findAllCountries() throws Exception;
	
	public List<Country> findAllCountriesByInhabitantsBetween(float limit1, float limit2) throws Exception;

}
