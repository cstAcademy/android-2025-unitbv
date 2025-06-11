package com.cst.cstacademy2025unitbv.data.repositories

import com.cst.cstacademy2025unitbv.ApplicationController
import com.cst.cstacademy2025unitbv.models.UserModel

object UsersRepository {
    suspend fun getUsers() = ApplicationController.instance.database.usersDao.getAll()
    suspend fun insertUsers(users: List<UserModel>) = ApplicationController.instance.database.usersDao.insertAll(users)
    suspend fun getUsersWithIDCards() = ApplicationController.instance.database.usersDao.getUsersWithIDCards()
}