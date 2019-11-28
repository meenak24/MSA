package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyConversionRepository extends 
    CrudRepository<CurrencyConversion,Long>{
	CurrencyConversion findByCountryCode(String countryCode);
	CurrencyConversion save(CurrencyConversion conversion);
	
}