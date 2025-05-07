package com.cst.cstacademy2025unitbv.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cst.cstacademy2025unitbv.models.UserModel

@Dao
interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(users: List<UserModel>)

    @Query(
        """
        SELECT * FROM users
        """
    )
    suspend fun getAll(): List<UserModel>
}