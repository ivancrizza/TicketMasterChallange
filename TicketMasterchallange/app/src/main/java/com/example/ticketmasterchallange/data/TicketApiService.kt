package com.example.ticketmasterchallange.data

import com.example.ticketmasterchallange.data.response.ImageResponse
import com.example.ticketmasterchallange.data.response.TicketsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TicketApiService {
    @GET("discovery/v2/events.json")
    suspend fun getEvents(@Query("apikey") apiKey: String): TicketsResponse

}