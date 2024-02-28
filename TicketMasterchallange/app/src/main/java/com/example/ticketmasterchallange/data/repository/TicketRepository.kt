package com.example.ticketmasterchallange.data.repository

import com.example.ticketmasterchallange.data.room.EventEntity
import kotlinx.coroutines.flow.Flow

interface TicketRepository {
    fun getAllEvents(): Flow<List<EventEntity>>

    suspend fun refreshEvents()

    suspend fun getEventById(eventId: String): EventEntity?
}