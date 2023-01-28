package com.example.duaily_server.domain

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface UserRepository : JpaRepository<User, Long>{
    fun findByPhoneNumOrNull(phoneNum: String): Nothing?
}