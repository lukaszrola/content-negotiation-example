package com.example.contentnegotiation.controller

import com.example.contentnegotiation.domain.ExchangeRates
import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.stereotype.Component
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

private const val EXCHANGE_RATES = "exchange-rates"
private const val UPDATED_AT = "updated-at"
private const val BASE_CURRENCY = "base-currency"
private const val QUOTED_CURRENCY = "quoted-currency"
private const val RATE = "rate"

private val DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss")

@Component
class HTMLMapper(private val messageSource: MessageSource) {
    fun mapToHTML(exchangeRates: ExchangeRates): String {
        val locale = LocaleContextHolder.getLocale()
        return buildString {
            appendHTML().html {
                head {
                    title { +messageSource.getMessage(EXCHANGE_RATES, null, locale)}
                    style {
                        unsafe {
                            +"""
                                 h1, h2, p {
                                   text-align: center;
                                 }
                                 table {
                                   margin-left:auto;
                                   margin-right:auto;
                                 }
                                 th, td {
                                   text-align: center;
                                   padding: 10px;
                                   border:1px solid black;
                                 }
                           """.trimIndent()
                        }
                    }
                }

                body {
                    h1 { +messageSource.getMessage(EXCHANGE_RATES, null, locale) }
                    p {
                        h2 {
                            +"${messageSource.getMessage(UPDATED_AT, null, locale)}: ${DATE_TIME_FORMATTER.format(exchangeRates.updatedAt.atOffset(ZoneOffset.UTC))}"
                        }

                        table {
                            thead {
                                tr {
                                    th { +messageSource.getMessage(BASE_CURRENCY, null, locale) }
                                    th { +messageSource.getMessage(QUOTED_CURRENCY, null, locale) }
                                    th { +messageSource.getMessage(RATE, null, locale)}
                                }
                            }
                            tbody {
                                exchangeRates.exchangeRates.map {
                                    tr {
                                        td { +"${it.baseCurrency}" }
                                        td { +"${it.quotedCurrency}" }
                                        td { +"${it.rate}" }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}