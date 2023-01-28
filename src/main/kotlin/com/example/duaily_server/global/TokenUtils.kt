package com.example.duaily_server.global

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class TokenUtils(
        @Value("\\${jwt.secretKey}")
        private val secretKey: String,

        @Value("\\${jwt.accessValidTime}")
        private val accessValidTime: Int,

        @Value("\\${jwt.refreshValidTime}")
        private val refreshValidTime: Int,

        @Value("\\${jwt.accessName}")
        private val accessName : String,

        @Value("\\${jwt.refreshName}")
        private val refreshName : String
){
    fun createAccessToken(userId: Long, name: String): String {
        val now = Date()
        val claims: Claims = Jwts.claims()
                .setSubject(accessName)
                .setIssuedAt(now)
        claims.put("userId", userId)
        claims.put("name", name)
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setClaims(claims)
                .setExpiration(Date(now.time + accessValidTime))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact()
    }

    fun createRefreshToken(userId: Long, name: String) : String {
        val now = Date()
        val claims: Claims = Jwts.claims()
                .setSubject(refreshName)
                .setIssuedAt(now)
        claims.put("userId", userId)
        claims.put("name", name)
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setClaims(claims)
                .setExpiration(Date(now.time + refreshValidTime))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact()
    }
    fun getUserIdFromToken(token: String): String {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).body["userId"].toString()
    }
}