package com.example.contentnegotiation.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver
import java.util.*

@Configuration
class LocaleConfiguration {
    @Bean
    fun localeResolver(): LocaleResolver {
        val localeResolver = AcceptHeaderLocaleResolver()
        localeResolver.setDefaultLocale(Locale.ENGLISH)
        localeResolver.supportedLocales = listOf(Locale.ENGLISH, Locale.GERMANY, Locale("pl"))

        return localeResolver
    }
}