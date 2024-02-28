package com.example.ticketmasterchallange.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [EventEntity::class], version = 1)
@TypeConverters(Converter::class)
abstract class TicketDataBase : RoomDatabase() {
    abstract fun eventDao(): EventDao
}