package com.sistemi.informativi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemi.informativi.entity.Country;
import com.sistemi.informativi.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public Country saveOrUpdateCountry(Country country) throws Exception {
		Country countrySavedOrUpdated = countryRepository.save(country);
		if (!countrySavedOrUpdated.getName().equals(country.getName())) {
			throw new Exception("Inserimento/Aggiornamento Country failed");
		}
		return countrySavedOrUpdated;
	}

	@Override
	public Map<String, Boolean> removeCountry(int id) {
		Map<String, Boolean> deletionMap = new HashMap<>();

		try {
			countryRepository.deleteById(id);
			deletionMap.put("deletion", true);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			deletionMap.put("deletion", false);
		}

		return deletionMap;
	}

	@Override
	public Country findCountryById(int id) throws Exception {
		return countryRepository.findById(id).orElseThrow(() -> new Exception("Country not found"));
	}

	@Override
	public List<Country> findAllCountries() throws Exception {
		List<Country> countries = new ArrayList<>();
		countries = countryRepository.findAll();
		if (countries.isEmpty()) {
			throw new Exception("List All Countries is Empty");
		}
		return countries;

	}

	@Override
	public List<Country> findAllCountriesByInhabitantsBetween(float limit1, float limit2) throws Exception {
		List<Country> countries = new ArrayList<>();
		countries = countryRepository.findByInhabitantsBetween(limit1, limit2);
		if (countries.isEmpty()) {
			throw new Exception("Lista Country by Inghabitants Between is Empty");
		}
		return countries;
	}

}
