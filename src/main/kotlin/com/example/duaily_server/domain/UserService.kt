package com.example.duaily_server.domain

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserService(
        private val userRepository: UserRepository
) {
    fun getUserAll() : MutableIterable<User> {
        return userRepository.findAll()
    }

    @Transactional
    fun createUser(userCreateRequest: UserCreateRequest) : User {
        return userRepository.save(userCreateRequest.toEntity())
    }

    @Transactional
    fun updateUser(userUpdateRequest: UserUpdateRequest,
    userId : Long) : User {
        val user = userRepository.findByIdOrNull(userId) ?: throw IllegalArgumentException("userId = $userId, 해당하는 user가 없습니다.")
        user.update(userUpdateRequest)
        return userRepository.save(user)
    }
}