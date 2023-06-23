package com.sistemi.informativi.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Country implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50, nullable = false)
	private String name;
	@Column(precision = 9, scale = 2, nullable = false) //precision numero di cifre prima della virgola, scale numero di cifre dopo la virgola
	private float inhabitants;
	@JsonIgnore
	@OneToMany(mappedBy="country", fetch = FetchType.EAGER)
	private List<City> cities = new ArrayList<>();

	protected Country() {
	}

	public Country(String name, float inhabitants) {
		this.name = name;
		this.inhabitants = inhabitants;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getInhabitants() {
		return inhabitants;
	}

	public void setInhabitants(float inhabitants) {
		this.inhabitants = inhabitants;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
}
