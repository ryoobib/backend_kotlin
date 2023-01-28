package com.example.duaily_server.domain

import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
@Table(name = "users")
class User(
        name : String,
        phoneNum : String
) : BaseEntity() {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null

        @Column(name = "name")
        var name : String = name
                protected set

        @Column(name = "phone_number")
        var phoneNum : String = phoneNum
                protected set

        fun update(userUpdateRequest: UserUpdateRequest){
                name = userUpdateRequest.name
                phoneNum = userUpdateRequest.phoneNum
        }
}
