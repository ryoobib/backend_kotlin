package com.example.duaily_server.domain

data class UserCreateRequest(
        val name: String,
        val phoneNum: String
) {
    fun toEntity() : User {
        return User(
                this.name,
                this.phoneNum
        )
    }
}

data class UserUpdateRequest(
        val name: String = "",
        val phoneNum: String = ""
)

data class UserResponse(
        val id: Long? = null,
        val name : String,
        val phoneNum: String
)