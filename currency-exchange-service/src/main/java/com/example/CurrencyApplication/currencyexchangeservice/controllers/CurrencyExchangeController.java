package com.example.CurrencyApplication.currencyexchangeservice.controllers;

import com.example.CurrencyApplication.currencyexchangeservice.Beans.CurrencyExchange;
import com.example.CurrencyApplication.currencyexchangeservice.repositories.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;
    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveCurrencyExchange
            (@PathVariable String from,
             @PathVariable String to) {

        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from,to);
        if(currencyExchangeRepository == null){
            throw new RuntimeException("cant find any data");
        }
    return currencyExchange;
    }
}
