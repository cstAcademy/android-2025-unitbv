package com.cst.cstacademy2025unitbv.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class UserModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val avatar: String
)

//{
//    "id": 7,
//    "email": "michael.lawson@reqres.in",
//    "first_name": "Michael",
//    "last_name": "Lawson",
//    "avatar": "https://reqres.in/img/faces/7-image.jpg"
//},