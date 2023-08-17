package com.example.contentnegotiation.controller

import com.example.contentnegotiation.domain.ExchangeRates
import kotlinx.html.*
import kotlinx.html.stream.appendHTML
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.stereotype.Component
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

private val DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss")

@Component
class HTMLMapper {
    fun mapToHTML(exchangeRates: ExchangeRates): String {
        val locale = LocaleContextHolder.getLocale()
        return buildString {
            appendHTML().html {
                head {
                    title { +"Exchange rates" }
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
                                 thead, td {
                                   text-align: center;
                                   padding: 10px;
                                   border:1px solid black;
                                 }
                           """.trimIndent()
                        }
                    }
                }

                body {
                    h1 { +"Exchange rates" }
                    p {
                        h2 {
                            +"Updated at: ${DATE_TIME_FORMATTER.format(exchangeRates.updatedAt.atOffset(ZoneOffset.UTC))}"
                        }

                        table {
                            thead {
                                tr {
                                    td { b { +"Base currency"} }
                                    td { b { +"Quoted currency" } }
                                    td { b { +"Rate"} }
                                }
                            }
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