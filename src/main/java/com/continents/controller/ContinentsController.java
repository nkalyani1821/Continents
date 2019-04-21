package com.continents.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.continents.service.ContinentService;

@RestController
public class ContinentsController {
	
	private Logger log = LogManager.getLogger(ContinentsController.class);

	@Autowired
	public ContinentService continentService;

	@GetMapping("/")
	public ResponseEntity<?> getAllData() {
		
		log.info("Request to get All Continents");
		return ResponseEntity.ok(continentService.getContinents());
	}
	
	@GetMapping("/{continent}")
	public ResponseEntity<?> getCountries(@PathVariable("continent") String continent) {
		
		log.info("Request to get All countries by continent : " + continent);
		return ResponseEntity.ok(continentService.getCountries(continent));
	}
	
	@GetMapping("/country/{name}")
	public ResponseEntity<?> getCountryFlag(@PathVariable("name") String name) {
		
		log.info("Request to get country flag by Country name : " + name);
		
		return ResponseEntity.ok(continentService.getCountryFlag(name));
	}
}
