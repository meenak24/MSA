package com.example.demo;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-conversion", url="localhost:8091")
@RibbonClient(name="currency-conversion")
public interface CurrencyExchangeServiceProxy {
  @GetMapping("/currency-conversion/getCountryCode/{countryCode}/")
  public CurrencyConversionBean retrieveExchangeValue
    (@PathVariable("countryCode") String from);
}
