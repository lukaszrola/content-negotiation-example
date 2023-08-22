package com.example.contentnegotiation.controller

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.annotation.WebFilter
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders

@WebFilter("/exchange-rates")
class ExchangeRateFilter : Filter{
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val httpServletResponse = response as HttpServletResponse

        httpServletResponse.setHeader(HttpHeaders.VARY, "${HttpHeaders.ACCEPT}, ${HttpHeaders.ACCEPT_LANGUAGE}, ${HttpHeaders.ACCEPT_ENCODING}")

        chain!!.doFilter(request, response)
    }
}