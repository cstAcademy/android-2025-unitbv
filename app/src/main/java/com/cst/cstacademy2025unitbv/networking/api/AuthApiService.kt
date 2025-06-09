package com.cst.cstacademy2025unitbv.networking.api

import com.cst.cstacademy2025unitbv.networking.models.LoginRequestDto
import com.cst.cstacademy2025unitbv.networking.models.LoginResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface AuthApiService {

    @POST("api/login")
    @Headers("x-api-key: reqres-free-v1")
    suspend fun login(@Body request: LoginRequestDto): Response<LoginResponseDto>

}