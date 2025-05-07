package com.cst.cstacademy2025unitbv.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cst.cstacademy2025unitbv.data.dao.UsersDao
import com.cst.cstacademy2025unitbv.models.UserModel

@Database(
    entities = [
        UserModel::class
    ],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract val usersDao: UsersDao
}