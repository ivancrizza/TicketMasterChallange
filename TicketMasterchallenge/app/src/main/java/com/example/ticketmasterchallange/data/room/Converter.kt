package com.example.ticketmasterchallange.data.room

import androidx.room.TypeConverter
import com.example.ticketmasterchallange.data.response.ImageResponse
import com.example.ticketmasterchallange.domain.ImageEvent
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {
    @TypeConverter
    fun fromImageResponseList(value: List<ImageEvent>?): String? {
        val gson = Gson()
        val type = object : TypeToken<List<ImageEvent>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toImageResponseList(value: String?): List<ImageEvent>? {
        val gson = Gson()
        val type = object : TypeToken<List<ImageEvent>>() {}.type
        return gson.fromJson(value, type)
    }
}