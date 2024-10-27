package com.example.CurrencyApplication.currencyconversionservice.controllers;

import com.example.CurrencyApplication.currencyconversionservice.beans.CurrencyConversion;
import com.example.CurrencyApplication.currencyconversionservice.proxy.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {
    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;
    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){

        CurrencyConversion currencyConversion =
                currencyExchangeProxy.retrieveCurrencyExchange(from, to);
        return new CurrencyConversion(
                currencyConversion.getId(),
                from,
                to,
                quantity,
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                "");
    }
}
