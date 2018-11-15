package com.example.imac.checkcounter.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.util.Log
import com.example.imac.checkcounter.common.DB_VERSION
import com.example.imac.checkcounter.data.model.dao.CheckDao
import com.example.imac.checkcounter.data.model.entity.Check

@Database(entities = [Check::class], version = DB_VERSION, exportSchema = false )
abstract class AppDatabase : RoomDatabase() {
    /**
     * @return The DAO for the DebugMessage table.
     */
    abstract fun getCheckDao(): CheckDao

    init { Log.d(TAG, "Instance Database") }

    companion object {
        private val TAG = AppDatabase::class.java.simpleName
    }
}