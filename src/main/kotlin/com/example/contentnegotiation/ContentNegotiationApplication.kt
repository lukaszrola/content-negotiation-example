package com.example.contentnegotiation

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@SpringBootApplication
@ServletComponentScan
class ContentNegotiationApplication

fun main(args: Array<String>) {
	runApplication<ContentNegotiationApplication>(*args)
}
