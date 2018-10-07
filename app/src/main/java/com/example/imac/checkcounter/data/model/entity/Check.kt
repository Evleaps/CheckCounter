package com.example.imac.checkcounter.data.model.entity

import android.arch.persistence.room.Entity
import com.example.imac.checkcounter.data.CHECK_TABLE_NAME

@Entity(tableName = CHECK_TABLE_NAME)
data class Check(val total: String,
                 val name:  String,
                 val date:  String)