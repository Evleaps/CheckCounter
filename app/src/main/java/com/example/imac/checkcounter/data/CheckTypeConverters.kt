package com.example.imac.checkcounter.data

import android.arch.persistence.room.TypeConverter
import com.example.imac.checkcounter.data.model.entity.CheckItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> Gson.fromJson(json: String?) = this.fromJson<T>(json, object : TypeToken<T>() {}.type)

class CheckTypeConverters {

    private var gson = Gson()

    @TypeConverter
    fun checkItemToString(list: List<CheckItem>) = gson.toJson(list)

    @TypeConverter
    fun stringToCheckItem(json: String) = gson.fromJson<List<CheckItem>>(json)

}



