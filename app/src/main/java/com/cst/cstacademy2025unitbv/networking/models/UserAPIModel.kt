package com.cst.cstacademy2025unitbv.networking.models

import com.cst.cstacademy2025unitbv.models.UserModel

data class UserListAPIResponseModel(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<UserModel>
)