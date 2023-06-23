package com.sistemi.informativi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class City implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50)
	private String name;
	@Column(precision = 9, scale = 2, nullable = false)
	private float inhabitants;
	@ManyToOne(fetch=FetchType.EAGER)
	private Country country;
	
	
	protected City() {
	}


	public City(String name, float inhabitants) {
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


	public Country getCountry() {
		return country;
	}


	public void setCountry(Country country) {
		this.country = country;
	}
}
