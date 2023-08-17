package com.example.contentnegotiation.domain

import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.Instant
import java.util.*

private val EUR = Currency.getInstance("EUR")
private val USD = Currency.getInstance("USD")
private val PLN = Currency.getInstance("PLN")

@Service
class ExchangeRatesService {
    private val exchangeRates: ExchangeRates = ExchangeRates(
        listOf(
            ExchangeRate(
                baseCurrency = EUR,
                quotedCurrency = USD,
                rate = BigDecimal.valueOf(1.10)
            ),
            ExchangeRate(
                baseCurrency = USD,
                quotedCurrency = EUR,
                rate = BigDecimal.valueOf(0.90)
            ),
            ExchangeRate(
                baseCurrency = EUR,
                quotedCurrency = PLN,
                rate = BigDecimal.valueOf(4.44)
            ),
            ExchangeRate(
                baseCurrency = PLN,
                quotedCurrency = EUR,
                rate = BigDecimal.valueOf(0.23)
            ),
            ExchangeRate(
                baseCurrency = USD,
                quotedCurrency = PLN,
                rate = BigDecimal.valueOf(4.04)
            ),
            ExchangeRate(
                baseCurrency = PLN,
                quotedCurrency = USD,
                rate = BigDecimal.valueOf(0.25)
            )
        ),
        Instant.now()
    )

    fun getAllExchangeRates(): ExchangeRates {
        return exchangeRates
    }
}

data class ExchangeRates(val exchangeRates: List<ExchangeRate>, val updatedAt: Instant)

data class ExchangeRate(val baseCurrency: Currency, val quotedCurrency: Currency, val rate: BigDecimal)