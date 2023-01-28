package com.example.duaily_server.domain

import com.google.gson.Gson
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest
@AutoConfigureMockMvc
class UserControllerTest(
        @Autowired private val mockMvc: MockMvc,
        @Autowired private val userService: UserService,
        @Autowired private val gson : Gson
) {

    @Test
    fun `사용자 전체 조회 테스트`() {
        mockMvc.perform(
                get("/api/v1/users")
        ).andExpect(
                status().isOk
        )
    }
}