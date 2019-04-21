package com.continents.repository;

import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.continents.bean.Continent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ContinentsRepository {

	private Logger log = LogManager.getLogger(ContinentsRepository.class);

	private static ContinentsRepository continetRepository = null;

	private List<Continent> continents = null;

	private ContinentsRepository() {
		Gson gson = new Gson();
		Type type = new TypeToken<List<Continent>>() {
		}.getType();

		String fileName = "/continents.json";
		log.info("Reading file " + fileName);
		this.continents = gson.fromJson(new InputStreamReader(this.getClass().getResourceAsStream(fileName)), type);
	}

	public synchronized static ContinentsRepository getInstance() {

		if (continetRepository == null) {
			continetRepository = new ContinentsRepository();
		}
		return continetRepository;
	}

	public List<Continent> getContinents() {
		return continents;
	}

}
