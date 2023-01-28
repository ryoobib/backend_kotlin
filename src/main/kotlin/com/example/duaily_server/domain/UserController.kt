package com.example.duaily_server.domain

import org.springframework.web.bind.annotation.*

@RestController
class UserController(
        private val userService: UserService
) {
    @GetMapping("/api/v1/users")
    fun getUserAll() : MutableIterable<User> = userService.getUserAll()

    @PostMapping("/api/v1/users")
    fun creatUser(@RequestBody userCreateRequest : UserCreateRequest) : User = userService.createUser(userCreateRequest)

    @PutMapping("/api/v1/users/{userId}")
    fun updateUser(@PathVariable userId: Long, @RequestBody userUpdateRequest: UserUpdateRequest) : User = userService.updateUser(userUpdateRequest, userId)
}