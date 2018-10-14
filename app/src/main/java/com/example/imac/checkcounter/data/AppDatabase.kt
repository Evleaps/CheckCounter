package com.example.imac.checkcounter.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.util.Log
import com.example.imac.checkcounter.data.model.dao.CheckDao
import com.example.imac.checkcounter.data.model.entity.Check

@Database(entities = [Check::class], version = DB_VERSION, exportSchema = false )
abstract class AppDatabase: RoomDatabase() {
    /**
     * @return The DAO for the DebugMessage table.
     */
    abstract fun getCheckDao(): CheckDao

    init {
        Log.d(TAG, "Instance Database")
    }

    companion object {
        private val TAG = AppDatabase::class.java.simpleName
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
                instance ?: synchronized(this) {
                    instance ?: buildDatabase(context).also { instance = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, DATABASE_NAME)
                        .build()
    }
}