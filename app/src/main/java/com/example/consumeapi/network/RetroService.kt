package com.example.consumeapi.network

import com.example.consumeapi.models.User
import com.example.consumeapi.models.UserList
import com.example.consumeapi.models.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface RetroService {
    @GET("users")
    @Headers("Accept:application/json", "Content-Type:application/json" )
    fun getUserList(): Call<UserList>

    @GET("users")
    @Headers("Accept:application/json", "Content-Type:application/json" )
    fun searchUsers(@Query("name") searchText: String): Call<UserList>

    @GET("users/{user_id}")
    @Headers("Accept:application/json", "Content-Type:application/json" )
    fun getUser(@Path("user_id") searchText: String): Call<UserList>

    @PATCH("users/{user_id}")
    @Headers("Accept:application/json", "Content-Type:application/json","Authorization: Bearer 4de22cb9048cf0d33ff9f6630674bc301b8c14d242a3d21c582493418d06fbd1" )
    fun updateUser(@Path("user_id") user_id: String, @Body params: User): Call<UserResponse>


    @POST("users")
    @Headers("Accept:application/json", "Content-Type:application/json","Authorization: Bearer 4de22cb9048cf0d33ff9f6630674bc301b8c14d242a3d21c582493418d06fbd1")
   fun createUser(@Body params:User): Call<UserResponse>

   @DELETE("users")
    @Headers("Accept:application/json", "Content-Type:application/json","Authorization: Bearer 4de22cb9048cf0d33ff9f6630674bc301b8c14d242a3d21c582493418d06fbd1")
    fun createUser(@Path("user_id") user_id: String): Call<UserResponse>
}