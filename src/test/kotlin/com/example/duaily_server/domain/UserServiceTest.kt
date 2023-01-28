package com.example.duaily_server.domain

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class UserServiceTest {

    @InjectMockKs
    private lateinit var underTest: UserService

    @MockK
    private lateinit var userRepository: UserRepository

    @Test
    fun getUserAll() {

    }

    @Test
    fun createUser() {
    }

    @Test
    fun updateUser() {
    }
}