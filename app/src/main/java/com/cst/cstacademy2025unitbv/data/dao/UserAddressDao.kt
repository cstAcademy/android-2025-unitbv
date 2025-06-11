package com.cst.cstacademy2025unitbv.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cst.cstacademy2025unitbv.models.one_to_many.AddressWithUsersModel
import com.cst.cstacademy2025unitbv.models.one_to_many.UserAddressModel

@Dao
interface UserAddressDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entities: List<UserAddressModel>)

    @Query("SELECT * FROM UserAddressModel WHERE id = :id")
    suspend fun getAddressWithUsers(id: String): AddressWithUsersModel?
}