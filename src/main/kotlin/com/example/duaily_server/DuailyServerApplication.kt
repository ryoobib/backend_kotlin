package com.example.duaily_server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class DuailyServerApplication

fun main(args: Array<String>) {
    runApplication<DuailyServerApplication>(*args)
}
