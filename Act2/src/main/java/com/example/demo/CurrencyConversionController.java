package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyConversionRepository repository;

	@Autowired
	private Environment environment;
	
	@PostMapping("/currency-conversion/save/")
	public CurrencyConversion saveCurrencyConversion(@RequestBody CurrencyConversion conversion) {
		conversion.setPort(
		        Integer.parseInt(environment.getProperty("local.server.port")));
		repository.save(conversion);
		return conversion;
	}
	@HystrixCommand(fallbackMethod="fallback")
	@GetMapping("/currency-conversion/getCountryCode/{countryCode}")
	public Double getByCountryCode(@PathVariable String countryCode) {
		CurrencyConversion conversion= repository.findByCountryCode(countryCode);
		
		  if(countryCode.equalsIgnoreCase("US")) { throw new RuntimeException(); }
		 
		conversion.setPort(
		        Integer.parseInt(environment.getProperty("local.server.port")));
		return conversion.getConversionFactor();
	}

	@PutMapping("/currency-conversion/update/")
	public CurrencyConversion updateCurrencyConversion(@RequestBody CurrencyConversion conversion) {
		conversion.setPort(
		        Integer.parseInt(environment.getProperty("local.server.port")));
		repository.save(conversion);
		return conversion;
	}
	
	public Double fallback(String countryCode) {
		 return 10.0;
	}

	
}