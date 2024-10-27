package com.example.CurrencyApplication.currencyexchangeservice.repositories;

import com.example.CurrencyApplication.currencyexchangeservice.Beans.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,Long> {
    CurrencyExchange findByFromAndTo(String from,String to);
}
