package com.example.imac.checkcounter.data.model.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.imac.checkcounter.common.CHECK_TABLE_NAME
import com.example.imac.checkcounter.data.model.entity.Check
import io.reactivex.Single

@Dao
abstract class CheckDao {

    @Query("SELECT * FROM $CHECK_TABLE_NAME")
    abstract fun getCheckList(): Single<List<Check>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertCheck(check: Check)

    @Query("SELECT * FROM $CHECK_TABLE_NAME")
    abstract fun getCheck(): Single<Check>
}