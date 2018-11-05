package com.example.imac.checkcounter.data.model.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.example.imac.checkcounter.data.CHECK_TABLE_NAME
import com.example.imac.checkcounter.data.CheckTypeConverters

@Entity(tableName = CHECK_TABLE_NAME)
@TypeConverters(CheckTypeConverters::class)
data class Check(@PrimaryKey(autoGenerate = true)
                 val id: Long?,
                 val total: Int,
                 val name: String,
                 val date: String,
                 val items: List<CheckItem>)