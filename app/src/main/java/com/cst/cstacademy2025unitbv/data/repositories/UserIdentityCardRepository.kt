package com.cst.cstacademy2025unitbv.data.repositories

import com.cst.cstacademy2025unitbv.ApplicationController
import com.cst.cstacademy2025unitbv.models.one_to_one.UserIdentityCardModel

object UserIdentityCardRepository {
    suspend fun insertIdCards(idCards: List<UserIdentityCardModel>) =
        ApplicationController.instance.database.userIdentityCardDao.insertAll(idCards)
}