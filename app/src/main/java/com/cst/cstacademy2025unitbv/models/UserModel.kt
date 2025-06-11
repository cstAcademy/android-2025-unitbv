package com.cst.cstacademy2025unitbv.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class UserModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    val id: Int = 0,
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    val avatar: String,
    @ColumnInfo(name = ADDRESS_ID)
    var addressId: String?
) {
    companion object {
        const val ID = "id"
        const val ADDRESS_ID = "addressId"
    }
}

//{
//    "id": 7,
//    "email": "michael.lawson@reqres.in",
//    "first_name": "Michael",
//    "last_name": "Lawson",
//    "avatar": "https://reqres.in/img/faces/7-image.jpg"
//},