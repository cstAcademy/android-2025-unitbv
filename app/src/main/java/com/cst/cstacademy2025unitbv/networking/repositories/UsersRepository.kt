package com.cst.cstacademy2025unitbv.networking.repositories

import com.cst.cstacademy2025unitbv.networking.api.UserApiService
import com.cst.cstacademy2025unitbv.networking.client.RetrofitClient

object UsersRepository {
    private val userApiService by lazy {
        RetrofitClient.instance.create(UserApiService::class.java)
    }

    suspend fun getUsers(page: Int) = userApiService.getUsers(page = page)
}