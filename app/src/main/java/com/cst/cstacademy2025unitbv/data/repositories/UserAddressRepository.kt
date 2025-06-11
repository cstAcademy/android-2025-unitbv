package com.cst.cstacademy2025unitbv.data.repositories

import com.cst.cstacademy2025unitbv.ApplicationController
import com.cst.cstacademy2025unitbv.models.one_to_many.UserAddressModel

object UserAddressRepository {
    suspend fun insert(entities: List<UserAddressModel>) {
        ApplicationController.instance.database.userAddressDao.insert(entities)
    }

    suspend fun getAddressWithUsers(id: String) =
        ApplicationController.instance.database.userAddressDao.getAddressWithUsers(id)

}