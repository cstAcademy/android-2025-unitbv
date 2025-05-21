package com.cst.cstacademy2025unitbv.networking.repositories

import com.cst.cstacademy2025unitbv.networking.api.AuthApiService
import com.cst.cstacademy2025unitbv.networking.client.RetrofitClient
import com.cst.cstacademy2025unitbv.networking.models.LoginRequestDto

object AuthRepository {

    val authApiService by lazy {
        RetrofitClient.instance.create(AuthApiService::class.java)
    }
    suspend fun login(email: String, password: String) = authApiService.login(LoginRequestDto(email, password))
}