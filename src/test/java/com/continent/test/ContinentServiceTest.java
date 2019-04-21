package com.continent.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.continents.service.ContinentService;
import com.continents.service.impl.ContinentServiceImpl;
import com.continents.utils.ObjectNotFoundException;

@ExtendWith(SpringExtension.class)
class ContinentServiceTest {

	ContinentService continentServoce = new ContinentServiceImpl();
	
	@Test
	@DisplayName("Test get All Continents")
	void getAllContinentsTest() {
		assertEquals(5, continentServoce.getContinents().size());
	}
	
	@Test
	@DisplayName("test get continent countries")
	public void getContinentCountriesTest() {
		assertTrue(!continentServoce.getCountries("Africa").isEmpty());
	}
	
	@Test
	@DisplayName("test get continent countries ObjectNotFoundException")
	public void getContinentCountriesNotFoundTest() {
		
		assertThrows(ObjectNotFoundException.class, () -> continentServoce.getCountries("Afric"));
	}
	
	@Test
	@DisplayName("test get country flag")
	public void getCountryFlagTest() {
		assertTrue(continentServoce.getCountryFlag("Nigeria") != null);
	}
	
	@Test
	@DisplayName("test get country Flag ObjectNotFoundException")
	public void getCountryFlagNotFoundTest() {
		
		assertThrows(ObjectNotFoundException.class, () -> continentServoce.getCountryFlag("Ind"));
	}
	
	

}
