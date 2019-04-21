package com.continents.service;

import java.util.List;

import com.continents.bean.Continent;
import com.continents.bean.Country;

public interface ContinentService {

	public List<Continent> getContinents();

	public List<Country> getCountries(String continent);

	public String getCountryFlag(String name);
}
