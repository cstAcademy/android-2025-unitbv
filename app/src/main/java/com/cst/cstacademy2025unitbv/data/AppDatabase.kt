package com.cst.cstacademy2025unitbv.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cst.cstacademy2025unitbv.data.dao.UserAddressDao
import com.cst.cstacademy2025unitbv.data.dao.UserIdentityCardDao
import com.cst.cstacademy2025unitbv.data.dao.UsersDao
import com.cst.cstacademy2025unitbv.models.UserModel
import com.cst.cstacademy2025unitbv.models.one_to_many.UserAddressModel
import com.cst.cstacademy2025unitbv.models.one_to_one.UserIdentityCardModel

@Database(
    entities = [
        UserModel::class,
        UserIdentityCardModel::class,
        UserAddressModel::class
    ],
    version = 4
)
abstract class AppDatabase: RoomDatabase() {
    abstract val usersDao: UsersDao
    abstract val userIdentityCardDao: UserIdentityCardDao
    abstract val userAddressDao: UserAddressDao
}
