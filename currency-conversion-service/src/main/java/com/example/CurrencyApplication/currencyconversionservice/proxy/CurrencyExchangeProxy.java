package com.example.CurrencyApplication.currencyconversionservice.proxy;

import com.example.CurrencyApplication.currencyconversionservice.beans.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-exchange-service")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveCurrencyExchange
            (@PathVariable String from,
             @PathVariable String to);
}
