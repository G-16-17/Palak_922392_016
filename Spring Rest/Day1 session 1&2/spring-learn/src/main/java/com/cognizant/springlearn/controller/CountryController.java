package com.cognizant.springlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	@Autowired
	CountryService countryService;

	@RequestMapping(("/country"))
	public Country getCountryIndia() {
		LOGGER.info("START of getCountryIndia ");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("in", Country.class);

		LOGGER.info("END of getCountryIndia");
		return country;

	}

	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		LOGGER.info("START of getAllCountries ");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		@SuppressWarnings("unchecked")
		List<Country> countries = (List<Country>) context.getBean("countryList");
		LOGGER.info("END of getAllCountries ");
		return countries;

	}

	@GetMapping("/countries/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {

		LOGGER.info("Start");
		LOGGER.info("End");
		Country country = countryService.getCountry(code);
		return country;
	}

}
