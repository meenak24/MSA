package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private CurrencyExchangeServiceProxy proxy;
  
  @GetMapping("/currency-conversionr-feign/getCountryCode/{countryCode}/quantity/{quantity}")
  public CurrencyConversionBean convertCurrencyFeign(@PathVariable String countryCode,@PathVariable Double quantity) {

    CurrencyConversionBean response = proxy.retrieveExchangeValue(countryCode);

    logger.info("{}", response);

    return new CurrencyConversionBean( response.getConversionFactor(), quantity*(response.getConversionFactor()), response.getPort());
  }	

}
