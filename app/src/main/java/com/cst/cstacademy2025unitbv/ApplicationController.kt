package com.cst.cstacademy2025unitbv

import android.app.Application
import androidx.room.Room
import com.cst.cstacademy2025unitbv.data.AppDatabase

class ApplicationController : Application() {

    lateinit var database: AppDatabase
        private set

    companion object {
        lateinit var instance: ApplicationController
            private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
        initDatabase()
    }

    private fun initDatabase() {
        database = Room.databaseBuilder(
            context = applicationContext,
            klass = AppDatabase::class.java,
            name = "cst_academy_2025_unit_bv"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}