package com.cst.cstacademy2025unitbv.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cst.cstacademy2025unitbv.models.UserModel
import com.cst.cstacademy2025unitbv.models.one_to_one.UserWithIDCardModel

@Dao
interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<UserModel>)

    @Query(
        """
        SELECT * FROM users
        """
    )
    suspend fun getAll(): List<UserModel>

    @Query("SELECT * FROM users")
    suspend fun getUsersWithIDCards(): List<UserWithIDCardModel>
}