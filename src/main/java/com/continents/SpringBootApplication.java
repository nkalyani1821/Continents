package com.continents;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan({ "com.continents.controller", "com.continents.service", "com.continents.service.impl" })
public class SpringBootApplication extends SpringBootServletInitializer {

	private static Logger log = LogManager.getLogger(SpringBootApplication.class);

	public static void main(String[] args) {
		log.info("Application start up");
		SpringApplication.run(SpringBootApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootApplication.class);
	}

}
