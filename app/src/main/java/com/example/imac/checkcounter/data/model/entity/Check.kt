package com.example.imac.checkcounter.data.model.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.imac.checkcounter.data.CHECK_TABLE_NAME

@Entity(tableName = CHECK_TABLE_NAME)
data class Check(@PrimaryKey(autoGenerate = true)
                 val id: Long?,
                 val total: String,
                 val name:  String,
                 val date:  String)