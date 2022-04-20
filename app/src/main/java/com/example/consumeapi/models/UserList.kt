package com.example.consumeapi.models

class UserList:ArrayList<User>()
data class User(
    val id: Int,
    val email: String,
    val gender: String,
    val name: String,
    val status: String
)
data class UserResponse(val code: Int?, val meta:String?, val data: User?)