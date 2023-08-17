package com.example.contentnegotiation.controller

import java.math.BigDecimal
import java.time.Instant
import java.util.*

data class ExchangeRatesResponse(
    val exchangeRates: List<ExchangeRateResponseItem>,
    val updatedAt: Instant
)

data class ExchangeRateResponseItem(val baseCurrency: Currency, val quotedCurrency: Currency, val rate: BigDecimal)