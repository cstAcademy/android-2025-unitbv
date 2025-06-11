package com.cst.cstacademy2025unitbv.models.one_to_one

import androidx.room.Embedded
import androidx.room.Relation
import com.cst.cstacademy2025unitbv.models.UserModel

data class UserWithIDCardModel(
    @Embedded
    val user: UserModel,
    @Relation(
        parentColumn = UserModel.ID,
        entityColumn = UserIdentityCardModel.OWNER_ID
    )
    val idCard: UserIdentityCardModel
)