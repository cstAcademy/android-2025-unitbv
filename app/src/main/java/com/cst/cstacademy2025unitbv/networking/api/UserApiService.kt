package com.cst.cstacademy2025unitbv.networking.api

import com.cst.cstacademy2025unitbv.networking.models.UserListAPIResponseModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UserApiService {
    @Headers("x-api-key: reqres-free-v1")
    @GET("/api/users")
    suspend fun getUsers(@Query("page") page: Int): UserListAPIResponseModel
}