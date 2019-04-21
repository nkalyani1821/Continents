package com.continents.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.continents.bean.Continent;
import com.continents.bean.Country;
import com.continents.repository.ContinentsRepository;
import com.continents.service.ContinentService;
import com.continents.utils.ObjectNotFoundException;

@Service
public class ContinentServiceImpl implements ContinentService {

	public List<Continent> getContinents() {

		return getAllContinents();
	}

	@Override
	public List<Country> getCountries(String continent) {
		return getAllContinents().parallelStream()
				.filter(continentBean -> continentBean.getContinent().equalsIgnoreCase(continent))
				.map(continentBean -> continentBean.getCountries()).findAny()
				.orElseThrow(() -> new ObjectNotFoundException("Given continent '" + continent + "' not found"));
	}

	private List<Continent> getAllContinents() {

		ContinentsRepository continentRepo = ContinentsRepository.getInstance();
		return continentRepo.getContinents();
	}

	@Override
	public String getCountryFlag(String name) {

		return getAllContinents().parallelStream().flatMap(continent -> continent.getCountries().stream())
				.filter(country -> country.getName().equalsIgnoreCase(name)).map(country -> country.getFlag()).findAny()
				.orElseThrow(() -> new ObjectNotFoundException("Given country '" + name + "' not found"));
	}

}
