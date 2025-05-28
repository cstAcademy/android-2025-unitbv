package com.cst.cstacademy2025unitbv.networking.models

class LoginResponseDto(

    val token: String,
)

class LoginRequestDto (

    val email: String,
    val password: String

)