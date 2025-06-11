package com.cst.cstacademy2025unitbv.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.cst.cstacademy2025unitbv.models.one_to_one.UserIdentityCardModel

@Dao
interface UserIdentityCardDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(idCard: List<UserIdentityCardModel>)
}