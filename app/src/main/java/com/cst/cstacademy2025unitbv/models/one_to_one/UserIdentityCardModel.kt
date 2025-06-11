package com.cst.cstacademy2025unitbv.models.one_to_one

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "userIDCard",
    indices = [
        Index(
            value = [UserIdentityCardModel.OWNER_ID],
            unique = true
        )
    ]
)
data class UserIdentityCardModel(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = OWNER_ID)
    val ownerId: Int,
    val cnp: String
) {
    companion object {
        const val OWNER_ID = "ownerId"
    }
}