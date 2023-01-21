package com.example.duaily_server.global

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {

    private val logger = LoggerFactory.getLogger(HealthCheckController::class.java)

    @GetMapping("/health-check")
    fun healthCheck(): ResponseEntity<String> {
        val hello = "Hello World!"
        logger.info("hello:[{}]", hello)
        return ResponseEntity.ok(hello)
    }
}