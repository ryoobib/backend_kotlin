package com.example.duaily_server.domain

import com.example.duaily_server.global.TokenUtils
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service

@Service
class AuthService(
        private val userRepository: UserRepository,
        private val tokenUtils: TokenUtils
) {
    fun signIn(signInRequest: SignInRequest) : SignInResponse {
        val user = userRepository.findByPhoneNumOrNull(signInRequest.phoneNum) ?: throw NotFoundException()
        return toDto(user, generateToken(user))
    }

    fun generateToken(user: User): String {

        val accessToken : String = tokenUtils.createAccessToken(user.id!!, user.name)
        val refreshToken : String = tokenUtils.createRefreshToken(user.id!!, user.name)
        tokenUtils.getUserIdFromToken(accessToken)
        return accessToken
    }
}