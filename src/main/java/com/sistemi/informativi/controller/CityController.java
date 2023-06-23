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

import com.sistemi.informativi.entity.City;
import com.sistemi.informativi.service.CityService;

/*
 * http://localhost:8080/cities
 * http://localhost:8080/cities/city-inhabitants/{limit1}/{limit2}
 * http://localhost:8080/cities/city-id/{id}
 * http://localhost:8080/cities/country-id/{countryId}
 * http://localhost:8080/cities
 * http://localhost:8080/cities
 * http://localhost:8080/cities/city-id/{id}
 */

@RestController
@RequestMapping("/cities")
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@GetMapping("")
	public List<City> findAllCities() throws Exception{
		return cityService.findAllCity();
	}
	
	@GetMapping("city-inhabitants/{limit1}/{limit2}")
	public List<City> findAllCitiesByInhabitantsBetween(@PathVariable float limit1, @PathVariable float limit2) throws Exception{
		return cityService.findAllCitiesByInhabitantsBetween(limit1, limit2);
	}
	
	@GetMapping("/city-id/{id}")
	public City findCityById(@PathVariable int id) throws Exception{
		return cityService.findCityById(id);
	}
	
	@PostMapping("")
	public City saveCity(@RequestBody City city) throws Exception{
		return cityService.saveOrUpdateCity(city);
	}
	
	 @PutMapping("")
		public City updateCity(@RequestBody City city) throws Exception{
			return cityService.saveOrUpdateCity(city);
		}
	 
	 @DeleteMapping("/city-id/{id}")
	 public Map<String, Boolean> removeCity(@PathVariable int id){
		 return cityService.removeCity(id);
	 }
	
	
		
	
	
	

}
