package com.sistemi.informativi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemi.informativi.entity.Country;
import com.sistemi.informativi.service.CountryService;

/*
 * http://localhost:8080/countries---->GET
 * http://localhost:8080/countries/country-inhabitants/{limit1}/{limit2}------------->GET
 * http://localhost:8080/countries/country.id/{id}------>GET
 * http://localhost:8080/countries-------->POST
 * http://localhost:8080/countries--------PUT
 * http://localhost:8080/countries/country-id/{id}---->DELETE
 */

@RestController
@RequestMapping("/countries")
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping("")
	public List<Country> findAllCountries() throws Exception{
		return countryService.findAllCountries();
	}
	
	@GetMapping("/country-inhabitants/{limit1}/{limit2}")
	public List<Country> findAllCountriesByInhabitantsBetween(@PathVariable float limit1, @PathVariable float limit2) throws Exception{
		return countryService.findAllCountriesByInhabitantsBetween(limit1, limit2);
	}
	
	@GetMapping("/country-id/{id}")
	public Country findCountryById(@PathVariable int id) throws Exception {
		return countryService.findCountryById(id);
	}
	
	@PostMapping("")
	public Country saveCountry(@RequestBody Country country) throws Exception {
		return countryService.saveOrUpdateCountry(country);
	}
	
	@PutMapping("")
	public Country updateCountry(@RequestBody Country country) throws Exception {
		return countryService.saveOrUpdateCountry(country);
	}
	
	@DeleteMapping("/country-id/{id}")
	public Map<String, Boolean> removeCountry(@PathVariable int id){
		return countryService.removeCountry(id);
	}
}
