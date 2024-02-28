package com.example.ticketmasterchallange.domain

import com.example.ticketmasterchallange.data.TicketApiService
import com.example.ticketmasterchallange.data.repository.TicketRepository
import com.example.ticketmasterchallange.data.room.EventDao
import com.example.ticketmasterchallange.data.room.EventEntity
import kotlinx.coroutines.flow.Flow

private const val API_KEY = "DW0E98NrxUIfDDtNN7ijruVSm60ryFLX"

class TicketsRepositoryImpl(
    private val eventDao: EventDao,
    private val apiService: TicketApiService
) : TicketRepository {
    override fun getAllEvents(): Flow<List<EventEntity>> = eventDao.getAllEvents()

    override suspend fun refreshEvents() {
        val eventsResponse = apiService.getEvents(API_KEY)
        val convert = TicketsMapper.convertResponseToModel(eventsResponse)
        val eventsToInsert = convert.map {apiEvent ->
            EventEntity(
                id = apiEvent.id,
                name = apiEvent.name,
                locale = apiEvent.locale,
                url = apiEvent.url,
                type = apiEvent.type,
                imageUrl = apiEvent.images
            )
        }
        eventDao.insertAll(eventsToInsert)
    }

    override suspend fun getEventById(eventId: String): EventEntity? {
        return eventDao.getEventById(eventId)
    }
}