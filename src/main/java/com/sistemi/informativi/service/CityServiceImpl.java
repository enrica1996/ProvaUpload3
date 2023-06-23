package com.sistemi.informativi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemi.informativi.entity.City;
import com.sistemi.informativi.entity.Country;
import com.sistemi.informativi.repository.CityRepository;
import com.sistemi.informativi.repository.CountryRepository;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CountryRepository countryRepository;

	@Override
	public City saveOrUpdateCity(City city) throws Exception {
		Country country = countryRepository.findById(city.getCountry().getId()).orElseThrow(()-> new Exception ("Country not found"));
		
		city.setCountry(country);
		
		City citySavedOrUpdated = cityRepository.save(city);
		if (!citySavedOrUpdated.getName().equals(city.getName())) {
			throw new Exception("Inserimento/Aggiornamento City failed");
		}
		return citySavedOrUpdated;
	}

	@Override
	public Map<String, Boolean> removeCity(int id) {
		Map<String, Boolean> deletionMap = new HashMap<>();

		try {
			cityRepository.deleteById(id);
			deletionMap.put("deletion", true);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			deletionMap.put("deletion", false);
		}
		return deletionMap;
	}

	@Override
	public City findCityById(int id) throws Exception {
		
		return cityRepository.findById(id).orElseThrow(()-> new Exception("City not found"));
	}

	@Override
	public List<City> findAllCity() throws Exception {
		List<City> cities = new ArrayList<>();
		cities = cityRepository.findAll();
		if (cities.isEmpty()) {
			throw new Exception("List All Cities is Empty");
		}
		return cities;
	}

	@Override
	public List<City> findAllCitiesByInhabitantsBetween(float limit1, float limit2) throws Exception {
		List<City> cities = new ArrayList<>();
		cities = cityRepository.findByInhabitantsBetween(limit1, limit2);
		if (cities.isEmpty()) {
			throw new Exception("List Cities by Inghabitants Between is Empty");
		}
		return cities;
	}

	@Override
	public List<City> findAllCitiesByCountry(int countryId) throws Exception {

		// 1.recuperare country con countryId

		Country country = countryRepository.findById(countryId).orElseThrow(() -> new Exception("Country not found"));

		// 2.recuperare tutte le cities relative al country recuperato prima

		return country.getCities();
	}

}
