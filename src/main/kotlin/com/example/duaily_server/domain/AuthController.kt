package com.example.duaily_server.domain

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(
        private val authService : AuthService
) {

    @PostMapping("/api/v1/auth/sign-in")
    fun signIn(signInRequest: SignInRequest) : SignInResponse = authService.signIn(signInRequest)
}