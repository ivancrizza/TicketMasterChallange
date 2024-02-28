package com.example.ticketmasterchallange.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.ticketmasterchallange.data.response.ImageResponse
import com.example.ticketmasterchallange.domain.ImageEvent

@Entity(tableName = "events")
data class EventEntity(
    @PrimaryKey val id: String,
    val name: String,
    val type: String,
    val url: String,
    val locale: String,
    val imageUrl: List<ImageEvent>
)