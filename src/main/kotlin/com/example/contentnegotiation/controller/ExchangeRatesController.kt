package com.example.contentnegotiation.controller

import com.example.contentnegotiation.domain.ExchangeRatesService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/exchange-rates")
class ExchangeRatesController(private val exchangeRatesService: ExchangeRatesService) {
    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE])
    fun getAllExchangeRates(): ExchangeRatesResponse {
        val exchangeRates = exchangeRatesService.getAllExchangeRates()
        return ExchangeRatesResponse(
            exchangeRates = exchangeRates.exchangeRates.map {
                ExchangeRateResponseItem(
                    baseCurrency = it.baseCurrency,
                    quotedCurrency = it.quotedCurrency,
                    rate = it.rate
                )
            },
            updatedAt = exchangeRates.updatedAt
        )
    }
}