package com.example.duaily_server.domain

data class SignInRequest(
        val phoneNum : String
)

data class SignInResponse(
        val name : String,
        val phoneNum : String,
        val token : String
)
fun toDto(user: User, token : String) : SignInResponse {
    return SignInResponse(
            name = user.name,
            phoneNum = user.phoneNum,
            token = token
    )
}
